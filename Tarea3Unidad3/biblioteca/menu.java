package biblioteca;
import java.util.Scanner;

import usuarios.Usuario;

public class menu {
    Scanner sc=new Scanner(System.in);
    public void showMenuCliente(){
        while (true){
        System.out.println("---------C  L  I  E  N  T  E---------");
        System.out.println("Elija una de las siguientes opciones:");
        System.out.println("1. Rentar libro \n2. Devolver libro \n3.Ver libros disponibles \n4.Mostrar Informacion \n5. Ver libros rentados \n6. Salir");
       int opcion=sc.nextInt();

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
                case 6:
                inicioSesion();
                    break;
                default:
                System.out.println("Opcion invalida, vuelva a seleccionar otra opcion.");
                    break;
            }
            if(opcion==6){
                System.out.println("Saliendo del sistema");
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
                case 6: 
                inicioSesion();
                    break;
                default:
                System.out.println("Opcion invalida, vuelva a seleccionar otra opcion.");
                    break;
            }
            if(opcion==6){
            System.out.println("Saliendo del sistema");
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
                case 6:
                inicioSesion();
                    break;
                default:
                System.out.println("Opcion invalida, vuelva a seleccionar otra opcion.");
                    break;
            }
            if(opcion==6){
                System.out.println("Saliendo del sistema");
            break;
           }
        }
    }
    public void inicioSesion(){
        boolean datosCorrectos=false;
        do{
            System.out.println("Bienvenidoo al sistema de la biblioteca");
            System.out.println("Incia sesion para continuar");

            System.out.println("Ingresa tu usuario: ");
            String usuario = sc.nextLine();

            System.out.println("Ingrese contraseña: ");
            String contrasena = sc.nextLine();

            Usuario usuarioActual = biblioteca.verificarInicioSesion(usuario, contrasena);

            if (usuarioActual != null) {
                datosCorrectos=true;
                seleccionarMenu(usuarioActual);
            }
        }while (!datosCorrectos);
    }

    private void seleccionarMenu(Usuario usuario){
        switch (usuario.getRol()) {
            case CLIENTE: showMenuCliente();
            break;
            case TRABAJADOR: showMenuTrabajador();
            break;
            case GERENTE: showMenuGerente();
            break;
        }
    }

}