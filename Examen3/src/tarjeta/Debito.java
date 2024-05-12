package src.tarjeta;

import java.util.ArrayList;
import src.tarjeta.utils.DatosTarjeta;

public class Debito extends Tarjeta {

    public Debito(Long numSerie, Long clabeInterbancaria, int CVV, String fechaCreacion, String fechaVencimiento,
            String fechaUltimoMov, double saldo) {
        super(numSerie, clabeInterbancaria, CVV, fechaCreacion, fechaVencimiento, fechaUltimoMov, saldo);
    }

    public static Debito crearTarjetaDebito() {// un momento Jorch, no rompí nada, creo XD
        ArrayList<String> datos = DatosTarjeta.obtenerDatosTarjeta();
        // tipoTarjeta();//Para las de credito exclusivamente
        Long numeroSerie = Long.parseLong(datos.get(0));
        Long clabeInterbancaria = Long.parseLong(datos.get(1));
        int CVV = Integer.parseInt(datos.get(2));
        String fechaCreacion = datos.get(3);
        String fechaUltimoMovimiento = datos.get(4);
        String fechaVencimiento = datos.get(5);
        double saldo = 0;
        return new Debito(numeroSerie, clabeInterbancaria, CVV, fechaCreacion, fechaVencimiento, fechaUltimoMovimiento,
                saldo);
    }

}