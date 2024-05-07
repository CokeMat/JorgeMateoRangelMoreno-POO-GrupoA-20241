import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public  class Excepciones {
    String cadena;
    char letra;

    public static void excepciones() {

        try {//Excepcion 1
            System.out.println(" Excepcion 1, division entre 0");
            int div = 10/0;
        } catch (ArithmeticException error) {
            System.out.println("ERROR, DIVISION ENTRE 0 NO POSIBLE");
        }
        try {//Excepcion 2
            System.out.println(" Excepcion 2, el  largo de una cadena null");
            String cadena = null;
            System.out.println(cadena.length());
        } catch (NullPointerException error) {
            System.out.println("ERROR");
        }
        try {//Excepcion 3
            System.out.println(" Excepcion 3, introducir un tipo de dato donde no corresponde");
            Scanner sc = new Scanner(System.in);
            int algo = sc.nextInt();
        } catch (InputMismatchException error) {
            System.out.println("ERROR");
        }
        try {//Excepcion 4
            System.out.println(" Excepcion 4, acceso a un índice fuera del rango de un array");
            int[] array = new int[5];
            int fueraDeRango = array[10];
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("ERROR, ÍNDICE FUERA DE RANGO");
        }

        try {// Excepcion 5
            System.out.println("Excepcion 5, operación no soportada en este contexto");

            // Intentamos realizar una operación no soportada
            ArrayList<String> lista = new ArrayList<>();
            lista.add("Elemento");
            lista.ensureCapacity(0);
        } catch (UnsupportedOperationException error) {
            System.out.println("ERROR, CAPACIDAD MAXIMA DEL ARRAY LIST SOBREPASADA");
        }

        try {//Excepcion 6
            System.out.println(" Excepcion 6, manipulación de un objeto no inicializado");
            Object obj = null;
            obj.toString();
        } catch (NullPointerException error) {
            System.out.println("ERROR, OBJETO NO INICIALIZADO");
        }

        try {//Excepcion 7
            System.out.println(" Excepcion 7, intento de abrir un archivo inexistente");
            FileInputStream fis = new FileInputStream("Tarea4.txt");
        } catch (FileNotFoundException error) {
            System.out.println("ERROR, ARCHIVO NO ENCONTRADO");
        }

        try {//Excepcion 8
            System.out.println(" Excepcion 8, uso de un recurso que ya está cerrado");
            BufferedReader reader = new BufferedReader(new FileReader("archivo.txt"));
            reader.close();
            reader.readLine();
        } catch (IOException error) {
            System.out.println("ERROR, RECURSO YA CERRADO");
        }

        try {//Excepcion 9
            System.out.println(" Excepcion 9, uso de un formato de fecha inválido");
            LocalDate fecha = LocalDate.of(0,0,0);
            DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dia = fecha.format(date);
        } catch (DateTimeException error) {
            System.out.println("ERROR, FORMATO DE FECHA INVÁLIDO");
        }

        try {// Excepcion 10
            System.out.println("Excepcion 10, manipulación de un objeto con tipo de dato incorrecto");
            Object obj = "Hola";
            Integer numero = (Integer) obj;
        } catch (ClassCastException error) {
            System.out.println("ERROR, CONVERSIÓN DE TIPO INCORRECTA");
        }
    }
}
