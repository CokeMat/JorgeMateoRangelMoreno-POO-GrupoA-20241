import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("¿Qué ejercicio desea hacer?");
        Scanner scanner = new Scanner(System.in);
        int eleccion = scanner.nextInt();
        switch (eleccion) {
            case 1:
            System.out.println("Ejercicio 1, Rectangulo: ");
            System.out.println("Ingresa el ancho:");
            double ancho = scanner.nextDouble();
            System.out.println("Ingrese el alto:");
            double alto = scanner.nextDouble();

            Rectangulo rectangulo = new Rectangulo(ancho, alto);
            if (alto % 2 == 0 && ancho % 2 == 0 || alto % 2 == 1 && ancho % 2 == 1) {
                rectangulo.perimetro((int) ancho, (int) alto);
                rectangulo.area((int) ancho, (int) alto);
            } else {
                rectangulo.perimetro();
                rectangulo.area();
            }
            System.out.println("*************");
            break;

            case 2:
            System.out.println("Ejercicio 2, Empleado:");
            System.out.println("Nombre del empleado: ");
            String nombre = scanner.next();
            System.out.println("Edad:");
            int edad = scanner.nextInt();
            System.out.println("Sueldo Base:");
            double salario = scanner.nextDouble();
            System.out.println("Bonificación(es): ");
            double bonificacion = scanner.nextDouble();
            System.out.println("Cantidad de horas extras: ");
            int horasExtras = scanner.nextInt();

            Empleado empleado = new Empleado(nombre, salario, bonificacion, horasExtras);
            if (bonificacion == 0 && horasExtras == 0) {
                empleado.calcularSalario();
            } else if (horasExtras == 0) {
                empleado.calcularSalario(bonificacion);
            } else {
                empleado.calcularSalario(bonificacion, horasExtras);
            }
            System.out.println("***********");
            break;

            default:
            System.out.println("Ejercicio 3, Impuestos:");
            System.out.println("Ingresos: ");
            int ingresos = scanner.nextInt();
            System.out.println("Porcentaje de Impuestos:");
            double porcentajeImpuestos = scanner.nextFloat();
            System.out.println("Dividendos:");
            double dividendos = scanner.nextDouble();
            System.out.println("Exención: ");
            double exencion = scanner.nextDouble();
            System.out.println("Ventas realizadas: ");
            int ventas = scanner.nextInt();

            CalculadoraImpuestos Impuestos = new CalculadoraImpuestos(ingresos, porcentajeImpuestos, dividendos, exencion);
            Impuestos.calculadoraImpuestos();
            Impuestos.calculadoraImpuestos(ventas, porcentajeImpuestos);
            Impuestos.calculadoraImpuestos(dividendos, porcentajeImpuestos, exencion);
            System.out.println("***********");
        }
    }
}