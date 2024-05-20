package utils;

import usuarios.*;
import java.util.*;
public class UsuarioModel {
    private ArrayList<Trabajador> trabajadores;
    private ArrayList<Cliente> clientes;
    private ArrayList<Gerente> gerentes;

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Gerente> getGerente() {
        return gerentes;
    }

}
