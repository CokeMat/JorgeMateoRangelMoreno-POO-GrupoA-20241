package Cliente;

import Productos.Producto;

import java.time.LocalDate;
import java.util.*;
public class Cliente {
    private String nombre;
    private String id;
    private int edad;
    private int numPedido;
    private ArrayList<Producto> productosComprados;
    private ArrayList<Compras> compras;
    private LocalDate fechaPedido;
    private boolean compraHecha;


    public Cliente(String nombre, int edad) {
        this.nombre = nombre;
        this.edad=edad;
        this.numPedido= rd.nextInt(1000, 9999);
        this.id=generateID();
        this.productosComprados = new ArrayList<>();
        this.compras = new ArrayList<>();
        this.fechaPedido = LocalDate.now();
        this.compraHecha=false;
    }

    public String getNombre() {
        return nombre;
    }
    public String getId() {
        return id;
    }
    public int getEdad() {
        return edad;
    }
    public int getNumeroPedido() {
        return numPedido;
    }
    public LocalDate getFechaPedido() {
        return fechaPedido;
    }
    public boolean isCompraHecha() {
        return compraHecha;
    }
    public void setCompraHecha(boolean compraHecha) {
        this.compraHecha = compraHecha;
    }
    public String getProductosComprados(int i) {
        return (compras.get(i)).toString();
    }

    Random rd = new Random();
    public String generateID(){
        char letraNombre = getNombre().charAt(0);
        String pedido = String.valueOf(getNumeroPedido());
        setId("C"+letraNombre+("-")+pedido);
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void getDatos(){
        System.out.printf("\nID: %s \nNombre: %s \nEdad: %s \nNúmero de Pedido: %s \nFecha del pedido: %s \nCompra realizada: %b", getId(), getNombre(), getEdad(), getNumeroPedido(), getFechaPedido(), isCompraHecha());
    }
    public void pedido(Producto producto){
        productosComprados.add(producto);
    }
}