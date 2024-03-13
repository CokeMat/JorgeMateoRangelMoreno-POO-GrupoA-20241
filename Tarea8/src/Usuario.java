import java.util.ArrayList;
public class Usuario {
    private String nombre;
    private int id;
    private int edad;


    private ArrayList<Libro> librosRentados;

    public Usuario(String nombre, int id, int edad){
        this.nombre=nombre;
        this.edad=edad;
        this.id=id;
        this.librosRentados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public int getEdad() {
        return edad;
    }

    public String getLibrosRentados() {
        for (Libro libro : librosRentados){

        System.out.println("Título del libro: "+libro.getNombre());
        System.out.println("Autor: "+libro.getAutor());
        System.out.println("ID: "+libro.getId());}
        return ("");
    }

    public String getDatos(){
        System.out.println("Nombre:"+getNombre());
        System.out.println("ID: "+getId());
        System.out.println("Edad: "+getEdad());
        return ("");
    }
    public void addLibro(Libro libro){
        librosRentados.add(libro);
    }
}