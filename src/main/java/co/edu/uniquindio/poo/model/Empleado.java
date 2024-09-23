package co.edu.uniquindio.poo.model;

public class Empleado extends Persona{
    private Double salario;

    public Empleado(String nombre, String cedula, String telefono, String correo, Double salario){
        super(nombre, cedula, telefono, correo);
        this.salario=salario;
    }

    public Double getSalario(){
        return salario;
    }

    public void setSalario(Double salario){
        this.salario=salario;
    }

    
}
