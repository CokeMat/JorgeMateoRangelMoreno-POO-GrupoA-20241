package biblioteca;
import java.util.*;

import libros.Libro;
import libros.constants.Genero;
import usuarios.helpers.Rol;
import usuarios.*;
import utils.JsonClass;


public class Biblioteca {
    public static final HashMap<String, ArrayList<Usuario>> usuarios = new HashMap<String, ArrayList<Usuario>>();
    public static final HashMap<String, ArrayList<Libro>> libros = new HashMap<>();

    public static void inicializarPrograma(){
        inicializarHashMaps();
        Gerente gerente = new Gerente("Jorge", "Rangel", Rol.GERENTE.toString(), "9am a 4pm", "Masculino", "4433017887", "cokemat", "1234", "16/02/2018");
        usuarios.get(Rol.GERENTE.toString()).add(gerente);
    }
    Scanner sc = new Scanner(System.in);

    public static Usuario verificarInicioSesion(String usuario, String contrasena) {
        for(Map.Entry<String, ArrayList<Usuario>> entry : usuarios.entrySet()){
            ArrayList<Usuario> listaUsuarios = entry.getValue();
            for(Usuario usuarioActual : listaUsuarios){
                if(usuarioActual.getNombreUsuario().equals(usuario) && usuarioActual.getContrasena().equals(contrasena)){
                    return usuarioActual;
                }
            }
        }
        return null;
    }

    private static void inicializarHashMaps(){
        usuarios.put(Rol.TRABAJADOR.toString(), new ArrayList<>());
        usuarios.put(Rol.CLIENTE.toString(), new ArrayList<>());
        usuarios.put(Rol.GERENTE.toString(), new ArrayList<>());

        libros.put(Genero.TERROR.toString(), new ArrayList<>());
        libros.put(Genero.COMEDIA.toString(), new ArrayList<>());
        libros.put(Genero.ACCION.toString(), new ArrayList<>());

    }

    //CLIENTE
    public static void addCliente(){
        Cliente.addCliente();
    }
    public static void showClientes(){
        Cliente.showClientes();
    }
    public static void showInfoCliente(){
        Cliente.showInfoCliente();
    }
    public static void eliminarCliente(){
        Cliente.eliminarCliente();
    }
    public static void modifyInfoCliente(){
        Cliente.modifyInfo();
    }

    //Trabajador
    public static void addTrabajadores(){
        Trabajador.addTrabajadores();
    }

    public static void showTrabajadores(){
        Trabajador.showTrabajadores();
    }
    public static void showInfoTrabajador(){Trabajador.showInfoTrabajador();}
    public static void eliminarTrabajador(){
        Trabajador.eliminarTrabajador();
    }
    public void modifyInfoTrabajador(){
        Trabajador.modifyInfo();
    }

    //Gerente
    private void addGerente(){
        Gerente.addGerente();
    }

    public void showGerentes(){
        Gerente.showGerentes();
    }
    public void eliminarGerente(){
        Gerente.eliminarGerente();
    }
    public void modifyInfoGerente(){
        Gerente.modifyInfo();
    }
    public void showInfoGerente(){Trabajador.showInfoTrabajador();}



    //Getters y setters
    public static HashMap<String, ArrayList<Libro>> getListaLibros(){
        return libros;
    }
}
