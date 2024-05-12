package src.fintech.solicitudes;

import java.time.LocalDate;
import java.util.ArrayList;

import src.fintech.Sys;
import src.fintech.solicitudes.utils.Estatus;
import src.fintech.utils.DatosComun;
import src.tarjeta.Credito;
import src.tarjeta.utils.TipoTarjeta;
import src.usuarios.Cliente;
import src.usuarios.utils.Rol;
import src.utils.Ask;
import src.utils.Id;
import src.utils.SucursalActual;

public class Solicitud {
    private Cliente cliente;
    private LocalDate fechaSolicitud;
    private TipoTarjeta tipo;
    private double montoTarjetaDebito;
    private Estatus estatus;
    private String IdCliente;
    private String IdSolicitud;

    public Solicitud(Cliente cliente, TipoTarjeta tipo) {
        this.cliente = cliente;
        this.fechaSolicitud = LocalDate.now();
        this.tipo = tipo;
        this.montoTarjetaDebito = cliente.getTarjetaDebito().getSaldo();
        this.estatus = Estatus.PENDIENTE;
        this.IdCliente = cliente.getId();
        this.IdSolicitud = Id.generate("S");
    }


    public static void aceptarSolicitud(String CLAVE) {//AGREGALE AL CLIENTE CUANDO SE LOGEA SI SU ÚLTIMA SOLICITUD FUE APROBADA, RECHAZA O SIGUE PENDIENTE
        int contador = 0;
        if (containsEstatus(Estatus.PENDIENTE)) {
            while (true) {
                System.out.println("----------ACEPTAR UNA SOLICITUD---------");
                mostrarIdSolicitudesPendientes();
                String id = Ask.forString("el ID de la solicitud que desea aceptar");
                Solicitud solicitud = Id.validIdSolicitud(id);
                if (solicitud == null)
                    System.out.println("No se encontró la solicitud");
                    //INtentarlo de nuevo o salir
                else {
                    System.out.println("Ingrese la clave de gerente para proceder");
                    contador = 0;
                    while (contador != 3) {
                        String answer = Ask.forString("la clave del gerente");
                        if (answer.equals(CLAVE)) {
                            agregarTarjetaCliente(solicitud); //agregarle su tarjeta al cliente correspondiente en su lista de tarjetas
                            devolverSolicitudBanco(solicitud, Estatus.APROBADA); //devoler solicitud al arrayList del Banco ya aprobada
                            devolverSolicitudCliente(solicitud, Estatus.APROBADA); //devolver solicitud al arrayList del Cliente ya aprobada  
                            System.out.println("La tarjeta fue aceptada exitosamente");      
                            break;
                        }
                        else{
                            System.out.println("La clave es incorrecta. Si realiza 3 intentos fallidos consecutivos la operación que esté realizando se detendrá");
                            contador++;
                        }
                    }                    
                }
                if (contador == 3) {
                    System.out.println("Se ha excedido el número de intentos, por cuestiones de seguridad la operación se ha detenido");
                    break;
                }
                else{
                    System.out.println("¿Desea seguir aceptando solicitudes?");
                System.out.println("1. SI \n2. NO");
                int answer = Ask.forInt("el número de opción");
                if (answer != 1) break;
                }
            }
        } 
        else System.out.println("No hay solicitudes pendientes en el sistema");
    }

    public static void rechazarSolicitud(String CLAVE) {
        if (containsEstatus(Estatus.PENDIENTE)) {
            while (true) {
                System.out.println("----------RECHAZAR UNA SOLICITUD---------");
                mostrarIdSolicitudesPendientes();
                String id = Ask.forString("el ID de la solicitud que desea rechazar");
                Solicitud solicitud = Id.validIdSolicitud(id);
                if (solicitud == null)
                    System.out.println("No se encontró la solicitud");
                    //INtentarlo de nuevo o salir
                else {
                    System.out.println("Ingrese la clave de gerente para proceder");
                    int contador = 0;
                    while (contador != 3) {
                        String answer = Ask.forString("la clave del gerente");
                        if (answer.equals(CLAVE)) {
                            devolverSolicitudBanco(solicitud, Estatus.RECHAZADA); //devoler solicitud al arrayList del Banco ya aprobada
                            devolverSolicitudCliente(solicitud, Estatus.RECHAZADA); //devolver solicitud al arrayList del Cliente ya aprobada  
                            System.out.println("La tarjeta fue rechazada exitosamente");      
                            break;
                        }
                        else{
                            System.out.println("La clave es incorrecta. Si realiza 3 intentos fallidos consecutivos la operación que esté realizando se detendrá");
                            contador++;
                        }
                    }                    
                }
                System.out.println("¿Desea seguir aceptando solicitudes?");
                System.out.println("1. SI \n2. NO");
                int answer = Ask.forInt("el número de opción");
                if (answer != 1) break;
            }
        } 
        else System.out.println("No hay solicitudes pendientes en el sistema");
    }


    public static void mostrarListaSolicitudes() {//MUESTRA TODAS
        ArrayList<Solicitud> lista = Sys.getInstance().getSucursales()
                .get(SucursalActual.getInstancia().getSucursalActual()).getListaSolicitudes();
        if (lista.isEmpty()) {
            System.out.println("No hay solicitudes en el sistema");
        } else {
            System.out.println("----------------LISTA DE SOLICITUDES---------------");
            for (Solicitud solicitud : lista) {
                System.out.println(solicitud);
            }
        }
    }

    public static void mostrarListaSolicitudes(Estatus estatus) {// si el diagrama queda legible es ganancia
        ArrayList<Solicitud> lista = Sys.getInstance().getSucursales()
                .get(SucursalActual.getInstancia().getSucursalActual()).getListaSolicitudes();
        if (containsEstatus(estatus)) {
            System.out.printf("\n----------------LISTA DE SOLICITUDES %sS---------------", estatus.toString());
            for (Solicitud solicitud : lista) {
                if (solicitud.getEstatus() == estatus)
                    System.out.println(solicitud);
            }
        } else
            System.out.printf("No hay solicitudes %sS", estatus.toString());
    }

    

    public static boolean revisarUltimaSolicitudPendiente(ArrayList<Solicitud> listaSolicitudes) {
        if (listaSolicitudes.isEmpty())
            return false;
        else {
            int indexUltimaSoli = listaSolicitudes.size() - 1;
            if (listaSolicitudes.get(indexUltimaSoli).getEstatus() == Estatus.PENDIENTE)
                return true;
            else
                return false;
        }
    }

    public static boolean containsEstatus(Estatus estatus) {
        ArrayList<Solicitud> lista = Sys.getInstance().getSucursales()
                .get(SucursalActual.getInstancia().getSucursalActual()).getListaSolicitudes();
        for (Solicitud solicitud : lista) {
            if (solicitud.getEstatus() == estatus)
                return true;
        }
        return false;
    }

    private static void mostrarIdSolicitudesPendientes() {
        ArrayList<Solicitud> lista = Sys.getInstance().getSucursales()
                .get(SucursalActual.getInstancia().getSucursalActual()).getListaSolicitudes();
        for (Solicitud solicitud : lista) {
            if (solicitud.getEstatus() == Estatus.PENDIENTE) {
                System.out.printf("\n | CLIENTE: %s | TIPO DE TARJETA: %s | ID DE LA SOLICITUD: %s | ",
                        solicitud.getCliente().getNombreCompleto(), solicitud.getTipo().toString(),
                        solicitud.getIdSolicitud());
            }
        }
    }



    //DEVOLVER

    private static void agregarTarjetaCliente(Solicitud solicitud){
        Cliente cliente = solicitud.getCliente();
        int indexCliente = Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(Rol.CLIENTE).indexOf(cliente);
        cliente.getListaTarjetaCredito().add(Credito.crearTarjetaCredito(solicitud.getTipo()));
        //Devolverlo a la lista del banco
        Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(Rol.CLIENTE).set(indexCliente, cliente);
    }

    private static void devolverSolicitudBanco(Solicitud solicitud, Estatus estatus) {
        int indexSolicitud = Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaSolicitudes().indexOf(solicitud);
        solicitud.setEstatus(estatus);
        Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaSolicitudes().set(indexSolicitud, solicitud);
    }

    private static void devolverSolicitudCliente(Solicitud solicitud, Estatus estatus) {
        Cliente cliente = solicitud.getCliente();
        int indexCliente = Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(Rol.CLIENTE).indexOf(cliente);
        int indexSolicitud = cliente.getListaSolicitudes().indexOf(solicitud);
        solicitud.setEstatus(estatus);
        cliente.getListaSolicitudes().set(indexSolicitud, solicitud);
        Sys.getInstance().getSucursales().get(SucursalActual.getInstancia().getSucursalActual()).getListaUsuarios().get(Rol.CLIENTE).set(indexCliente, cliente);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public TipoTarjeta getTipo() {
        return tipo;
    }

    public void setTipo(TipoTarjeta tipo) {
        this.tipo = tipo;
    }

    public double getMontoTarjetaDebito() {
        return montoTarjetaDebito;
    }

    public void setMontoTarjetaDebito(double montoTarjetaDebito) {
        this.montoTarjetaDebito = montoTarjetaDebito;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }

    public String getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(String idCliente) {
        IdCliente = idCliente;
    }

    public String getIdSolicitud() {
        return IdSolicitud;
    }

    @Override
    public String toString() {
        String datos1 = String.format("\n | CLIENTE: %s | ID DEL CLIENTE: %s | FECHA DE SOLICITUD: %s |",
                cliente.getNombreCompleto(), IdCliente, DatosComun.formateoFecha(fechaSolicitud));
        String datos2 = String.format("\n| TIPO DE TARJETA: %s | MONTO ACTUAL EN LA TARJETA DE DEBITO: $%.2f |",
                tipo.toString(), montoTarjetaDebito);
        return String.format("%s %s \n | ESTATUS: %s | ID DE SOLICITUD: %s | ", datos1, datos2, estatus.toString(),
                IdSolicitud);
    }
}