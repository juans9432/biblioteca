package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Prestamo {
    private Double costo;
    private String codigo;
    private LocalDate fechaEntrega;
    private LocalDate fechaPrestamo;
    private Libro[] listaLibros = new Libro[10];

    public Prestamo(Double costo, String codigo, LocalDate fechaEntrega, LocalDate fechaPrestamo, EstadoLibro estado){
        this.costo=costo;
        this.codigo=codigo;
        this.fechaEntrega=fechaEntrega;
        this.fechaPrestamo=fechaPrestamo;
        this.listaLibros = new Libro[10];
    }

    

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Libro[] getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(Libro[] listaLibros) {
        this.listaLibros = listaLibros;
    }

    /**
     * metodo para agregar libro al prestamo
     */
    public String agregarLibroPrestamo(String titulo, String codigo, Biblioteca todosLosLibros){
        String mensaje = "";
        int posicionDisponible = 0;
        Libro libroEncontrado = null;

        posicionDisponible = buscarPosicionDisponiblePrestamo();

        if (posicionDisponible == -1) {
            mensaje = "No hay espacio para un nuevo contacto.";
            return mensaje;
        } else {
            libroEncontrado = buscarLibro(titulo, codigo);

            if (libroEncontrado != null) {
                mensaje = "El contacto ya se encuentra registrado.";
            } else {
                libroEncontrado = todosLosLibros.buscarLibro(titulo, codigo);
                if(libroEncontrado == null){
                    mensaje = "El contacto que intenta ingresar no existe.";
                }else{
                    listaLibros[posicionDisponible] = libroEncontrado;
                    mensaje = "El contacto se a almacenado exitosamente.";
                }
            }         
        }
        return mensaje;
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

     /*
     * Este método busca una posición disponible y la retorna, en caso de no haber,
     * retorna -1.
     */
    private int buscarPosicionDisponiblePrestamo() {
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



}
