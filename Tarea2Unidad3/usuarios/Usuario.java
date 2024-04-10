
package usuarios;
import usuarios.helpers.Rol;
import java.util.Random;

public class Usuario {
    private static int CANTIDAD = 1;
    private int id;
    private String nombre;
    private String apellido;
    private Rol rol;
    
    public Usuario(String nombre, String apellido, Rol rol){
        this.nombre=nombre;
        this.apellido=apellido;
        this.rol=rol;
        id= rd.nextInt(1000, 9999);
        CANTIDAD++;
    }
    public String toString(){
        return String.format("Id: %d \nNombre completo: %s %s \nRol: %s", id, nombre, apellido, rol);
    }

    Random rd=new Random();
}
