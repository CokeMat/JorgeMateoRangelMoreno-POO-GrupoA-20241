package escuela.models;

import java.util.ArrayList;

import usuarios.Trabajadores.Profesor;

public class ProfesorModel {
    private ArrayList<Profesor> SISTEMAS;
    private ArrayList<Profesor> ELECTRONICA;
    private ArrayList<Profesor> MATERIALES;

    public ArrayList<Profesor> getListaSistemas() {
        return SISTEMAS;
    }

    public ArrayList<Profesor> getListaMateriales() {
        return MATERIALES;
    }

    public ArrayList<Profesor> getListaElectronica() {
        return ELECTRONICA;
    }
    
}
