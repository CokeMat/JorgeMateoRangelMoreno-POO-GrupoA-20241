public class Main {
    public static void main(String[] args) {
        System.out.println("Ejercicio 1 Libro");
        Persona p1 = new Persona("Marta", 35, "Mujer");
        p1.datos();
        Persona p2 = new Persona("Esteban", 14, "Hombre");
        p2.datos();
        Persona p3 = new Persona("Karla", 18, "Mujer");
        p3.datos();
        Persona p4 = new Persona("Carlos", 66, "Hombre");
        p4.datos();
        System.out.println();

        System.out.println("Ejercicio 2 Libro:");
        Libro l1 = new Libro();
        System.out.println(l1.titulo);
        System.out.println(l1.Autor);
        System.out.println(l1.year);
        System.out.println("********");
        Libro l2 = new Libro();
        System.out.println(l2.titulo="El señor de los anillos");
        System.out.println(l2.Autor="J.R.R. Tolkien");
        System.out.println(l2.year=1954);
        System.out.println("*********");
        Libro l3 = new Libro();
        System.out.println(l3.titulo="Cien años de soledad");
        System.out.println(l3.Autor="Gabriel Garcia Márquez");
        System.out.println(l3.year=1967);
        System.out.println("*********");
        Libro l4 = new Libro();
        System.out.println(l4.titulo="El Principito");
        System.out.println(l4.Autor="Antoine de Saint-Exupéry");
        System.out.println(l4.year=1943);
        System.out.println("*********");
        System.out.println();

        System.out.println("Ejercicio 3 Rectangulo");
        Rectangulo r1 = new Rectangulo(3.5, 6.7);
        r1.calculos();
        Rectangulo r2 = new Rectangulo(7.9, 5.4);
        r2.calculos();
        Rectangulo r3 = new Rectangulo(65, 40);
        r3.calculos();
        Rectangulo r4 = new Rectangulo(10.1, 2.1);
        r4.calculos();
        }
    }