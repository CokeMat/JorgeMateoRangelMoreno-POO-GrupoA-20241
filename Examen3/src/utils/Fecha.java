package src.utils;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Fecha {
    public static String askForDate(String cad) {
        System.out.printf("\nIngrese la fecha de %s", cad);
        int year = getYear();
        int month = getMonth();
        int dayOfMonth = getDay(month);
        LocalDate date = LocalDate.of(year, month, dayOfMonth);
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        String fecha = date.format(pattern);
        return fecha;
    }

    public static String askForDate(int year, int month, int dayOfMonth) {
        LocalDate date = LocalDate.of(year, month, dayOfMonth);
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        String fecha = date.format(pattern);
        return fecha;
    }

    private static int getYear() {
        int year = Ask.forInt("el año");
        while (!validYear(year)) {
            System.out.println("Se ingresó un año inválido, inténtelo nuevamente");
            year = Ask.forInt("el año");
        }
        return year;
    }

    private static boolean validYear(int year) {
        return year > 1950 && year <= 2024;
    }

    private static int getMonth() {
        int month = Ask.forInt("el mes");
        while (!validMonth(month)) {
            System.out.println("Se ingresó un mes inválido, inténtelo nuevamente");
            month = Ask.forInt("el mes");
        }
        return month;
    }

    private static boolean validMonth(int month) {
        return month > 0 && month <= 12;
    }

    public static int getDay(int month) {
        int day = 0;
        while (true) {
            day = Ask.forInt("el día");
            if (validDay(month, day))
                return day;
            else
                System.out.println("Inténtelo nuevamente");
        }
    }

    private static boolean validDay(int month, int day) {
        if (day > 0 && day <= 31) {
            if (day <= Month.of(month).maxLength())
                return true;
            else {
                System.out.println("El día ingresado es válido, sin embargo, no se encuentra dentro del rango del mes");
                System.out.printf("\nEl día máximo para el mes %s es: %d", Month.of(month).toString(),
                        Month.of(month).maxLength());
            }
        } else
            System.out.println("Se ingresó un número de día inválido");
        return false;
    }
}
