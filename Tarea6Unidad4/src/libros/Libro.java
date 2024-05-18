package libros;

import java.time.LocalDate;

import biblioteca.Biblioteca;
import libros.constants.Genero;

public abstract class Libro {
    private static int CANTIDAD_LIBROS = 1;
    private int id;
    private String nombre;
    private String autor;
    private String editorial;
    private LocalDate fechaPublicacion;
    private double precio;
    private int stock;
    private Genero genero;
    
    public Libro(String nombre, String autor, String editorial, LocalDate fechaPublicacion, double precio,
            int stock, Genero genero) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
        this.precio = precio;
        this.stock = stock;
        this.genero = genero;
        CANTIDAD_LIBROS++;
    }

    public static int getCantidadLibros() {
        return CANTIDAD_LIBROS;
    }

    public static void setCantidadLibros(int cantidadLibros) {
        CANTIDAD_LIBROS = cantidadLibros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    //filtros
    protected abstract void filtrarPorID(int ID);
    protected abstract void filtrarPorFecha(LocalDate Fecha);
    protected abstract void filtrarPorNombre(String nombre);
    protected abstract void filtrarPorLetra(char letra);
    protected abstract void filtrarPorPrecio(double precio);
    protected abstract void filtrarPorStock(int stock);
    protected abstract void filtrarPorEditorial(String editorial);

    protected void filtrarPorGenero(Genero genero){
        Biblioteca.libros.get(genero).stream().filter(libro -> libro.getGenero() == genero).forEach(libro -> System.out.println(libro.toString()));
    }

    public char getletraAutor(){
        String autor = getAutor();
        char letra = autor.charAt(0);
        return letra;
    }

}
