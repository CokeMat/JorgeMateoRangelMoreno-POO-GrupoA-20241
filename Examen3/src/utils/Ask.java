package src.utils;

import java.util.Scanner;

public class Ask {
    static Scanner sc = new Scanner(System.in);

    public static String forString(String cadena) {
        String answer = "";
        boolean datoCorrecto = false;
        while (!datoCorrecto) {
            try {
                print(cadena);
                answer = sc.next();

                datoCorrecto = true;
            } catch (Exception error) {
                System.out.println("Ocurrio un error, intentelo de nuevo.");
                sc.nextLine();
            }
        }
        return answer;
    }

    public static double forDouble(String cadena) {
        double answer = 0;
        boolean datoCorrecto = false;
        while (!datoCorrecto) {
            try {
                print(cadena);
                answer = sc.nextDouble();
                datoCorrecto = true;
            } catch (Exception error) {
                System.out.println("Ocurrio un error, intentelo de nuevo.");
                sc.nextLine();
            }
        }
        return answer;
    }

    public static int forInt(String cadena) {
        int answer = 0;
        boolean datoCorrecto = false;
        while (!datoCorrecto) {
            try {
                print(cadena);
                answer = sc.nextInt();
                datoCorrecto = true;
            } catch (Exception error) {
                System.out.println("Ocurrio un error, intentelo de nuevo.");
                sc.nextLine();
            }
        }
        return answer;
    }

    public static long forLong(String cadena) {
        long answer = 0;
        boolean datoCorrecto = false;
        while (!datoCorrecto) {
            try {
                print(cadena);
                answer = sc.nextLong();
                datoCorrecto = true;
            } catch (Exception error) {
                System.out.println("Ocurrio un error, intentelo de nuevo.");
                sc.nextLine();
            }
        }
        return answer;
    }

    public static boolean forBoolean(String cadena) {
        int answer = 0;
        boolean datoCorrecto = false;
        while (!datoCorrecto) {
            try {
                System.out.printf("ES %s?", cadena);
                System.out.println("1. Yes");
                System.out.println("2. No");
                answer = sc.nextInt();
                datoCorrecto = true;
            } catch (Exception error) {
                System.out.println("Ocurrio un error, intentelo de nuevo.");
                sc.nextLine();
            }
        }
        if (answer == 1) {
            return true;
        } else {
            return false;
        }
    }

    private static void print(String cad) {
        System.out.printf("\nIngrese %s: ", cad);
    }
}
