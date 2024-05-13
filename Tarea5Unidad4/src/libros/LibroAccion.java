package libros;

import biblioteca.Biblioteca;
import libros.constants.Genero;
import libros.constants.SubgeneroAccion;
import libros.constants.SubgeneroComedia;
import libros.utils.LibrosUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class LibroAccion extends Libro{
    private SubgeneroAccion subgenero;
    public LibroAccion(String nombre, String autor, String editorial, LocalDate fechaPublicacion, double precio, int stock, SubgeneroAccion subgenero) {
        super(nombre, autor, editorial, fechaPublicacion, precio, stock, Genero.ACCION);
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
        System.out.println("1. Superheroes");
        System.out.println("2. Ciencia Ficción");
        System.out.println("3. Aventuras de otro mundo");

        int opcionSubgenero = 0;
        SubgeneroAccion subgeneroInput = null;

        if (opcionSubgenero == 1) {
            subgeneroInput = SubgeneroAccion.SUPERHEROES;
        } else if (opcionSubgenero == 2) {
            subgeneroInput = SubgeneroAccion.CIENCIA_FICCION;
        }else {
            subgeneroInput = SubgeneroAccion.AVENTURAS_DE_OTRO_MUNDO;
        }

        LibroAccion libroAccion = new LibroAccion(nombre, autor, editorial, fechaPublicacion, precio, stock, subgeneroInput);
    }
    public void eliminarLibro(){
        LibrosUtils.eliminarLibro(Genero.ACCION);
    }

    //flitros
    @Override
    protected void filtrarPorID(int ID) {
        Biblioteca.libros.get(Genero.ACCION).stream().filter(libro -> libro.getId() == ID).forEach(libro -> System.out.println(libro.toString()));
    }
    @Override
    protected void filtrarPorFecha(LocalDate Fecha) {
        Biblioteca.libros.get(Genero.ACCION).stream().filter(libro -> libro.getFechaPublicacion() == Fecha).forEach(libro -> System.out.println(libro.toString()));
    }
    @Override
    protected void filtrarPorPrecio(double precio) {
        Biblioteca.libros.get(Genero.ACCION).stream().filter(libro -> libro.getPrecio() == precio).forEach(libro -> System.out.println(libro.toString()));
    }
    @Override
    protected void filtrarPorLetra(char letra) {
        Biblioteca.libros.get(Genero.ACCION).stream().filter(libro -> libro.getletraAutor() == letra).forEach(libro -> System.out.println(libro.toString()));
    }

    @Override
    protected void filtrarPorNombre(String nombre) {
        Biblioteca.libros.get(Genero.ACCION).stream().filter(libro -> libro.getNombre() == nombre).forEach(libro -> System.out.println(libro.toString()));
    }

    @Override
    protected void filtrarPorStock(int stock) {
        Biblioteca.libros.get(Genero.ACCION).stream().filter(libro -> libro.getStock() == stock).forEach(libro -> System.out.println(libro.toString()));
    }

    @Override
    protected void filtrarPorEditorial(String editorial) {
        Biblioteca.libros.get(Genero.ACCION).stream().filter(libro -> libro.getEditorial() == editorial).forEach(libro -> System.out.println(libro.toString()));
    }
}
