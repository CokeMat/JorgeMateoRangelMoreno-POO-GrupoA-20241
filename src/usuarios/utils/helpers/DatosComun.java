package usuarios.utils.helpers;

//nada
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import usuarios.utils.*;
import utils.*;
import escuela.constantes.AbreviaturaCarrera;
import escuela.materias.Materia;
import escuela.materias.utils.NombreMateriaGeneral;
import sistema.Sistema;
import usuarios.*;
import usuarios.constantes.NombreCarrera;

public class DatosComun {
    public static final HashMap<Integer, String> troncocomun = new HashMap<>(
            Map.of(1, "CALCULO1", 2, "CALCULO2", 3, "CALCULO3"));
    public static final HashMap<Integer, String> SISTEMAS = new HashMap<>(Map.of(1, "PROGRAMACION1", 2, "PROGRAMACION2",
            3, "PROGRAMACION3", 4, "PROBABILIDAD1", 5, "PROBABILIDAD2", 6, "PROBABILIDAD3"));
    public static final HashMap<Integer, String> MATERIALES = new HashMap<>(Map.of(1, "ESTADISTICA1", 2, "ESTADISTICA2",
            3, "ESTADISTICA3", 4, "CONTABILIDAD1", 5, "CONTABILIDAD2", 6, "CONTABILIDAD3"));
    public static final HashMap<Integer, String> ELECTRONICA = new HashMap<>(
            Map.of(1, "REDES1", 2, "REDES2", 3, "REDES3", 4, "CIRCUITOS1", 5, "CIRCUITOS2", 6, "CIRCUITOS3"));
    public static final HashMap<Integer, String> materiasGeneral = Materia.incializarHashMaterias();

    public static ArrayList<String> obtenerDatosComun(Rol rol) {

        ArrayList<String> datosComun = new ArrayList<String>();
        // jorge, pondras aqui para la carrera?

        String rolActual = rol == Rol.ALUMNO ? "A L U M N O"
                : rol == Rol.PROFESOR ? "P R O F E S O R"
                        : rol == Rol.COORDINADOR ? "C O O R D I N A D O R"
                                : "G R A D U A D O";
        System.out.println(String.format("\n A Ñ A D I R    %s ", rolActual));

        String nombre = Ask.forString("el nombre");
        String apellidoP = Ask.forString("el apellido paterno");
        String apellidoM = Ask.forString("el apellido materno");
        String direccion = Ask.forString("la dirección");

        Estado state = DatosComun.elegirEstado();
        String estado = EntidadFederativa.getStringEstado(state);

        String nombreUsuario = obtenerNombreUsuario();// a
        String contrasena = Ask.forString("la contraseña");

        String genero = String.valueOf(elegirGenero());

        String fechaNacimiento = Fecha.askForDate("nacimiento");
        String fechaRegistro = DatosComun.formateoFecha(LocalDate.now());

        datosComun.addAll(
                Arrays.asList(nombre, apellidoP, apellidoM, fechaNacimiento, direccion, estado, nombreUsuario,
                        contrasena, genero, fechaRegistro));

        return datosComun;
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

    public static AbreviaturaCarrera getAbreviatura(String carrera) {
        AbreviaturaCarrera abreviatura = null;
        switch (carrera) {
            case "SISTEMAS" -> abreviatura = AbreviaturaCarrera.ISC;
            case "MATERIALES" -> abreviatura = AbreviaturaCarrera.IMAT;
            case "ELECTRONICA" -> abreviatura = AbreviaturaCarrera.ELC;
        }
        return abreviatura;
    }

    public static String elegirSemestre() {
        String semestre = "";
        int opcion = 0;
        while (semestre.equals("")) {// no se rompe este while
            opcion = Ask.forInt("el numero del semestre");
            System.out.println();
            switch (opcion) {
                case 1 -> semestre = "PRIMERO";
                case 2 -> semestre = "SEGUNDO";
                case 3 -> semestre = "TERCERO";
                default -> System.out.println("Opcion invalida, vuelva a intentarlo");
            }
        }
        return semestre;
    }

    public static String elegirGrupo(String carrera, String semestre) {
        String grupo = "";
        int opcion = 0;
        while (grupo.equals("")) {
            int a = Sistema.carreras.get(carrera).getSemestres().get(semestre).getGrupos().get("A").getAlumnosGrupo()
                    .size();
            // namas en vez de "PRIMERO" ponle semestre y listo, avr si jalara xd
            int b = Sistema.carreras.get(carrera).getSemestres().get(semestre).getGrupos().get("B").getAlumnosGrupo()
                    .size();

            System.out.printf("\n1. Grupo A, vacantes disponible %d", 20 - a);// aquí vdd??
            System.out.printf("\n2. Grupo B, vacantes disponible %d", 20 - b);// gracias

            opcion = Ask.forInt("el número del grupo(1 -> A | 2 -> B)");
            switch (opcion) {
                case 1 -> {
                    if (a < 20)
                        grupo = "A";
                    else {
                        System.out.println("Grupo 'A' lleno, sera colocado en el 'B'");
                        grupo = "B";
                    }
                }
                case 2 -> {
                    if (b < 20)
                        grupo = "B";
                    else {
                        System.out.println("Grupo 'B' lleno, sera colocado en el 'A'");
                        grupo = "A";
                    }
                }
                default -> System.out.println("Opcion invalida, vuelva a intentarlo");
            }
        }
        return grupo;
    }

    public static String obtenerNombreUsuario() {
        String nombreUsuario = "";
        while (true) {
            boolean nombreUsuarioValido = true;
            nombreUsuario = Ask.forString("nombre de usuario");
            String cadena = "";
            for (int i = 1; i < 4; i++) {
                switch (i) {
                    case 1 -> cadena = NombreCarrera.SISTEMAS.toString();// me estoy mamando bien cabron, la cosa es que
                                                                         // no se si para bien o para mal jajajaja
                    case 2 -> cadena = NombreCarrera.ELECTRONICA.toString();// es que agarre la mentalidad de que entre
                                                                            // mas flojera tengas en hacerlo encontraras
                                                                            // la solucion mas sencilla
                    case 3 -> cadena = NombreCarrera.MATERIALES.toString();// para bien para bien, ya andas bien filoso,
                                                                           // XDD si tiene bastante sentido
                }
                if (nombreUsuario.equals(Sistema.coordinadores.get(cadena).getNombreUsuario())) {
                    nombreUsuarioValido = false;
                    break;
                }

                for (Usuario usuario : Sistema.alumnos.get(cadena)) {// LISTA ALUMNOS DE LA CARRERA i
                    if (nombreUsuario.equals(usuario.getNombreUsuario())) {// tranqui ve a tomar aire, en lo mientras lo
                                                                           // checo
                        nombreUsuarioValido = false;// voy a cenar algo, va
                    }
                    if (!nombreUsuarioValido)
                        break;// sip yo tmb lo checo y ceno, te voy a sacar tantito
                }
                for (Usuario profesor : Sistema.profesores.get(cadena)) {// LISTA DE PROFES DE LA CARRERA i, ok
                    if (!nombreUsuarioValido)
                        break;
                    if (nombreUsuario.equals(profesor.getNombreUsuario())) {// el pedo es aqui, ya me trabe
                        nombreUsuarioValido = false;
                    }
                }
                if (!nombreUsuarioValido)
                    break;
            }
            if (!nombreUsuarioValido)
                System.out.println("Este nombre de usuario ya fue ingresado");
            else
                return nombreUsuario;
        }
    }
    /* No seas malo, traetelo a este comment para ir agarrando */

    public static ArrayList<String> seleccionarMaterias() {// que hacemos con este?? smn smn smn
        ArrayList<String> listaMaterias = new ArrayList<>();// sigueme tantito
        boolean flag = true;// amos kbron ya hasta sabes como llamarme aqui xd, q pro, emm es el q ya está
                            // en el de registrar profesor* vdd??okok, me gustó más el q hiciste hace rato,
                            // vamos usar ese
        int index = 0;// lo metemos aqui??
        // Agregar las materias del profesor
        // no agarrar mismas materias
        while (flag) {
            System.out.println("¿DE QUÉ CARRERA DESEA AGREGAR UNA MATERIA? ");
            System.out.println("1. TRONCO COMUN");
            System.out.println("2. SISTEMAS  ");
            System.out.println("3. ELECTRONICA ");
            System.out.println("4. MATERIALES  ");

            int opcion = Ask.forInt("");
            switch (opcion) {
                case 1 -> {
                    if (materiaDuplicada(listaMaterias, submenuTroncoComun())) {
                        index++;
                        listaMaterias.add(submenuTroncoComun());
                    }
                }
                case 2 -> {
                    if (materiaDuplicada(listaMaterias, submenuSistemas())) {
                        index++;
                        listaMaterias.add(submenuSistemas());
                    }
                }
                case 3 -> {
                    if (materiaDuplicada(listaMaterias, submenuElectronica())) {
                        index++;
                        listaMaterias.add(submenuElectronica());
                    }
                }
                case 4 -> {
                    if (materiaDuplicada(listaMaterias, submenuMateriales())) {
                        index++;
                        listaMaterias.add(submenuMateriales());
                    }
                }
            }
            flag = index == 3 ? false : true;
            if (flag) {
                System.out.println("Estas son las materias registradas hasta el momento");
                int n = 1;
                for (String materia : listaMaterias) {
                    System.out.printf("%d. %s", n, materia);
                    n++;
                }
                int opcion2 = Ask.forInt("QUIERE AGREGAR OTRA MATERIA?: (1.SI \n 2.NO)");
                if (opcion2 != 1) {
                    flag = false;
                }
            }

        }
        return listaMaterias;
    }

    public static boolean materiaDuplicada(ArrayList<String> listaMaterias, String materia) {// ----CORREGIR-----
        boolean noDuplicado = true;
        int index = 0;
        for (int i = 0; i < listaMaterias.size(); i++) {
            if (listaMaterias.get(i).equals(materia)) {
                index++;
            }
        }
        if (index > 1) {
            System.out.println("------------MATERIA YA REGISTRADA-----------");
            noDuplicado = false;
        }
        return noDuplicado;
    }

    //////////////////////////
    public static String submenuTroncoComun() {// mucho mejor no?? no no devuelve el String del nomre de la materia,
                                               // arre
        while (true) {
            System.out.println("1.CALCULO 1 \n2.CALCULO 2 \n3. CALCULO 3");
            int opcion = Ask.forInt("la opción numérica");
            if (opcion >= 1 && opcion <= 3)
                return troncocomun.get(opcion);// y ah yaya ookok deja los hago asi
            else
                System.out.println("Se ingresó una opción inválida");
        }
    }

    public static String submenuSistemas() {
        while (true) {
            System.out.println(
                    "1.PROGRAMACION1 \n 2.PROGRAMACION2 \n 3.PROGRAMACION3 \n 4.PROBABILIDAD1 \n  5.PROBABILIDAD2 \n 6.PROBABILIDAD3");
            int opcion = Ask.forInt("la opción numérica");
            if (opcion >= 1 && opcion <= 6)
                return SISTEMAS.get(opcion);
            else
                System.out.println("Se ingresó una opción inválida");

        }

    }

    public static String submenuElectronica() {
        while (true) {
            System.out.println("1.REDES1 \n 2.REDES2 \n 3.REDES3 \n 4. CIRCUITOS1 \n  5. CIRCUITOS2\n 6. CIRCUITOS3");
            int opcion = Ask.forInt("la opción numérica");
            if (opcion >= 1 && opcion <= 6)
                return ELECTRONICA.get(opcion);
            else
                System.out.println("Se ingresó una opción inválida");

        }

    }

    public static String submenuMateriales() {
        while (true) {
            System.out.println(
                    " 1.ESTADISTICA1 \n2.ESTADISTICA2 \n3.ESTADISTICA3 \n4.CONTABILIDAD1 \n5.CONTABILIDAD2 \n6.CONTABILIDAD3 ");
            int opcion = Ask.forInt("la opción numérica");
            if (opcion >= 1 && opcion <= 6)
                return MATERIALES.get(opcion);
            else
                System.out.println("Se ingresó una opción inválida");

        }

    }

    public static ArrayList<String> elegirMateria(int random, String carrera) {
        System.out.println("1.Electronica \n2.Sistemas \n3.Materiales ");
        ArrayList<String> nombreMateria = new ArrayList<>();

        switch (carrera) {
            case "SISTEMAS" -> nombreMateria.add(SISTEMAS.get(random));
            case "ELECTRONICA" -> nombreMateria.add(ELECTRONICA.get(random));
            case "MATERIALES" -> nombreMateria.add(MATERIALES.get(random));

        }

        return nombreMateria;
    }
    // a es este??
    // ok lo hacemos a partir de este entonces

    public static ArrayList<String> materiasProfesor(String nombre) {// ya esta aqui, smn
        System.out.println(" ----------------- ASIGNAR MATERIAS A UN PROFESOR --------------------");
        ArrayList<String> materias = new ArrayList<>();
        String materia = "";
        while (materias.size() != 3) {
            materia = "";
            System.out.println(" --------- MATERIAS ---------");
            System.out.println(
                    "\n|1. Cálculo 1|\t|4. Circuitos 1|\t|7. Redes 1|\t|10. Estadística 1|\t|13. Contabilidad 1|\t|16. Probabilidad 1|\t|19. Programación 1|");
            System.out.println(
                    "\n|2. Cálculo 2|\t|5. Circuitos 2|\t|8. Redes 2|\t|11. Estadística 2|\t|14. Contabilidad 2|\t|17. Probabilidad 2|\t|20. Programación 2|");
            System.out.println(
                    "\n|3. Cálculo 3|\t|6. Circuitos 3|\t|9. Redes 3|\t|12. Estadística 3|\t|15. Contabilidad 3|\t|18. Probabilidad 3|\t|21. Programación 3|");

            int option = Ask.forInt("el numero de la materia");
            switch (option) {
                case 1 -> materia = NombreMateriaGeneral.CALCULO1.toString();
                case 2 -> materia = NombreMateriaGeneral.CALCULO2.toString();
                case 3 -> materia = NombreMateriaGeneral.CALCULO3.toString();

                case 4 -> materia = NombreMateriaGeneral.CIRCUITOS1.toString();
                case 5 -> materia = NombreMateriaGeneral.CIRCUITOS2.toString();
                case 6 -> materia = NombreMateriaGeneral.CIRCUITOS3.toString();

                case 7 -> materia = NombreMateriaGeneral.REDES1.toString();
                case 8 -> materia = NombreMateriaGeneral.REDES2.toString();
                case 9 -> materia = NombreMateriaGeneral.REDES3.toString();

                case 10 -> materia = NombreMateriaGeneral.ESTADISTICA1.toString();
                case 11 -> materia = NombreMateriaGeneral.ESTADISTICA2.toString();
                case 12 -> materia = NombreMateriaGeneral.ESTADISTICA3.toString();

                case 13 -> materia = NombreMateriaGeneral.CONTABILIDAD1.toString();
                case 14 -> materia = NombreMateriaGeneral.CONTABILIDAD2.toString();
                case 15 -> materia = NombreMateriaGeneral.CONTABILIDAD3.toString();

                case 16 -> materia = NombreMateriaGeneral.PROBABILIDAD1.toString();
                case 17 -> materia = NombreMateriaGeneral.PROBABILIDAD2.toString();
                case 18 -> materia = NombreMateriaGeneral.PROBABILIDAD3.toString();

                case 19 -> materia = NombreMateriaGeneral.PROGRAMACION1.toString();
                case 20 -> materia = NombreMateriaGeneral.PROGRAMACION2.toString();
                case 21 -> materia = NombreMateriaGeneral.PROGRAMACION3.toString();

                default -> System.out.println("Opcion invalida, intente de nuevo");
            }

            if (!materia.equals("")) {// si ingreso una opcion invalida
                if (veririficarMateriaRepetida(materias, materia)) {// verificar que no se repitan
                    System.out.println("Esta materia ya ha sido seleccionada");
                } else {
                    materias.add(materia);
                    System.out.println("Se guardó la materia");
                }
            }
            if (materias.isEmpty()) {
                System.out.println("El profesor debe impartir al menos una materia, intente de nuevo");
            } else {
                System.out.println("Estas son las materias agregadas hasta el momento");// esto ya está creo
                for (String string : materias) {
                    System.out.printf("| %s | ", string);// parece que si
                }
                System.out.println("\n¿Desea agregar otra materia?");
                System.out.println("1. SI\n2. NO");
                int ans = Ask.forInt("una opción");
                if (ans != 1)
                    break;
            }

        }
        String cadena = "";
        for (int i = 0; i < materias.size(); i++) {
            cadena = cadena + " " + materias.get(i);
        }
        System.out.println("**************************************************************************************");
        System.out.printf("Al profesor %s se le asignaron las siguientes materia(s): %s", nombre, cadena);
        return materias;
    }

    private static boolean veririficarMateriaRepetida(ArrayList<String> listaMaterias, String materia) {
        if (listaMaterias.isEmpty()) {
            return false;
        } else {
            for (String string : listaMaterias) {
                if (materia.equals(string)) {
                    return true;
                }
            }
        }
        return false;
    }

}// esta es la de la clase
 // pq la q cierra la clase va a esta altura siempre XDDDD, creo q orita nos va
 // marcar el error no lo recorras, smn smn ya vi mb
