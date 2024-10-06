package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {
    private int costo;
    private String codigo;
    private LocalDate fechaEntrega;
    private LocalDate fechaPrestamo;
    private Estudiante estudiante;
    private Empleado empleado;
    private Libro libro;
    

    public Prestamo(int costo, String codigo, LocalDate fechaEntrega, LocalDate fechaPrestamo, Estudiante estudiante, Empleado empleado, Libro libro ){
        assert costo >= 0;
        assert codigo != null && !codigo.isBlank();
        assert fechaEntrega != null;
        assert fechaPrestamo != null;
        this.costo=costo;
        this.codigo=codigo;
        this.fechaEntrega=fechaEntrega;
        this.fechaPrestamo=fechaPrestamo;
        this.estudiante=estudiante;
        this.empleado=empleado;
        this.libro=libro;
    }

    /**
     * metodos get y set 
     */
    public int getCosto() {
        return costo;
    }

    public void setCosto( int costo) {
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

    public Estudiante getEstudiante(){
        return estudiante;
    }

    public Empleado getEmpleado(){
        return empleado;
    }

    public Libro getLibro(){
        return libro;
    }

    /**
     * metodo para asignar un estudiante 
     * @param estudiante
     */
    public void asignarEstudiante(Estudiante estudiante){
        this.estudiante=estudiante;
    }

    /**
     * metodo para asignar un libro 
     * @param libro
     */
    public void asignarLibro(Libro libro){
        this.libro=libro;
    }

    /**
     * metodo para asignar un empleado
     */
    public void asignarEmpleado(Empleado empleado){
        this.empleado=empleado;
    }

    /**
     * metodo para entregar el prestamo
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

    

}
