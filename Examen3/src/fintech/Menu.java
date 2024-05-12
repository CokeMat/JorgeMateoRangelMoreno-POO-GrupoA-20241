package src.fintech;

import src.fintech.utils.Sucursal;
import src.usuarios.*;
import src.usuarios.empleados.*;
import src.usuarios.utils.Rol;
import src.utils.Ask;
import src.utils.UsuarioEnSesion;

public class Menu {

    public static Sucursal preguntarSucursal() {
        while (true) {
            System.out.println("***************BIENVENIDO AL PROGRAMA***************");
            System.out.println("\n1. MADERO \n2. ACUEDUCTO \n3. SALIR DEL PROGRAMA");
            int opcion = Ask.forInt("el número de opción");
            if (opcion == 1)
                return Sucursal.MADERO;
            else if (opcion == 2)
                return Sucursal.ACUEDUCTO;
            else if (opcion == 3)
                return null;
            else
                System.out.println("Opción inválida inténtelo nuevamente");
        }
    }

    public static void seleccionarMenu() {
        switch (UsuarioEnSesion.getInstancia().getUsuarioActual().getRol()) {
            case CLIENTE -> ejecutarMenuCliente();
            case GERENTE -> ejecutarMenuGerente();
            case CAPTURISTA -> ejecutarMenuCapturista();
            case EJECUTIVO -> ejecutarMenuEjecutivo();
            case INVERSIONISTA -> ejecutarMenuInversionista();
        }
    }

    private static void ejecutarMenuCliente() {// -----------------DRAFT READY-----------------------
        boolean flag = true;
        int contador = 0;
        saludarUsuario();
        while (flag) {
            //Notificación
            if (contador == 0) Cliente.mostrarNotificacion();
            System.out.println("\n ¿Qué desea hacer?");
            System.out.println("1. Consultar información personal");
            System.out.println("2. Modificar información personal");
            System.out.println("3. Hacer un depósito a una tarjeta");
            System.out.println("4. Retirar dinero de una tarjeta");
            System.out.println("5. Consultar información sobre mis tarjetas");
            System.out.println("6. Solicitar una tarjeta de crédito");
            System.out.println("7. Ver mis solicitudes de tarjeta de crédito");
            System.out.println("8. Cerrar sesión");
            contador++;
            int option = Ask.forInt("el número de opción");

            switch (option) {
                case 1 -> {
                    System.out.println("----------------MI INFORMACIÓN PERSONAL-----------------------");
                    System.out.println(UsuarioEnSesion.getInstancia().getUsuarioActual());
                }
                case 2 -> Cliente.modificarInfoPersonal();// Para modificarse a si mismo
                case 3 -> Cliente.depositar();
                case 4 -> Cliente.retirar();
                case 5 -> Cliente.consultarInfoTarjeta();
                case 6 -> Cliente.solicitarTarjeta();
                case 7 -> Cliente.verSolicitudes();
                case 8 -> {
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    flag = false;
                }
                default -> System.out.println("Se ingresó una opción inválida, intenta de nuevo");
            }
        }

    }

    private static void ejecutarMenuGerente() {// -----------------DRAFT READY-----------------------
        boolean flag = true;
        saludarUsuario();
        while (flag) {
            System.out.println("\n¿Qué desea hacer?");
            System.out.println("1. Agregar un usuario");
            System.out.println("2. Eliminar un usuario");
            System.out.println("3. Modificar un usuario");
            System.out.println("4. Conulstar información de un usuario en concreto");
            System.out.println("5. Consultar la información de todos los usuarios(Deberá indicar el tipo)");
            System.out.println("6. Consultar información acerca de los movimientos bancarios");
            System.out.println("7. Entrar al menú de solicitudes de tarjeta de crédito");
            System.out.println("8. Mostrar la información de la sucursal actual");
            System.out.println("9. Cerrar sesión");
            int x = Ask.forInt("el número de opción");
            switch (x) {
                case 1 -> {
                    switch (pedirTipoUsuario()) {
                        case CLIENTE -> Cliente.registrar();
                        case CAPTURISTA -> Capturista.registrar();
                        case EJECUTIVO -> Ejecutivo.registrar();
                        case INVERSIONISTA -> Inversionista.registrar();
                        case GERENTE -> System.out.println("Parche");
                    }
                }

                case 2 -> {
                    switch (pedirTipoUsuario()) {
                        case CLIENTE -> Cliente.eliminar();
                        case CAPTURISTA -> Capturista.eliminar();
                        case EJECUTIVO -> Ejecutivo.eliminar();
                        case INVERSIONISTA -> Inversionista.eliminar();
                        case GERENTE -> System.out.println("Parche");
                    }
                }

                case 3 -> {
                    switch (pedirTipoUsuario()) {
                        case CLIENTE -> Cliente.modificar();
                        case CAPTURISTA -> Capturista.modificar();
                        case EJECUTIVO -> Ejecutivo.modificar();
                        case INVERSIONISTA -> Inversionista.modificar();
                        case GERENTE -> System.out.println("Parche");
                    }
                }

                case 4 -> {
                    switch (pedirTipoUsuario()) {
                        case CLIENTE -> Cliente.showInfo();
                        case CAPTURISTA -> Capturista.showInfo();
                        case EJECUTIVO -> Ejecutivo.showInfo();
                        case INVERSIONISTA -> Inversionista.showInfo();
                        case GERENTE -> System.out.println("Parche");
                    }
                }

                case 5 -> {
                    switch (pedirTipoUsuario()) {
                        case CLIENTE -> Cliente.showList();
                        case CAPTURISTA -> Capturista.showList();
                        case EJECUTIVO -> Ejecutivo.showList();
                        case INVERSIONISTA -> Inversionista.showList();
                        case GERENTE -> System.out.println("Parche");
                    }
                }
                case 6 -> Gerente.mostrarListaMovimientosBancarios();
                case 7 -> Gerente.menuSolicitudes();// EL MENÚ PARA ACEPTARLAS Y RECHAZARLAS
                case 8 -> Fintech.mostrarInfoBanco();
                case 9 -> {
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    flag = false;
                }
                default -> System.out.println("Se ingresó una opción inválida, intenta de nuevo");
            }
        }
    }

    private static void ejecutarMenuCapturista() {// -----------------DRAFT READY-----------------------
        boolean flag = true;
        saludarUsuario();
        System.out.println("Seleccione una opción");
        while (flag) {
            System.out.println("\n ¿Qué desea hacer?");
            System.out.println("1. Registrar ejecutivo de cuenta");
            System.out.println("2. Modificar información del ejecutivo de cuenta");
            System.out.println("3. Mostrar los ejecutivos de cuenta");
            System.out.println("4. Eliminar un ejecutivo de cuenta");
            System.out.println("5. Mostrar informacion personal de un ejecutivo de cuenta");
            System.out.println("6. Cerrar sesión");
            int option = Ask.forInt("el número de opción");
            switch (option) {
                case 1 -> Ejecutivo.registrar();
                case 2 -> Ejecutivo.modificar();
                case 3 -> Ejecutivo.showList();
                case 4 -> Ejecutivo.eliminar();
                case 5 -> Ejecutivo.showInfo();
                case 6 -> {
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    flag = false;
                }
            }
        }

    }

    private static void ejecutarMenuEjecutivo() {// -----------------DRAFT READY-----------------------
        boolean flag = true;
        saludarUsuario();
        System.out.println("Seleccione una opción");
        while (flag) {
            System.out.println("\n ¿Qué desea hacer?");
            System.out.println("1. Consultar mi información personal");
            System.out.println("2. Modificar mi información personal");
            System.out.println("3. Agregar un cliente");
            System.out.println("4. Eliminar un cliente");
            System.out.println("5. Modificar información de un cliente");
            System.out.println("6. Mostrar la información de un cliente");
            System.out.println("7. Mostrar la LISTA de clientes");
            System.out.println("8. Ver solicitudes de tarjeta de crédito");
            System.out.println("9. Cerrar sesión");
            int option = Ask.forInt("el número de opción");

            switch (option) {
                case 1 -> System.out.println(UsuarioEnSesion.getInstancia().getUsuarioActual());
                case 2 -> Ejecutivo.showInfo();
                case 3 -> Cliente.registrar();
                case 4 -> Cliente.eliminar();
                case 5 -> Cliente.modificar();// Para elegir uno de la lista y modificarlo
                case 6 -> Cliente.showInfo();
                case 7 -> Cliente.showList();
                case 8 -> Ejecutivo.menuSolicitudes();// Un menú en el que puede rechazar y aceptar todas las tarjetas
                                                      // de crédito
                case 9 -> {
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    flag = false;
                }
                default -> System.out.println("Se ingresó una opción inválida, intenta de nuevo");
            }
        }

    }

    private static void ejecutarMenuInversionista() {// -----------------DRAFT READY-----------------------
        boolean flag = true;
        saludarUsuario();
        System.out.println("Seleccione una opción");
        while (flag) {
            System.out.println("1. Consultar mi información personal");
            System.out.println("2. Realizar inversión al banco");
            System.out.println("3. Cerrar sesión");
            int option = Ask.forInt("el número de opción");

            switch (option) {
                case 1 -> System.out.println(UsuarioEnSesion.getInstancia().getUsuarioActual());
                case 2 -> Inversionista.hacerCargo();
                case 3 -> {
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    flag = false;
                }
                default -> System.out.println("Se ingresó una opción inválida, intenta de nuevo");
            }
        }
    }

    private static void saludarUsuario() {
        System.out.printf("\n---------------BIENVENIDO AL SISTEMA %s---------------\n",
                UsuarioEnSesion.getInstancia().getUsuarioActual().getNombreCompleto());
    }

    private static Rol pedirTipoUsuario() {
        Rol rol = null;
        while (rol == null) {
            System.out.println("Ahora ingrese el tipo de usuario");
            System.out.println("1. Cliente");
            System.out.println("2. Ejecutivo de cuenta");
            System.out.println("3. Capturista");
            System.out.println("4. Inversonista");
            int answer = Ask.forInt("el número de opción");

            switch (answer) {
                case 1 -> rol = Rol.CLIENTE;
                case 2 -> rol = Rol.EJECUTIVO;
                case 3 -> rol = Rol.CAPTURISTA;
                case 4 -> rol = Rol.INVERSIONISTA;
                default -> System.out.println("Opción inválida, intenta de nuevo");
            }
        }
        return rol;
    }

}
