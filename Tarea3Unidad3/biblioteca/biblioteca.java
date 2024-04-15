package biblioteca;
import java.util.ArrayList;

import usuarios.Usuario;;

public class biblioteca {
    @Deprecated
    private ArrayList<Usuario> usuarios=new ArrayList<>();

    public Usuario verificarInicioSesion(String usuario, String contrasena){
        for(Usuario usuarioActual:usuarios){
            if(usuarioActual.getNombreUsuario().equals(usuario)){
                if(usuarioActual.getContrasena().equals(contrasena)){
                    return usuarioActual;
                }
                return null;
            }
        }
        return null;
    }
}
