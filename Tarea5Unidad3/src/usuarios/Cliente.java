package usuarios;
import java.util.*;
import java.time.LocalDate;
import biblioteca.Biblioteca;
import biblioteca.utils.DatosComun;
import usuarios.helpers.Rol;

public class Cliente extends Usuario{

    private LocalDate fechaRegistro;

    public Cliente(String nombre, String apellido,  String numeroTelefono, String nombreUsuario, String contrasena){
        super(nombre, apellido, Rol.CLIENTE, numeroTelefono, nombreUsuario, contrasena);
        this.fechaRegistro = LocalDate.now();
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString(){
        return String.format("%s \nFecha de registro: %s\n\n", super.toString(), fechaRegistro.toString());}

    public static void modifyInfo(){
        Cliente cliente = showInfoCliente();

        Scanner sc = new Scanner(System.in);

        while (true) {
                if(cliente == null) {System.out.println("ERROR, vuelva a intentarlo");break;}
            System.out.println("¿Que quiere modificar?");
            System.out.println("1.Nombre \n2.Apellido \n3. Telefono  \n4. Nombre de Usuario \n5. Contraseña \n6. Volver a menu Cliente");
            System.out.println("Opcion");
            int opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Nuevo nombre");
                    String newName = sc.next();
                    cliente.setNombre(newName);
                    System.out.println("Nombre actualizado");
                    break;
                case 2:
                    System.out.println("Nuevo apellido");
                    String newLastName = sc.next();
                    cliente.setApellido(newLastName);
                    System.out.println("Apellido actualizado");
                    break;
                case 3:
                    System.out.println("Nuevo numero de telefono:");
                    String newtelefono = sc.next();
                    cliente.setNumeroTelefono(newtelefono);
                    System.out.println("Numero de Telefono actualizado");
                     break;
                case 4:
                    System.out.println("Nuevo nombre de usuario");
                    String newUserName = sc.next();
                    cliente.setNombreUsuario(newUserName);
                    System.out.println("Nombre de usuario actualizado");
                    break;
                case 5:
                    System.out.println("Contraseña nueva");
                    String newPassword = sc.next();
                    cliente.setContrasena(newPassword);
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
    }

    public static void addCliente(){
        ArrayList<String> datos = DatosComun.obtenerDatosComun(Rol.CLIENTE);

        String nombre = datos.get(0);
        String apellido = datos.get(1);
        String telefono = datos.get(2);
        String nombreUsuario = datos.get(3);
        String contrasena = datos.get(4);

        Cliente cliente = new Cliente(nombre, apellido, telefono, nombreUsuario, contrasena);

        if (!Biblioteca.usuarios.containsKey(Rol.CLIENTE)) {
            Biblioteca.usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        }

        Biblioteca.usuarios.get(Rol.CLIENTE).add(cliente);

        System.out.println("\nCliente Registrado\n");
    }
    public static void showClientes(){
        System.out.println("**** L I S T A    C L I E N T E S ****");
        if(Biblioteca.usuarios.isEmpty()){
            System.out.println("No hay clientes registrados");
        }else{
            for (Usuario usuario :Biblioteca.usuarios.get(Rol.CLIENTE)) {
                Cliente cliente = (Cliente) usuario;
                System.out.println(cliente.toString());
            }
        }
    }
    public static Cliente showInfoCliente(){
        Scanner sc = new Scanner(System.in);
        if(Biblioteca.usuarios.isEmpty()){
            System.out.println("No hay clientes registrados");
        }else{
            showClientes();
            System.out.println("¿De que cliente quiere ver su informacion?");
            int i = sc.nextInt();
            if (i<Biblioteca.usuarios.get(Rol.CLIENTE).size()) {
                Cliente cliente = (Cliente) Biblioteca.usuarios.get(Rol.CLIENTE).get(i-1);
                System.out.println(cliente.toString());
                return cliente;
            }else{
                System.out.println("No se selecciono ninguno de los clientes mostrados");
                return null;
            }
        }
        return null;
    }
    public static void eliminarCliente(){
        Scanner sc = new Scanner(System.in);
        if(Biblioteca.usuarios.isEmpty()){
            System.out.println("No hay clientes registrados");
        }else{
            showClientes();
            System.out.println("¿Cuál cliente quiere eliminar?");
            int i = sc.nextInt();
            if (i<=Biblioteca.usuarios.size()) {
                ArrayList<Usuario> clientes = Biblioteca.usuarios.get(Rol.CLIENTE);
                clientes.remove(i-1);
                Biblioteca.usuarios.replace(Rol.CLIENTE, clientes);
                System.out.println("Cliente eliminado exitosamente.");
            }else{
                System.out.println("No se selecciono ninguno de los clientes mostrados");
            }
        }
    }
}
