package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Libro {
    private String titulo, codigo, isbn, autor, editorial;
    private LocalDate fecha;
    private int unidadesDisponibles;
    private EstadoLibro estadoLibro;

    public Libro(String titulo, String codigo, String isbn, String autor, String editorial, LocalDate fecha, int unidadesDisponibles, EstadoLibro estadoLibro){
        assert titulo != null && !titulo.isBlank();
        assert codigo != null && !codigo.isBlank();
        assert isbn != null && !isbn.isBlank();
        assert autor != null && !autor.isBlank();
        assert editorial != null && !editorial.isBlank();
        assert fecha != null;
        assert unidadesDisponibles >= 0;
        this.titulo=titulo;
        this.codigo=codigo;
        this.isbn=isbn;
        this.autor=autor;
        this.editorial=editorial;
        this.fecha=fecha;
        this.unidadesDisponibles=unidadesDisponibles;
        this.estadoLibro=estadoLibro;
    }

    /**
     * metodos get and set 
     * @return
     */
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(Byte unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public EstadoLibro getEstadoLibro() {
        return estadoLibro;
    }

    @Override
    public String toString() {
        return "Libro [titulo=" + titulo + ", codigo=" + codigo + ", isbn=" + isbn + ", autor=" + autor + ", editorial="
                + editorial + ", fecha=" + fecha + ", unidadesDisponibles=" + unidadesDisponibles + ", estadoLibro="
                + estadoLibro + "]";
    }

    /**
     * metodo para modificar la cantidad de unidades disponibles
     */
    public void cantidadUnidadesDisponibles(){
        if(unidadesDisponibles > 0){
            unidadesDisponibles--;
            if(unidadesDisponibles == 0){
                estadoLibro=EstadoLibro.OCUPADO;
            }
        }else{
            System.out.println("no hay mas unidades disponibles");
        }
    }

    

    

}
