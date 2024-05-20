package utils;

import libros.*;

import java.util.ArrayList;

public class LibroModel {
    private ArrayList<LibroAccion> accion;
    private ArrayList<LibroComedia> comedia;
    private ArrayList<LibroTerror> terror;

    public ArrayList<LibroAccion> getAccion() {
        return accion;
    }

    public ArrayList<LibroComedia> getComedia() {
        return comedia;
    }

    public ArrayList<LibroTerror> getTerror() {
        return terror;
    }
}
