import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Producto producto1 = new Producto();
        System.out.println("Producto 1");
        System.out.println("Producto: "+producto1.getNombre());
        System.out.println("Precio: $"+producto1.getPrecio());
        System.out.println("Cantidad de prodcutos en existencia: "+producto1.getStock());
        Scanner sc = new Scanner(System.in);
        System.out.println("**********");
        System.out.println("Producto 2");
        System.out.println("Nombre del producto:");
        String nombre = sc.next();
        System.out.println("Precio del producto:");
        double precio = sc.nextFloat();
        System.out.println("Cantidad de prodcutos en existencia: ");
        int stock = sc.nextInt();
        System.out.println();

        Producto producto2 = new Producto();
            if (stock==0){
                producto2.setNombre(nombre);
                producto2.setPrecio(precio);
                 System.out.println("Producto: "+producto2.getNombre());
                 System.out.println("Precio: $"+producto2.getPrecio());
                System.out.println("Sin existencias del producto.");
            }
            else{
                producto2.setNombre(nombre);
                producto2.setPrecio(precio);
                producto2.setStock(stock);
                System.out.println("Producto: "+producto2.getNombre());
                System.out.println("Precio: $"+producto2.getPrecio());
                System.out.println("Cantidad de existencias del producto: "+producto2.getStock());
            }

        System.out.println("1. Añadir cantidad de productos ");
        System.out.println("2. Reducir cantidad de productos ");
        int decision = sc.nextInt();
        while(decision!=1 && decision!=2){
            System.out.println("Error, ingrese 1 o 2:");
            int newDecision = sc.nextInt();
            decision = newDecision;
        }
        System.out.println("¿Cuantos productos?");
        int cantidad = sc.nextInt();
        switch (decision){
            case 1:
                System.out.printf("Habia %d %s\n Aumento a %d %s(es)", producto2.getStock(), producto2.getNombre(), producto2.aumentarStock(cantidad, stock), producto2.getNombre());
                break;
            case 2:
                System.out.printf("Habia %d %s\n Ahora hay a %d %s(es)", producto2.getStock(), producto2.getNombre(), producto2.reducirStock(cantidad, stock), producto2.getNombre());
                break;
            default:
        }
    }
}