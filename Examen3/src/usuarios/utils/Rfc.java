package src.usuarios.utils;

import java.util.Random;

public class Rfc {
    private static Random rd = new Random();

    public static String generate(String apellidoPaterno, String apellidoMaterno, String nombre,
            String fechaNacimiento) {
        String fecha = fechaNacimiento;
        String apellidoP = apellidoPaterno.substring(0, 2);
        String apellidoM = apellidoMaterno.substring(0, 1);
        String name = String.valueOf(nombre.charAt(0));
        String year = fecha.substring(8, 10);
        String month = fecha.substring(0, 2);
        String day = fecha.substring(3, 5);

        String homoclave = generateHomoclave();

        return apellidoP + apellidoM + name + year + month + day + homoclave;
    }

    private static String generateHomoclave() {
        String homoclave;
        String abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        int i = rd.nextInt(0, 1);
        // Primer caracter de la homoclave
        String caracter1;
        if (i == 0) {
            int caracter = rd.nextInt(0, 9);
            caracter1 = String.valueOf(caracter);
        } else {
            int c = rd.nextInt(0, 26);
            caracter1 = String.valueOf(abecedario.charAt(c));
        }

        // Segundo caracter de la homoclave
        int c = rd.nextInt(0, 26);
        String caracter2 = String.valueOf(abecedario.charAt(c));
        while (caracter2 == caracter1) {
            c = rd.nextInt(0, 26);
            caracter2 = String.valueOf(abecedario.charAt(c));
        }

        // Tercer caracter de la homoclave
        int caracter = rd.nextInt(0, 9);
        String caracter3 = String.valueOf(caracter);
        while (caracter3 == caracter1) {
            caracter = rd.nextInt(0, 9);
            caracter3 = String.valueOf(caracter);
        }

        homoclave = caracter1 + caracter2 + caracter3;

        return homoclave;
    }
}