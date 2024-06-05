package escuela.models;

import java.util.ArrayList;

import usuarios.Alumnos.Alumno;

public class AlumnoModel {
    private ArrayList<Alumno> SISTEMAS;
    private ArrayList<Alumno> ELECTRONICA;
    private ArrayList<Alumno> MATERIALES;

    public ArrayList<Alumno> getListaSistemas() {
        return SISTEMAS;
    }

    public ArrayList<Alumno> getListaMateriales() {
        return MATERIALES;
    }

    public ArrayList<Alumno> getListaElectronica() {
        return ELECTRONICA;
    }
}
