package biblioteca;
import java.util.*;

import libros.Libro;
import libros.constants.Genero;
import usuarios.helpers.Rol;
import usuarios.*;


public class Biblioteca {
    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>();
    public static final HashMap<Genero, ArrayList<Libro>> libros = new HashMap<>();

    public static void inicializarPrograma(){
        inicializarHashMaps();
        Gerente gerente = new Gerente("Jorge", "Rangel", Rol.GERENTE.toString(), "9am a 4pm", "Masculino", "4433017887", "cokemat", "1234");
        usuarios.get(Rol.GERENTE).add(gerente);
    }
    Scanner sc = new Scanner(System.in);

    public static Usuario verificarInicioSesion(String usuario, String contrasena) {
        for(Map.Entry<Rol, ArrayList<Usuario>> entry : usuarios.entrySet()){
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
        usuarios.put(Rol.TRABAJADOR, new ArrayList<>());
        usuarios.put(Rol.CLIENTE, new ArrayList<>());
        usuarios.put(Rol.GERENTE, new ArrayList<>());

        libros.put(Genero.TERROR, new ArrayList<>());
        libros.put(Genero.COMEDIA, new ArrayList<>());
        libros.put(Genero.ACCION, new ArrayList<>());

    }

    //CLIENTE
    private static void addCliente(){
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
    public static HashMap<Genero, ArrayList<Libro>> getListaLibros(){
        return libros;
    }
}
