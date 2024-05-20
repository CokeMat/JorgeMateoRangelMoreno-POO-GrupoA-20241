package libros;

import biblioteca.Biblioteca;
import biblioteca.utils.DatosComun;
import libros.constants.*;
import libros.utils.LibrosUtils;
import utils.JsonClass;

import java.time.LocalDate;
import java.util.*;


public class LibroTerror extends Libro {
    private SubgeneroTerror subgenero;

    public LibroTerror(String nombre, String autor, String editorial, String fechaPublicacion, double precio, int stock, SubgeneroTerror subgenero) {
        super(nombre, autor, editorial, fechaPublicacion, precio, stock, Genero.TERROR);
        this.subgenero = subgenero;
    }

    public static void registrarLibro() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = LibrosUtils.obtenerLibrosDatosComun();

        String nombre = datosComun.get(0);
        String autor = datosComun.get(1);
        String editorial = datosComun.get(2);
        String fechaPublicacion = datosComun.get(3);
        double precio = Double.parseDouble(datosComun.get(4));
        int stock = Integer.parseInt(datosComun.get(5));

        System.out.println("Ingresa el subgenero del libro");
        System.out.println("Selecciona una opción");
        System.out.println("1. Psicológico");
        System.out.println("2. Crímen");

        int opcionSubgenero = 0;
        SubgeneroTerror subgeneroInput = null;

        if (opcionSubgenero == 1) {
            subgeneroInput = SubgeneroTerror.PSICOLOGICO;
        } else {
            subgeneroInput = SubgeneroTerror.CRIMEN;
        }

        LibroTerror libroTerror = new LibroTerror(nombre, autor, editorial, fechaPublicacion, precio, stock, subgeneroInput);

    }
    public void eliminarLibro(){
        LibrosUtils.eliminarLibro(Genero.TERROR);
    }


    //flitros
    @Override
    protected void filtrarPorID(int ID) {
        Biblioteca.libros.get(Genero.TERROR.toString()).stream().filter(libro -> libro.getId() == ID).forEach(libro -> System.out.println(libro.toString()));
    }
    @Override
    protected void filtrarPorFecha(String Fecha) {
        Biblioteca.libros.get(Genero.TERROR.toString()).stream().filter(libro -> libro.getFechaPublicacion() == Fecha).forEach(libro -> System.out.println(libro.toString()));
    }
    @Override
    protected void filtrarPorPrecio(double precio) {
        Biblioteca.libros.get(Genero.TERROR.toString()).stream().filter(libro -> libro.getPrecio() == precio).forEach(libro -> System.out.println(libro.toString()));
    }
    @Override
    protected void filtrarPorLetra(char letra) {
        Biblioteca.libros.get(Genero.TERROR.toString()).stream().filter(libro -> libro.getletraAutor() == letra).forEach(libro -> System.out.println(libro.toString()));
    }

    @Override
    protected void filtrarPorNombre(String nombre) {
        Biblioteca.libros.get(Genero.TERROR.toString()).stream().filter(libro -> Objects.equals(libro.getNombre(), nombre)).forEach(libro -> System.out.println(libro.toString()));
    }

    @Override
    protected void filtrarPorStock(int stock) {
        Biblioteca.libros.get(Genero.TERROR.toString()).stream().filter(libro -> libro.getStock() == stock).forEach(libro -> System.out.println(libro.toString()));
    }
    @Override
    protected void filtrarPorEditorial(String editorial) {
        Biblioteca.libros.get(Genero.TERROR.toString()).stream().filter(libro -> libro.getEditorial() == editorial).forEach(libro -> System.out.println(libro.toString()));
    }
}
