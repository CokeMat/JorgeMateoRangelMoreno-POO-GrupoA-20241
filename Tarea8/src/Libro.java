public class Libro {
    private String nombre;
    private String autor;
    private int id;
    private boolean rentado=false;

    public Libro(String nombre, String autor, int id) {
        this.nombre = nombre;
        this.autor = autor;
        this.id=id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public int getId() {
        return id;
    }

    public boolean isRentado() {
        return rentado;
    }

    public String getDatos(){
        System.out.println("Título del libro:"+getNombre());
        System.out.println("Autor: "+getAutor());
        System.out.println("ID: "+getId());
        return ("");
    }

    public void setRentado(boolean rentado) {
        this.rentado = rentado;
    }
}