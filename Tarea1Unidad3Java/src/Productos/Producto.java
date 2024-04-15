package Productos;

import java.util.Random;
import Productos.helpers.tipoProducto;

public class Producto {
    private String nombre;
    private double precio;
    private int stock;
    private String fechaImportacion;
    private String numSerie;
    private tipoProducto tipoProducto;
    private boolean comprado;

    public Producto(String nombre, tipoProducto tipoProducto,  double precio, int stock, String fechaImportacion, String numSerie) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.fechaImportacion = fechaImportacion;
        numSerie = numeroDeSerie();
        this.tipoProducto=tipoProducto;
        this.comprado=false;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getFechaImportacion() {
        return fechaImportacion;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public boolean isComprado() {
        return comprado;
    }
    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    public Productos.helpers.tipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public String getDatos(){
        System.out.printf("Nombre: %s \nPrecio: $%f \nNúmero de serie: %s \nFecha de importación: %s \nTipo de producto: %s \nCantidad de productos: %d\n", getNombre(), getPrecio(), getNumSerie(), getFechaImportacion(), getTipoProducto(), getStock());
        return("");
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    Random rd = new Random();
    public String numeroDeSerie(){
        char letraNombre=getNombre().charAt(0);
        int num = rd.nextInt(100000, 999999);
        numSerie=(letraNombre+"-"+String.valueOf(num));

        return numSerie;
    }
}