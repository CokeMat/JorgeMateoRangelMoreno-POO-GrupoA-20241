package src.usuarios.empleados;

import src.usuarios.utils.*;
import src.usuarios.Usuario;
import src.usuarios.utils.Genero;
import src.usuarios.utils.Rol;

public class Empleado extends Usuario {
	private double salario;
	private String horario;
	private String fechaIngreso;

	public Empleado(String nombre, String apellidoM, String apellidoP, String fechaNacimiento, Genero genero,
			Estado estado, String direccion, String ciudad, String nombreUsuario, String contrasena,
			Rol rol, String numTelefono, String id, double salario, String horario, String fechaIngreso) {
		super(nombre, apellidoM, apellidoP, fechaNacimiento, genero, estado, direccion, ciudad, nombreUsuario,
				contrasena, rol, numTelefono, id);
		this.salario = salario;
		this.horario = horario;
		this.fechaIngreso = fechaIngreso;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String toString() {
		return String.format("%s | SALARIO: $% .2f | HORARIO: %s | FECHA DE INGRESO: %s |", super.toString(), salario,
				horario, fechaIngreso);
	}
}

/*
 * public static void showList(Rol rol) {
 * String rolActual = rol == Rol.CLIENTE ? "C L I E N T E S"
 * : rol == Rol.CAPTURISTA ? "E M P L E A D O S"
 * : rol == Rol.INVERSIONISTA ? "I N V E R S I O N I S T A S"
 * : "E J E C U T I V O S   DE   C U E N T A";
 * System.out.println(String.format("\n L I S T A   DE   %s ", rolActual));
 * 
 * if (Sys.sucursales.get(SucursalActual.getInstancia().getSucursalActual()).
 * listaUsuarios.get(Rol.CLIENTE)
 * .isEmpty()) {
 * System.out.println("No hay " + rolActual + " registrados");
 * } else {
 * for (Usuario usuario :
 * Sys.sucursales.get(SucursalActual.getInstancia().getSucursalActual()).
 * listaUsuarios
 * .get(rol)) {
 * System.out.println(usuario);
 * }
 * }
 * }
 */