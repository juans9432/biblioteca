package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;

public class Biblioteca {
    private String nombre;
    private LinkedList<Estudiante> listaEstudiantes;
    private LinkedList<Libro> listaLibros;
    private LinkedList<Prestamo> listaPrestamos; 
    private LinkedList<Empleado> listaEmpleados;


    public Biblioteca(String nombre){
        this.nombre=nombre;
        this.listaEstudiantes = new LinkedList<>();
        this.listaLibros = new LinkedList<>();
        this.listaPrestamos = new LinkedList<>();
        this.listaEmpleados = new LinkedList<>();
    }

    /**
     * metodos get y set 
     */
    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public LinkedList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }


    public void setListaEstudiantes (LinkedList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }


    public LinkedList<Libro> getListaLibros() {
        return listaLibros;
    }


    public void setListaLibros(LinkedList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }


    public LinkedList<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }


    public void setListaPrestamos(LinkedList<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }


    public LinkedList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void agregarLibros(LinkedList<Libro> listaLibros) {
        this.listaLibros.addAll(listaLibros); 
    }


    public void setListaEmpleados(LinkedList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    
    @Override
    public String toString() {
        return "Biblioteca [nombre=" + nombre + ", listaEstudiantes=" + listaEstudiantes + ", listaLibros="
                + listaLibros + ", listaPrestamos=" + listaPrestamos + ", listaEmpleados=" + listaEmpleados + "]";
    }

    /**
     * metodo para crear un libro
     */
    public boolean agregarLibro(Libro nuevoLibro){
        listaLibros = new LinkedList<>();

        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equals(nuevoLibro.getTitulo()) && 
                libro.getCodigo().equals(nuevoLibro.getCodigo())){
                return false;
            }
        }
        listaLibros.add(nuevoLibro);
        return true;
    }
    
    /**
     * metodo para buscar un libro
     */
    public Libro buscarLibro(String codigo, String titulo) {
        if (listaLibros == null || listaLibros.isEmpty()) {
            return null; 
        }
    
        for (Libro libroAux : listaLibros) {  
            if (libroAux != null &&
                codigo != null && codigo.equals(libroAux.getCodigo()) && titulo != null && titulo.equals(libroAux.getTitulo())) {
                return libroAux;  
            }
        }
    
        return null; 
    }

    /**
     * metodo para actualizar un libro
     */
    public String actualizarLibro(String titulo, String codigo, String isbn, String autor, String editorial, LocalDate fecha, byte unidadesDisponibles) {
        String mensaje = "\nEl Libro no se encuentra registrado.";
        Libro libroEncontrado = buscarLibro(codigo, titulo);
        if (libroEncontrado != null) {
            libroEncontrado.setTitulo(titulo);
            libroEncontrado.setCodigo(codigo);
            libroEncontrado.setIsbn(isbn);
            libroEncontrado.setAutor(autor);
            libroEncontrado.setEditorial(editorial);
            libroEncontrado.setFecha(fecha);
            libroEncontrado.setUnidadesDisponibles(unidadesDisponibles);
            mensaje = "\nLa información del libro ha sido actualizada de manera satisfactoria.";
            return mensaje;
        }

        return mensaje;
    }

    /**
     * metodo para eliminar un libro
     */
    public String eliminarLibro(String titulo, String codigo) {
        String mensaje = "\nEl libro no existe.";

        for (int i = 0; i < listaLibros.size(); i++) {
            Libro libroAux = listaLibros.get(i);
            if (listaLibros != null) {
                if (libroAux.getTitulo().equals(titulo) && libroAux.getCodigo().equals(codigo)) {
                    listaLibros.remove(i);
                    mensaje = "\nEl libro ha sido eliminado correctamente.";
                    return mensaje;
                }                
            }           
        }
        return mensaje;
    }

     /**
     * metodo para agregar un Empleado
     */
    public boolean agregarEmpleado(Empleado nuevoEmpleado){
        listaEmpleados = new LinkedList<>();

        for (Empleado empleado : listaEmpleados) {
            if (empleado.getNombre().equals(nuevoEmpleado.getNombre()) && 
                empleado.getCedula().equals(nuevoEmpleado.getCedula())){
                return false;
            }
        }
        listaEmpleados.add(nuevoEmpleado);
        return true;
    }
    
    /**
     * metodo para buscar un empleado
     */
    public Empleado buscarEmpleado(String nombre, String cedula) {
        Empleado empleadoEncontrado = null;

        for (int i = 0; i < listaEmpleados.size(); i++) {
            Empleado empleadoAux = listaEmpleados.get(i);
            if (empleadoAux != null) {
                if (empleadoAux.getNombre().equals(nombre) && empleadoAux.getCedula().equals(cedula)) {
                    empleadoEncontrado = empleadoAux;
                    return empleadoEncontrado;
                }
            }
        }
        return empleadoEncontrado;
    }

    /**
     * metodo para actualizar un empleado
     */
    public String actualizarEmpleado(String nombre, String cedula, String telefono, String correo, int salario) {
        String mensaje = "\nEl empleado no se encuentra registrado.";
        Empleado empleadoEncontrado = buscarEmpleado(nombre, cedula);
        if (empleadoEncontrado != null) {
            empleadoEncontrado.setNombre(nombre);
            empleadoEncontrado.setCedula(cedula);
            empleadoEncontrado.setTelefono(telefono);
            empleadoEncontrado.setCorreo(correo);
            empleadoEncontrado.setSalario(salario);
            mensaje = "\nLa información del libro ha sido actualizada de manera satisfactoria.";
            return mensaje;
        }
        return mensaje;
    }

    /**
     * metodo para eliminar un empleado
     */
    public String eliminarEmpleado(String nombre, String cedula) {
        String mensaje = "\nEl empleado no existe.";

        for (int i = 0; i < listaEmpleados.size(); i++) {
            Empleado empleadoAux = listaEmpleados.get(i);
            if (listaEmpleados != null) {
                if (empleadoAux.getNombre().equals(nombre) && empleadoAux.getCedula().equals(cedula)) {
                    listaEmpleados.remove(i);
                    mensaje = "\nEl empleado ha sido eliminado correctamente.";
                    return mensaje;
                }                
            }           
        }
        return mensaje;
    }

     /**
     * metodo para crear un estudiante
     */
    public boolean agregarEstudiante(Estudiante nuevoEstudiante){
        listaEstudiantes = new LinkedList<>();

        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getNombre().equals(nuevoEstudiante.getNombre()) && 
                estudiante.getCedula().equals(nuevoEstudiante.getCedula())){
                return false;
            }
        }
        listaEstudiantes.add(nuevoEstudiante);
        return true;
    }

    /**
     * metodo para buscar un estudiante 
     */
    public Estudiante buscarEstudiante(String nombre, String cedula) {
        Estudiante estudianteEncontrado = null;

        for (int i = 0; i < listaEstudiantes.size(); i++) {
            Estudiante estudianteAux = listaEstudiantes.get(i);
            if (estudianteAux != null) {
                if (estudianteAux.getNombre().equals(nombre) && estudianteAux.getCedula().equals(cedula)) {
                    estudianteEncontrado = estudianteAux;
                    return estudianteEncontrado;
                }
            }
        }
        return estudianteEncontrado;
    }

    /**
     * metodo para actualizar un estudiante
     */
    public String actualizarEstudiante(String nombre, String cedula, String telefono, String correo, Double salario) {
        String mensaje = "\nEl estudiante no se encuentra registrado.";
        Estudiante estudianteEncontrado = buscarEstudiante(nombre, cedula);
        if (estudianteEncontrado != null) {
            estudianteEncontrado.setNombre(nombre);
            estudianteEncontrado.setCedula(cedula);
            estudianteEncontrado.setTelefono(telefono);
            estudianteEncontrado.setCorreo(correo);
            mensaje = "\nLa información del estudiante ha sido actualizada de manera satisfactoria.";
            return mensaje;
        }
        return mensaje;
    }

    /**
     * metodo para eliminar un estudiante
     */
    public String eliminarEstudiante(String nombre, String cedula) {
        String mensaje = "\nEl estudiante no existe.";

        for (int i = 0; i < listaEstudiantes.size(); i++) {
            Estudiante estudianteAux = listaEstudiantes.get(i);
            if (listaEstudiantes != null) {
                if (estudianteAux.getNombre().equals(nombre) && estudianteAux.getCedula().equals(cedula)) {
                    listaEstudiantes.remove(i);
                    mensaje = "\nEl estudiante ha sido eliminado correctamente.";
                    return mensaje;
                }                
            }           
        }
        return mensaje;
    }

      /**
     * metodo para crear un prestamo
     */
    public boolean agergarPrestamo(Prestamo nuevoPrestamo){
        listaPrestamos = new LinkedList<>();

        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getCodigo().equals(nuevoPrestamo.getCodigo())){
                return false;
            }
        }
        listaPrestamos.add(nuevoPrestamo);
        return true;
    }
    
    /**
     * metodo para buscar un prestamo 
     */
    public Prestamo buscarPrestamo(LocalDate fechaEntrega, LocalDate fechaPrestamo) {
        Prestamo prestamoEncontrado = null;

        for (int i = 0; i < listaPrestamos.size(); i++) {
            Prestamo prestamoAux = listaPrestamos.get(i);
            if (prestamoAux != null) {
                if (prestamoAux.getFechaPrestamo().equals(fechaPrestamo) && prestamoAux.getFechaEntrega().equals(fechaEntrega)) {
                    prestamoEncontrado = prestamoAux;
                    return prestamoEncontrado;
                }
            }
        }
        return prestamoEncontrado;
    }

    /**
     * metodo para actualizar un prestamo
     */
    public String actualizarPrestamo(int costo, LocalDate fechaPrestamo, LocalDate fechaEntrega) {
        String mensaje = "\nEl prestamo no se encuentra registrado.";
        Prestamo prestamoEncontrado = buscarPrestamo(fechaPrestamo, fechaEntrega);
        if (prestamoEncontrado != null) {
            prestamoEncontrado.setCosto(costo);
            prestamoEncontrado.setFechaEntrega(fechaEntrega);
            prestamoEncontrado.setFechaPrestamo(fechaPrestamo);
            mensaje = "\nLa información del estudiante ha sido actualizada de manera satisfactoria.";
            return mensaje;
        }
        return mensaje;
    }

    /**
     * metodo para eliminar un prestamo
     */
    public String eliminarPrestamo(LocalDate fechaEntrega, LocalDate fechaPrestamo) {
        String mensaje = "\nEl prestamo no existe.";

        for (int i = 0; i < listaPrestamos.size(); i++) {
            Prestamo prestamoAux = listaPrestamos.get(i);
            if (listaPrestamos != null) {
                if (prestamoAux.getFechaEntrega().equals(fechaEntrega) && prestamoAux.getFechaPrestamo().equals(fechaPrestamo)) {
                    listaPrestamos.remove(i);
                    mensaje = "\nEl prestamo ha sido eliminado correctamente.";
                    return mensaje;
                }                
            }           
        }
        return mensaje;
    }

    /**
     * metodo para consultar los datos de un libro dado su codigo
     */
    public String consultarDatosLibro(String codigo){
        for(int i = 0; i < listaLibros.size(); i++){
            Libro libroAux=listaLibros.get(i);
            if(libroAux.getCodigo().equals(codigo)){
                return "Código: " + libroAux.getCodigo() +
                   ", Título: " + libroAux.getTitulo() +
                   ", Autor: " + libroAux.getAutor() + 
                   ", isbn: " + libroAux.getIsbn() +
                   ", Editorial: " + libroAux.getEditorial() +
                   ", unidades disponibles: " + libroAux.getUnidadesDisponibles();
            }
        }
        return "libro no encontrado";
    }

    /**
     * metodo para consultar la cantidad de prestamos a la que esta asociada un libro dado su nombre
     */
    public int cantidadDePrestamosLibro(String titulo){
        int contador = 0;

        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getLibro().getTitulo().equals(titulo)){
                contador++;  
            }
        }
        return contador; 
    }

    /**
    * metodo para consultar los datos de un prestamo dado su codigo
    */
    public String consultarDatosPrestamo(String codigo){
        for(int i = 0; i < listaPrestamos.size(); i++){
            Prestamo prestamoAux=listaPrestamos.get(i);
            if(prestamoAux.getCodigo().equals(codigo)){
                return "Código: " + prestamoAux.getCodigo() +
                   ", costo: " + prestamoAux.getCosto() +
                   ", fecha de prestamo: " + prestamoAux.getFechaPrestamo() +
                   ", fecha de entrega: " + prestamoAux.getFechaEntrega() +
                   ", empleado: " + prestamoAux.getEmpleado() + 
                   ", estudiante: " + prestamoAux.getEstudiante() +
                   ", libro: " + prestamoAux.getLibro();
            }
        }
        return "libro no encontrado";
    }

    /**
     * metodo para reemplazar un libro
     */
    public Libro reemplazarLibro(String titulo, Libro nuevoLibro) {
        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getTitulo().equals(titulo)) {
                listaLibros.set(i, nuevoLibro); 
            }
        }
        return nuevoLibro;
    }

    /**
    * metodo para calcular el total recaudado por la empresa
    */
    public double calcularTotalRecaudado() {
        double totalRecaudado = 0.0;

        for (Prestamo prestamo : listaPrestamos) {
            long diasPrestamo = ChronoUnit.DAYS.between(prestamo.getFechaPrestamo(), prestamo.getFechaEntrega());

            double costoPrestamo = diasPrestamo * prestamo.getCosto();
            totalRecaudado += costoPrestamo;
        }
        return totalRecaudado;
    }

    /**
     * metodo que muestra la cantidad de prestamos hechos por cada empleado
     */
    public void mostrarCantidadPrestamosPorEmpleado() {
        LinkedList<Empleado> empleados = new LinkedList<>();
        LinkedList<Integer> contadorPrestamos = new LinkedList<>();

        for (Prestamo prestamo : listaPrestamos) {
            Empleado empleado = prestamo.getEmpleado();
            int index = empleados.indexOf(empleado);

            if (index == -1) {
                empleados.add(empleado);
                contadorPrestamos.add(1); 
            } else {
                contadorPrestamos.set(index, contadorPrestamos.get(index) + 1);
            }
        }

        System.out.println("Cantidad de préstamos realizados por cada empleado:");
        for (int i = 0; i < empleados.size(); i++) {
            System.out.println(empleados.get(i) + ": " + contadorPrestamos.get(i) + " préstamos");
        }
    }

    /**
     * metodo para mostrar el estudiante con mas prestamos
     */
    public Estudiante estudianteConMasPrestamos(){
        Estudiante estudianteConMasPrestamos = null;
        int maxPrestamos=0;
        for (Prestamo prestamo : listaPrestamos){
            Estudiante estudianteActual = prestamo.getEstudiante();
            int conteoPrestamos=0;

            for(Prestamo prestamoAux : listaPrestamos){
                if(prestamoAux.getEstudiante().equals(estudianteActual)){
                    conteoPrestamos++;
                }
            }

            if(conteoPrestamos > maxPrestamos){
                maxPrestamos = conteoPrestamos;
                estudianteConMasPrestamos = estudianteActual;
            }
        }
        return estudianteConMasPrestamos;
    }

    /**
     * metodo para calcular el pago de los propietarios
     */
    public double calcularTotalAPagarABibliotecarios() {
        double totalAPagar = 0.0;
        LinkedList<Empleado> empleados = new LinkedList<>();
        LinkedList<Double> ganancias = new LinkedList<>();

        for (Prestamo prestamo : getListaPrestamos()) {
            Empleado empleado = prestamo.getEmpleado();
            double costoPorDia = prestamo.getCosto(); 
            long diasPrestamo = ChronoUnit.DAYS.between(prestamo.getFechaPrestamo(), prestamo.getFechaEntrega());
            double gananciaPorPrestamo = costoPorDia * diasPrestamo * 0.2; 

            int index = empleados.indexOf(empleado);

            if (index == -1) {
                empleados.add(empleado);
                ganancias.add(gananciaPorPrestamo);
            } else {
                ganancias.set(index, ganancias.get(index) + gananciaPorPrestamo);
            }
        }

        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado = empleados.get(i);
            double gananciaTotal = ganancias.get(i);
            double bonificacion = gananciaTotal * (0.02 * empleado.getAntiguedad()); //
            totalAPagar += gananciaTotal + bonificacion;
        }

        return totalAPagar;
    }
}
