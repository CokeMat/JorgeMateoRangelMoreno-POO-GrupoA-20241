package libros.utils;

import biblioteca.Biblioteca;
import biblioteca.utils.DatosComun;
import libros.Libro;
import libros.constants.Genero;
import usuarios.helpers.Rol;
import utils.Fecha;

import java.util.*;
import java.time.*;

public class LibrosUtils {
    public static ArrayList<String> obtenerLibrosDatosComun(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = new ArrayList<>();

        System.out.println("Ingresa el nombre del libro: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingresa el autor libro: ");
        String autor = scanner.nextLine();

        System.out.println("Ingresa el editorial del libro: ");
        String editorial = scanner.nextLine();

        String fechaPublicacion = Fecha.askForDate("publicacion");

        System.out.println("Ingresa el precio del libro: ");
        double precio = scanner.nextDouble();

        System.out.println("Ingresa el stock del libro: ");
        int stock = scanner.nextInt();

        datosComun.addAll(Arrays.asList(nombre, autor, editorial, fechaPublicacion, String.valueOf(precio), String.valueOf(stock)));
        return datosComun;
    }

    public static void eliminarLibro(Genero genero){
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while(i<Biblioteca.libros.get(genero.toString()).size() && i>=0) {
            int num = 0;
            for (Libro libro : Biblioteca.libros.get(genero.toString())) {
                num++;
                System.out.println(num + ". " + libro.getNombre() + ", " + libro.getAutor());
            }
            System.out.println("¿Cuál libro desea eliminar?");
            try {
                i = sc.nextInt();
                if (i > Biblioteca.libros.get(genero.toString()).size()) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Exception error) {
                System.out.println("Ocurrio un error, vuelva a intentarlo.");
            } finally {
                sc.nextLine();
            }
        }
        Biblioteca.libros.get(genero.toString()).remove(i-1);
    }

    public static void mostrarLibros(){
        Genero genero = null;
        for(int i = 1; i<4; i++) {
            switch (i){
                case 1 -> genero = Genero.ACCION;
                case 2 -> genero = Genero.TERROR;
                case 3 -> genero = Genero.COMEDIA;
            }
            String generoActual = genero == Genero.ACCION ? "A C C I O N" : genero == Genero.COMEDIA ? "C O M E D I A" : "T E R R O R";
            int num = 0;
            System.out.printf("******* L I B R O S    D E L    G E N E R O    %s ********", generoActual);
            for (Libro libro : Biblioteca.libros.get(genero.toString())) {
                num++;
                System.out.println(num + ". " + libro.getNombre() + ", " + libro.getAutor());
            }
        }
    }
}
