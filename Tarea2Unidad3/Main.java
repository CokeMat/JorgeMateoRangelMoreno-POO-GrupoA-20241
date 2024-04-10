import usuarios.*;

public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Jorge", "Rangel");
        System.out.println(cliente.toString());

        Trabajador trabajador = new Trabajador("Mateo", "Moreno", 26, "Recursos Humanos");
        System.out.println(trabajador.toString());

        Gerente gerente = new Gerente("Marián", "Vieyra", "Ventas", "9am - 16pm", "Mujer");
        System.out.println(gerente.toString());
    }
}
