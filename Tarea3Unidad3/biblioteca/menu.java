package biblioteca;
import java.util.Scanner;

public class menu {
    Scanner sc=new Scanner(System.in);
    public void showMenuCliente(){
        while (true){
        System.out.println("---------C  L  I  E  N  T  E---------");
        System.out.println("Elija una de las siguientes opciones:");
        System.out.println("1. Rentar libro \n2. Devolver libro \n3.Ver libros disponibles \n4.Mostrar Informacion \n5. Ver libros rentados \n6. Salir");
       int opcion=sc.nextInt();
       if(opcion==6){
        break;
       }
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                System.out.println("Opcion invalida, vuelva a seleccionar otra opcion.");
                    break;
            }
        }
    }

    public void showMenuTrabajador(){
        while (true){
        System.out.println("---------T  R  A  B  A  J  A  D  O  R---------");
        System.out.println("Elija una de las siguientes opciones:");
        System.out.println("1. Chambear \n2. Añadir libros \n3. Mostrar Informacion libros\n 4. Modificar informacion libros \n5. Quitar libro \n6.  Salir");
       int opcion=sc.nextInt();
       if(opcion==6){
        break;
       }
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                System.out.println("Opcion invalida, vuelva a seleccionar otra opcion.");
                    break;
            }
        }
    }

    public void showMenuGerente(){
        while (true){
        System.out.println("---------G  E  R  E  N  T  E---------");
        System.out.println("Elija una de las siguientes opciones:");
        System.out.println("1. Contratar Trabajdor \n2. Correr Trabajador \n3. Mostrar Informacion de Trabajdor\n 4. Modificar informacion del trabajdor \n5. Correr a todos \n5. Ver registro de rentas \n6. Registrar Clientes \n 6.  Salir");
       int opcion=sc.nextInt();
       if(opcion==6){
        break;
       }
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                System.out.println("Opcion invalida, vuelva a seleccionar otra opcion.");
                    break;
            }
        }
    }
    public static void ejecutarMenu(){}
}
