package escuela.models;

import java.util.HashMap;

import escuela.historiales.Historial;

public class HistorialModel {
    private HashMap<String, Historial> SISTEMAS;
    private HashMap<String, Historial> ELECTRONICA;
    private HashMap<String, Historial> MATERIALES;

    public HashMap<String, Historial> getListaSistemas() {
        return SISTEMAS;
    }

    public HashMap<String, Historial> getListaMateriales() {
        return MATERIALES;
    }

    public HashMap<String, Historial> getListaElectronica() {
        return ELECTRONICA;
    }

}
