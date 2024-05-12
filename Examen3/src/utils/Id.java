package src.utils;

import java.util.ArrayList;
import java.util.Random;

import src.fintech.Sys;
import src.fintech.solicitudes.Solicitud;
import src.usuarios.Usuario;
import src.usuarios.utils.Rol;

public class Id {
    static Random ran = new Random();

    public static String generate(String cad){
        String ID = cad;
        //String lettersBank = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbersBank = "01234567890";
        int i = 0;
        while (i < 5) {
            ID += String.valueOf(numbersBank.charAt(ran.nextInt(numbersBank.length())));
            i++;
        }   
    return ID;
    } 

    public static int validId(String Id, Rol rol){
        int index = -1;
        ArrayList<Usuario> lista = Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(rol);
        for (int i = 0; i < lista.size(); i++) {
            if (Id.equals(lista.get(i).getId())) return i;
        }
    return index;
    }

    public static Solicitud validIdSolicitud(String Id) {
        Solicitud solicitud = null;
        ArrayList<Solicitud> lista = Sys.getInstance().getSucursales()
                .get(SucursalActual.getInstancia().getSucursalActual()).getListaSolicitudes();
        for (Solicitud solicitudActual : lista) {
            if (Id.equals(solicitudActual.getIdSolicitud()))//Ta bien, amonos
                return solicitudActual;//listo
        }
        return solicitud;
    }

    public static void showIdList(Rol rol) {
		System.out.printf("\n---------------LISTA DE ID de %sS---------------", rol.toString());//PARA ESTE PRINT
        for (Usuario usuario : Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(rol)) {
            System.out.printf("\n | NOMBRE DEL CAPTURISTA: %s| NOMBRE DE USUARIO: %s | ID: %s | ", usuario.getNombreCompleto(), usuario.getNombreUsuario(), usuario.getId());
        }
	}
}