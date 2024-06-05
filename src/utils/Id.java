package utils;

import java.util.*;

import escuela.constantes.AbreviaturaCarrera;
import usuarios.Alumnos.Alumno;
import usuarios.Trabajadores.Profesor;
import usuarios.utils.*;
import usuarios.utils.helpers.*;
import sistema.Sistema;

public class Id {
    static Random ran = new Random();
    // Deberiamos cambiarle de id a numero de control, pero no se si jode algo xd

    public static String generateNumeroControl(String nombre, String carrera, Rol rol) {
        int indice = 0;
        switch (rol) {
            case Rol.ALUMNO -> {
                indice = Sistema.contadorAlumnos.get(carrera);
                Sistema.contadorAlumnos.put(carrera, (indice + 1));
            }
            case Rol.PROFESOR -> {
                indice = Sistema.contadorProfesores.get(carrera);
                Sistema.contadorProfesores.put(carrera, (indice + 1));
            }
            case Rol.COORDINADOR -> indice = 0;
        }

        AbreviaturaCarrera abreviatura = DatosComun.getAbreviatura(carrera);
        char letra = nombre.charAt(0);
        String rolActual = rol == Rol.ALUMNO ? "l" : rol == Rol.PROFESOR ? "M" : "C";
        return rolActual + String.valueOf(letra) + "24" + abreviatura.toString() + indice;

    }

    public static String generate(String cad) {
        String ID = cad;
        // String lettersBank = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbersBank = "01234567890";
        int i = 0;
        while (i < 5) {
            ID += String.valueOf(numbersBank.charAt(ran.nextInt(numbersBank.length())));
            i++;
        }
        return ID;
    }

    public static int validNumeroControl(String numeroControl, String rol) {
        // Devuelve index
        int index = -1;
        if (rol.equals("ALUMNO")) {
            ArrayList<Alumno> lista = Sistema.alumnos.get(CarreraActual.getInstancia().getCarreraActual());
            for (int i = 0; i < lista.size(); i++) {
                if (numeroControl.equals(lista.get(i).getNumeroControl())) {
                    return i;
                }
            }
        } else {
            ArrayList<Profesor> lista = Sistema.profesores.get(CarreraActual.getInstancia().getCarreraActual());
            for (int i = 0; i < lista.size(); i++) {
                if (numeroControl.equals(lista.get(i).getNumeroControl())) {
                    return i;
                }
            }
        }
        return index;
    }

    /*
     * public static void showNumeroControlList(String carrera) {
     * // Quite rol de parametro
     * 
     * String carreraActual = carrera == NombreCarrera.SISTEMAS.toString() ?
     * "SISTEMAS"
     * : carrera == NombreCarrera.ELECTRONICA.toString() ? "ELECTRONICA" :
     * "MATERIALES";
     * 
     * System.out.
     * printf("\n---------------LISTA DE NUMEROS DE CONTROL %s---------------",
     * carreraActual);
     * 
     * System.out.printf("\n---------------ALUMNOS---------------");
     * ArrayList<Alumno> lista = Sistema.alumnos.get(carrera);
     * for (int i = 0; i < lista.size(); i++) {
     * System.out.println(String.format(
     * "| NOMBRE: %s |NUMERO DE CONTROL : %s| "
     * + Sistema.alumnos.get(carrera).get(i).getNombre(),
     * Sistema.alumnos.get(carrera).get(i).getNumeroControl()));
     * 
     * }
     * System.out.printf("\n---------------MAESTROS---------------");
     * ArrayList<Profesor> listaprofes = Sistema.profesores.get(carrera);
     * for (int i = 0; i < listaprofes.size(); i++) {
     * System.out.println(String.format(
     * "| NOMBRE: %s |NUMERO DE CONTROL : %s| " +
     * Sistema.profesores.get(carrera).get(i).getNombre(),
     * Sistema.profesores.get(carrera).get(i).getNumeroControl()));
     * 
     * }
     * 
     * }
     */
}
