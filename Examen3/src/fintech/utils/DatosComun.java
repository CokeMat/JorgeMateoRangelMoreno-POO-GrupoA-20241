package src.fintech.utils;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import src.utils.*;
import src.fintech.Fintech;
import src.fintech.Sys;
import src.usuarios.Usuario;
import src.usuarios.utils.*;

public class DatosComun {
    public static ArrayList<String> obtenerDatosComun(Rol rol) {

        ArrayList<String> datosComun = new ArrayList<String>();

        String rolActual = rol == Rol.CLIENTE ? "C L I E N T E"
                : rol == Rol.CAPTURISTA ? "C A P T U R I S T A"
                        : rol == Rol.INVERSIONISTA ? "I N V E R S I O N I S T A"
                                : "E J E C U T I V O    DE   C U E N T A";
        System.out.println(String.format("\n A Ñ A D I R    %s ", rolActual));

        String nombre = Ask.forString("el nombre");
        String apellidoP = Ask.forString("el apellido paterno");
        String apellidoM = Ask.forString("el apellido materno");
        String direccion = Ask.forString("la dirección");

        Estado state = DatosComun.elegirEstado();
        String estado = EntidadFederativa.getStringEstado(state);

        String ciudad = Ask.forString("la ciudad");
        String nombreUsuario = DatosComun.obtenerNombreUsuario();
        String contrasena = Ask.forString("la contraseña");

        String genero = String.valueOf(elegirGenero());

        String fechaNacimiento = Fecha.askForDate("nacimiento");
        String numTelefono = obtenerNumTelefono();

        datosComun.addAll(Arrays.asList(nombre, apellidoP, apellidoM, fechaNacimiento, direccion, estado, ciudad,
                nombreUsuario, contrasena, genero, numTelefono));

        return datosComun;
    }

    public static Estado validEstado(String cadena) {
        cadena = cadena.toUpperCase();
        Estado estado;
        switch (cadena) {
            case "AGUASCALIENTES" -> estado = Estado.Aguascalientes;
            case "BAJA CALIFORNIA" -> estado = Estado.Baja_California;
            case "BAJA CALIFORNIA SUR" -> estado = Estado.Baja_California_Sur;
            case "CAMPECHE" -> estado = Estado.Campeche;
            case "CHIAPAS" -> estado = Estado.Chiapas;
            case "CHIHUAHUA" -> estado = Estado.Chihuahua;
            case "CIUDAD DE MÉXICO" -> estado = Estado.CDMX;
            case "COAHUILA" -> estado = Estado.Coahuila;
            case "COLIMA" -> estado = Estado.Colima;
            case "DURANGO" -> estado = Estado.Durango;
            case "ESTADO DE MÉXICO" -> estado = Estado.Estado_de_Mexico;
            case "GUANAJUATO" -> estado = Estado.Guanajuato;
            case "GUERRERO" -> estado = Estado.Guerrero;
            case "HIDALGO" -> estado = Estado.Hidalgo;
            case "JALISCO" -> estado = Estado.Jalisco;
            case "MICHOACÁN" -> estado = Estado.Michoacan;
            case "MORELOS" -> estado = Estado.Morelos;
            case "NAYARIT" -> estado = Estado.Nayarit;
            case "NUEVO LEÓN" -> estado = Estado.Nuevo_Leon;
            case "OAXACA" -> estado = Estado.Oaxaca;
            case "PUEBLA" -> estado = Estado.Puebla;
            case "QUERÉTARO" -> estado = Estado.Queretaro;
            case "QUINTANA ROO" -> estado = Estado.Quintana_Roo;
            case "SAN LUIS POTOSÍ" -> estado = Estado.San_Luis_Potosi;
            case "SINALOA" -> estado = Estado.Sinaloa;
            case "SONORA" -> estado = Estado.Sonora;
            case "TABASCO" -> estado = Estado.Tabasco;
            case "TAMAULIPAS" -> estado = Estado.Tamaulipas;
            case "TLAXCALA" -> estado = Estado.Tlaxcala;
            case "VERACRUZ" -> estado = Estado.Veracruz;
            case "YUCATÁN" -> estado = Estado.Yucatan;
            case "ZACATECAS" -> estado = Estado.Zacatecas;
            default -> estado = Estado.Nacido_En_Extranjero;
        }
        return estado;
    }

    public static String obtenerNombreUsuario() {
        String nombreUsuario = "";
        while (true) {
            boolean nombreUsuarioValido = true;
            nombreUsuario = Ask.forString("nombre de usuario");
            for (Fintech banco : Sys.getInstance().getSucursales().values()) {
                if (nombreUsuario.equals(banco.getGerente().getNombreUsuario())) {// Compararlo con el gerente
                    nombreUsuarioValido = false;
                }
                if (!nombreUsuarioValido)
                    break;

                for (ArrayList<Usuario> lista : banco.getListaUsuarios().values()) {
                    if (!nombreUsuarioValido)
                        break;
                    for (Usuario usuario : lista) {
                        if (nombreUsuario.equals(usuario.getNombreUsuario())) {
                            nombreUsuarioValido = false;
                            break;
                        }
                    }
                }
            }
            if (!nombreUsuarioValido)
                System.out.println("Este nombre de usuario ya fue ingresado");
            else
                return nombreUsuario;
        }
    }

    public static String obtenerNumTelefono() {

        String numeroTelefono;
        while (true) {
            boolean telefonoValido = true;
            numeroTelefono = Ask.forString("el número de teléfono");
            for (Fintech banco : Sys.getInstance().getSucursales().values()) {
                if (numeroTelefono.equals(banco.getGerente().getNumTelefono())) {// Compararlo con el gerente
                    telefonoValido = false;
                }
                if (!telefonoValido)
                    break;

                for (ArrayList<Usuario> lista : banco.getListaUsuarios().values()) {
                    if (!telefonoValido)
                        break;
                    for (Usuario usuario : lista) {
                        if (numeroTelefono.equals(usuario.getNumTelefono())) {
                            telefonoValido = false;
                            break;
                        }
                    }
                }
            }
            if (!telefonoValido)
                System.out.println("Este número de telefono ya fue ingresado");
            else
                return numeroTelefono;
        }
    }

    public static String obtenerID(String cad) {
        boolean idValido = true;
        String id = "";
        while (true) {
            id = Id.generate(cad);
            for (Fintech banco : Sys.getInstance().getSucursales().values()) {
                if (id.equals(banco.getGerente().getId())) {
                    idValido = false;
                }
                if (!idValido)
                    break;
                for (ArrayList<Usuario> lista : banco.getListaUsuarios().values()) {
                    if (!idValido)
                        break;
                    for (Usuario usuario : lista) {
                        if (id.equals(usuario.getId())) {
                            idValido = false;
                            break;
                        }
                    }
                }
            }
            if (!idValido)
                System.out.println("Este nombre de usuario ya fue ingresado");
            else
                return id;
        }
    }

    public static String formateoFecha(LocalDate fecha) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        String newFecha = fecha.format(pattern);
        return newFecha;
    }

    public static String formateoFecha(LocalDateTime fechaHora) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/YYYY  HH:mm");
        String newFecha = fechaHora.format(pattern);
        return newFecha;
    }

    public static String seleccionarHorario() {
        String horario = "";
        while (true) {
            System.out.println("Horarios: \n1. Vespertino \n2. Matutino \n");
            int numHorario = Ask.forInt("el horario que le gustaria");
            switch (numHorario) {
                case 1 -> horario = "12pm a 8pm";
                case 2 -> horario = "8am a 16pm";
                default -> System.out.println("Opcion invalida, intentelo de nuevo.");
            }
            if (numHorario == 1 || numHorario == 2)
                break;
        }
        return horario;
    }

    public static Estado elegirEstado() {
        Estado estado = null;
        while (true) {
            System.out.println(
                    "1. Aguascalientes \n2. Baja California \n3. Baja California Sur \n4. Campeche \n5. Chiapas \n6. Chihuahua \n7. Ciudad de México \n8. Coahuila \n9. Colima \n10. Durango \n11. Estado de México \n12. Guanajuato \n13. Guerrero \n14. Hidalgo \n15. Jalisco \n16. Michoacán \n17. Morelos \n18. Nayarit \n19. Nuevo León \n20. Oaxaca \n21. Puebla \n22. Querétaro \n23. Quintana Roo \n24. San Luis Potosí \n25. Sinaloa \n26. Sonora \n27. Tabasco \n28. Tamaulipas \n29. Tlaxcala \n30. Veracruz \n31. Yucatán \n32. Zacatecas \n33. Extranjero\n");
            int opcion = Ask.forInt("el número del estado: ");

            switch (opcion) {
                case 1 -> estado = Estado.Aguascalientes;
                case 2 -> estado = Estado.Baja_California;
                case 3 -> estado = Estado.Baja_California_Sur;
                case 4 -> estado = Estado.Campeche;
                case 5 -> estado = Estado.Chiapas;
                case 6 -> estado = Estado.Chihuahua;
                case 7 -> estado = Estado.CDMX;
                case 8 -> estado = Estado.Coahuila;
                case 9 -> estado = Estado.Colima;
                case 10 -> estado = Estado.Durango;
                case 11 -> estado = Estado.Estado_de_Mexico;
                case 12 -> estado = Estado.Guanajuato;
                case 13 -> estado = Estado.Guerrero;
                case 14 -> estado = Estado.Hidalgo;
                case 15 -> estado = Estado.Jalisco;
                case 16 -> estado = Estado.Michoacan;
                case 17 -> estado = Estado.Morelos;
                case 18 -> estado = Estado.Nayarit;
                case 19 -> estado = Estado.Nuevo_Leon;
                case 20 -> estado = Estado.Oaxaca;
                case 21 -> estado = Estado.Puebla;
                case 22 -> estado = Estado.Queretaro;
                case 23 -> estado = Estado.Quintana_Roo;
                case 24 -> estado = Estado.San_Luis_Potosi;
                case 25 -> estado = Estado.Sinaloa;
                case 26 -> estado = Estado.Sonora;
                case 27 -> estado = Estado.Tabasco;
                case 28 -> estado = Estado.Tamaulipas;
                case 29 -> estado = Estado.Tlaxcala;
                case 30 -> estado = Estado.Veracruz;
                case 31 -> estado = Estado.Yucatan;
                case 32 -> estado = Estado.Zacatecas;
                case 33 -> estado = Estado.Nacido_En_Extranjero;
                default -> System.out.println("\nOpción invalida, vuelva a ingresarla\n");
            }
            if (opcion <= 33) {
                break;
            }
        }
        return estado;
    }

    public static Genero elegirGenero() {
        Genero genero = null;
        while (genero == null) {
            System.out.println("1. Femenino \n2. Masculino");
            int opcion = Ask.forInt("el genero: ");

            switch (opcion) {
                case 1 -> genero = Genero.FEMENINO;
                case 2 -> genero = Genero.MASCULINO;
                default -> System.out.println("\nOpcion invalida, vuelva a ingresarla\n");
            }
        }
        return genero;
    }

    public static Genero validaGenero(String cadena) {
        Genero genero;
        if (cadena.equals("FEMENINO")) {
            genero = Genero.FEMENINO;
        } else {
            genero = Genero.MASCULINO;
        }
        return genero;
    }
}
/*
 * cadena = cadena.toUpperCase();
 * Estado estado = switch (cadena) {
 * case "AGUASCALIENTES":
 * estado = Estado.Aguascalientes;
 * break;
 * case "BAJA CALIFORNIA":
 * estado = Estado.Baja_California;
 * break;
 * case "BAJA CALIFORNIA SUR":
 * estado = Estado.Baja_California_Sur;
 * break;
 * case "CAMPECHE":
 * estado = Estado.Campeche;
 * break;
 * case "CHIAPAS":
 * estado = Estado.Chiapas;
 * break;
 * case "CHIHUAHUA":
 * estado = Estado.Chihuahua;
 * break;
 * case "CIUDAD DE MÉXICO":
 * estado = Estado.CDMX;
 * break;
 * case "COAHUILA":
 * estado = Estado.Coahuila;
 * break;
 * case "COLIMA":
 * estado = Estado.Colima;
 * break;
 * case "DURANGO":
 * estado = Estado.Durango;
 * break;
 * case "ESTADO DE MÉXICO":
 * estado = Estado.Estado_de_Mexico;
 * break;
 * case "GUANAJUATO":
 * estado = Estado.Guanajuato;
 * break;
 * case "GUERRERO":
 * estado = Estado.Guerrero;
 * break;
 * case "HIDALGO":
 * estado = Estado.Hidalgo;
 * break;
 * case "JALISCO":
 * estado = Estado.Jalisco;
 * break;
 * case "MICHOACÁN":
 * estado = Estado.Michoacan;
 * break;
 * case "MORELOS":
 * estado = Estado.Morelos;
 * break;
 * case "NAYARIT":
 * estado = Estado.Nayarit;
 * break;
 * case "NUEVO LEÓN":
 * estado = Estado.Nuevo_Leon;
 * break;
 * case "OAXACA":
 * estado = Estado.Oaxaca;
 * break;
 * case "PUEBLA":
 * estado = Estado.Puebla;
 * break;
 * case "QUERÉTARO":
 * estado = Estado.Queretaro;
 * break;
 * case "QUINTANA ROO":
 * estado = Estado.Quintana_Roo;
 * break;
 * case "SAN LUIS POTOSÍ"-> estado = Estado.San_Luis_Potosi;
 * break;
 * case "SINALOA"-> estado = Estado.Sinaloa;
 * break;
 * case "SONORA"-> estado = Estado.Sonora;
 * break;
 * case "TABASCO"-> estado = Estado.Tabasco;
 * break;
 * case "TAMAULIPAS"-> estado = Estado.Tamaulipas;
 * break;
 * case "TLAXCALA"-> estado = Estado.Tlaxcala;
 * break;
 * case "VERACRUZ"-> estado = Estado.Veracruz;
 * break;
 * case "YUCATÁN"-> estado = Estado.Yucatan;
 * break;
 * case "ZACATECAS" -> estado = Estado.Zacatecas
 * break
 * default:
 * estado = Estado.Nacido_En_Extranjero;
 * break;
 * }
 * 
 * return estado;
 * }
 */
