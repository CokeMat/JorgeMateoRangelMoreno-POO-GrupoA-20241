package utils;

public class CarreraActual {
    private static CarreraActual instancia;
    private String carreraActual;

    private CarreraActual() {
    }

    public static CarreraActual getInstancia() {
        if (instancia == null) {
            instancia = new CarreraActual();
        }
        return instancia;
    }

    public String getCarreraActual() {
        return carreraActual;
    }

    public void setCarreraActual(String carreraActual) {
        this.carreraActual = carreraActual;
    }

    public boolean hayUsuarioActual() {
        return carreraActual != null;
    }

    public void cerrarCarreraActual() {
        instancia = null;
        carreraActual = null;
    }

}
