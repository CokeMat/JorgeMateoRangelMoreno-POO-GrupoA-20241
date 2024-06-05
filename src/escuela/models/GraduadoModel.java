package escuela.models;

import java.util.ArrayList;

import usuarios.Alumnos.Graduado;



public class GraduadoModel {
    private ArrayList<Graduado> SISTEMAS;
    private ArrayList<Graduado> ELECTRONICA;
    private ArrayList<Graduado> MATERIALES;

    public ArrayList<Graduado> getListaSistemas() {
        return SISTEMAS;
    }

    public ArrayList<Graduado> getListaMateriales() {
        return MATERIALES;
    }

    public ArrayList<Graduado> getListaElectronica() {
        return ELECTRONICA;
    }
    
}
