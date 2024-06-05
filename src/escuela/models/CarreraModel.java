package escuela.models;



import escuela.carreras.Carrera;


public class CarreraModel {
    private Carrera SISTEMAS;
    private Carrera ELECTRONICA;
    private Carrera MATERIALES;

    public Carrera getListaSistemas() {
        return SISTEMAS;
    }

    public Carrera getListaMateriales() {
        return MATERIALES;
    }

    public Carrera getListaElectronica() {
        return ELECTRONICA;
    }

}
