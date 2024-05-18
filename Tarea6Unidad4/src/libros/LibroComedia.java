package libros;

import biblioteca.Biblioteca;
import biblioteca.utils.DatosComun;
import libros.constants.Genero;
import libros.constants.SubgeneroComedia;
import libros.utils.LibrosUtils;
import utils.JsonClass;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class LibroComedia extends Libro{
    private SubgeneroComedia subgenero;

    public LibroComedia(String nombre, String autor, String editorial, LocalDate fechaPublicacion, double precio, int stock, SubgeneroComedia subgenero) {
        super(nombre, autor, editorial, fechaPublicacion, precio, stock, Genero.COMEDIA);
        this.subgenero = subgenero;
    }

    public static void registrarLibro() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = LibrosUtils.obtenerLibrosDatosComun();

        String nombre = datosComun.get(0);
        String autor = datosComun.get(1);
        String editorial = datosComun.get(2);
        LocalDate fechaPublicacion = LocalDate.parse(datosComun.get(3));
        double precio = Double.parseDouble(datosComun.get(4));
        int stock = Integer.parseInt(datosComun.get(5));

        System.out.println("Ingresa el subgenero del libro");
        System.out.println("Selecciona una opción");
        System.out.println("1. Musical");
        System.out.println("2. Física");
        System.out.println("3. Negra");

        int opcionSubgenero = 0;
        SubgeneroComedia subgeneroInput = null;

        if (opcionSubgenero == 1) {
            subgeneroInput = SubgeneroComedia.MUSICAL;
        } else if (opcionSubgenero == 2) {
            subgeneroInput = SubgeneroComedia.FISICA;
        }else {
            subgeneroInput = SubgeneroComedia.NEGRA;
        }

        LibroComedia libroComedia = new LibroComedia(nombre, autor, editorial, fechaPublicacion, precio, stock, subgeneroInput);
        JsonClass.addLibroJson();
    }
    public void eliminarLibro(){

    }


    //flitros
    @Override
    protected void filtrarPorID(int ID) {
        Biblioteca.libros.get(Genero.COMEDIA).stream().filter(libro -> libro.getId() == ID).forEach(libro -> System.out.println(libro.toString()));
    }
    @Override
    protected void filtrarPorFecha(LocalDate Fecha) {
        Biblioteca.libros.get(Genero.COMEDIA).stream().filter(libro -> libro.getFechaPublicacion() == Fecha).forEach(libro -> System.out.println(libro.toString()));
    }
    @Override
    protected void filtrarPorPrecio(double precio) {
        Biblioteca.libros.get(Genero.COMEDIA).stream().filter(libro -> libro.getPrecio() == precio).forEach(libro -> System.out.println(libro.toString()));
    }
    @Override
    protected void filtrarPorLetra(char letra) {
        Biblioteca.libros.get(Genero.COMEDIA).stream().filter(libro -> libro.getletraAutor() == letra).forEach(libro -> System.out.println(libro.toString()));
    }

    @Override
    protected void filtrarPorNombre(String nombre) {
        Biblioteca.libros.get(Genero.COMEDIA).stream().filter(libro -> libro.getNombre() == nombre).forEach(libro -> System.out.println(libro.toString()));
    }

    @Override
    protected void filtrarPorStock(int stock) {
        Biblioteca.libros.get(Genero.COMEDIA).stream().filter(libro -> libro.getStock() == stock).forEach(libro -> System.out.println(libro.toString()));
    }
    @Override
    protected void filtrarPorEditorial(String editorial) {
        Biblioteca.libros.get(Genero.COMEDIA).stream().filter(libro -> libro.getEditorial() == editorial).forEach(libro -> System.out.println(libro.toString()));
    }
}
