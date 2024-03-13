import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Bienvenido a la libreria, seleccione una de las siguientes opciones:");
        Libreria libreria = new Libreria();


        while (true) {
            System.out.println("** MENU   L I B R E R I A **");
            System.out.printf(" 1. Mostrar Usuarios\n 2. Mostrar Libros\n 3. Registrar Usuario\n 4. Registrar Libros\n 5. Rentar un libro\n 6. Mostrar libros rentados\n 7. Mostrar libros disponibles\n 8. Usuarios con libros\n 9. Salir\n");
            System.out.printf("Opcion: ");
            int opcion=sc.nextInt();
            if (opcion==9){
                break;
            }
            switch (opcion){

                case 1:
                    libreria.mostrarEmpleados();
                    break;
                case 2:
                    libreria.mostrarLibros();
                    break;
                case 3:
                    libreria.agregarUsuarios();
                    break;
                case 4:
                    libreria.agregarLibros();
                    break;
                case 5:
                    libreria.rentarLibros();
                    break;
                case 6:
                    libreria.mostrarLibrosRentados();
                    break;
                case 7:
                    libreria.mostrarLibrosDisponibles();
                    break;
                case 8:
                    libreria.mostrarUsuariosLibros();
                    break;
                default:
                    System.out.println("No se selecciono ninguna de las opciones mostradas, vuelva a elegir.");
            }
            System.out.println();
        }
        System.out.println("¡Hasta luego! Vuelva pronto.");
    }
}