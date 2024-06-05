package escuela.models;

import usuarios.Trabajadores.Coordinador;

public class CoordinadorModel {
    private Coordinador SISTEMAS;
    private Coordinador ELECTRONICA;
    private Coordinador MATERIALES;

    public Coordinador getCoordinadorSistemas() {
        return SISTEMAS;
    }

    public Coordinador getCoordinadorMateriales() {
        return MATERIALES;
    }

    public Coordinador getCoordinadorElectronica() {
        return ELECTRONICA;
    }
    
}
