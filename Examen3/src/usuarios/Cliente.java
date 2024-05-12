package src.usuarios;

import java.time.LocalDateTime;
import java.util.ArrayList;
import src.fintech.utils.DatosComun;
import src.tarjeta.*;
import src.tarjeta.utils.TipoTarjeta;
import src.usuarios.utils.*;
import src.fintech.Sys;
import src.fintech.movimientos.MovimientoBancario;
import src.fintech.movimientos.utils.TipoMovimiento;
import src.fintech.solicitudes.Solicitud;
import src.fintech.solicitudes.utils.Estatus;
import src.utils.*;

public class Cliente extends Usuario {
    private ArrayList<Credito> listaTarjetaCredito;
    private Debito tarjetaDebito;
    private ArrayList<Solicitud> listaSolicitudes = new ArrayList<>();

    public Cliente(String nombre, String apellidoM, String apellidoP, String fechaNacimiento, Genero genero,
            Estado estado, String direccion, String ciudad, String nombreUsuario, String contrasena,
            String numTelefono, String id) {
        super(nombre, apellidoM, apellidoP, fechaNacimiento, genero, estado, direccion, ciudad, nombreUsuario,
                contrasena,
                Rol.CLIENTE, numTelefono, id);
        tarjetaDebito = Debito.crearTarjetaDebito();
        listaTarjetaCredito = new ArrayList<>();
    }

    public static void registrar() {
        ArrayList<String> datos = DatosComun.obtenerDatosComun(Rol.CLIENTE);
        String nombre = datos.get(0);
        String apellidoP = datos.get(1);
        String apellidoM = datos.get(2);
        String fechaNacimiento = datos.get(3);
        String direccion = datos.get(4);
        String state = datos.get(5);
        String ciudad = datos.get(6);
        String nombreUsuario = datos.get(7);
        String contrasena = datos.get(8);
        String gender = datos.get(9);
        String numTelefono = datos.get(10);
        // oye,
        Genero genero = DatosComun.validaGenero(gender);
        Estado estado = DatosComun.validEstado(state);

        String id = DatosComun.obtenerID("C");

        Cliente cliente = new Cliente(nombre, apellidoM, apellidoP, fechaNacimiento, genero, estado, direccion, ciudad,
                nombreUsuario, contrasena, numTelefono, id);

        Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios()
                .get(Rol.CLIENTE)
                .add(cliente);
        System.out.println("\n----------------CLIENTE REGISTRADO----------------\n");
    }

    public static void eliminar() {
        if (Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios()
                .get(Rol.CLIENTE)
                .isEmpty()) {
            System.out.println("No hay clientes registrados");
        } else {
            boolean flag = true;
            String id = "";
            int index = 0;
            Rol rol = Rol.CLIENTE;
            System.out.printf("\n---------------------MOSTRAR LA INFORMACIÓN DE UN %s---------------------", rol);
            while (true) {// LÓGICA PARA OBTENER UN USUARIO
                Id.showIdList(rol);
                id = Ask.forString("el ID del usuario");
                Id.validId(id, rol);
                int i = Id.validId(id, rol);
                if (i == -1) {
                    System.out.println("No se encontró al usuario, ¿desea intentarlo nuevamente?");
                    System.out.println("1. SI \n2. NO");
                    if (Ask.forInt("el número de opción") != 1) {
                        flag = false;
                        break;
                    }
                } else {
                    index = i;
                    break;
                }
            }
            if (flag) {
                Usuario usuario = Sys.getInstance().getSucursales()
                        .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios()
                        .get(Rol.CLIENTE).get(index);
                if (usuario.isActive()) {
                    System.out.println(
                            "Este usuario participa en otras actividades, por lo que no es posible eliminarlo");
                } else {
                    Sys.getInstance().getSucursales()
                            .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(Rol.CLIENTE)
                            .remove(usuario);
                    System.out.println("El cliente fue eliminado exitosamente");
                }
            }
        }
    }

    public static void modificar() {
        if (Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios()
                .get(Rol.CLIENTE)
                .isEmpty()) {
            System.out.println("No hay clientes registrados");
        } else {
            boolean flag = true;
            Rol rol = Rol.CLIENTE;

            String id = "";
            int index = 0;
            while (true) {// LÓGICA PARA OBTENER UN USUARIO
                Id.showIdList(rol);
                id = Ask.forString("el ID del usuario");
                int i = Id.validId(id, rol);
                if (i == -1) {
                    System.out.println("No se encontró al usuario, ¿desea intentarlo nuevamente?");
                    System.out.println("1. SI \n2. NO");
                    if (Ask.forInt("el número de opción") != 1) {
                        flag = false;
                        break;
                    }
                } else {
                    index = i;
                    break;
                }
            }

            while (flag) {
                System.out.printf("\n---------------------MODIFICAR LA INFORMACIÓN DE UN %s---------------------",
                        rol.toString());
                System.out.println("¿Qué desea modificar?");
                System.out.println(
                        "1.Apelldio materno \n2.ApellidoPaterno\n3.nombre \n4.Fecha de nacimiento\n5.Genero \n6.Estado \n7.Direccion \n8.Ciudad \n9.Nombre de usuario \n10.Contrasena \n11.Número de telefono \n12. Volver al menú anterior");
                int opcion = Ask.forInt("el número de opción opcion: ");

                switch (opcion) {
                    case 1 -> {
                        String apellidoM = Ask.forString("nuevo apellido materno ");
                        Sys.getInstance().getSucursales()
                                .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(rol)
                                .get(index).setApellidoM(apellidoM);
                    }
                    case 2 -> {
                        String apellidoP = Ask.forString("nuevo apellido paterno ");
                        Sys.getInstance().getSucursales()
                                .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(rol)
                                .get(index)
                                .setApellidoP(apellidoP);
                    }
                    case 3 -> {
                        String nombre = Ask.forString("nuevo nombre");
                        Sys.getInstance().getSucursales()
                                .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(rol)
                                .get(index)
                                .setNombre(nombre);
                    }
                    case 4 -> {
                        String fechaNacimiento = Fecha.askForDate("nueva fecha de nacimiento");
                        Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual())
                                .getListaUsuarios().get(rol).get(index)
                                .setFechaNacimiento(fechaNacimiento);
                    }
                    case 5 -> {
                        Genero genero = DatosComun.elegirGenero();
                        Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual())
                                .getListaUsuarios().get(rol)
                                .get(index)
                                .setGenero(genero);
                    }
                    case 6 -> {
                        Estado estado = DatosComun.elegirEstado();
                        Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual())
                                .getListaUsuarios().get(rol)
                                .get(index)
                                .setEstado(estado);
                    }
                    case 7 -> {
                        String direccion = Ask.forString("nueva dirección");
                        Sys.getInstance().getSucursales()
                                .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(rol)
                                .get(index)
                                .setDireccion(direccion);
                    }
                    case 8 -> {
                        String ciudad = Ask.forString("nueva ciudad");
                        Sys.getInstance().getSucursales()
                                .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(rol)
                                .get(index)
                                .setCiudad(ciudad);
                    }
                    case 9 -> {
                        String nombreUsuario = DatosComun.obtenerNombreUsuario();
                        Sys.getInstance().getSucursales()
                                .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(rol)
                                .get(index)
                                .setNombreUsuario(nombreUsuario);
                    }
                    case 10 -> {
                        String contrasena = Ask.forString("nueva contraseña");
                        Sys.getInstance().getSucursales()
                                .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(rol)
                                .get(index)
                                .setContrasena(contrasena);
                    }
                    case 11 -> {
                        String numTelefono = DatosComun.obtenerNumTelefono();
                        Sys.getInstance().getSucursales()
                                .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(rol)
                                .get(index)
                                .setNumTelefono(numTelefono);
                    }
                    case 12 -> flag = false;
                    default -> System.out.println("Se ingresó una opción inválida");
                }
                System.out.println("---------------INFORMACIÓN ACTUAL------------------");
                System.out.println(Sys.getInstance().getSucursales()
                        .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios()
                        .get(rol).get(index));
                System.out.println("¿Desea seguir modificando la información?");
                System.out.println("1. SI \n2. NO");
                if (Ask.forInt("el número de opción") != 1)
                    flag = false;
            }
        }
    }

    public static void modificarInfoPersonal() {
        int index = Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual())
                .getListaUsuarios().get(Rol.CLIENTE).indexOf(UsuarioEnSesion.getInstancia().getUsuarioActual());
        Rol rol = Rol.CLIENTE;
        boolean flag = true;
        while (flag) {
            System.out.printf("\n---------------------MODIFICAR MI INFORMACIÓN PERSONAL---------------------",
                    rol.toString());
            System.out.println("\n¿Qué desea modificar?");
            System.out.println(
                    "1. Apellido materno \n2. Apellido Paterno\n3. Nombre \n4. Fecha de nacimiento\n5. Genero \n6. Estado \n7. Direccion \n8. Ciudad \n9. Nombre de usuario \n10. Contrasena \n11. Número de telefono \n12. Volver al menú anterior");
            int opcion = Ask.forInt("el número de opción opcion: ");

            switch (opcion) {
                case 1 -> {
                    String apellidoM = Ask.forString("nuevo apellido materno ");
                    Sys.getInstance().getSucursales()
                            .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(rol)
                            .get(index).setApellidoM(apellidoM);
                }
                case 2 -> {
                    String apellidoP = Ask.forString("nuevo apellido paterno ");
                    Sys.getInstance().getSucursales()
                            .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(rol)
                            .get(index)
                            .setApellidoP(apellidoP);
                }
                case 3 -> {
                    String nombre = Ask.forString("nuevo nombre");
                    Sys.getInstance().getSucursales()
                            .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(rol)
                            .get(index)
                            .setNombre(nombre);
                }
                case 4 -> {
                    String fechaNacimiento = Fecha.askForDate("nueva fecha de nacimiento");
                    Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual())
                            .getListaUsuarios().get(rol).get(index)
                            .setFechaNacimiento(fechaNacimiento);
                }
                case 5 -> {
                    Genero genero = DatosComun.elegirGenero();
                    Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual())
                            .getListaUsuarios().get(rol)
                            .get(index)
                            .setGenero(genero);
                }
                case 6 -> {
                    Estado estado = DatosComun.elegirEstado();
                    Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual())
                            .getListaUsuarios().get(rol)
                            .get(index)
                            .setEstado(estado);
                }
                case 7 -> {
                    String direccion = Ask.forString("nueva dirección");
                    Sys.getInstance().getSucursales()
                            .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(rol)
                            .get(index)
                            .setDireccion(direccion);
                }
                case 8 -> {
                    String ciudad = Ask.forString("nueva ciudad");
                    Sys.getInstance().getSucursales()
                            .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(rol)
                            .get(index)
                            .setCiudad(ciudad);
                }
                case 9 -> {
                    String nombreUsuario = DatosComun.obtenerNombreUsuario();
                    Sys.getInstance().getSucursales()
                            .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(rol)
                            .get(index)
                            .setNombreUsuario(nombreUsuario);
                }
                case 10 -> {
                    String contrasena = Ask.forString("nueva contraseña");
                    Sys.getInstance().getSucursales()
                            .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(rol)
                            .get(index)
                            .setContrasena(contrasena);
                }
                case 11 -> {
                    String numTelefono = DatosComun.obtenerNumTelefono();
                    Sys.getInstance().getSucursales()
                            .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(rol)
                            .get(index)
                            .setNumTelefono(numTelefono);
                }
                case 12 -> flag = false;
                default -> System.out.println("Se ingresó una opción inválida");
            }
            System.out.println("---------------INFORMACIÓN ACTUAL------------------");
            System.out.println(Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual())
                    .getListaUsuarios()
                    .get(rol).get(index));
            System.out.println("¿Desea seguir modificando la información?");
            System.out.println("1. SI \n2. NO");
            if (Ask.forInt("el número de opción") != 1)
                flag = false;
        }
    }

    public static void showInfo() {
        // MOSTRAR LA INFO DE UNO EN ESPECÍFICO
        if (Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios()
                .get(Rol.CLIENTE)
                .isEmpty()) {
            System.out.println("No hay clientes registrados");
        } else {
            boolean flag = true;
            String id = "";
            int index = 0;
            Rol rol = Rol.CLIENTE;
            System.out.printf("\n---------------------MOSTRAR LA INFORMACIÓN DE UN %s---------------------",
                    rol.toString());
            while (true) {// LÓGICA PARA OBTENER UN USUARIO
                Id.showIdList(rol);
                id = Ask.forString("el ID del usuario");
                int i = Id.validId(id, rol);
                if (i == -1) {
                    System.out.println("No se encontró al usuario, ¿desea intentarlo nuevamente?");
                    System.out.println("1. SI \n2. NO");
                    if (Ask.forInt("el número de opción") != 1) {
                        flag = false;
                        break;
                    }
                } else {
                    index = i;
                    break;
                }
            }
            if (flag) {
                Usuario usuario = Sys.getInstance().getSucursales()
                        .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios()
                        .get(Rol.CLIENTE).get(index);
                System.out.printf("-----------------------INFORMACIÓN DEL USUARIO %s-----------------------",
                        usuario.getNombreCompleto().toUpperCase());
                Cliente cliente = (Cliente) usuario;
                System.out.println(cliente);
            }
        }
    }

    public static void showList() {
        if (Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios()
                .get(Rol.CLIENTE)
                .isEmpty()) {
            System.out.println("No hay clientes registrados");
        } else {
            System.out.print("\n---------------C L I E N T E S---------------");
            for (Usuario usuario : Sys.getInstance().getSucursales()
                    .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios()
                    .get(Rol.CLIENTE)) {
                System.out.println(usuario);
            }
        }
    }

    // LÓGICA PARA SOLICITAR TARJETAS
    public static void solicitarTarjeta() {
        Cliente cliente = (Cliente) UsuarioEnSesion.getInstancia().getUsuarioActual();
        if (cliente.getListaTarjetaCredito().size() == 3) {
            System.out.println("Ya cuenta con 3 tarjetas de crédito");// hola Jorch
        } 
        else {
            
            if (Solicitud.revisarUltimaSolicitudPendiente(cliente.getListaSolicitudes())) {
                System.out.println( "Tiene una solicitud pendiente, espere a que la tarjeta sea rechazada o aprobada para solicitar otra");
            } 
            else {
                if (cliente.getTarjetaDebito().getSaldo() < 50000) {
                    System.out.println("Lo sentimos. No cuenta con el saldo suficiente para solicitar una tarjeta de crédito");
                } 
                else {
                    TipoTarjeta tipoTarjeta = Credito.obtenerTipoTarjeta(cliente.getTarjetaDebito().getSaldo());
                    if (containsTipoTarjeta(cliente.getListaTarjetaCredito(), tipoTarjeta)) {
                        System.out.printf("\nYa cuenta con una tarjeta de este tipo: %s", tipoTarjeta.toString());
                        System.out.println("\nSólo puede tener una tarjeta de crédito de cada tipo");
                    }
                    else{
                        if (verificarIdentidad()) { //pedir la contraseña para verificar la identidad
                            Solicitud solicitud = new Solicitud(cliente, tipoTarjeta);
                            cliente.getListaSolicitudes().add(solicitud);
                            Sys.getInstance().getSucursales()
                                    .get(SucursalActual.getInstancia().getSucursalActual()).getListaSolicitudes()
                                    .add(solicitud);
                            devolverUsuario(cliente);
                            System.out.println("Se ha realizado una solicitud para una tarjeta de crédito");
                            System.out.println("Espere a que esta sea aceptada o rechazada por un empleado del banco"); 
                        }
                        else{
                            System.out.println("LA SOLICITUD NO PUDO SER COMPLETA, VOLVIENDO AL MENÚ...");
                        }
                    }
                }
            }
        }
    }

    public static void consultarInfoTarjeta() {
        Cliente cliente = (Cliente) UsuarioEnSesion.getInstancia().getUsuarioActual();
        // DEBITO
        System.out.println("----------------INFORMACIÓN DE LA TARJETA DE DÉBITO----------------");
        System.out.println(cliente.getTarjetaDebito());
        // CREDITO
        if (cliente.getListaTarjetaCredito().isEmpty()) {
            System.out.println("NO CUENTA CON TARJETAS DE CRÉDITO");
        } else {
            System.out.println("----------------INFORMACIÓN DE LAS TARJETAS DE CRÉDITO----------------");
            for (Credito tarjeta : cliente.getListaTarjetaCredito()) {
                System.out.println(tarjeta);
                System.out.println("\n-----------------------------------------------------------");
            }
        }
    }

    public static void verSolicitudes() {
        Cliente cliente = (Cliente) UsuarioEnSesion.getInstancia().getUsuarioActual();
        if (cliente.getListaSolicitudes().isEmpty())
            System.out.println("No ha realizado ninguna solicitud aún");
        else {
            System.out.println("-----------LISTA DE SOLICITUDES------------");
            for (Solicitud solicitud : cliente.getListaSolicitudes()) {
                System.out.println(solicitud);
            }
        }
    }

   
    public static void depositar() {
        Cliente cliente = (Cliente) UsuarioEnSesion.getInstancia().getUsuarioActual();
        double monto = Ask.forDouble("el monto a depositar");

        System.out.println("¿A cuál tarjeta desea depositar dinero?");
        System.out.println("1. Credito \n2. Debito");
        int tarjeta = Ask.forInt("la opción");
        switch (tarjeta) {
            case 1:
                if (cliente.getListaTarjetaCredito().isEmpty()) {
                    System.out.println("---No cuenta con tarjetas de credito---");
                } else {
                    //CORREGIR URGENTEMENTE ESTO
                    int i = obtenerIndexTarjetaCredito();
                    Double saldo = cliente.listaTarjetaCredito.get(i).getSaldo();
                    if (monto > cliente.listaTarjetaCredito.get(i).getCreditoMax()) {
                        System.out.println("No puede depositar mas del limite de la tarjeta.");
                    } else {
                        if (saldo + monto > cliente.listaTarjetaCredito.get(i).getCreditoMax()) {
                            cliente.getListaTarjetaCredito().get(i)
                                    .setSaldo(cliente.listaTarjetaCredito.get(i).getCreditoMax());
                            devolverUsuario(cliente);
                        } else {
                            double nuevoSaldo = depositarSaldo(monto, saldo);
                            cliente.getListaTarjetaCredito().get(i).setSaldo(nuevoSaldo);
                            cliente.setActive(true);
                            MovimientoBancario.registrarMovimiento(cliente, monto, TipoMovimiento.DEPOSITO);
                            devolverUsuario(cliente);
                        }
                    }
                }
                break;
            case 2:
                Double saldo = cliente.getTarjetaDebito().getSaldo();
                double nuevoSaldo = depositarSaldo(monto, saldo);
                cliente.getTarjetaDebito().setSaldo(nuevoSaldo);
                cliente.getTarjetaDebito().setFechaUltimoMov(DatosComun.formateoFecha(LocalDateTime.now()));
                cliente.setActive(true);
                MovimientoBancario.registrarMovimiento(cliente, monto, TipoMovimiento.DEPOSITO);
                devolverUsuario(cliente);
                break;
            default:
                System.out.println("Opción inválida inténtelo nuevamente");
                break;
        }
    }

    public static void retirar() {// DEBITO Y CREDITO
        Cliente cliente = (Cliente) UsuarioEnSesion.getInstancia().getUsuarioActual();
        double monto = Ask.forDouble("el monto a retirar");

        System.out.println("¿De cuál tarjeta desea retirar dinero?");
        System.out.println("1. Credito \n2. Debito");
        int tarjeta = Ask.forInt("la opción");
        switch (tarjeta) {
            case 1:
                if (cliente.getListaTarjetaCredito().isEmpty()) {
                    System.out.println("---No cuenta con tarjetas de credito---");
                } else {
                    int i = obtenerIndexTarjetaCredito();
                    Double saldo = cliente.getListaTarjetaCredito().get(i).getSaldo();
                    if (monto >= saldo) {
                        System.out.println("No puede retirar mas dinero del que tiene la tarjeta.");
                    } else {
                        double nuevoSaldo = retiroSaldo(monto, saldo);
                        cliente.getListaTarjetaCredito().get(i).setSaldo(nuevoSaldo);
                        MovimientoBancario.registrarMovimiento(cliente, monto, TipoMovimiento.DEPOSITO);
                        devolverUsuario(cliente);
                    }
                }
                break;
            case 2:
                Double saldo = cliente.getTarjetaDebito().getSaldo();
                if (monto >= saldo) {
                    System.out.println("No puede retirar mas de lo que tiene la tarjeta.");
                } else {
                    double nuevoSaldo = retiroSaldo(monto, saldo);
                    cliente.getTarjetaDebito().setSaldo(nuevoSaldo);
                    cliente.getTarjetaDebito().setFechaUltimoMov(DatosComun.formateoFecha(LocalDateTime.now()));
                    cliente.setActive(true);
                    MovimientoBancario.registrarMovimiento(cliente, monto, TipoMovimiento.RETIRO);
                    devolverUsuario(cliente);
                }
                break;
            default:
                System.out.println("Opción inválida inténtelo nuevamente");
                break;
        }
    }


    public static void mostrarNotificacion(){
        Cliente cliente = (Cliente)UsuarioEnSesion.getInstancia().getUsuarioActual();
        if (!cliente.getListaSolicitudes().isEmpty()) {
            Estatus estatus = cliente.getListaSolicitudes().get(cliente.getListaSolicitudes().size() - 1).getEstatus();
            if ( estatus == Estatus.APROBADA) {
                System.out.println("********Su última solicitud fue aprobada!********");
            }
            else if (estatus == Estatus.RECHAZADA ) {
                System.out.println("********Su última solicitud fue rechazada :(********");
            }
            else{
                System.out.println("********Su última solicitud sigue pendiente********");
            }
        }
    }

    private static double retiroSaldo(double monto, double saldo) {
        Double nuevoSaldo = saldo - monto;
        Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).disminuirSaldo(monto);;
        System.out.println("Se ha retirado $" + monto + " de la tarjeta. Nuevo saldo: $" + nuevoSaldo);
        return nuevoSaldo;
    }

    private static double depositarSaldo(double monto, double saldo) {
        Double nuevoSaldo = saldo + monto;
        Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).aumentarSaldo(monto);
        System.out.printf("\nSe ha depositado $%.2f de la tarjeta. Nuevo saldo: $%.2f\n\n", monto, nuevoSaldo);
        return nuevoSaldo;
    }

    private static boolean containsTipoTarjeta(ArrayList<Credito> lista, TipoTarjeta tipoTarjeta){
        for (Credito tarjeta : lista) {
            if (tarjeta.getTipoTarjeta() == tipoTarjeta) {
                return true;
            }
        }
        return false;
    }

    private static int obtenerIndexTarjetaCredito(){
        Cliente cliente = (Cliente) UsuarioEnSesion.getInstancia().getUsuarioActual();
        
        int index = 0;
        while (index == 0) {
            int i = 1;
            for (Credito tarjeta : cliente.getListaTarjetaCredito()) {
                System.out.printf("[%d] %s",i, tarjeta.toString());
            i++;
            }
            index = Ask.forInt("el número de tarjeta de crédito que aparece en la lista");
            switch (index) {
                case 1 -> index = 1;
                case 2 -> {
                    if (index > cliente.getListaTarjetaCredito().size()) {
                        System.out.println("Se ingresó una opción inválida");
                    }
                    else{
                        index = 2;
                    }
                }
                case 3 -> {
                    if (index > cliente.getListaTarjetaCredito().size()) {
                        System.out.println("Se ingresó una opción inválida");
                    }
                    else{
                        index = 3;
                    }
                }
                default -> System.out.println("Se ingresó una opción inválida");
            }
        }
    return index - 1;
    }


    private static boolean verificarIdentidad(){
        int contador = 0;
        System.out.println("Para solicitar la tarjeta de crédito debemos verificar su identidad");
        System.out.println("Es necesario que ingrese su nombre de usuario y contraseña");
        while (contador != 3) {
            String nombreUsuario = Ask.forString("el nombre de usuario");
            String contrasena = Ask.forString("la contraseña");

            for (Usuario cliente: Sys.getInstance().getSucursales()
                .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(Rol.CLIENTE)) {
            if (cliente.getNombreUsuario().equals(nombreUsuario)) {
                if (cliente.getContrasena().equals(contrasena)) {
                    return true;
                }
                else{
                    contador++;
                    System.out.println("Nombre de usuario o contraseña incorrectos");
                    System.out.println("Si realiza 3 intentos fallidos consecutivos la operación se cancelará");
                    break;
                }
            }
            else{
                contador++;
                    System.out.println("Nombre de usuario o contraseña incorrectos");
                    System.out.println("Si realiza 3 intentos fallidos consecutivos la operación se cancelará");
                    break;
            }

            }
        }
        return false;
    }


    public static void devolverUsuario(Usuario usuario) {// index del usuario original
        int index = Sys.getInstance().getSucursales()
                .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(Rol.CLIENTE)
                .indexOf(UsuarioEnSesion.getInstancia().getUsuarioActual());
        Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios()
                .get(Rol.CLIENTE).set(index,
                        usuario);
    }

    public Debito getTarjetaDebito() {
        return tarjetaDebito;
    }

    public ArrayList<Credito> getListaTarjetaCredito() {
        return listaTarjetaCredito;
    }

    public ArrayList<Solicitud> getListaSolicitudes() {
        return listaSolicitudes;
    }
}