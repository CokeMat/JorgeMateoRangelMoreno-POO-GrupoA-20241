import biblioteca.Biblioteca;
import biblioteca.Menu;
public class Main {
    public static void main(String[] args) {
        biblioteca.Menu menu = new Menu();
        Biblioteca.inicializarPrograma();
        menu.inicioSesion();

    }
}