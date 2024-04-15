package usuarios;

import usuarios.helpers.Rol;
import java.time.LocalDate;

public class Cliente extends Usuario {
    private LocalDate fechaRegistro;
    
    public Cliente(String nombre, String apellido, LocalDate fechaNacimiento, String nombreUsuario, String contrasena){
    super(nombre, apellido, Rol.CLIENTE, fechaNacimiento, nombreUsuario, contrasena);
    this.fechaRegistro = LocalDate.now();
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    @Override
    public String toString(){
        return String.format("%s \nFecha de registro: %s\n\n", super.toString(), fechaRegistro.toString());}
}