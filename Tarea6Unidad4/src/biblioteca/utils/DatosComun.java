package biblioteca.utils;

import biblioteca.Biblioteca;
import java.util.*;

import libros.Libro;
import libros.constants.Genero;
import usuarios.Gerente;
import usuarios.Usuario;
import usuarios.helpers.Rol;
import utils.UsuarioEnSesion;

import java.time.LocalDate;
public class DatosComun {
    public static ArrayList<String> obtenerDatosComun(Rol rol) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> datosComun = new ArrayList<String>();

        String rolActual = rol == Rol.CLIENTE ? "C L I E N T E" : rol == Rol.TRABAJADOR ? "T R A B A J A D O R" : "G E R E N T E";
        System.out.println(String.format("\n A Ñ A D I R     %s ", rolActual));

        System.out.println("Ingresa el nombre");
        String nombre = sc.nextLine();
        System.out.println("Ingresa el apellido");
        String apellido = sc.nextLine();
        String telefono = obtenerNumeroTelefono();
        String nombreUsuario = obtenerNombreUsuario();
        System.out.println("Ingresa la contrasena");
        String contrasena = sc.nextLine();

        datosComun.addAll(Arrays.asList(nombre, apellido, telefono, nombreUsuario, contrasena));

        return datosComun;
    }



    //Auxiliares
    public static LocalDate fechaNacimiento(String cadena){
        Scanner sc = new Scanner(System.in);
        System.out.println(cadena);
        System.out.println("Día:");
        int d = sc.nextInt();
        System.out.println("Mes;");
        int m = sc.nextInt();
        System.out.println("Año:");
        int a = sc.nextInt();
        LocalDate fechaNacimiento = LocalDate.of(a, m, d);
        return fechaNacimiento;
    }
    private static String obtenerNumeroTelefono(){
        String numeroTelefono;
        Scanner sc = new Scanner(System.in);
        while (true) {
            boolean telefonoValido = true;
            System.out.println("Ingrese el numero de telefono");
            numeroTelefono = sc.next();
            sc.nextLine();

                for (ArrayList<Usuario> lista : Biblioteca.usuarios.values()) {
                    if (!telefonoValido)
                        break;
                    for (Usuario usuario : lista) {
                        if (numeroTelefono.equals(usuario.getNumeroTelefono())) {
                            telefonoValido = false;
                            break;
                        }
                    }
            }
            if (!telefonoValido)
                System.out.println("Este número de telefono ya fue ingresado");
            else
                return numeroTelefono;
        }
    }

    private static String obtenerNombreUsuario(){
        Scanner sc = new Scanner(System.in);
        boolean nombreUsuarioExistente = true;
        String nombreUsuario = "";

        do {
            System.out.println("Ingresa el el nombre de usuario");
            nombreUsuario = sc.nextLine();

            nombreUsuarioExistente = false;
            Rol rol = null;


            if (nombreUsuarioExistente) {
                System.out.println("El nombre de usuario ya existe. Intenta de nuevo\n");
            }
        } while (nombreUsuarioExistente);

        return nombreUsuario;
    }
}
