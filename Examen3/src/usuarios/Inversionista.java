package src.usuarios;

import src.fintech.Sys;
import src.fintech.movimientos.MovimientoBancario;
import src.fintech.movimientos.utils.TipoMovimiento;
import src.utils.*;
import java.util.ArrayList;
import src.usuarios.utils.Estado;
import src.usuarios.utils.Genero;
import src.usuarios.utils.Rol;
import src.fintech.utils.DatosComun;

public class Inversionista extends Usuario {
    private double fondos, cantidadInvertida;

    public Inversionista(String nombre, String apellidoM, String apellidoP, String fechaNacimiento,
            Genero genero, Estado estado, String direccion, String ciudad, String nombreUsuario, String contrasena,
            Rol rol,
            double fondos, String numTelefono, String id) {
        super(nombre, apellidoM, apellidoP, fechaNacimiento, genero, estado, direccion, ciudad, nombreUsuario,
                contrasena,
                rol, numTelefono, id);
        this.fondos = fondos;
    }

    public static void registrar() {
        ArrayList<String> datos = DatosComun.obtenerDatosComun(Rol.INVERSIONISTA);

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
        Rol rol = Rol.INVERSIONISTA;

        Genero genero = DatosComun.validaGenero(gender);
        Estado estado = DatosComun.validEstado(state);
        String id = DatosComun.obtenerID("I");

        Double fondos = Ask.forDouble("los fondos");
        Sys.getInstance().getSucursales()
                .get(SucursalActual.getInstancia().getSucursalActual()).aumentarSaldo(fondos);

        Inversionista inversionista = new Inversionista(nombre, apellidoM, apellidoP, fechaNacimiento, genero, estado,
                direccion, ciudad, nombreUsuario, contrasena, rol, fondos, numTelefono, id);

        Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios()
                .get(Rol.INVERSIONISTA)
                .add(inversionista);

        System.out.println("\nInversionista Registrado\n");
    }

    public static void eliminar() {
        if (Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios()
                .get(Rol.INVERSIONISTA)
                .isEmpty()) {
            System.out.println("No hay inversionistas registrados");
        } else {
            boolean flag = true;
            String id = "";
            int index = 0;
            System.out.printf("\n---------------------MOSTRAR LA INFORMACIÓN DE UN %s---------------------",
                    Rol.INVERSIONISTA.toString());
            while (true) {// LÓGICA PARA OBTENER UN USUARIO
                Id.showIdList(Rol.INVERSIONISTA);
                id = Ask.forString("el ID del usuario");
                int i = Id.validId(id, Rol.INVERSIONISTA);
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
                        .get(Rol.INVERSIONISTA).get(index);

                if (usuario.isActive()) {
                    System.out.println(
                            "Este usuario participa en otras actividades, por lo que no es posible eliminarlo");
                } else {
                    Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual())
                            .getListaUsuarios()
                            .get(Rol.INVERSIONISTA).remove(usuario);
                    System.out.println("El inversionista fue eliminado exitosamente");
                }
            }
        }
    }

    public static void modificar() {
        if (Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios()
                .get(Rol.INVERSIONISTA)
                .isEmpty()) {
            System.out.println("No hay inversionistas registrados");
        } else {
            boolean flag = true;
            Rol rol = Rol.INVERSIONISTA;

            String id = "";
            int index = 0;
            while (true) {// LÓGICA PARA OBTENER UN USUARIO
                Id.showIdList(Rol.INVERSIONISTA);
                id = Ask.forString("el ID del usuario");
                int i = Id.validId(id, Rol.INVERSIONISTA);
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
                        Rol.INVERSIONISTA.toString());
                System.out.println("¿Qué desea modificar?");
                System.out.println(
                        "1.Apelldio materno \n2.ApellidoPaterno\n3.nombre \n4.Fecha de nacimiento\n5.Genero \n6.Estado \n7.Direccion \n8.Ciudad \n9.Nombre de usuario \n10.Contrasena \n11.numero de telefono ");
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

    public static void showInfo() {
        // MOSTRAR LA INFO DE UNO EN ESPECÍFICO
        if (Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios()
                .get(Rol.INVERSIONISTA)
                .isEmpty()) {
            System.out.println("No hay inversionistas registrados");
        } else {
            boolean flag = true;
            String id = "";
            int index = 0;
            System.out.printf("\n---------------------MOSTRAR LA INFORMACIÓN DE UN %s---------------------",
                    Rol.INVERSIONISTA.toString());
            while (true) {// LÓGICA PARA OBTENER UN USUARIO
                Id.showIdList(Rol.INVERSIONISTA);
                id = Ask.forString("el ID del usuario");
                int i = Id.validId(id, Rol.INVERSIONISTA);
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
                        .get(Rol.INVERSIONISTA).get(index);
                System.out.printf("-----------------------INFORMACIÓN DEL USUARIO %s-----------------------",
                        usuario.getNombreCompleto().toUpperCase());
                Inversionista inversionista = (Inversionista) usuario;
                System.out.println(inversionista);
            }
        }
    }

    public static void showList() {
        if (Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios()
                .get(Rol.INVERSIONISTA)
                .isEmpty()) {
            System.out.println("No hay inversionistas registrados");
        } else {
            System.out.print("\n---------------I N V E R S I O N I S T A S---------------");
            for (Usuario usuario : Sys.getInstance().getSucursales()
                    .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios()
                    .get(Rol.INVERSIONISTA)) {
                System.out.println(usuario);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s | FONDOS: $% .2f |\n", super.toString(), fondos);
    }

    

    public static void hacerCargo() {
        System.out.println("------R E A L I Z A R---I N V E R S I O N------");
        Inversionista inversionista = (Inversionista) UsuarioEnSesion.getInstancia().getUsuarioActual();
        double cantidadInvertida = Ask.forDouble("la cantidad que desea invertir");
        if (cantidadInvertida > inversionista.getFondos()) {
            System.out.println("FONDOS INSUFICIENTES\n");
        } else {
            Sys.getInstance().getSucursales()
                    .get(SucursalActual.getInstancia().getSucursalActual()).aumentarSaldo(cantidadInvertida);
            double nuevosFondos = inversionista.getFondos() - cantidadInvertida;
            inversionista.setFondos(nuevosFondos);
            inversionista.setActive(true);
            MovimientoBancario.registrarMovimiento(inversionista, cantidadInvertida, TipoMovimiento.DEPOSITO);
            devolverUsuario(inversionista);
            System.out.println("Se realizo una inversión de " + cantidadInvertida);
            System.out.println("Fondos restantes: " + inversionista.getFondos()+"\n");
        }
    }

    public static void devolverUsuario(Usuario usuario) {// index del usuario original
        int index = Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual())
                .getListaUsuarios().get(Rol.INVERSIONISTA).indexOf(UsuarioEnSesion.getInstancia().getUsuarioActual());
        Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios()
                .get(Rol.INVERSIONISTA).set(index, usuario);
    }

    public double getFondos() {
        return fondos;
    }

    public void setFondos(double fondos) {
        this.fondos = fondos;
    }

    public void setCantidadInvertida(double cantidadInvertida) {
        this.cantidadInvertida = cantidadInvertida;
    }

    


}