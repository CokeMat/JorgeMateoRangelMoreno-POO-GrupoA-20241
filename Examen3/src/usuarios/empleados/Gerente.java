package src.usuarios.empleados;

import java.util.ArrayList;

import src.fintech.Sys;
import src.fintech.movimientos.MovimientoBancario;
import src.fintech.solicitudes.Solicitud;
import src.fintech.solicitudes.utils.Estatus;
import src.usuarios.utils.*;
import src.utils.Ask;
import src.utils.SucursalActual;

public class Gerente extends Empleado {
    private final static String CLAVE_GERENTE = "claveGerente123";

    public Gerente(String nombre, String apellidoM, String apellidoP, String fechaNacimiento, Genero genero,
            Estado estado, String direccion, String ciudad, String nombreUsuario, String contrasena, Rol rol,
            String numTelefono, String id, double salario, String horario, String fechaIngreso) {
        super(nombre, apellidoM, apellidoP, fechaNacimiento, genero, estado, direccion, ciudad, nombreUsuario,
                contrasena, rol, numTelefono, id, salario, horario, fechaIngreso);
    }

    public static void mostrarListaMovimientosBancarios() {
        ArrayList<MovimientoBancario> lista = Sys.getInstance().getSucursales()
                .get(SucursalActual.getInstancia().getSucursalActual()).getListaMovimientoBancarios();
        if (lista.isEmpty()) {
            System.out.println("No se han registrado movimientos bancarios");
        } else {
            for (MovimientoBancario movimiento : lista) {
                System.out.println(movimiento);
            }  
            System.out.printf("\n | SALDO DEL BANCO: $%.2f |", Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getSaldoBanco());
        }
    }

    public static void menuSolicitudes() {// MENÚ DINÁMICO PARA LAS SOLICITUDES
        if (Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual())
                .getListaSolicitudes().isEmpty()) {
            System.out.println("No hay solicitudes registradas en el sistema");
        } else {
            boolean flag = true;
            while (flag) {
                if (Solicitud.containsEstatus(Estatus.PENDIENTE)) {
                    System.out.println("\n************** Tiene solicitudes pendientes ***************");
                }
                System.out.println("\n¿Qué desea realizar?");
                System.out.println("1. Ver todas las solicitudes registradas en el sistema");
                System.out.println("2. Mostrar las solicitudes aprobadas");
                System.out.println("3. Mostrar las solicitudes rechazadas");
                System.out.println("4. Mostrar las solicitudes pendientes");
                System.out.println("5. Aceptar una tarjeta de crédito");
                System.out.println("6. Rechazar una tarjeta de crédito");
                System.out.println("7. Volver al menu principal");
                int option = Ask.forInt("el número de opción");

                switch (option) {
                    case 1 -> Solicitud.mostrarListaSolicitudes();
                    case 2 -> Solicitud.mostrarListaSolicitudes(Estatus.APROBADA);
                    case 3 -> Solicitud.mostrarListaSolicitudes(Estatus.RECHAZADA);
                    case 4 -> Solicitud.mostrarListaSolicitudes(Estatus.PENDIENTE);
                    case 5 -> Solicitud.aceptarSolicitud(CLAVE_GERENTE);
                    case 6 -> Solicitud.rechazarSolicitud(CLAVE_GERENTE);
                    case 7 -> {
                        System.out.println("Regresando al menu principal...");
                        flag = false;
                    }
                    default -> System.out.println("Se ingresó una opción inválida, intenta de nuevo");
                }
            }

        }
    }

    public String getCLAVE_GERENTE() {
        return CLAVE_GERENTE;
    }
}