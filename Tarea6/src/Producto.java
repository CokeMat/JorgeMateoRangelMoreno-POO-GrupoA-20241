import java.util.Scanner;
public class Producto {
    private String nombre = "Television";
    private double precio = 14999.99;
    private int stock = 45;

    public Producto() {
        this.nombre = nombre;
        this.precio=precio;
        this.stock=stock;
    }
    public Producto(String nombre, double precio){
        this.nombre = nombre;
        this.precio=precio;
    }
    Scanner sc = new Scanner(System.in);
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        while(precio<=0){
            System.out.println("Vuelva a introducir el precio correctamente: ");
            double newPrecio = sc.nextFloat();
            precio=newPrecio;
        }
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        while(stock<=0){
            System.out.println("Vuelva a introducir la cantidad de productos correctamente: ");
            int newStock = sc.nextInt();
            stock=newStock;
        }
        this.stock = stock;
    }
    int aumentarStock(int cantidad, int stock){
        while(cantidad<0){
            System.out.println("Vuelva a introducir la cantidad correctamente: ");
            int newCant = sc.nextInt();
            cantidad=newCant;
        }
        stock=stock+cantidad;
        return stock;
    }
    int reducirStock(int cantidad, int stock){
        while(cantidad>stock || cantidad<0){
            System.out.println("Vuelva a introducir la cantidad correctamente: ");
            int newCant = sc.nextInt();
            cantidad=newCant;
        }
        stock=stock-cantidad;
        return stock;
    }
}