package src.tarjeta;

import java.util.*;
import src.tarjeta.utils.DatosTarjeta;


public class Tarjeta {
    private long numSerie, clabeInterbancaria;
    private int CVV;
    private String fechaCreacion, fechaVencimiento, fechaUltimoMov;
    private double saldo;
    //private TipoTarjeta tipoTarjeta; Sólo para las de crédito

    public Tarjeta(Long numSerie, Long clabeInterbancaria, int CVV, String fechaCreacion, String fechaVencimiento,
            String fechaUltimoMov, double saldo) {
        this.CVV = CVV;
        this.clabeInterbancaria = clabeInterbancaria;
        this.fechaCreacion = fechaCreacion;
        this.fechaUltimoMov = fechaUltimoMov;
        this.fechaVencimiento = fechaVencimiento;
        this.numSerie = numSerie;
        this.saldo = saldo;
    }

    // Getters y Setters
    public long getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(long numSerie) {
        this.numSerie = numSerie;
    }

    public long getClabeInterbancaria() {
        return clabeInterbancaria;
    }

    public void setClabeInterbancaria(long clabeInterbancaria) {
        this.clabeInterbancaria = clabeInterbancaria;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int cVV) {
        CVV = cVV;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFechaUltimoMov() {
        return fechaUltimoMov;
    }

    public void setFechaUltimoMov(String fechaUltimoMov) {
        this.fechaUltimoMov = fechaUltimoMov;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // crear y mostrar tarjeta
    public Tarjeta crearTarjeta() {
        ArrayList<String> datos = DatosTarjeta.obtenerDatosTarjeta();
        Long numeroSerie = Long.parseLong(datos.get(0));
        Long clabeInterbancaria = Long.parseLong(datos.get(1));
        int CVV = Integer.parseInt(datos.get(2));
        String fechaCreacion = datos.get(3);
        String fechaUltimoMovimiento = datos.get(4);
        String fechaVencimiento = datos.get(5);
        double saldo = Double.parseDouble(datos.get(6));

        return new Tarjeta(numeroSerie, clabeInterbancaria, CVV, fechaCreacion, fechaVencimiento, fechaUltimoMovimiento, saldo);
    }
    
    @Override
    public String toString(){
        String datos1 = String.format(" | Número de Serie: %d | Clabe Interbancaria: %d | CVV: %d |", getNumSerie(), getClabeInterbancaria(), getCVV());
        String datos2 = String.format("\n | Fecha de Creación: %s | Fecha de Vencimiento: %s | Fecha y Hora del Último Movimiento: %s | ", getFechaCreacion(), getFechaVencimiento(), getFechaUltimoMov());
        String datos3 = String.format("Saldo: $%.2f | ", getSaldo());
        return datos1+datos2+datos3;
    }
}