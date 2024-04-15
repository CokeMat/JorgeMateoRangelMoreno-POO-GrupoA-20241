package Sistema;

import Productos.*;
import Cliente.Cliente;
import Productos.helpers.tipoProducto;

import java.time.LocalDate;
import java.util.*;
public class Tienda {
    private ArrayList<Cliente> clientes=new ArrayList<>();
    private ArrayList<Producto> productos=new ArrayList<>();
    private int totalProductos=0;
    private int stockIncial=0;
    Scanner sc = new Scanner(System.in);
    public int getStockIncial() {
        return stockIncial;
    }
    public void setStockIncial(int stockIncial) {
        this.stockIncial = stockIncial;
    }
    public int getTotal() {
        return totalProductos;
    }
    public void setTotal(int total) {
        this.totalProductos = total;
    }
    public void registrarProducto(){
        ArrayList<String> datosComun = new ArrayList<String>();
            System.out.println("¿Que producto desea registrar?");
            System.out.println("1. Limpieza \n2. Belleza \n3. Alimento \n4. Electrodomestico \n");
            System.out.println("Opcion: ");
            int opProducto = sc.nextInt();
            if(opProducto<5) {
                System.out.println("**** N U E V O   P R O D U C T O ****");
                System.out.println("Ingresa el nombre: ");
                String nombre = sc.next();
                datosComun.add(nombre);

                System.out.println("Ingresa el precio: ");
                double precio = sc.nextDouble();
                datosComun.add(String.valueOf(precio));

                System.out.println("Ingresa la fecha de importación: ");
                String fechaImportacion = sc.next();
                sc.nextLine();
                datosComun.add(fechaImportacion);

                System.out.println("Ingresa el stock: ");
                int stock = sc.nextInt();
                setStockIncial(stock);
                setTotal(stock+getTotal());
                datosComun.add(String.valueOf(stock));
            }
            switch (opProducto) {
                case 1:
                    registrarProductoLimpieza(datosComun);
                    break;
                case 2:
                    registrarProductoBelleza(datosComun);
                    break;
                case 3:
                    registrarProductoAlimento(datosComun);
                    break;
                case 4:
                    registrarProductoElec(datosComun);
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;
            }
    }
    public void eliminarProducto(){
        System.out.println("**** E L I M I N A R   P R O D U C T O ****");
        if(productos.isEmpty()){
            System.out.println("No hay productos para eliminar de la lista");
        }else {
            mostrarProductos();
            System.out.println("Ingrese el numero de serie del producto:");
            String enterNumSerie = sc.next();
            sc.nextLine();
            for(Producto producto : productos){
                if(producto.getNumSerie().equals(enterNumSerie)) {
                    if (producto.isComprado()==false) {
                        productos.remove(producto);
                        System.out.println("El producto ha sido removido exitosamente");
                    }else{
                        System.out.println("No se puede eliminar a este producto debido a que ya ha sido registrado en una compra, elija otro");
                    }
                }else{
                    System.out.println("No se ha encontrado un producto con el Numero de serie introducido.");
                }
            }
        }
    }
    public void mostrarInfoProducto(){
        System.out.println("**** I N F O   P R O D U C T O ****");
        if(productos.isEmpty()){
            System.out.println("No hay productos registrados en la lista");
        } else {
            mostrarProductos();
            System.out.println("\nIngrese el número de serie del producto:");
            String enterNumSerie = sc.next();

            boolean encontrado = false;
            for(Producto producto : productos){
                if(producto.getNumSerie().equals(enterNumSerie)) {
                    producto.getDatos();
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("No se ha encontrado un producto con el número de serie introducido.");
            }
        }
    }

    public void mostrarProductos() {
        System.out.println("**** L I S T A   P R O D U C T O S ****");
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados");
        } else {
            mostrarLimpieza();
            mostrarAlimento();
            mostrarBelleza();
            mostrarElec();
            System.out.println("\nTotal productos registrados: "+productos.size());
            System.out.println("Total de productos: "+getTotal());
        }
    }
    private void mostrarLimpieza(){
        int i= 0;
        System.out.println("\n** Limpieza **");
        for (Producto producto : productos) {
            if(producto.getTipoProducto().equals(tipoProducto.LIMPIEZA)){
                i++;
                System.out.printf("%d. Nombre: %s \n    Numero de Serie: %s\n    Precio: $%.2f\n   Stock: %d\n", i, producto.getNombre(), producto.getNumSerie(), producto.getPrecio(), producto.getStock());
            }
        }
    }
    private void mostrarBelleza(){
        int i= 0;
        System.out.println("\n** Belleza **");
        for (Producto producto : productos) {
            if(producto.getTipoProducto().equals(tipoProducto.BELLEZA)){
                i++;
                System.out.printf("%d. Nombre: %s \n    Numero de Serie: %s\n    Precio: $%.2f\n   Stock: %d\n", i, producto.getNombre(), producto.getNumSerie(), producto.getPrecio(), producto.getStock());
            }
        }
    }
    private void mostrarAlimento(){
        int i= 0;
        System.out.println("\n** Alimento **");
        for (Producto producto : productos) {
            if(producto.getTipoProducto().equals(tipoProducto.ALIMENTO)){
                i++;
                System.out.printf("%d. Nombre: %s \n    Numero de Serie: %s\n    Precio: $%.2f\n   Stock: %d\n", i, producto.getNombre(), producto.getNumSerie(), producto.getPrecio(), producto.getStock());
            }
        }
    }
    private void mostrarElec(){
        int i= 0;
        System.out.println("\n** Electrodomesticos **");
        for (Producto producto : productos) {
            if(producto.getTipoProducto().equals(tipoProducto.ELECTRODOMESTICOS)){
                i++;
                System.out.printf("%d. Nombre: %s \n    Numero de Serie: %s\n    Precio: $%.2f\n   Stock: %d\n", i, producto.getNombre(), producto.getNumSerie(), producto.getPrecio(), producto.getStock());
            }
        }
    }

    private void registrarProductoLimpieza(ArrayList<String> datosComun) {
        System.out.println("\n** Limpieza **");

        String nombre = datosComun.get(0);
        double precio = Double.parseDouble(datosComun.get(1));
        String fechaImportacion = datosComun.get(2);
        int stock = Integer.parseInt(datosComun.get(3));

        System.out.println("Ingresa la marca: ");
        String marca = sc.nextLine();
        String numSerie="";
        Limpieza limpieza = new Limpieza(nombre, precio, stock, fechaImportacion, numSerie, marca);
        productos.add(limpieza);

        System.out.println("\nProducto Registrado");
    }
    private void registrarProductoBelleza(ArrayList<String> datosComun) {
        System.out.println("\n** Belleza **");

        String nombre = datosComun.get(0);
        double precio = Double.parseDouble(datosComun.get(1));
        String fechaImportacion = datosComun.get(2);
        int stock = Integer.parseInt(datosComun.get(3));

        System.out.println("Ingresa la marca: ");
        String marca = sc.next();
        String numSerie="";
        Belleza belleza = new Belleza(nombre, precio, stock, fechaImportacion, numSerie, marca);
        productos.add(belleza);

        System.out.println("\nProducto Registrado");
    }
    private void registrarProductoAlimento(ArrayList<String> datosComun) {
        System.out.println("\n** Alimento **");

        String nombre = datosComun.get(0);
        double precio = Double.parseDouble(datosComun.get(1));
        String fechaImportacion = datosComun.get(2);
        int stock = Integer.parseInt(datosComun.get(3));
        String numSerie="";

        LocalDate fechaCaducidad=null;
        setFechaCaducidad(fechaCaducidad);

        Alimento alimento = new Alimento(nombre, precio, stock, fechaImportacion, numSerie, fechaCaducidad);
        productos.add(alimento);

        System.out.println("\nProducto Registrado");
    }
    private LocalDate setFechaCaducidad(LocalDate fechaCaducidad){
        System.out.println("Ingresa la fecha de caducidad: ");
        System.out.println("Año: ");
        int a = sc.nextInt();
        System.out.println("Mes: ");
        int m = sc.nextInt();
        System.out.println("Día: ");
        int d = sc.nextInt();
        fechaCaducidad = LocalDate.of(a, m, d);
        return fechaCaducidad;
    }

    private void registrarProductoElec(ArrayList<String> datosComun) {
        System.out.println("\n** Electrodomesticos **");

        String nombre = datosComun.get(0);
        double precio = Double.parseDouble(datosComun.get(1));
        String fechaImportacion = datosComun.get(2);
        int stock = Integer.parseInt(datosComun.get(3));
        String numSerie="";

        System.out.println("Ingresa la marca: ");
        String marca = sc.next();

        Electrodomesticos electrodomesticos = new Electrodomesticos(nombre, precio, stock, fechaImportacion, numSerie, marca);
        productos.add(electrodomesticos);

        System.out.println("\nProducto Registrado");
    }

    public void registrarCliente(){
        System.out.println("**** N U E V O   C L I E N T E ****");
        System.out.println("Nombre: ");
        String nombre= sc.next();
        sc.nextLine();
        System.out.println("Edad: ");
        int edad = sc.nextInt();
        Cliente cliente = new Cliente(nombre, edad);
        clientes.add(cliente);
        System.out.println("\nSe registro con exito al cliente");
    }
    public void eliminarCliente(){
        System.out.println("**** E L I M I N A R   C L I E N T E ****");
        if(clientes.isEmpty()){
            System.out.println("No hay clientes para eliminar de la lista");
        }else {
            System.out.println("¿Qué cliente desea eliminar?");
            for(Cliente cliente: clientes){
                mostrarClientes();
            }
            int opEliminar = sc.nextInt();
            if(clientes.get(opEliminar).isCompraHecha()==true){
                System.out.println("No se puede eliminar a este cliente debido a que ya ha realizado una compra, elija otro");
            }else {
                clientes.remove(opEliminar);
                System.out.println("El cliente ha sido removido exitosamente.");
            }
        }
    }
    public void mostrarClientes() {
        System.out.println("**** L I S T A   C L I E N T E S ****");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados");
        } else {
            int i=0;
            for (Cliente cliente : clientes) {
                i++;
                System.out.printf("%d. Nombre: %s\n    ID: %s\n",i, cliente.getNombre(), cliente.getId());
            }
        }
    }
    public void mostrarInfoCliente(){
        System.out.println("**** I N F O   C L I E N T E S ****");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados");
        }else {
            mostrarClientes();
            System.out.println("¿De cual cliente quiere ver su informacion?");
            int opCliente = sc.nextInt();
            clientes.get(opCliente-1).getDatos();
        }
    }
    public void realizarPedido(){
        System.out.println("**** R E G I S T R O    P E D I D O S ****");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados");
        }else if (productos.isEmpty()){
            System.out.println("No hay productos registrados");
        }else{
            mostrarClientes();
            System.out.println("¿Qué cliente desea realizar un pedido?");
            int opCliente = sc.nextInt();
            double total=0;
            int numProductos=0;
            while (true) {
                mostrarProductos();
                System.out.println("Ingrese el ID del producto que desea agregar: ");
                String idProducto = sc.next();
                if (idProducto.equals(String.valueOf(0))){
                    break;
                }
                for(Producto producto : productos) {
                    if (producto.getNumSerie().equals(idProducto)) {
                        if(producto.getStock()==0){
                            System.out.println("Ya no quedan productos de "+producto.getNombre()+", elija otro.");
                        }else{
                            System.out.println("¿Cuantos "+producto.getNombre()+" desea?");
                            int productoSolicitado = sc.nextInt();
                            total= total+producto.getPrecio();
                            numProductos=numProductos+productoSolicitado;
                            clientes.get(opCliente-1).pedido(producto);
                            producto.setStock(producto.getStock()-productoSolicitado);
                            setTotal(getTotal()-productoSolicitado);
                            clientes.get(opCliente-1).setCompraHecha(true);
                            producto.setComprado(true);}
                    } else {
                        System.out.println("No se ha encontrado un producto con el Numero de serie introducido.");
                    }
                }
                System.out.println("Cuando ya haya terminado de agregar productos ingrese 0.");
            }
        }
    }
    public void verPedidos(){
        System.out.println("**** P E D I D O S   T O T A L E S ****");
        if (clientes.isEmpty()) {
            System.out.println("No hay pedidos registrados");
        }else{
            int i=0;
            for(Cliente cliente : clientes){
                if(cliente.isCompraHecha()==true){
                    i++;
                    System.out.printf("\n%d. \n%s \n%s\n\n", i, cliente.getNombre(), cliente.getNumeroPedido());
                }
            }
            System.out.println("Total de pedidos: "+i);
        }
    }
    public void verPedidoCliente(){
        System.out.println("**** V E R    P E D I D O S    C L I E N T E ****");
        if (clientes.isEmpty()) {
            System.out.println("No hay pedidos registrados");
        }else{
            mostrarClientes();
            System.out.println("¿De que cliente quiere ver su pedido?");
            int i= sc.nextInt();
                if(clientes.get(i-1).isCompraHecha()==true){
                    System.out.println();
                    System.out.printf("\n%d. \nNombre: %s \nNumero de Pedido: %s  \nPedido: %\n", i, clientes.get(i-1).getNombre(), clientes.get(i-1).getNumeroPedido(), clientes.get(i-1).getProductosComprados(i-1));
                }else{
                    System.out.println("Este cliente no ha realizado ninguna compra.");
                }

        }
    }
    public void ventasProducto(){
        System.out.println("**** V E N T A S    P R O D U C T O ****");
        int i=0, totalProductos = 0;
        double cantTotalTienda = 0;
        for(Producto producto : productos) {
            i++;
            int numProductosVendidos=getStockIncial()-producto.getStock();
            double cantTotalProducto = numProductosVendidos*producto.getPrecio();
            totalProductos=totalProductos+numProductosVendidos;
            cantTotalTienda=cantTotalProducto+cantTotalTienda;
            System.out.printf("\n%d. Producto: %s \n   Vendidos: %d \n   Total Vendido: $%f\n", i, producto.getNombre(), numProductosVendidos, cantTotalProducto);
        }
        System.out.println("Total de productos vendidos de la tienda: "+totalProductos);
        System.out.println("Total de dinero: "+cantTotalTienda);
    }

}