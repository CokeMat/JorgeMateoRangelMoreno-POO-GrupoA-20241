package usuarios;

import usuarios.helpers.Rol;
import java.time.LocalDate;

public class Gerente extends Usuario {
    private String cargo;
    private String horario;
    private String genero;
    private LocalDate fechaRegistro;

    public Gerente(String nombre, String apellido, String cargo, String horario, String genero, String numeroTelefono, String nombreUsuario, String contrasena) {
        super(nombre, apellido, Rol.GERENTE, numeroTelefono, nombreUsuario, contrasena);
        this.cargo = cargo;
        this.horario = horario;
        this.genero = genero;
        this.fechaRegistro = LocalDate.of(2018, 02, 16);
    }

    public String getCargo() {
        return cargo;
    }

    public String getHorario() {
        return horario;
    }

    public String getGenero() {
        return genero;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    @Override
    public String toString(){
        return String.format("%s \nCargo: %s \nHorario: %s \nGenero: %s \nFecha de Registro: %s \n\n", super.toString(), getCargo(), getHorario().toString(), getGenero().toString(), getFechaRegistro().toString());
    }
}
