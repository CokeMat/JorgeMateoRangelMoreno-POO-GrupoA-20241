package src.fintech;

import src.fintech.utils.Sucursal;
import src.usuarios.Usuario;
import src.utils.Ask;
import src.utils.SucursalActual;
import src.utils.UsuarioEnSesion;

import java.util.HashMap;

public class Sys {
    private static Sys instance;
    private static HashMap<Sucursal, Fintech> sucursales = new HashMap<>();

    public Sys() {
        sucursales.put(Sucursal.ACUEDUCTO, new Fintech(Sucursal.ACUEDUCTO));
        sucursales.put(Sucursal.MADERO, new Fintech(Sucursal.MADERO));
    }

    public void ejecutarSistema() {
        Sucursal sucursal = null;
        boolean flag = true;
        do {
            if (SucursalActual.getInstancia().getSucursalActual() == null) {
                sucursal = Menu.preguntarSucursal();
                if (sucursal == null){
                    System.out.println("Gracias por utilizar nuestro programa \3");
                    break;
                }
                else 
                SucursalActual.getInstancia().setSucursal(sucursal);
            }
            System.out.printf("\n****************BIENVENIDO A LA SUCURSAL %s****************",
                    SucursalActual.getInstancia().getSucursalActual());
            iniciarSesion();

            System.out.printf("\nSe encuentra actualmente en la sucursal: %s",
                    SucursalActual.getInstancia().getSucursalActual().toString());
            System.out.println("\n¿Qué desea hacer?");
            System.out.println("\n1. Mantenerse en esta sucursal");
            System.out.println("2. Volver al menú principal");
            int answer = Ask.forInt("el número de opción");
            if (answer != 1) {
                SucursalActual.getInstancia().cerrarSucursal();
            }
        } while (flag);
    }

    private static void iniciarSesion() {
        int contador = 0;
        boolean datosCorrectos = false;
        System.out.print("\n----------------Inicia sesión para continuar----------------");
        do {
            String nombreUsuario = Ask.forString("el nombre de usuario");
            String contrasena = Ask.forString("la contraseña");

            Usuario usuario = Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual())
                    .verificarInicioSesion(nombreUsuario, contrasena);
            if (usuario != null) {
                UsuarioEnSesion.getInstancia().setUsuario(usuario);
                datosCorrectos = true;
                Menu.seleccionarMenu();
            } else {
                contador++;
                if (contador == 4) {
                    System.out.println("Ha excedido el número de intentos. Volviendo al menú anterior...");
                }
                System.out.println("Nombre de usuario o contraseña incorrectos. Intente de nuevo");
            }
        } while (!datosCorrectos && contador != 4);
    }

    public HashMap<Sucursal, Fintech> getSucursales() {
        return sucursales;
    }

    public static Sys getInstance() {
        if (instance == null) {
            instance = new Sys();
        }
        return instance;
    }

    /*
     * public static ArrayList<Usuario> obtenerLista(Rol rol){
     * return sucursales.get(SucursalActual.getInstancia().getSucursalActual()).
     * listaUsuarios.get(rol);
     * }
     */

}
