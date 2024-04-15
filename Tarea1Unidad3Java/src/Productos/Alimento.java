package Productos;

import java.time.LocalDate;
import Productos.helpers.tipoProducto;

public class Alimento extends Producto {
    private LocalDate fechaVencimiento;

    public Alimento(String nombre, double precio, int stock, String fechaImportacion, String numSerie, LocalDate fechaVencimiento) {
        super(nombre, tipoProducto.ALIMENTO, precio, stock, fechaImportacion, numSerie);
        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    @Override
    public String getDatos(){
        return String.format("%s    Fecha de Caducidad: %s", super.getDatos(), getFechaVencimiento());
    }
}
