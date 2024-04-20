
package usuarios;
import usuarios.helpers.Rol;

import java.time.LocalDate;
import java.util.Random;

public class Usuario {
    private static int CANTIDAD = 1;
    private int id;
    private String nombre;
    private String apellido;
    private String numeroTelefono;
    private Rol rol;

    private String nombreUsuario;
    private String contrasena;
    
    public Usuario(String nombre, String apellido, Rol rol,  String numeroTelefono, String nombreUsuario, String contrasena){
        this.nombre=nombre;
        this.apellido=apellido;
        this.rol=rol;
        this.numeroTelefono=numeroTelefono;
        this.nombreUsuario=nombreUsuario;
        this.contrasena=contrasena;
        this.id=id;
        CANTIDAD++;
    }
    public String toString(){
        return String.format("Id: %d \nNombre completo: %s %s \nRol: %s", id, nombre, apellido, rol);
    }

    

    Random rd=new Random();

    public static int getCANTIDAD() {
        return CANTIDAD;
    }
    public static void setCANTIDAD(int CANTIDAD) {
        CANTIDAD = CANTIDAD;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    
}
