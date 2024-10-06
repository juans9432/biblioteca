package co.edu.uniquindio.poo.model;

public class Empleado extends Persona{
    private int salario;
    private int antiguedad;

    public Empleado(String nombre, String cedula, String telefono, String correo, int salario, int antiguedad){
        super(nombre, cedula, telefono, correo);
        assert salario >= 0;
        assert antiguedad >= 0;
        this.salario=salario;
        this.antiguedad=antiguedad;
    }

    public int getSalario(){
        return salario;
    }

    public void setSalario(int salario){
        this.salario=salario;
    }

    public int getAntiguedad(){
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad){
        this.antiguedad=antiguedad;
    }

    
}
