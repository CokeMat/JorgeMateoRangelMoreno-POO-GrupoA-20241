package Sistema;


import java.util.*;
public class Sistema {
    private final String CONTRASENA_SEGURA = "%Pr0gr4m4c10n%";
    private Scanner sc = new Scanner(System.in);
    private Tienda tienda = new Tienda();

    public void ejecutarPrograma() {
        boolean esContrasenaValida = false;
        do {
            System.out.println("\n*** BIENVENIDO ***");
            System.out.println("Contraseña: %Pr0gr4m4c10n%");
            System.out.println("Ingresa la contraseña: ");
            String contrasena = sc.nextLine();

            if (contrasena.equals(CONTRASENA_SEGURA)) {
                esContrasenaValida = true;
                ejecutarMenuSistema();
            } else {
                System.out.println("\nCONTRASEÑA INCORRECTA");
            }
        } while (!esContrasenaValida);
    }

    private void ejecutarMenuSistema() {
        int opcion = 0;

        do {
            System.out.println("\n--------T  I  E  N  D  A----------");
            System.out.println("BIENVENIDO A LA TIENDA");
            System.out.println("Seleccione una opción:\n");
            System.out.println("1. Productos");
            System.out.println("2. Clientes");
            System.out.println("3. Compras");
            System.out.println("4. Salir");
            System.out.println("\nOpcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    while (true) {
                        System.out.println("\nSelecciono la opción Producto");
                        System.out.println("---------P  R  O  D  U  C  T  O  S----------");
                        System.out.println("1. Registrar producto");
                        System.out.println("2. Eliminar producto");
                        System.out.println("3. Ver Productos");
                        System.out.println("4. Consultar informacion de un producto");
                        System.out.println("5. Volver al menu principal");
                        System.out.println("\nOpción:");
                        int opcionProcucto = sc.nextInt();
                        if (opcionProcucto == 5) {
                            break;
                        }

                        switch (opcionProcucto) {
                            case 1:
                                tienda.registrarProducto();
                                break;
                            case 2:
                                tienda.eliminarProducto();
                                break;
                            case 3:
                                tienda.mostrarProductos();
                                break;
                            case 4:
                                tienda.mostrarInfoProducto();
                                break;
                            default:
                                System.out.println("Opcion invalida");
                        }
                    }
                    break;
                case 2:
                    while (true){
                        System.out.println("\nSelecciono la opción Clientes");
                        System.out.println("---------C  L  I  E  N  T  E  S----------");
                        System.out.println("1. Registrar cliente");
                        System.out.println("2. Eliminar cliente");
                        System.out.println("3. Ver clientes");
                        System.out.println("4. Consultar informacion de un cliente");
                        System.out.println("5. Volver al menu principal");
                        System.out.println("\nOpción: ");
                        int opcionCliente = sc.nextInt();
                        if(opcionCliente==5){
                            System.out.println("Volviendo al menu principal...");
                            break;
                        }

                        switch (opcionCliente) {
                            case 1:
                                tienda.registrarCliente();
                                break;
                            case 2:
                                tienda.eliminarCliente();
                                break;
                            case 3:
                                tienda.mostrarClientes();
                                break;
                            case 4:
                                tienda.mostrarInfoCliente();
                                break;
                            default:
                                System.out.println("Opcion invalida");
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        System.out.println("\nSelecciono la opción Compras");
                        System.out.println("---------C  O  M  P  R  A  S----------");
                        System.out.println("1. Realizar un pedido");
                        System.out.println("2. Ver compras totales");
                        System.out.println("3. Ver compras de un cliente");
                        System.out.println("4. Ver compras totales de productos");
                        System.out.println("5. Volver al menu principal");
                        System.out.println("\nOpción: ");
                        int opcionCompras = sc.nextInt();
                        if (opcionCompras == 5) {
                            System.out.println("Volviendo al menu principal...");
                            break;
                        }

                        switch (opcionCompras) {
                            case 1:
                                tienda.realizarPedido();
                                break;
                            case 2:
                                tienda.verPedidos();
                                break;
                            case 3:
                                tienda.verPedidoCliente();
                                break;
                            case 4:
                                tienda.ventasProducto();
                                break;
                            default:
                                System.out.println("Opcion invalida");
                        }
                    }
                    break;
                case 4:
                    System.out.println("¡Vuelva pronto!");
                    break;
                default:
                    System.out.println("Opcion invalida, seleccione otra.");
            }
        } while(opcion != 4);
    }
}