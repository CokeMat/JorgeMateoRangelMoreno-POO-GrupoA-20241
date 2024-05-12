package src.tarjeta;

import java.util.ArrayList;

import src.tarjeta.utils.DatosTarjeta;
import src.tarjeta.utils.TipoTarjeta;
import src.utils.Ask;

public class Credito extends Tarjeta {
    private TipoTarjeta tipoTarjeta;
    private double creditoMaximo;

    public Credito(Long numSerie, Long clabeInterbancaria, int CVV, String fechaCreacion, String fechaVencimiento,
            String fechaUltimoMov, double saldo, TipoTarjeta tipoTarjeta) {
        super(numSerie, clabeInterbancaria, CVV, fechaCreacion, fechaVencimiento, fechaUltimoMov, saldo);
        this.tipoTarjeta = tipoTarjeta;
        switch (tipoTarjeta) {
            case SIMPLICITY -> this.creditoMaximo = 60000;
            case PLATINO -> this.creditoMaximo = 150000;
            case ORO -> this.creditoMaximo = 400000;
        }
    }

    public static Credito crearTarjetaCredito(TipoTarjeta tipoTarjeta) {
        ArrayList<String> datos = DatosTarjeta.obtenerDatosTarjeta();
        // tipoTarjeta();//Para las de credito exclusivamente
        Long numeroSerie = Long.parseLong(datos.get(0));
        Long clabeInterbancaria = Long.parseLong(datos.get(1));
        int CVV = Integer.parseInt(datos.get(2));
        String fechaCreacion = datos.get(3);
        String fechaUltimoMovimiento = datos.get(4);
        String fechaVencimiento = datos.get(5);
        double saldo = Double.parseDouble(datos.get(6));//ERROR AQUÍ

        return new Credito(numeroSerie, clabeInterbancaria, CVV, fechaCreacion, fechaVencimiento, fechaUltimoMovimiento,
                saldo, tipoTarjeta);
    }

    public static TipoTarjeta obtenerTipoTarjeta(double saldo){
    TipoTarjeta tipoTarjeta = null;
        if (saldo >= 200000) {//LOS 3 TIPOS DE TARJETA
            while (tipoTarjeta == null) {
                System.out.println("------------------------TIPOS DE TARJETA DE DISPONIBLE------------------------");
                System.out.println("1. ORO | CRÉDITO MÁXIMO: $400,000");
                System.out.println("2. PLATINO | CRÉDITO MÁXIMO: $150,000");
                System.out.println("3. SIMPLICITY | CRÉDITO MÁXIMO: $60,000");
                int opcion = Ask.forInt("el número de opción");
                switch (opcion) {
                    case 1 -> tipoTarjeta = TipoTarjeta.ORO;
                    case 2 -> tipoTarjeta = TipoTarjeta.PLATINO;
                    case 3 -> tipoTarjeta = TipoTarjeta.SIMPLICITY;
                    default -> System.out.println("Se ingresó un opción inválida, inténtelo de nuevo");
                }
            }
        }
        else if (saldo >= 100000) {//PLATINO Y SIMPLICITY
            while (tipoTarjeta == null) {
                System.out.println("------------------------TIPOS DE TARJETA DE DISPONIBLE------------------------");
                System.out.println("1. PLATINO | CRÉDITO MÁXIMO: $150,000");
                System.out.println("2. SIMPLICITY | CRÉDITO MÁXIMO: $60,000");
                int opcion = Ask.forInt("el número de opción");
                switch (opcion) {
                    case 1 -> tipoTarjeta = TipoTarjeta.PLATINO;
                    case 2 -> tipoTarjeta = TipoTarjeta.SIMPLICITY;
                    default -> System.out.println("Se ingresó un opción inválida, inténtelo de nuevo");
                }
            }
        }
        else{//SÓLO SIMPLICITY
            tipoTarjeta = TipoTarjeta.SIMPLICITY;
            System.out.println("Con su saldo actual sólo puede solicitar tarjetas de tipo SIMPLICITY");
            System.out.println("Por lo que el tipo de tarjeta se ha asignado automáticamente");
        }
        return tipoTarjeta;
    }

    public TipoTarjeta getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(TipoTarjeta tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public double getCreditoMax() {
        return creditoMaximo;
    }

    @Override
    public String toString() {
        return String.format("%s \n | TIPO DE TARJETA: %s | CRÉDITO MÁXIMO: % .2f | ", super.toString(),
                tipoTarjeta.toString(), creditoMaximo);
    }
}