package sistema;

import java.time.LocalDate;
import java.util.*;
import escuela.carreras.Carrera;
import escuela.deserializers.*;
import escuela.historiales.Historial;
import escuela.materias.Materia;
import escuela.serializers.*;
import usuarios.Usuario;
import usuarios.Alumnos.Alumno;
import usuarios.Alumnos.Graduado;
import usuarios.Trabajadores.*;
import usuarios.constantes.NombreCarrera;
import usuarios.utils.helpers.DatosComun;

public class Sistema {
    public static final HashMap<String, ArrayList<Profesor>> profesores = new HashMap<>();
    public static final HashMap<String, ArrayList<Alumno>> alumnos = new HashMap<>();
    public static final HashMap<String, Coordinador> coordinadores = new HashMap<>();
    public static final HashMap<String, Carrera> carreras = new HashMap<>();
    public static final HashMap<String, ArrayList<Graduado>> graduados = new HashMap<>();
    public static final HashMap<String, HashMap<String, Historial>> historiales = new HashMap<>(
            Map.of("SISTEMAS", new HashMap<>(), "ELECTRONICA", new HashMap<>(), "MATERIALES", new HashMap<>()));
    public static final HashMap<String, Integer> semestreActual = new HashMap<>(
            Map.of("SISTEMAS", 1, "ELECTRONICA", 1, "MATERIALES", 1));

    public static final HashMap<String, Integer> contadorProfesores = new HashMap<>(
            Map.of("SISTEMAS", 0, "ELECTRONICA", 0, "MATERIALES", 0));
    public static final HashMap<String, Integer> contadorAlumnos = new HashMap<>(
            Map.of("SISTEMAS", 0, "ELECTRONICA", 0, "MATERIALES", 0));
    // CARRERA NUM CONTROL
    // En le Key la carrera

    // lista de números de control
    /*
     * NUM1
     * //loco
     * //Preguntar que periodo
     * AGOSTO_DICIEMBRE_2023
     * /*
     * 1. ArrayList<Periodo>
     * 
     * Historial:
     * HashMap<String, Periodo> en la key "AGOSTO_DICIEMBRE_2023"
     * String, numero de control
     * 
     * 
     * Sistema.historiales.get(carrera).get(numeroControl).get(
     * "AGOSTO_DICIEMBRE_2023"); //LA IMPORTANTE, rompeHuevos
     * //historial.getPeriodos().get("AGOSTO_DICIEMBRE_2023")
     * las 3 materias
     * 
     * 
     * Cada vez que se crea un alumno hacer la siguiente instruccion
     * Sistema.historiales.get(nombreCarrera).put(getNumeroControl(),
     * incializarPeriodo());
     * el de incializar Periodo obtenlo del de incializar historiales
     * 
     * 
     */
    public Sistema(boolean incializarDatos) {
        if (incializarDatos) {
            inicializarDatos();
        } else {
            Sistema.leerJson();
            Sistema.contadorAlumnos.put("SISTEMAS", Sistema.alumnos.get("SISTEMAS").size());
            Sistema.contadorAlumnos.put("MATERIALES", Sistema.alumnos.get("MATERIALES").size());
            Sistema.contadorAlumnos.put("ELECTRONICA", Sistema.alumnos.get("ELECTRONICA").size());
            Sistema.contadorProfesores.put("SISTEMAS", Sistema.profesores.get("SISTEMAS").size());
            Sistema.contadorProfesores.put("ELECTRONICA", Sistema.profesores.get("ELECTRONICA").size());
            Sistema.contadorProfesores.put("MATERIALES", Sistema.profesores.get("MATERIALES").size());
        }
    }

    private void inicializarDatos() {
        // historiales.get("SISTEMAS").put("numeroControl", new Historial(null));// así
        // sería para agregar
        // MAPA DE ALUMNOS
        alumnos.put(NombreCarrera.SISTEMAS.toString(), new ArrayList<>());
        alumnos.put(NombreCarrera.MATERIALES.toString(), new ArrayList<>());
        alumnos.put(NombreCarrera.ELECTRONICA.toString(), new ArrayList<>());

        // MAPA DE PROFESORES
        profesores.put(NombreCarrera.SISTEMAS.toString(), new ArrayList<>());
        profesores.put(NombreCarrera.MATERIALES.toString(), new ArrayList<>());
        profesores.put(NombreCarrera.ELECTRONICA.toString(), new ArrayList<>());

        // MAPA DE GRADUADOS
        graduados.put(NombreCarrera.SISTEMAS.toString(), new ArrayList<>());
        graduados.put(NombreCarrera.MATERIALES.toString(), new ArrayList<>());
        graduados.put(NombreCarrera.ELECTRONICA.toString(), new ArrayList<>());

        // SE INICIALIZAN LOS COORDINADORES
        Coordinador coordinadorSistemas = new Coordinador("Gabriel", "Chacon", "Arellano", "11/04/2005",
                DatosComun.formateoFecha(LocalDate.now()), "MORELIA", "MICHOACAN", "MASCULINO",
                "1", "123", "SISTEMAS", 10000.00, Materia.generarMateriasFromString("PROGRAMACION"));
        Coordinador coordinadorElectronica = new Coordinador("Jorge", "Rangel", "Moreno", "11/04/2005",
                DatosComun.formateoFecha(LocalDate.now()), "MORELIA", "MICHOACAN", "MASCULINO",
                "2", "123", "ELECTRONICA", 1000.00, Materia.generarMateriasFromString("CIRCUITOS"));
        Coordinador coordinadorMateriales = new Coordinador("Edgar", "Martinez", "Lopez", "22/11/2005",
                DatosComun.formateoFecha(LocalDate.now()), "MORELIA", "MICHOACAN", "MASCULINO",
                "3", "123", "MATERIALES", 1000.00, Materia.generarMateriasFromString("ESTADISTICA"));
        // SE INICIALIZAN LOS PROFESORES

        // SISTEMAS
        Profesor profesorSistemas1 = new Profesor("Lionel", "Andres", "Messi", "11/04/2005",
                DatosComun.formateoFecha(LocalDate.now()), "MORELIA", "MICHOACAN", "MASCULINO", "profe1", "123",
                1000.00,
                "SISTEMAS", Materia.generarMateriasFromString("PROGRAMACION"));// ---Edgar---
        Profesor profesorSistemas2 = new Profesor("Henrry", "Ramirez", "Perez", "11/04/2005",
                DatosComun.formateoFecha(LocalDate.now()), "MORELIA", "MICHOACAN", "MASCULINO", "profe2", "123",
                1000.00,
                "SISTEMAS", Materia.generarMateriasFromString("PROBABILIDAD"));
        Profesor profesorSistemas3 = new Profesor("Diego", "Chacon", "Argolla", "11/04/2005",
                DatosComun.formateoFecha(LocalDate.now()), "MORELIA", "MICHOACAN", "MASCULINO", "profe3", "123",
                1000.00,
                "SISTEMAS", Materia.generarMateriasFromString("CALCULO"));

        // ELECTRONICA
        Profesor profesorElectronica1 = new Profesor("Gavi", "Pedroza", "Montiel", "11/04/2005",
                DatosComun.formateoFecha(LocalDate.now()), "MORELIA",
                "MICHOACAN", "MASCULINO", "profe4", "123", 1000.00,
                "ELECTRONICA", Materia.generarMateriasFromString("REDES"));
        Profesor profesorElectronica2 = new Profesor("Jose", "Ronaldo", "Dosantos", "11/04/2005",
                DatosComun.formateoFecha(LocalDate.now()), "MORELIA",
                "MICHOACAN", "MASCULINO", "profe5", "123", 1000.00,
                "ELECTRONICA", Materia.generarMateriasFromString("CIRCUITOS"));
        Profesor profesorElectronica3 = new Profesor("Gabriel", "Ramirez", "Morales", "11/04/2005",
                DatosComun.formateoFecha(LocalDate.now()), "MORELIA",
                "MICHOACAN", "MASCULINO", "profe6", "123", 1000.00,
                "ELECTRONICA", Materia.generarMateriasFromString("CALCULO"));

        // MATERIALES
        Profesor profesorMateriales1 = new Profesor("Cristiano", "Ronaldo", "Aveiro", "11/04/2005",
                DatosComun.formateoFecha(LocalDate.now()), "MORELIA",
                "MICHOACAN", "MASCULINO", "profe7", "123", 1000.00,
                "MATERIALES", Materia.generarMateriasFromString("ESTADISTICA"));
        Profesor profesorMateriales2 = new Profesor("Israel", "Palas", "Morales", "11/04/2005",
                DatosComun.formateoFecha(LocalDate.now()), "MORELIA", "MICHOACAN", "MASCULINO", "profe8", "123",
                1000.00,
                "MATERIALES", Materia.generarMateriasFromString("CONTABILIDAD")); // XDD NEGRITO
        Profesor profesorMateriales3 = new Profesor("Ricardo", "Martinez", "Gonzalez", "11/04/2005",
                DatosComun.formateoFecha(LocalDate.now()), "MORELIA", "MICHOACAN", "MASCULINO", "profe9", "123",
                1000.00,
                "MATERIALES", Materia.generarMateriasFromString("CALCULO"));

        // SISTEMAS
        profesores.get(NombreCarrera.SISTEMAS.toString()).add(profesorSistemas1);
        profesores.get(NombreCarrera.SISTEMAS.toString()).add(profesorSistemas2);
        profesores.get(NombreCarrera.SISTEMAS.toString()).add(profesorSistemas3);
        // ELECTORNICA
        profesores.get(NombreCarrera.ELECTRONICA.toString()).add(profesorElectronica1);
        profesores.get(NombreCarrera.ELECTRONICA.toString()).add(profesorElectronica2);
        profesores.get(NombreCarrera.ELECTRONICA.toString()).add(profesorElectronica3);
        // MATERIALES
        profesores.get(NombreCarrera.MATERIALES.toString()).add(profesorMateriales1);
        profesores.get(NombreCarrera.MATERIALES.toString()).add(profesorMateriales2);
        profesores.get(NombreCarrera.MATERIALES.toString()).add(profesorMateriales3);

        // PROFESORES AGREGADOS A LA LISTA DE

        /*
         * String nombre, String apellidoP, String apellidoM, String direccion,
         * String fechaDeNacimiento, String fechaRegistro, String estado, String genero,
         * String nombreUsuario,
         * String contrasena,
         * String carrera, double sueldo)
         * ire haciendo el mapa en la clase Materia, si ocupan algo andaré por ahí ;)
         */// vava, gracias

        // DE AQUI VIENE EL ERROR, PQ QUIERES PONER ALGO EN LA KEY SISTEMAS CUANDO NO LO
        // HAS CREADO
        carreras.put(NombreCarrera.SISTEMAS.toString(),
                new Carrera(NombreCarrera.SISTEMAS.toString(), coordinadorSistemas));
        carreras.put(NombreCarrera.ELECTRONICA.toString(),
                new Carrera(NombreCarrera.ELECTRONICA.toString(), coordinadorElectronica));
        carreras.put(NombreCarrera.MATERIALES.toString(),
                new Carrera(NombreCarrera.MATERIALES.toString(), coordinadorMateriales));

        // COORDINADORES AGREGADOS A LA LISTA DE PROFESORES CLASIFICADOS POR CARRERA
        coordinadores.put(NombreCarrera.SISTEMAS.toString(), coordinadorSistemas);
        coordinadores.put(NombreCarrera.ELECTRONICA.toString(), coordinadorElectronica);
        coordinadores.put(NombreCarrera.MATERIALES.toString(), coordinadorMateriales);

        // PROFESORES AGREGADOS A LA LISTA CLASIFICADOS POR CARRERA
        // SISTEMAS

        Sistema.guardarEnJson();
    }

    public static void guardarEnJson() {
        // Serializers
        CarreraSerializer.serialize();
        AlumnoSerializer.serialize();
        CoordinadorSerializer.serialize();
        ProfesorSerializer.serialize();
        GraduadoSerializer.serialize();
        HistorialSerializer.serialize();
    }

    public static void leerJson() {
        // Deserealizers
        CarreraDeserializer.deserialize();
        AlumnoDeserializer.deserialize();
        CoordinadorDeserializer.deserialize();
        ProfesorDeserializer.deserialize();
        GraduadoDeserializer.deserialize();
        HistorialDeserializer.deserialize();
    }

    public void ejecutarSistema() {
        Menu.ejecutarMenuPrincipal();
    }

    public static Usuario verificarInicioSesion(String nombreUsuario, String contrasena) {// CAMBIAR
        // CON COORDINDAORES
        for (Coordinador coordinador : Sistema.coordinadores.values()) {
            if (nombreUsuario.equals(coordinador.getNombreUsuario())) {
                if (contrasena.equals(coordinador.getContrasena())) {
                    return coordinador;
                }
            }
        }
        // CON PROFESORES
        for (ArrayList<Profesor> lista : Sistema.profesores.values()) {
            for (Profesor profesor : lista) {
                if (nombreUsuario.equals(profesor.getNombreUsuario())) {
                    if (contrasena.equals(profesor.getContrasena())) {
                        return profesor;
                    }
                }
            }
        }
        // CON ALUMNOS
        for (ArrayList<Alumno> lista : Sistema.alumnos.values()) {
            for (Alumno alumno : lista) {
                if (nombreUsuario.equals(alumno.getNombreUsuario())) {
                    if (contrasena.equals(alumno.getContrasena())) {
                        return alumno;
                    }
                }
            }
        }
        return null;
    }
}
