package src.fintech;

import java.util.*;

import src.usuarios.utils.Estado;
import src.usuarios.utils.Genero;
import src.usuarios.utils.Rol;
import src.utils.Fecha;
import src.utils.Id;
import src.utils.SucursalActual;
import src.usuarios.Usuario;
import src.usuarios.empleados.Gerente;
import src.fintech.movimientos.MovimientoBancario;
import src.fintech.solicitudes.Solicitud;
import src.fintech.utils.Sucursal;

public class Fintech {
    private static double saldoBanco;
    Gerente gerente;
    private HashMap<Rol, ArrayList<Usuario>> listaUsuarios = new HashMap<>();
    private ArrayList<MovimientoBancario> listaMovimientos = new ArrayList<>();
    private ArrayList<Solicitud> listaSolicitudes = new ArrayList<>();

    public Fintech(Sucursal sucursal) {
        listaUsuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        listaUsuarios.put(Rol.EJECUTIVO, new ArrayList<Usuario>());
        listaUsuarios.put(Rol.CAPTURISTA, new ArrayList<Usuario>());
        listaUsuarios.put(Rol.INVERSIONISTA, new ArrayList<Usuario>());
        switch (sucursal) {

            case MADERO -> this.gerente = new Gerente("Gabriel", "Arellano", "Chacón", Fecha.askForDate(2005, 5, 11),
                    Genero.MASCULINO, Estado.Michoacan, "El hospital", "Morelia", "gabo123", "contra123", Rol.GERENTE,
                    "123456", Id.generate("G"), 25000, "07:00-19:00", "12/06/2018");
            case ACUEDUCTO -> this.gerente = new Gerente("Jorge", "Moreno", "Rangel", Fecha.askForDate(2004, 9, 8),
                    Genero.MASCULINO, Estado.Michoacan, "El hospital", "Morelia", "jorge123", "contra123", Rol.GERENTE,
                    "123456", Id.generate("G"), 25000, "07:00-19:00", "12/06/2018");
        }
    }

    public Usuario verificarInicioSesion(String nombreUsuario, String contrasena) {
        if (nombreUsuario.equals(gerente.getNombreUsuario()) && contrasena.equals(gerente.getContrasena())) {
            return gerente;
        }
        for (ArrayList<Usuario> lista : listaUsuarios.values()) {
            for (Usuario usuario : lista) {
                if (nombreUsuario.equals(usuario.getNombreUsuario())) {
                    if (contrasena.equals(usuario.getContrasena())) {
                        return usuario;
                    }
                }
            }
        }
        return null;
    }

    public static void mostrarInfoBanco(){
        System.out.printf("\n------------------------INFORMACIÓN DE LA SUCURSAL %s------------------------------", SucursalActual.getInstancia().getSucursalActual().toString());
        ArrayList<Integer> datos = calcularNumeroUsuarios();
        System.out.printf("\n | SALDO ACTUAL DEL BANCO: $%.2f | ", Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getSaldoBanco());
        System.out.printf("\n | NÚMERO TOTAL DE MOVIMIENTOS BANCARIOS: %d | NÚMERO TOTAL DE SOLICITUDES: %d | ", Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaMovimientoBancarios().size(), Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaSolicitudes().size());
        System.out.println("\n--------------NÚMERO TOTAL DE USUARIOS EN EL SISTEMA------------------");
        System.out.printf("\n | CLIENTES: %d | \n |  EJECUTIVOS DE CUENTA : %d | | \n CAPTURISTAS: %d | \n | INVERSIONISTAS: %d |   ", datos.get(0), datos.get(1), datos.get(2), datos.get(3));
        System.out.printf("\n | NÚMERO TOTAL DE USUARIOS: %d |", datos.get(4));

        System.out.println("\n------------------INFORMACIÓN DEL GERENTE A CARGO DEL BANCO------------------");
        System.out.println(Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getGerente());

    }

    private static ArrayList<Integer> calcularNumeroUsuarios(){
        ArrayList<Integer> datos = new ArrayList<>();
        HashMap<Rol, ArrayList<Usuario>> mapa = Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios();
        datos.add(mapa.get(Rol.CLIENTE).size());
        datos.add(mapa.get(Rol.EJECUTIVO).size());
        datos.add(mapa.get(Rol.CAPTURISTA).size());
        datos.add(mapa.get(Rol.INVERSIONISTA).size());
        datos.add(datos.get(0) + datos.get(1) + datos.get(2) + datos.get(3));
        return datos;
    }

    public HashMap<Rol, ArrayList<Usuario>> getListaUsuarios() {
        return listaUsuarios;
    }

    public ArrayList<MovimientoBancario> getListaMovimientoBancarios() {
        return listaMovimientos;
    }

    public ArrayList<Solicitud> getListaSolicitudes() {
        return listaSolicitudes;
    }

    public Gerente getGerente() {
        return this.gerente;
    }

    public double getSaldoBanco(){
        return saldoBanco;
    }

    public void aumentarSaldo(double cantidad){
        saldoBanco += cantidad;
    }

    public void disminuirSaldo(double cantidad){
        saldoBanco -= cantidad;
    }

}