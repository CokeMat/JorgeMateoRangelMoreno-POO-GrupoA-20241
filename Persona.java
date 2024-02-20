public class Persona {
    String nombre;
    int edad;
    String genero;

    public Persona(String nombre, int edad, String genero){
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }
    public void datos(){
        System.out.printf("-Nombre: %s\n -Edad: %d\n -Género: %s\n", nombre, edad, genero);
        System.out.println("********");
    }

}