
package usuarios;
import usuarios.helpers.Rol;

import java.time.LocalDate;
import java.util.Random;

public class Usuario {
    private static int CANTIDAD = 1;
    private int id;
    private String nombre;
    private String apellido;
    private Rol rol;
    private LocalDate fechaNacimiento;
    private String nombreUsuario;
    private String contrasena;
    
    public Usuario(String nombre, String apellido, Rol rol, LocalDate fechaNacimiento, String nombreUsuario, String contrasena){
        this.nombre=nombre;
        this.apellido=apellido;
        this.rol=rol;
        this.fechaNacimiento=fechaNacimiento;
        this.nombreUsuario=nombreUsuario;
        this.contrasena=contrasena;
        this.id=id;
        CANTIDAD++;
    }
    public String toString(){
        return String.format("Id: %d \nNombre completo: %s %s \nRol: %s", id, nombre, apellido, rol);
    }

    Random rd=new Random();
}
