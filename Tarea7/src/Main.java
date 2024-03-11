import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Employee employee;
        Scanner sc= new Scanner(System.in);
        Random num= new Random();
        System.out.println("Bienvenido al banco, seleccione una de las siguientes opciones:");
        Banco banco = new Banco();


        while (true) {
            System.out.println("** MENU   B A N C O **");
            System.out.printf(" 1. Mostrar Empleados\n 2. Mostrar detalles de un empleado\n 3. Agregar Usuario\n 4. Agregar cuenta a un Usuario\n 5. Depositar a una cuenta\n 6. Retirar dinero de una cuenta\n 7. Salir\n");
            System.out.printf("Opcion: ");
            int opcion=sc.nextInt();
            if (opcion==7){
                break;
            }

            switch (opcion){

                case 1:
                    banco.mostrarEmpleados();
                    break;
                case 2:
                    banco.mostrarInfoEmpleado();
                    break;
                case 3:
                    banco.ingresarDatos();
                    break;
                case 4:
                    banco.agregarCuentaEmpleado();
                    break;
                case 5:
                    banco.depositarDinero();
                    break;
                case 6:
                    banco.retirarDinero();
                    break;
                default:
                    System.out.println("No se selecciono ninguna de las opciones mostradas, vuelva a elegir.");
            }
            System.out.println();
        }
        System.out.println("¡Hasta luego! Vuelva pronto.");
    }
}