package usuarios;

import usuarios.helpers.Rol;
import java.time.LocalDate;
import java.util.*;

import biblioteca.Biblioteca;
import biblioteca.utils.DatosComun;
import utils.JsonClass;

public class Trabajador extends Usuario{
    private double salario;
    private String departamento;
    private int edad;
    private LocalDate fechaRegistro;
    public Trabajador(String nombre, String apellido, int edad, String departamento, String numeroTelefono, String nombreUsuario, String contrasena) {
        super(nombre, apellido, Rol.TRABAJADOR, numeroTelefono, nombreUsuario, contrasena);
        this.edad=edad;
        this.salario=salario;
        this.departamento=departamento;
        this.fechaRegistro = LocalDate.now();
    }
    Random rd=new Random();
    public double getSalario() {
        return salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getEdad() {
        return edad;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    @Override
    public String toString(){
        return String.format("%s \nEdad: %d \nsalario: $%.2f \nDepartamento: %s \nFecha de Registro: %s \n\n", super.toString(), getEdad(), getSalario(), getDepartamento().toString(), getFechaRegistro().toString());
    }

    public static void addTrabajadores(){
        ArrayList<String> datos = DatosComun.obtenerDatosComun(Rol.TRABAJADOR);
        Scanner sc = new Scanner(System.in);

        int edad = sc.nextInt();
        String departamente = sc.nextLine();

        String nombre = datos.get(0);
        String apellido = datos.get(1);
        String telefono = datos.get(2);
        String nombreUsuario = datos.get(3);
        String contrasena = datos.get(4);

        Trabajador trabajador = new Trabajador(nombre, apellido, edad, departamente, telefono, nombreUsuario, contrasena);

        if (!Biblioteca.usuarios.containsKey(Rol.TRABAJADOR)){
            Biblioteca.usuarios.put(Rol.TRABAJADOR, new ArrayList<Usuario>());
        }

        Biblioteca.usuarios.get(Rol.TRABAJADOR).add(trabajador);



        System.out.println("\nTrabajador Registrado\n");
    }

    public static void showTrabajadores(){
        if(Biblioteca.usuarios.isEmpty()){
            System.out.println("No hay trabajadores registrados");
        }else{
            for (Usuario usuario : Biblioteca.usuarios.get(Rol.TRABAJADOR)){
                Trabajador trabajador = (Trabajador) usuario;
                System.out.println(trabajador.toString());
            }
        }
    }
    public static Trabajador showInfoTrabajador(){
        Scanner sc = new Scanner(System.in);
        if(Biblioteca.usuarios.get(Rol.TRABAJADOR).isEmpty()){
            System.out.println("No hay trabajadores registrados");
        }else{
            showTrabajadores();
            System.out.println("¿De que trabajador quiere ver su informacion?");
            int i = sc.nextInt();
            if (i<Biblioteca.usuarios.get(Rol.TRABAJADOR).size()) {
                Trabajador trabajador = (Trabajador) Biblioteca.usuarios.get(Rol.TRABAJADOR).get(i-1);
                System.out.println(trabajador.toString());
                return trabajador;
            }else{
                System.out.println("No se selecciono ninguno de los clientes mostrados");
            }
        }
        return null;
    }
    public static void eliminarTrabajador(){
        Scanner sc = new Scanner(System.in);
        if(Biblioteca.usuarios.get(Rol.TRABAJADOR).isEmpty()){
            System.out.println("No hay clientes registrados");
        }else{
            showTrabajadores();
            System.out.println("¿Cuál trabajador quiere eliminar?");
            int i = sc.nextInt();
            if (i<=Biblioteca.usuarios.get(Rol.TRABAJADOR).size()) {
                ArrayList<Usuario> trabajadores = Biblioteca.usuarios.get(Rol.TRABAJADOR);
                trabajadores.remove(i-1);
                Biblioteca.usuarios.replace(Rol.TRABAJADOR, trabajadores);
                System.out.println("Trabajador eliminado exitosamente.");
            }else{
                System.out.println("No se selecciono ninguno de los trabajadores mostrados");
            }
        }
    }
    public static void modifyInfo(){
        Trabajador trabajador = showInfoTrabajador();

        Scanner sc = new Scanner(System.in);
        int index = 0;

        while (true) {
            if(trabajador == null) {System.out.println("ERROR, vuelva a intentarlo");break;}
            for (Usuario usuario : Biblioteca.usuarios.get(Rol.TRABAJADOR)) {
                if (usuario.equals(trabajador)) {
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
                    trabajador.setNombre(newName);
                    System.out.println("Nombre actualizado");
                    break;
                case 2:
                    System.out.println("Nuevo apellido");
                    String newLastName = sc.next();
                    trabajador.setApellido(newLastName);
                    System.out.println("Apellido actualizado");
                    break;
                case 3:
                    System.out.println("Nuevo numero de telefono:");
                    String newtelefono = sc.next();
                    trabajador.setNumeroTelefono(newtelefono);
                    System.out.println("Numero de Telefono actualizado");
                    break;
                case 4:
                    System.out.println("Nuevo nombre de usuario");
                    String newUserName = sc.next();
                    trabajador.setNombreUsuario(newUserName);
                    System.out.println("Nombre de usuario actualizado");
                    break;
                case 5:
                    System.out.println("Contraseña nueva");
                    String newPassword = sc.next();
                    trabajador.setContrasena(newPassword);
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
        Biblioteca.usuarios.get(Rol.TRABAJADOR).set(index, trabajador);

    }
}
