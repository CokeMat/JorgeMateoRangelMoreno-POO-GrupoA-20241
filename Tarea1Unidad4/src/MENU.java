import Shape.*;
import java.util.Scanner;

public class MENU {

    public static void runPrograme() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("**** F I G U R A S --- G E O M E T R I C A S ****");
            System.out.println("Seleccione una figura");
            System.out.println("1. Circulo \n2. Triangulo \n3. Trapecio \n4. Romboide \n5. Salir");
            System.out.printf("Opcion: ");
            int opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    Circulo circulo = new Circulo();
                    circulo.circulo();
                    break;
                case 2:
                    Triangulo triangulo = new Triangulo();
                    triangulo.triangulo();
                    break;
                case 3:
                    Trapecio trapecio = new Trapecio();
                    trapecio.trapecio();
                    break;
                case 4:
                    Romboide romboide = new Romboide();
                    romboide.romboide();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción invalida, vuelva a intentarlo");
            }
            if (opcion == 5)break;
        }
    }

}
