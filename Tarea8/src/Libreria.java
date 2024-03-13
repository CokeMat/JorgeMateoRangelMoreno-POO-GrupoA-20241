import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Libreria {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Libro> libros = new ArrayList<>();

    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    public String mostrarEmpleados() {
        if (usuarios.isEmpty()) {
            System.out.println("*****  V  A  C  I  O  ******");
            System.out.println("Agregue un usuario con la opción '3'");
        } else {
            int i = 0;
            for (Usuario usuario : usuarios) {
                System.out.printf("Usuario %d:\n", i += 1);
                System.out.printf("%s\n",  usuario.getDatos());
            }
        }
        return ("");
    }
    public String mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("*****  V  A  C  I  O  ******");
            System.out.println("No hay libros registrados");
        } else {
            int i = 0;
            for (Libro libro : libros) {
                System.out.printf("Libro %d:\n", i += 1);
                System.out.printf("%s\n", libro.getDatos());
            }
        }
        return ("");
    }
    public void agregarUsuarios() {
        int id = random.nextInt(100000, 999999);
        System.out.println("-Nombre:");
        String name = sc.next();
        System.out.println("-Edad:");
        int edad = sc.nextInt();
        Usuario usuario = new Usuario(name, id, edad);
        usuarios.add(usuario);
        System.out.println("Se han registrado con éxito los datos");
        System.out.println("****************");
    }
    public void agregarLibros() {
        int id = random.nextInt(100000, 999999);
        System.out.println("-Nombre:");
        String name = sc.next();
        System.out.println("-Autor:");
        String autor = sc.next();
        Libro libro = new Libro(name, autor, id);
        libros.add(libro);
        System.out.println("Se han registrado con éxito los datos");
        System.out.println("****************");
    }
    public String rentarLibros(){
        if(libros.isEmpty()){
            System.out.println("*****  V  A  C  I  O  ******");
            System.out.println("No hay libros para rentar.");
        }else{
            System.out.println("¿Que empleado es el que va a rentar un libro");
        mostrarEmpleados();
        int i = sc.nextInt();
        if (i > usuarios.size()) {
            System.out.println("No se ha encontrado el empleado.");
        } else {
            System.out.println("¿Que libro le gustaria rentar?:");
            mostrarLibros();
            int j = sc.nextInt();
            if (j > libros.size()) {
                System.out.println("No se ha encontrado el libro ingresado.");
            } else {
                Libro libro = libros.get(j - 1);
                if (libro.isRentado()==true) {
                    System.out.println("El libro ya ha sido rentado.");
                } else {
                    libro.setRentado(true);
                    Usuario usuario = usuarios.get(i - 1);
                    usuario.addLibro(libro);
                    System.out.println("Libro rentado con éxito.");
            }
        }}}
        return ("");
    }
    public String mostrarLibrosRentados() {
        if (libros.isEmpty()) {
            System.out.println("*****  V  A  C  I  O  ******");
            System.out.println("No hay libros registrados");
        } else {
            int i = 0;
            System.out.println("Libros rentados:");
            for (Libro libro : libros) {
                if (libro.isRentado()==true) {
                System.out.printf("Libro %d:\n", i += 1);
                System.out.printf("%s\n", libro.getDatos());}
            }
        }
        return ("");
    }
    public String mostrarLibrosDisponibles() {
        if (libros.isEmpty()) {
            System.out.println("*****  V  A  C  I  O  ******");
            System.out.println("No hay libros registrados");
        } else {
            int i = 0;
            System.out.println("Libros disponibles:");
            for (Libro libro : libros) {
                if (libro.isRentado()==false) {
                    System.out.printf("Libro %d:\n", i += 1);
                    System.out.printf("%s\n", libro.getDatos());}
            }
        }
        return ("");
    }
    public String mostrarUsuariosLibros(){
        if (usuarios.isEmpty()){
            System.out.println("*****  V  A  C  I  O  ******");
            System.out.println("Ningun usuario ha rentado un libro");
        }else{
            int i = 0;
           for (Usuario usuario : usuarios){
               System.out.println("Libros rentados por el usuario");
               System.out.printf("Usuario %d:\n", i += 1);
               System.out.printf("%s\n",  usuario.getDatos());
               System.out.println(usuario.getLibrosRentados());
               System.out.println("***********************");
           }
        }
        return ("");
    }
}