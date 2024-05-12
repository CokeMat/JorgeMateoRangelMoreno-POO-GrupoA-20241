package src.usuarios.empleados;

import java.time.LocalDate;
import java.util.ArrayList;
import src.fintech.utils.DatosComun;
import src.usuarios.utils.*;
import src.fintech.Sys;
import src.utils.*;
import src.usuarios.Usuario;

public class Capturista extends Empleado {

    public Capturista(String nombre, String apellidoM, String apellidoP, String fechaNacimiento, Genero genero,
            src.usuarios.utils.Estado estado, String direccion, String ciudad, String nombreUsuario, String contrasena,
            String numTelefono, String id, double salario, String horario, String fechaIngreso) {
        super(nombre, apellidoM, apellidoP, fechaNacimiento, genero, estado, direccion, ciudad, nombreUsuario,
                contrasena, Rol.CAPTURISTA, numTelefono, id, salario, horario, fechaIngreso);
    }

    public static void registrar() {
        ArrayList<String> datos = DatosComun.obtenerDatosComun(Rol.CAPTURISTA);

        String nombre = datos.get(0);
        String apellidoP = datos.get(1);
        String apellidoM = datos.get(2);
        String fechaNacimiento = datos.get(3);
        // LocalDate fechaNacimiento = LocalDate.parse(fecha);
        String direccion = datos.get(4);
        String state = datos.get(5);
        String ciudad = datos.get(6);
        String nombreUsuario = datos.get(7);
        String contrasena = datos.get(8);
        String gender = datos.get(9);
        String numTelefono = datos.get(10);

        Genero genero = DatosComun.validaGenero(gender);
        Estado estado = DatosComun.validEstado(state);
        String id = DatosComun.obtenerID("CA");
        double salario = Ask.forDouble("el salario");
        String horario = DatosComun.seleccionarHorario();
        String fechaIngreso = LocalDate.now().toString();

        Capturista capturista = new Capturista(nombre, apellidoM, apellidoP, fechaNacimiento, genero, estado, direccion,
                ciudad, nombreUsuario, contrasena, numTelefono, id, salario, horario, fechaIngreso);

        Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios()
                .get(Rol.CAPTURISTA)
                .add(capturista);

        System.out.println("\nCapturista Registrado\n");
    }

    public static void eliminar() {
        if (Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios()
                .get(Rol.CAPTURISTA).isEmpty()) {
            System.out.println("No hay capturistas registrados");
        } else {
            boolean flag = true;
            String id = "";
            int index = 0;
            Rol rol = Rol.CAPTURISTA;
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
                        .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(rol).get(index);
                    Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual())
                            .getListaUsuarios().get(rol).remove(usuario);
                    System.out.println("El capturista fue eliminado exitosamente");
                
            }
        }
    }

    public static void modificar() {
        if (Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios()
                .get(Rol.CAPTURISTA).isEmpty()) {
            System.out.println("No hay capturista registrados");
        } else {
            boolean flag = true;
            Rol rol = Rol.CAPTURISTA;

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
                        .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(rol).get(index));
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
                .get(Rol.CAPTURISTA).isEmpty()) {
            System.out.println("No hay capturistas registrados");
        } else {
            boolean flag = true;
            String id = "";
            int index = 0;
            System.out.printf("\n---------------------MOSTRAR LA INFORMACIÓN DE UN %s---------------------",
                    Rol.CAPTURISTA.toString());
            while (true) {// LÓGICA PARA OBTENER UN USUARIO
                Id.showIdList(Rol.CAPTURISTA);
                id = Ask.forString("el ID del usuario");
                int i = Id.validId(id, Rol.CAPTURISTA);
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
                        .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(Rol.CAPTURISTA)
                        .get(index);
                System.out.printf("-----------------------INFORMACIÓN DEL USUARIO %s-----------------------",
                        usuario.getNombreCompleto().toUpperCase());
                Capturista capturista = (Capturista) usuario;
                System.out.println(capturista);
            }
        }
    }

    public static void showList() {
        if (Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios()
                .get(Rol.CAPTURISTA).isEmpty()) {
            System.out.println("No hay capturistas registrados");
        } else {
            System.out.print("\n---------------E J E C U T I V O S   DE   C U E N T A---------------");
            for (Usuario usuario : Sys.getInstance().getSucursales()
                    .get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(Rol.CAPTURISTA)) {
                System.out.println(usuario);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s", super.toString());
    }

}
