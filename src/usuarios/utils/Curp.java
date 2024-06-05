package usuarios.utils;

import java.util.Random;

public class Curp {
    private static Random ran = new Random();

    public static String generate(String apellidoPaterno, String apellidoMaterno, String nombre, String fechaNacimiento,
            String genero, String estado) {

        String fecha = fechaNacimiento;
        String apellidoP = apellidoPaterno.substring(0, 1).toUpperCase();
        String apellidoM = apellidoMaterno.substring(0, 1).toUpperCase();
        String name = String.valueOf(nombre.charAt(0)).toUpperCase();
        String year = fecha.substring(8, 10);
        String month = fecha.substring(3, 5);
        String day = fecha.substring(0, 2);

        // 12/06/2012
        String sex = "";
        if (genero == "MASCULINO")
            sex = "H";
        else
            sex = "M";
        String apelldfo = "";
        for (int i = 1; i < apellidoPaterno.length(); i++) {
            char c = apellidoPaterno.charAt(i);
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                apelldfo += String.valueOf(c);
                break;
            }
        }
        String consonantes = "";
        for (int i = 1; i < apellidoPaterno.length(); i++) {
            char c = apellidoPaterno.charAt(i);
            if (c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                consonantes += String.valueOf(c);
                break;
            }
        }
        for (int i = 1; i < apellidoMaterno.length(); i++) {
            char c = apellidoMaterno.charAt(i);
            if (c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                consonantes += String.valueOf(c);
                break;
            }
        }
        for (int i = 1; i < nombre.length(); i++) {
            char c = nombre.charAt(i);
            if (c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                consonantes += String.valueOf(c);
                break;
            }
        }

        String entidadFederativa = EntidadFederativa.getEntidadFederativa(estado);// DE AQUÍ NO AVANZA

        int n1 = ran.nextInt(10);
        int n2 = ran.nextInt(10);
        String curp = apellidoP + apelldfo + apellidoM + name + year + month + day + sex + entidadFederativa
                + consonantes + n1
                + n2;
        return curp.toUpperCase();
    }
}