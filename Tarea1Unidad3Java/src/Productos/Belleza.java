package Productos;

import Productos.helpers.tipoProducto;

public class Belleza extends Producto {
    private String marca;
    public Belleza(String nombre, double precio, int stock, String fechaImportacion, String numSerie, String marca) {
        super(nombre, tipoProducto.BELLEZA, precio, stock, fechaImportacion, numSerie);
        this.marca=marca;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String getDatos(){
        return String.format("%s    Marca: %s", super.getDatos(), getMarca());
    }
}
