package src.tarjeta.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import src.fintech.utils.DatosComun;
import src.utils.Ask;

public class DatosTarjeta {

    public static ArrayList<String> obtenerDatosTarjeta(){
        ArrayList<String> datosTarjeta = new ArrayList<>();
        
        String numeroSerie = String.valueOf(num(16));
        String clabeInterbancaria = String.valueOf(num(16));
        String CVV = String.valueOf(CVV());
        String fechaCreacion = DatosComun.formateoFecha(LocalDate.now());
        String fechaUltimoMovimiento = DatosComun.formateoFecha(LocalDateTime.now());
        //pendiente de checar si hay error
        /*int year = Integer.parseInt(fechaCreacion.substring(8, 10));
        int month = Integer.parseInt(fechaCreacion.substring(0, 2));
        int dayOfMonth = Integer.parseInt(fechaCreacion.substring(3, 5));*/
        String fechaVencimiento = fechaVencimiento(LocalDate.now());

        
        //String saldo ;

        datosTarjeta.addAll(Arrays.asList(numeroSerie, clabeInterbancaria, CVV, fechaCreacion, fechaUltimoMovimiento, fechaVencimiento, String.valueOf(0)));
        return datosTarjeta;
    }

    //Metodos que ayudan a la creacion de la tarjeta 
    private static Long num (int numDigitos){
        Random rd = new Random();
        String cadenaDigitos = "";
        for (int i=0; i<numDigitos; i++){
            int num = 0;
            num = rd.nextInt(0, 9); 
            cadenaDigitos = cadenaDigitos+num;
        }
        Long digitos = Long.parseLong(cadenaDigitos);
        return digitos;
    }//Crea el numero de serie y la clabe interbancaria 

    private static int CVV(){
        Random rd = new Random();
        String CVV = "";
        for (int i=0; i<3; i++){
            int num = 0;
            num = rd.nextInt(0, 9); 
            CVV = CVV+num;
        }
        int cvv = Integer.parseInt(CVV);
        return cvv;
    }

    private static String fechaVencimiento(LocalDate fechaCreacion){
        fechaCreacion = fechaCreacion.plusYears(5);
        String fechaVencimiento = DatosComun.formateoFecha(fechaCreacion);
        return fechaVencimiento;
    }
    
    public static TipoTarjeta obtenerTipoTarjeta(){
        TipoTarjeta tipo = null;
        while(tipo == null){
            System.out.println("¿Qué tipo de tarjeta le gustaria?");
            System.out.printf("1. PLATINO \n2. SIMPLICTY \n 3. ORO\n");
            int opcion = Ask.forInt("la opcion");
            switch (opcion) {
                case 1 -> tipo = TipoTarjeta.PLATINO;
                case 2 -> tipo = TipoTarjeta.SIMPLICITY;
                case 3 -> tipo = TipoTarjeta.ORO;
                default -> System.out.println("Se ingresó una opción inválida, intenta de nuevo");}
            //setTipoTarjeta(tipo);
         }
    return tipo;
    }
    
}
