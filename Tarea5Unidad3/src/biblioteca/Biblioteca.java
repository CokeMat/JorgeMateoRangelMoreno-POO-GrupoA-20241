package biblioteca;
import java.util.*;
import usuarios.helpers.Rol;
import usuarios.*;


public class Biblioteca {
    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>();

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
}
