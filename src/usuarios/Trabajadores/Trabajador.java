package usuarios.Trabajadores;

import usuarios.Usuario;
import usuarios.utils.Rfc;
import usuarios.utils.Rol;

public class Trabajador extends Usuario {
    private double sueldo;
    private String RFC;

    public Trabajador(String nombre, String apellidoP, String apellidoM,
            String fechaDeNacimiento, String fechaRegistro, String direccion, String estado, String genero,
            String nombreUsuario,
            String contrasena, Rol rol,
            String carrera,
            double sueldo) {
        super(nombre, apellidoP, apellidoM, fechaDeNacimiento, fechaRegistro, direccion, estado, genero,
                nombreUsuario, contrasena, rol, carrera);
        this.sueldo = sueldo;
        // MÉTODO PARA EL RFC
        this.RFC = Rfc.generate(apellidoP, apellidoM, nombre, fechaDeNacimiento);
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    @Override
    public String toString() {

        return String.format("\n| %s | RFC: %s | SUELDO: %s | NOMBRE DE USUARIO: %s | ", super.toString(), getRFC(),
                getSueldo(), getNombreUsuario());

    }
}
