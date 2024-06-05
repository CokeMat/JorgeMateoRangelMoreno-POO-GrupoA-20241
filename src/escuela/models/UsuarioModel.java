package escuela.models;

import java.util.ArrayList;

import usuarios.Usuario;

public class UsuarioModel {
    private ArrayList<Usuario> SISTEMAS;
    private ArrayList<Usuario> ELECTRONICA;
    private ArrayList<Usuario> MATERIALES;

    public ArrayList<Usuario> getListaSistemas() {
        return SISTEMAS;
    }

    public ArrayList<Usuario> getListaMateriales() {
        return MATERIALES;
    }

    public ArrayList<Usuario> getListaElectronica() {
        return ELECTRONICA;
    }
}
