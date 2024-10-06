package co.edu.uniquindio.poo.model;

public class Persona {
    private String nombre, cedula, telefono, correo;

    public Persona(String nombre, String cedula, String telefono, String correo){
        assert nombre != null && !nombre.isBlank();
        assert cedula != null && !cedula.isBlank();
        assert telefono != null && !telefono.isBlank();
        assert correo != null && !correo.isBlank();
        this.nombre=nombre;
        this.cedula=cedula;
        this.telefono=telefono;
        this.correo=correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    

}
