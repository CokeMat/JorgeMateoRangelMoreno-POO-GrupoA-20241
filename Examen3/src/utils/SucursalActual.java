package src.utils;

import src.fintech.utils.Sucursal;

public class SucursalActual {
    private static SucursalActual instancia;
    private Sucursal sucursalActual;

    private SucursalActual() {
    }

    public static SucursalActual getInstancia() {
        if (instancia == null) {
            instancia = new SucursalActual();
        }
        return instancia;
    }

    public Sucursal getSucursalActual() {
        return sucursalActual;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursalActual = sucursal;
    }

    public boolean hayUsuarioActual() {
        return sucursalActual != null;
    }

    public void cerrarSucursal() {
        instancia = null;
        sucursalActual = null;
    }
}
