package usuarios;
import usuarios.helpers.Rol;
import java.time.LocalDate;
import java.util.*;

import biblioteca.Biblioteca;
import biblioteca.utils.DatosComun;
import utils.Fecha;
import utils.JsonClass;

public class Gerente extends Usuario{
    private String cargo;
    private String horario;
    private String genero;
    private String fechaRegistro;

    public Gerente(String nombre, String apellido, String cargo, String horario, String genero, String numeroTelefono, String nombreUsuario, String contrasena, String fechaRegistro) {
        super(nombre, apellido, Rol.GERENTE.toString(), numeroTelefono, nombreUsuario, contrasena);
        this.cargo = cargo;
        this.horario = horario;
        this.genero = genero;
        this.fechaRegistro = fechaRegistro;
        setROL(Rol.GERENTE);
    }

    public String getCargo() {
        return cargo;
    }

    public String getHorario() {
        return horario;
    }

    public String getGenero() {
        return genero;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    @Override
    public String toString(){
        return String.format("%s \nCargo: %s \nHorario: %s \nGenero: %s \nFecha de Registro: %s \n\n", super.toString(), getCargo(), getHorario().toString(), getGenero().toString(), getFechaRegistro().toString());
    }


    public static void addGerente(){
        ArrayList<String> datos = DatosComun.obtenerDatosComun(Rol.GERENTE);
        Scanner sc = new Scanner(System.in);

        String horario = sc.next();
        String cargo = sc.next();
        String genero = sc.nextLine();

        String nombre = datos.get(0);
        String apellido = datos.get(1);
        String telefono = datos.get(2);
        String nombreUsuario = datos.get(3);
        String contrasena = datos.get(4);

        String fechaRegistro = Fecha.askForDate("registro");

        Gerente gerente = new Gerente(nombre, apellido, cargo, horario, genero, telefono, nombreUsuario, contrasena, fechaRegistro);

        if (!Biblioteca.usuarios.containsKey(Rol.GERENTE.toString())){
            Biblioteca.usuarios.put(Rol.GERENTE.toString(), new ArrayList<Usuario>());
        }

        Biblioteca.usuarios.get(Rol.GERENTE.toString()).add(gerente);
        JsonClass.addUsuarioJson();

        System.out.println("\nTrabajador Registrado\n");
    }

    public static void showGerentes(){
        if(Biblioteca.usuarios.isEmpty()){
            System.out.println("No hay gerentes registrados");
        }else{
            for (Usuario usuario : Biblioteca.usuarios.get(Rol.GERENTE.toString())){
                Gerente gerente = (Gerente) usuario;
                System.out.println(gerente.toString());
            }
        }
    }
    public static Gerente showInfoGerente(){
        Scanner sc = new Scanner(System.in);
        if(Biblioteca.usuarios.get(Rol.GERENTE.toString()).isEmpty()){
            System.out.println("No hay gerentes registrados");
        }else{
            showGerentes();
            System.out.println("¿De que gerente quiere ver su informacion?");
            int i = sc.nextInt();
            if (i<Biblioteca.usuarios.get(Rol.GERENTE.toString()).size()) {
                Gerente gerente = (Gerente) Biblioteca.usuarios.get(Rol.GERENTE.toString()).get(i-1);
                System.out.println(gerente.toString());
                return gerente;
            }else{
                System.out.println("No se selecciono ninguno de los gerentes mostrados");
                return null;
            }
        }
        return null;
    }
    public static void eliminarGerente(){
        Scanner sc = new Scanner(System.in);
        if(Biblioteca.usuarios.get(Rol.GERENTE.toString()).isEmpty()){
            System.out.println("No hay gerente registrados");
        }else{
            showGerentes();
            System.out.println("¿Cuál gerente quiere eliminar?");
            int i = sc.nextInt();
            if (i<=Biblioteca.usuarios.get(Rol.GERENTE.toString()).size()) {
                ArrayList<Usuario> gerentes = Biblioteca.usuarios.get(Rol.GERENTE.toString());
                gerentes.remove(i-1);
                Biblioteca.usuarios.replace(Rol.GERENTE.toString(), gerentes);
                System.out.println("Gerente eliminado exitosamente.");
            }else{
                System.out.println("No se selecciono ninguno de los gerentes mostrados");
            }
        }
    }
    public static void modifyInfo(){
        Gerente gerente = showInfoGerente();

        Scanner sc = new Scanner(System.in);
        int index = 0;
        while (true) {
            if(gerente == null) {System.out.println("ERROR, vuelva a intentarlo");break;}
            for (Usuario usuario : Biblioteca.usuarios.get(Rol.GERENTE.toString())) {
                if (usuario.equals(gerente)) {
                    break;
                }
                index ++;
            }
            System.out.println("¿Que quiere modificar?");
            System.out.println("1.Nombre \n2.Apellido \n3. Telefono  \n4. Nombre de Usuario \n5. Contraseña \n6. Volver a menu Cliente");
            System.out.println("Opcion");
            int opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Nuevo nombre");
                    String newName = sc.next();
                    gerente.setNombre(newName);
                    System.out.println("Nombre actualizado");
                    break;
                case 2:
                    System.out.println("Nuevo apellido");
                    String newLastName = sc.next();
                    gerente.setApellido(newLastName);
                    System.out.println("Apellido actualizado");
                    break;
                case 3:
                    System.out.println("Nuevo numero de telefono:");
                    String newtelefono = sc.next();
                    gerente.setNumeroTelefono(newtelefono);
                    System.out.println("Numero de Telefono actualizado");
                    break;
                case 4:
                    System.out.println("Nuevo nombre de usuario");
                    String newUserName = sc.next();
                    gerente.setNombreUsuario(newUserName);
                    System.out.println("Nombre de usuario actualizado");
                    break;
                case 5:
                    System.out.println("Contraseña nueva");
                    String newPassword = sc.next();
                    gerente.setContrasena(newPassword);
                    System.out.println("Contraseña actualizada");
                    break;
                case 6 :
                    System.out.println("Volviendo al menu Cliente...");
                    break;
                default:
                    System.out.println("Opcion invalida, vuelva a elegir.");
            }
            if(opcion == 6) break;
        }
        Biblioteca.usuarios.get(Rol.GERENTE.toString()).set(index, gerente);

    }
}
