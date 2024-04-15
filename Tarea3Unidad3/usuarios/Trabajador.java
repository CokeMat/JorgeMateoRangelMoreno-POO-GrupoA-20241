package usuarios;

import usuarios.helpers.Rol;
import java.time.LocalDate;
import java.util.*;

public class Trabajador extends Usuario{
    private double salario;
    private String departamento;
    private int edad;
    private LocalDate fechaRegistro;
    public Trabajador(String nombre, String apellido, int edad, String departamento, LocalDate fechaNacimiento, String nombreUsuario, String contrasena) {
        super(nombre, apellido, Rol.TRABAJADOR, fechaNacimiento, nombreUsuario, contrasena);
        this.edad=edad;
        this.salario=salario;
        this.departamento=departamento;
        this.fechaRegistro = LocalDate.now();
    }
    Random rd=new Random();
    public double getSalario() {
        return salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getEdad() {
        return edad;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    @Override
    public String toString(){
        return String.format("%s \nEdad: %d \nsalario: $%.2f \nDepartamento: %s \nFecha de Registro: %s \n\n", super.toString(), getEdad(), getSalario(), getDepartamento().toString(), getFechaRegistro().toString());
    }
}
