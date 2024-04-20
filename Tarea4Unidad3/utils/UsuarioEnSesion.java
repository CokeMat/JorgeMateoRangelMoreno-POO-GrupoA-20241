import usuarios.Usuario;

public class UsuarioEnSesion{
    private static UsuarioEnSesion instancia;
    public Usuario usuarioActual;

    private UsuarioEnSesion(){}
    public static UsuarioEnSesion getInstancia(){
        if(instancia==null){
            instancia=new UsuarioEnSesion();
        }
        return instancia;
    }
    public Usuario getUsuarioActual(){
        return usuarioActual;
    }
    public void setUsuario(Usuario usuarioActual){
        this.usuarioActual=usuarioActual;
    }
    public boolean hayUsuarioEnSesion(){
        return usuarioActual != null;
    }

    public void cerrarSesion(){
        instancia = null;
        usuarioActual = null;
    }
}