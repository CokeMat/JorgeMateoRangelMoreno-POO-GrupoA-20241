package usuarios;

import usuarios.helpers.Rol;
import java.time.LocalDate;
import java.util.*;

import biblioteca.Biblioteca;
import biblioteca.utils.DatosComun;
import utils.Fecha;
import utils.JsonClass;

public class Trabajador extends Usuario{
    private double salario;
    private String departamento;
    private int edad;
    private String fechaRegistro;
    public Trabajador(String nombre, String apellido, int edad, String departamento, String numeroTelefono, String nombreUsuario, String contrasena, double salario, String fechaRegistro) {
        super(nombre, apellido, Rol.TRABAJADOR.toString(), numeroTelefono, nombreUsuario, contrasena);
        this.edad = edad;
        this.salario = salario;
        this.departamento = departamento;
        this.fechaRegistro = fechaRegistro;
        setROL(Rol.TRABAJADOR);
    }

    public double getSalario() {
        return salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getEdad() {
        return edad;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    @Override
    public String toString() {
        return String.format("%s \nEdad: %d \nSalario: $%.2f \nDepartamento: %s \nFecha de Registro: %s\n",
                super.toString(), edad, salario, departamento, fechaRegistro);
    }

    public static void addTrabajadores() {
        ArrayList<String> datos = DatosComun.obtenerDatosComun(Rol.TRABAJADOR);
        Scanner sc = new Scanner(System.in);

        String nombre = datos.get(0);
        String apellido = datos.get(1);
        String telefono = datos.get(2);
        String nombreUsuario = datos.get(3);
        String contrasena = datos.get(4);

        System.out.print("Edad: ");
        int edad = sc.nextInt();

        System.out.print("Departamento: ");
        String departamento = sc.next();

        System.out.print("Salario: ");
        double salario = sc.nextDouble();

        String fechaRegistro = Fecha.askForDate("registro");

        Trabajador trabajador = new Trabajador(nombre, apellido, edad, departamento, telefono, nombreUsuario, contrasena, salario, fechaRegistro);

        Biblioteca.usuarios.computeIfAbsent(Rol.TRABAJADOR.toString(), k -> new ArrayList<>()).add(trabajador);
        JsonClass.addUsuarioJson();

        System.out.println("\nTrabajador Registrado\n");
    }

    public static void showTrabajadores() {
        if (Biblioteca.usuarios.getOrDefault(Rol.TRABAJADOR.toString(), new ArrayList<>()).isEmpty()) {
            System.out.println("No hay trabajadores registrados");
        } else {
            for (Usuario usuario : Biblioteca.usuarios.get(Rol.TRABAJADOR.toString())) {
                Trabajador trabajador = (Trabajador) usuario;
                System.out.println(trabajador.toString());
            }
        }
    }

    public static Trabajador showInfoTrabajador() {
        Scanner sc = new Scanner(System.in);
        if (Biblioteca.usuarios.getOrDefault(Rol.TRABAJADOR.toString(), new ArrayList<>()).isEmpty()) {
            System.out.println("No hay trabajadores registrados");
            return null;
        }

        showTrabajadores();
        System.out.print("¿De qué trabajador quiere ver su información? ");
        int i = sc.nextInt();

        if (i > 0 && i <= Biblioteca.usuarios.get(Rol.TRABAJADOR.toString()).size()) {
            Trabajador trabajador = (Trabajador) Biblioteca.usuarios.get(Rol.TRABAJADOR.toString()).get(i - 1);
            System.out.println(trabajador.toString());
            return trabajador;
        } else {
            System.out.println("No se seleccionó ninguno de los trabajadores mostrados");
            return null;
        }
    }

    public static void eliminarTrabajador() {
        Scanner sc = new Scanner(System.in);
        if (Biblioteca.usuarios.getOrDefault(Rol.TRABAJADOR.toString(), new ArrayList<>()).isEmpty()) {
            System.out.println("No hay trabajadores registrados");
            return;
        }

        showTrabajadores();
        System.out.print("¿Cuál trabajador quiere eliminar? ");
        int i = sc.nextInt();

        if (i > 0 && i <= Biblioteca.usuarios.get(Rol.TRABAJADOR.toString()).size()) {
            ArrayList<Usuario> trabajadores = Biblioteca.usuarios.get(Rol.TRABAJADOR.toString());
            trabajadores.remove(i - 1);
            Biblioteca.usuarios.replace(Rol.TRABAJADOR.toString(), trabajadores);
            JsonClass.addUsuarioJson();
            System.out.println("Trabajador eliminado exitosamente.");
        } else {
            System.out.println("No se seleccionó ninguno de los trabajadores mostrados");
        }
    }

    public static void modifyInfo() {
        Trabajador trabajador = showInfoTrabajador();
        if (trabajador == null) {
            System.out.println("ERROR, vuelva a intentarlo");
            return;
        }

        Scanner sc = new Scanner(System.in);
        int index = Biblioteca.usuarios.get(Rol.TRABAJADOR.toString()).indexOf(trabajador);

        while (true) {
            System.out.println("¿Qué quiere modificar?");
            System.out.println("1. Nombre \n2. Apellido \n3. Telefono \n4. Nombre de Usuario \n5. Contraseña \n6. Volver al menú Trabajador");
            System.out.print("Opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Nuevo nombre: ");
                    trabajador.setNombre(sc.next());
                    System.out.println("Nombre actualizado");
                    break;
                case 2:
                    System.out.print("Nuevo apellido: ");
                    trabajador.setApellido(sc.next());
                    System.out.println("Apellido actualizado");
                    break;
                case 3:
                    System.out.print("Nuevo número de teléfono: ");
                    trabajador.setNumeroTelefono(sc.next());
                    System.out.println("Número de teléfono actualizado");
                    break;
                case 4:
                    System.out.print("Nuevo nombre de usuario: ");
                    trabajador.setNombreUsuario(sc.next());
                    System.out.println("Nombre de usuario actualizado");
                    break;
                case 5:
                    System.out.print("Contraseña nueva: ");
                    trabajador.setContrasena(sc.next());
                    System.out.println("Contraseña actualizada");
                    break;
                case 6:
                    System.out.println("Volviendo al menú Trabajador...");
                    break;
                default:
                    System.out.println("Opción inválida, vuelva a elegir.");
            }
            if (opcion == 6) break;
        }
        Biblioteca.usuarios.get(Rol.TRABAJADOR.toString()).set(index, trabajador);
        JsonClass.addUsuarioJson();
    }
}
