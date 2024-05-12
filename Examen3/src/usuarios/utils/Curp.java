package src.usuarios.utils;

import java.util.Random;

public class Curp {
    private static Random ran = new Random();

    public static String generate(String apellidoPaterno, String apellidoMaterno, String nombre, String fechaNacimiento,
            Genero genero, Estado estado) {
        String fecha = fechaNacimiento;
        String apellidoP = apellidoPaterno.substring(0, 2);
        String apellidoM = apellidoMaterno.substring(0, 1);
        String name = String.valueOf(nombre.charAt(0));
        String year = fecha.substring(8, 10);
        String month = fecha.substring(0, 2);
        String day = fecha.substring(3, 5);
        // 12/06/2012
        String sex = "";
        if (genero == Genero.MASCULINO)
            sex = "H";
        else
            sex = "M";

        String consonantes = "";
        for (int i = 0; i < apellidoPaterno.length(); i++) {
            char c = apellidoPaterno.charAt(i);
            if (c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                consonantes += String.valueOf(c);
                break;
            }
        }
        for (int i = 0; i < apellidoMaterno.length(); i++) {
            char c = apellidoMaterno.charAt(i);
            if (c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                consonantes += String.valueOf(c);
                break;
            }
        }
        for (int i = 0; i < nombre.length(); i++) {
            char c = nombre.charAt(i);
            if (c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                consonantes += String.valueOf(c);
                break;
            }
        }

        String entidadFederativa = EntidadFederativa.getEntidadFederativa(estado);

        int n1 = ran.nextInt(10);
        int n2 = ran.nextInt(10);
        return apellidoP + apellidoM + name + year + month + day + sex + entidadFederativa + consonantes + n1 + n2;
    }
}
