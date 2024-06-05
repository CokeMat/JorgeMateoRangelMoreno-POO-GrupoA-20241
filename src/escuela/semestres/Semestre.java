package escuela.semestres;

import java.util.ArrayList;
import java.util.HashMap;

import escuela.grupos.Grupo;
import escuela.historiales.periodos.utils.NombrePeriodo;
import escuela.materias.Materia;
import utils.Id;

public class Semestre {
    private String IDsemestre;
    private int numeroSemestre;
    private String nombreCarrera;
    private HashMap<String, Grupo> grupos;// En la Key va ir "A" O "B"

    public Semestre(int numeroSemestre, String nombreCarrera, HashMap<String, ArrayList<Materia>> materias) {
        this.grupos = new HashMap<>();
        this.numeroSemestre = numeroSemestre;
        this.nombreCarrera = nombreCarrera;
        this.IDsemestre = Id.generate(nombreCarrera + String.valueOf(numeroSemestre) + "-");
        inicializarGrupos(materias);
    }

    public String getID() {
        return IDsemestre;
    }

    public int getNumeroSemestre() {
        return numeroSemestre;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public HashMap<String, Grupo> getGrupos() {
        return grupos;
    }

    private void inicializarGrupos(HashMap<String, ArrayList<Materia>> materias) {// CORREGIR
        // se incializan las listas
        ArrayList<Materia> materiasGrupoA = new ArrayList<>();
        ArrayList<Materia> materiasGrupoB = new ArrayList<>();
        // se obtienen las 3 materias correspondientes a la carrera, número de semestre
        // y grupo
        materiasGrupoA = Materia.getMateriasGrupo(getNombreCarrera(), getNumeroSemestre(), "A", materias);
        materiasGrupoB = Materia.getMateriasGrupo(getNombreCarrera(), getNumeroSemestre(), "B", materias);
        // se incializan los grupos correspondientes de este semestre
        grupos.put("A", new Grupo(getNombreCarrera(), getID(), "A", materiasGrupoA, NombrePeriodo.AGOSTO_DICIEMBRE_2023.toString()));
        grupos.put("B", new Grupo(getNombreCarrera(), getID(), "B", materiasGrupoB, NombrePeriodo.AGOSTO_DICIEMBRE_2023.toString()));
    }

}