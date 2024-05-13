package biblioteca;
import java.util.*;

import libros.Libro;
import libros.constants.Genero;
import usuarios.helpers.Rol;
import usuarios.*;


public class Biblioteca {
    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>();
    public static final HashMap<Genero, ArrayList<Libro>> libros = new HashMap<>();

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

    private void inicializarHashMaps(){
        usuarios.put(Rol.TRABAJADOR, new ArrayList<>());
        usuarios.put(Rol.CLIENTE, new ArrayList<>());
        usuarios.put(Rol.GERENTE, new ArrayList<>());

        libros.put(Genero.TERROR, new ArrayList<>());
        libros.put(Genero.COMEDIA, new ArrayList<>());
        libros.put(Genero.ACCION, new ArrayList<>());

    }

    //CLIENTE
    private void addCliente(){
        Cliente.addCliente();
    }
    public void showClientes(){
        Cliente.showClientes();
    }
    public void showInfoCliente(){
        Cliente.showInfoCliente();
    }
    public void eliminarCliente(){
        Cliente.eliminarCliente();
    }
    public void modifyInfoCliente(){
        Cliente.modifyInfo();
    }

    //Trabajador
    public void addTrabajadores(){
        Trabajador.addTrabajadores();
    }

    public void showTrabajadores(){
        Trabajador.showTrabajadores();
    }
    public void showInfoTrabajador(){Trabajador.showInfoTrabajador();}
    public void eliminarTrabajador(){
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
