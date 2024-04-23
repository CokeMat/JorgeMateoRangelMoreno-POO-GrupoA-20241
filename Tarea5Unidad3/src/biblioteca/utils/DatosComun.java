package biblioteca.utils;

import biblioteca.Biblioteca;
import java.util.*;

import usuarios.Usuario;
import usuarios.helpers.Rol;
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
    private static LocalDate fechaNacimiento(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Fecha de nacimiento:");
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
        Scanner sc = new Scanner(System.in);
        boolean numeroExistente = true;
        String telefono;
        do{
            System.out.println("Ingresa el numero de telefono");
            telefono = sc.nextLine();
            numeroExistente=false;

            for(Usuario usuario : Biblioteca.usuarios.get(Rol.GERENTE)){
                if(usuario.equals(telefono)){
                    numeroExistente = true;
                }
            }
            for(Usuario usuario : Biblioteca.usuarios.get(Rol.TRABAJADOR)) {
                if (usuario.equals(telefono)) {
                    numeroExistente = true;
                }
            }
            for(Usuario usuario : Biblioteca.usuarios.get(Rol.CLIENTE)) {
                if (usuario.equals(telefono)) {
                    numeroExistente = true;
                }
            }
        }while(numeroExistente);
        return telefono;
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
