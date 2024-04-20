package biblioteca;

import java.time.LocalDate;
import java.util.*;

import usuarios.*;
import usuarios.helpers.Rol;

public class biblioteca {
    static HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>();

    Scanner sc = new Scanner(System.in);

    public static Usuario verificarInicioSesion(String usuario, String contrasena) {
        Rol rol = null;
        switch (rol) {
            case CLIENTE -> {
                for (Usuario usuarioActual : usuarios.get(rol)) {
                    if (usuarioActual.getNombreUsuario().equals(usuario)) {
                        if (usuarioActual.getContrasena().equals(contrasena)) {
                            return usuarioActual;
                        }return null;
                    }
                }
            }
            case TRABAJADOR -> {
                for (Usuario usuarioActual : usuarios.get(rol)) {
                    if (usuarioActual.getNombreUsuario().equals(usuario)) {
                        if (usuarioActual.getContrasena().equals(contrasena)) {
                            return usuarioActual;
                        } return null;
                    }
                }
            }
            case GERENTE -> {
                for (Usuario usuarioActual : usuarios.get(rol)) {
                    if (usuarioActual.getNombreUsuario().equals(usuario)) {
                        if (usuarioActual.getContrasena().equals(contrasena)) {
                            return usuarioActual;
                        } return null;
                    }
                }
            }
        }
        return null;
    }

    private ArrayList<String> obtenerDatosComun(Rol rol) {
        ArrayList<String> datosComun = new ArrayList<String>();

        String rolActual = rol == Rol.CLIENTE ? "C L I E N T E" : rol == Rol.TRABAJADOR ? "T R A B A J A D O R" : "G E R E N T E";
        System.out.println(String.format("\n A Ñ A D I R     %s ", rolActual));

        System.out.println("Ingresa el nombre");
        String nombre = sc.nextLine();
        System.out.println("Ingresa el apellido");
        String apellido = sc.nextLine();
        String telefono = obtenerNumeroTelefono();
        String nombreUsuario = obtenerNombreUsuario();
        System.out.println("Ingresa la contrasena");
        String contrasena = sc.nextLine();

        datosComun.addAll(Arrays.asList(nombre, apellido, telefono, nombreUsuario, contrasena));

        return datosComun;
    }
    //CLIENTE
    private void addCliente(){
        ArrayList<String> datos = obtenerDatosComun(Rol.CLIENTE);

        String nombre = datos.get(0);
        String apellido = datos.get(1);
        String telefono = datos.get(2);
        String nombreUsuario = datos.get(3);
        String contrasena = datos.get(4);

        Cliente cliente = new Cliente(nombre, apellido, telefono, nombreUsuario, contrasena);

        if (!usuarios.containsKey(Rol.CLIENTE)) {
            usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        }

        usuarios.get(Rol.CLIENTE).add(cliente);

        System.out.println("\nCliente Registrado\n");
    }
    public void showClientes(){
        System.out.println("**** L I S T A    C L I E N T E S ****");
        if(usuarios.isEmpty()){
            System.out.println("No hay clientes registrados");
        }else{
            for (Usuario usuario : usuarios.get(Rol.CLIENTE)) {
                Cliente cliente = (Cliente) usuario;
                System.out.println(cliente.toString());
            }
        }
    }
    public void showInfoCliente(){
        if(usuarios.isEmpty()){
            System.out.println("No hay clientes registrados");
        }else{
            showClientes();
            System.out.println("¿De que cliente quiere ver su informacion?");
            int i = sc.nextInt();
            if (i<usuarios.size()) {
                usuarios.get(i - 1).toString();
            }else{
                System.out.println("No se selecciono ninguno de los clientes mostrados");
            }
        }
    }
    public void eliminarCliente(){
        if(usuarios.isEmpty()){
            System.out.println("No hay clientes registrados");
        }else{
            showClientes();
            System.out.println("¿Cuál cliente quiere eliminar?");
            int i = sc.nextInt();
            if (i<usuarios.size()) {
                usuarios.remove(i-1);
            }else{
                System.out.println("No se selecciono ninguno de los clientes mostrados");
            }
        }
    }
    public void modifyInfoCliente(){
        if(usuarios.isEmpty()){
            System.out.println("No hay clientes registrados");
        }else{
            showClientes();
            System.out.println("¿Cuál cliente quiere modificar su informacion?");
            int i = sc.nextInt();
            if (i<usuarios.size()) {
                usuarios.get(i-1);
            }else{
                System.out.println("No se selecciono ninguno de los clientes mostrados");
            }
        }
    }

    //Trabajador
    private void addTrajadores(){
        ArrayList<String> datos = obtenerDatosComun(Rol.TRABAJADOR);

        int edad = sc.nextInt();
        String departamente = sc.nextLine();

        String nombre = datos.get(0);
        String apellido = datos.get(1);
        String telefono = datos.get(2);
        String nombreUsuario = datos.get(3);
        String contrasena = datos.get(4);

        Trabajador trabajador = new Trabajador(nombre, apellido, edad, departamente, telefono, nombreUsuario, contrasena);

        if (!usuarios.containsKey(Rol.TRABAJADOR)){
            usuarios.put(Rol.TRABAJADOR, new ArrayList<Usuario>());
        }

        usuarios.get(Rol.TRABAJADOR).add(trabajador);

        System.out.println("\nTrabajador Registrado\n");
    }

    public void showTrabajadores(){
        if(usuarios.isEmpty()){
            System.out.println("No hay trabajadores registrados");
        }else{
            for (Usuario usuario : usuarios.get(Rol.TRABAJADOR)){
                Trabajador trabajador = (Trabajador) usuario;
                System.out.println(trabajador.toString());
            }
        }
    }

    //Gerente
    private void addGerente(){
        ArrayList<String> datos = obtenerDatosComun(Rol.GERENTE);

        String horario = sc.next();
        String cargo = sc.next();
        String genero = sc.nextLine();

        String nombre = datos.get(0);
        String apellido = datos.get(1);
        String telefono = datos.get(2);
        String nombreUsuario = datos.get(3);
        String contrasena = datos.get(4);

        Gerente gerente = new Gerente(nombre, apellido, cargo, horario, genero, telefono, nombreUsuario, contrasena);

        if (!usuarios.containsKey(Rol.TRABAJADOR)){
            usuarios.put(Rol.TRABAJADOR, new ArrayList<Usuario>());
        }

        usuarios.get(Rol.GERENTE).add(gerente);

        System.out.println("\nTrabajador Registrado\n");
    }

    public void showGerentes(){
        if(usuarios.isEmpty()){
            System.out.println("No hay gerentes registrados");
        }else{
            for (Usuario usuario : usuarios.get(Rol.GERENTE)){
                Gerente gerente = (Gerente) usuario;
                System.out.println(gerente.toString());
            }
        }
    }


    //Auxiliares
    private LocalDate fechaNacimiento(){
        System.out.println("Fecha de nacimiento:");
        System.out.println("Día:");
        int d = sc.nextInt();
        System.out.println("Mes;");
        int m = sc.nextInt();
        System.out.println("Año:");
        int a = sc.nextInt();
        LocalDate fechaNacimiento = LocalDate.of(a, m, d);
        return fechaNacimiento;
    }
    private String obtenerNumeroTelefono(){
        boolean numeroExistente = true;
        String telefono;
        do{
            System.out.println("Ingresa el numero de telefono");
            telefono = sc.nextLine();
            numeroExistente=false;

            for(Usuario usuario : usuarios.get(Rol.GERENTE)){
                if(usuario.equals(telefono)){
                    numeroExistente = true;
                }
            }
            for(Usuario usuario : usuarios.get(Rol.TRABAJADOR)) {
                if (usuario.equals(telefono)) {
                    numeroExistente = true;
                }
            }
            for(Usuario usuario : usuarios.get(Rol.CLIENTE)) {
                if (usuario.equals(telefono)) {
                    numeroExistente = true;
                }
            }
        }while(numeroExistente);
        return telefono;
    }

    private String obtenerNombreUsuario(){
        boolean nombreUsuarioExistente = true;
        String nombreUsuario = "";

        do {
            System.out.println("Ingresa el el nombre de usuario");
            nombreUsuario = sc.nextLine();

            nombreUsuarioExistente = false;
            Rol rol = null;
            switch (rol) {
                case CLIENTE -> {
                    for (Usuario usuario : usuarios.get(rol)) {
                        if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                            nombreUsuarioExistente = true;
                        }
                    }
                }
                case TRABAJADOR -> {
                    for (Usuario usuario : usuarios.get(rol)) {
                        if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                            nombreUsuarioExistente = true;
                        }
                    }
                }
                case GERENTE -> {
                    for (Usuario usuario : usuarios.get(rol)) {
                        if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                            nombreUsuarioExistente = true;
                        }
                    }
                }
            }

            if (nombreUsuarioExistente) {
                System.out.println("El nombre de usuario ya existe. Intenta de nuevo\n");
            }
        } while (nombreUsuarioExistente);

        return nombreUsuario;
    }
}
