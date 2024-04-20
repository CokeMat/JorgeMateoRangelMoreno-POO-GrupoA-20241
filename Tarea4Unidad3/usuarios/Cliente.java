package usuarios;

import usuarios.helpers.Rol;
import java.time.LocalDate;

public class Cliente extends Usuario {
    private LocalDate fechaRegistro;
    
    public Cliente(String nombre, String apellido,  String numeroTelefono, String nombreUsuario, String contrasena){
    super(nombre, apellido, Rol.CLIENTE, numeroTelefono, nombreUsuario, contrasena);
    this.fechaRegistro = LocalDate.now();
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    @Override
    public String toString(){
        return String.format("%s \nFecha de registro: %s\n\n", super.toString(), fechaRegistro.toString());}

    public void modifyInfo(){
        System.out.println("¿Que quiere modificar?");
        System.out.println("1.Nombre \n2.Apellido \n3. Fecha de Nacimiento \n4. Nombre de Usuario \n5. Contraseña \n6. Volver a menu Cliente");

    }
}