package Productos;

import Productos.helpers.tipoProducto;

public class Electrodomesticos extends Producto {
    private  String marca;
    public Electrodomesticos(String nombre, double precio, int stock, String fechaImportacion, String numSerie, String marca) {
        super(nombre, tipoProducto.ELECTRODOMESTICOS, precio, stock, fechaImportacion, numSerie);
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
