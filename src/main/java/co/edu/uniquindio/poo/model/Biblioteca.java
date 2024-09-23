package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;

public class Biblioteca {
    private String nombre;
    private Estudiante[] listaEstudiantes = new Estudiante[10];
    private Libro[] listaLibros = new Libro[10];
    private Prestamo[] listaPrestamos = new Prestamo[10];
    private Empleado[] listaEmpleados = new Empleado[10];


    public Biblioteca(String nombre){
        this.nombre=nombre;
        this.listaEstudiantes = new Estudiante[10];
        this.listaLibros = new Libro[10];
        this.listaPrestamos = new Prestamo[10];
        this.listaEmpleados = new Empleado[10];
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


    public Persona[] getListaEstudiantes() {
        return listaEstudiantes;
    }


    public void setListaEstudiantes (Estudiante[] listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }


    public Libro[] getListaLibros() {
        return listaLibros;
    }


    public void setListaLibros(Libro[] listaLibros) {
        this.listaLibros = listaLibros;
    }


    public Prestamo[] getListaPrestamos() {
        return listaPrestamos;
    }


    public void setListaPrestamos(Prestamo[] listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }


    public Empleado[] getListaEmpleados() {
        return listaEmpleados;
    }


    public void setListaEmpleados(Empleado[] listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    @Override
    public String toString() {
        return "Biblioteca [nombre=" + nombre + ", listaEstudiantes=" + Arrays.toString(listaEstudiantes)
                + ", listaLibros=" + Arrays.toString(listaLibros) + ", listaPrestamos="
                + Arrays.toString(listaPrestamos) + ", listaEmpleados=" + Arrays.toString(listaEmpleados) + "]";
    }

    /**
     * metodo para crear un libro
     */
    public String agregarLibro(Libro nuevoLibro){
        String mensaje = "";
        int posicionDisponible = 0;
        Libro libroEncontrado = null;

        posicionDisponible = buscarPosicionDisponible();

        if (posicionDisponible == -1) {
            mensaje = "\nNo hay espacio para un nuevo Libro.";
            return mensaje;
        } else {
            libroEncontrado = buscarLibro(nuevoLibro.getTitulo(), nuevoLibro.getCodigo());

            if (libroEncontrado != null) {
                mensaje = "\nEl contacto ya se encuentra registrado.";
            } else {
                listaLibros[posicionDisponible] = nuevoLibro;
                mensaje = "\nEl contacto se a almacenado exitosamente.";
            }
        }

        return mensaje;
    }

    /**
     * metodo para buscar una posicion disponible
     */
    private int buscarPosicionDisponible() {
        int posicionDisponible = -1;

        for (int i = 0; i < listaLibros.length; i++) {
            Libro libro = listaLibros[i];
            if (libro == null) {
                posicionDisponible = i;
                return posicionDisponible;
            }
        }

        return posicionDisponible;
    }
    
    /**
     * metodo para buscar un libro
     */
    public Libro buscarLibro(String titulo, String codigo) {
        Libro libroEncontrado = null;

        for (int i = 0; i < listaLibros.length; i++) {
            Libro libroAux = listaLibros[i];
            if (libroAux != null) {
                if (libroAux.getTitulo().equals(titulo) && libroAux.getCodigo().equals(codigo)) {
                    libroEncontrado = libroAux;
                    return libroEncontrado;
                }
            }
        }

        return libroEncontrado;
    }

    /**
     * metodo para actualizar un libro
     */
    public String actualizarLibro(String titulo, String codigo, String isbn, String autor, String editorial, LocalDate fecha, byte unidadesDisponibles) {
        String mensaje = "\nEl Libro no se encuentra registrado.";
        Libro libroEncontrado = buscarLibro(titulo, codigo);
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

        for (int i = 0; i < listaLibros.length; i++) {
            Libro libroAux = listaLibros[i];
            if (listaLibros != null) {
                if (libroAux.getTitulo().equals(titulo) && libroAux.getCodigo().equals(codigo)) {
                    listaLibros[i] = null;
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
    public String agregarEmpleado(Empleado nuevoEmpleado){
        String mensaje = "";
        int posicionDisponible = 0;
        Empleado empleadoEncontrado = null;

        posicionDisponible = buscarPosicionDisponibleEmpleado();

        if (posicionDisponible == -1) {
            mensaje = "\nNo hay espacio para un nuevo empleado.";
            return mensaje;
        } else {
            empleadoEncontrado = buscarEmpleado(nuevoEmpleado.getNombre(), nuevoEmpleado.getCedula());

            if (empleadoEncontrado != null) {
                mensaje = "\nEl empleado ya se encuentra registrado.";
            } else {
                listaEmpleados[posicionDisponible] = nuevoEmpleado;
                mensaje = "\nEl empleado se a almacenado exitosamente.";
            }
        }
        return mensaje;
    }

    /**
     * metodo para buscar una posicion disponible
     */
    private int buscarPosicionDisponibleEmpleado() {
        int posicionDisponible = -1;

        for (int i = 0; i < listaEmpleados.length; i++) {
            Empleado empleado = listaEmpleados[i];
            if (empleado == null) {
                posicionDisponible = i;
                return posicionDisponible;
            }
        }

        return posicionDisponible;
    }
    
    /**
     * metodo para buscar un empleado
     */
    public Empleado buscarEmpleado(String nombre, String cedula) {
        Empleado empleadoEncontrado = null;

        for (int i = 0; i < listaEmpleados.length; i++) {
            Empleado empleadoAux = listaEmpleados[i];
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
    public String actualizarEmpleado(String nombre, String cedula, String telefono, String correo, Double salario) {
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

        for (int i = 0; i < listaEmpleados.length; i++) {
            Empleado empleadoAux = listaEmpleados[i];
            if (listaEmpleados != null) {
                if (empleadoAux.getNombre().equals(nombre) && empleadoAux.getCedula().equals(cedula)) {
                    listaEmpleados[i] = null;
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
    public String agregarEstudiante(Estudiante nuevoEstudiante){
        String mensaje = "";
        int posicionDisponible = 0;
        Estudiante estudianteEncontrado = null;

        posicionDisponible = buscarPosicionDisponibleEstudiante();

        if (posicionDisponible == -1) {
            mensaje = "\nNo hay espacio para un nuevo estudiante.";
            return mensaje;
        } else {
            estudianteEncontrado = buscarEstudiante(nuevoEstudiante.getNombre(), nuevoEstudiante.getCedula());

            if (estudianteEncontrado != null) {
                mensaje = "\nEl estudiante ya se encuentra registrado.";
            } else {
                listaEstudiantes[posicionDisponible] = nuevoEstudiante;
                mensaje = "\nEl estudiante se a almacenado exitosamente.";
            }
        }
        return mensaje;
    }

    /**
     * metodo para buscar una posicion disponible
     */
    private int buscarPosicionDisponibleEstudiante() {
        int posicionDisponible = -1;

        for (int i = 0; i < listaEstudiantes.length; i++) {
            Estudiante estudiante = listaEstudiantes[i];
            if (estudiante == null) {
                posicionDisponible = i;
                return posicionDisponible;
            }
        }
        return posicionDisponible;
    }
    
    /**
     * metodo para buscar un estudiante 
     */
    public Estudiante buscarEstudiante(String nombre, String cedula) {
        Estudiante estudianteEncontrado = null;

        for (int i = 0; i < listaEstudiantes.length; i++) {
            Estudiante estudianteAux = listaEstudiantes[i];
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

        for (int i = 0; i < listaEstudiantes.length; i++) {
            Estudiante estudianteAux = listaEstudiantes[i];
            if (listaEstudiantes != null) {
                if (estudianteAux.getNombre().equals(nombre) && estudianteAux.getCedula().equals(cedula)) {
                    listaEstudiantes[i] = null;
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
    public String agergarPrestamo(Prestamo nuevoPrestamo){
        String mensaje = "";
        int posicionDisponible = 0;
        Prestamo prestamoEncontrado = null;

        posicionDisponible = buscarPosicionDisponiblePrestamo();

        if (posicionDisponible == -1) {
            mensaje = "\nNo hay espacio para un nuevo prestamo.";
            return mensaje;
        } else {
            prestamoEncontrado = buscarPrestamo(nuevoPrestamo.getFechaEntrega(), nuevoPrestamo.getFechaPrestamo());

            if (prestamoEncontrado != null) {
                mensaje = "\nEl prestamo ya se encuentra registrado.";
            } else {
                listaPrestamos[posicionDisponible] = nuevoPrestamo;
                mensaje = "\nEl prestamo se a almacenado exitosamente.";
            }
        }
        return mensaje;
    }

    /**
     * metodo para buscar una posicion disponible
     */
    private int buscarPosicionDisponiblePrestamo() {
        int posicionDisponible = -1;

        for (int i = 0; i < listaPrestamos.length; i++) {
            Prestamo prestamo = listaPrestamos[i];
            if (prestamo == null) {
                posicionDisponible = i;
                return posicionDisponible;
            }
        }
        return posicionDisponible;
    }
    
    /**
     * metodo para buscar un prestamo 
     */
    public Prestamo buscarPrestamo(LocalDate fechaEntrega, LocalDate fechaPrestamo) {
        Prestamo prestamoEncontrado = null;

        for (int i = 0; i < listaPrestamos.length; i++) {
            Prestamo prestamoAux = listaPrestamos[i];
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
    public String actualizarPrestamo(Double costo, LocalDate fechaPrestamo, LocalDate fechaEntrega) {
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

        for (int i = 0; i < listaPrestamos.length; i++) {
            Prestamo prestamoAux = listaPrestamos[i];
            if (listaPrestamos != null) {
                if (prestamoAux.getFechaEntrega().equals(fechaEntrega) && prestamoAux.getFechaPrestamo().equals(fechaPrestamo)) {
                    listaPrestamos[i] = null;
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
        for(int i = 0; i < listaLibros.length; i++){
            Libro libroAux=listaLibros[i];
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
        int cantidadPrestamos = 0;
        for(int i = 0; i < listaPrestamos.length; i++){
            Prestamo prestamoAux = listaPrestamos[i];
            for(Libro libro : prestamoAux.getListaLibros()){
                if(libro.getTitulo().equals(titulo)){
                    cantidadPrestamos++;
                }
            }
        }
        return cantidadPrestamos;
    }

    /**
    * metodo para consultar los datos de un prestamo dado su codigo
    */
    public String consultarDatosPrestamo(String codigo){
        for(int i = 0; i < listaPrestamos.length; i++){
            Prestamo prestamoAux=listaPrestamos[i];
            if(prestamoAux.getCodigo().equals(codigo)){
                return "Código: " + prestamoAux.getCosto() +
                   ", Título: " + prestamoAux.getFechaEntrega() +
                   ", Autor: " + prestamoAux.getFechaPrestamo();
            }
        }
        return "libro no encontrado";
    }

    /**
     * metodo para reemplazar un libro
     */
    public boolean reemplazarLibro(String titulo, Libro nuevoLibro) {
        for (int i = 0; i < listaLibros.length; i++) {
            if (listaLibros[i].getTitulo().equals(titulo)) {
                listaLibros[i] = nuevoLibro; 
                return true; 
            }
        }
        return false; 
    }

    /**
     * metodo para entregar le prestamo
     */
    public void entregarPrestamo(LocalDate fechaEntrega, LocalDate fechaPrestamo, Libro libro, Prestamo prestamo){

        long diasPrestamo = ChronoUnit.DAYS.between(fechaPrestamo, fechaEntrega);

        double costoPorDia = prestamo.getCosto();
        double costoTotal = diasPrestamo * costoPorDia;

        System.out.println("Libro entregado: " + libro.getTitulo());
        System.out.println("Fecha de préstamo: " + fechaPrestamo);
        System.out.println("Fecha de entrega: " + fechaEntrega);
        System.out.println("Días prestado: " + diasPrestamo);
        System.out.println("Costo por día: $" + costoPorDia);
        System.out.println("Costo total del préstamo: $" + costoTotal);
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
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Integer> contadorPrestamos = new ArrayList<>();

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

        // Mostrar resultados
        System.out.println("Cantidad de préstamos realizados por cada empleado:");
        for (int i = 0; i < empleados.size(); i++) {
            System.out.println(empleados.get(i) + ": " + contadorPrestamos.get(i) + " préstamos");
        }
    }

    /**
     * metodo para mostrar el estudiante con mas prestamos
     */
    public void estudianteConMasPrestamos(){
    ArrayList<Estudiante> estudiantes = new ArrayList<>();
        ArrayList<Integer> contadorPrestamos = new ArrayList<>();

        Prestamo[] prestamos;
        for (Prestamo prestamo : prestamos) {
            Estudiante estudiante = prestamo.getEstudiante();
            int index = estudiantes.indexOf(estudiante);

            if (index == -1) {
                estudiantes.add(estudiante);
                contadorPrestamos.add(1); 
            } else {
                contadorPrestamos.set(index, contadorPrestamos.get(index) + 1);
            }
        }

        int maxPrestamos = 0;
        int indexMax = 0;

        for (int i = 0; i < contadorPrestamos.size(); i++) {
            if (contadorPrestamos.get(i) > maxPrestamos) {
                maxPrestamos = contadorPrestamos.get(i);
                indexMax = i;
            }
        }
        System.out.println("Estudiante con más préstamos: " + estudiantes.get(indexMax));
        System.out.println("Número de préstamos: " + maxPrestamos);
    }

    /**
     * metodo para calcular el pago de los propietarios
     */
    public double calcularTotalAPagarABibliotecarios() {
        double totalAPagar = 0.0;
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Double> ganancias = new ArrayList<>();

        for (Prestamo prestamo : getListaPrestamos()) {
            Empleado empleado = prestamo.getEmpleado();
            double costoPorDia = prestamo.getLibro().getCosto(); 
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
