package usuarios.Alumnos;

import usuarios.Usuario;
import usuarios.Trabajadores.Coordinador;
import utils.*;
import usuarios.utils.helpers.DatosComun;
import java.util.*;

import escuela.historiales.Historial;
import escuela.historiales.cursos.Curso;
import escuela.historiales.periodos.Periodo;
import escuela.historiales.periodos.utils.*;
import escuela.materias.Materia;
import sistema.Sistema;
import usuarios.utils.Rol;

public class Alumno extends Usuario {
    public static int CONTADOR = 0;
    private String semestre, grupo;
    // private Historial historial; Aqui dentro va ir el promedio como un atributo
    // de la clase Historial, va a ser un HashMap un arraylist que va ir conteniendo
    // semestres, las keys
    // van a ser los periodos AGOSTO-DICIEMBRE-202 y va a contener las
    // calificaciones. Es la idea nada más xc3

    public Alumno(String nombre, String apellidoP, String apellidoM, String fechaDeNacimiento, String fechaDeRegistro,
            String direccion, String estado, String genero, String nombreUsuario, String contrasena,
            String carrera, String semestre, String grupo) {
        super(nombre, apellidoP, apellidoM, fechaDeNacimiento, fechaDeRegistro, direccion, estado, genero,
                nombreUsuario, contrasena,
                Rol.ALUMNO, carrera);
        this.grupo = grupo;
        this.semestre = semestre;
        CONTADOR++;
    }

    public static void registrar() {
        ArrayList<String> datos = DatosComun.obtenerDatosComun(Rol.ALUMNO);
        String nombre = datos.get(0);
        String apellidoP = datos.get(1);
        String apellidoM = datos.get(2);
        String fechaNacimiento = datos.get(3);
        String direccion = datos.get(4);
        String state = datos.get(5);
        String nombreUsuario = datos.get(6);
        String contrasena = datos.get(7);
        String gender = datos.get(8);
        String fechaRegistro = datos.get(9);

        String carrera = CarreraActual.getInstancia().getCarreraActual();
        String semestre = "PRIMERO";
        String grupo = DatosComun.elegirGrupo(carrera, semestre);// 3 clics en el mouse para seleccionar toda la linea
        // viene de aqui el error
        // (CarreraActual.getInstancia().getCarreraActual()).getAlumnos()
        Alumno alumno = new Alumno(nombre, apellidoP, apellidoM, fechaNacimiento, fechaRegistro, direccion, state,
                gender,
                nombreUsuario, contrasena, carrera, semestre, grupo);
        Sistema.alumnos.get(CarreraActual.getInstancia().getCarreraActual()).add(alumno);
        Sistema.carreras.get(carrera).getSemestres().get(semestre).getGrupos().get(grupo).getAlumnosGrupo().add(alumno);
        String periodo = Sistema.carreras.get(carrera).getSemestres().get(semestre).getGrupos().get(grupo).getPeriodo();
        Sistema.historiales.get(alumno.getCarrera()).put(alumno.getNumeroControl(),
                new Historial(alumno.getNumeroControl(), periodo));
        Sistema.guardarEnJson();
        System.out.println("----------------------------Alumno registrado----------------------------");
    }

    public static void eliminar() {// DARLE UNA CHECADA
        if (Sistema.alumnos.get(CarreraActual.getInstancia().getCarreraActual()).isEmpty()) {
            System.out.println("No hay alumnos registrados");
        } else {
            String numeroControl = "";
            int index = 0;
            Rol rol = Rol.ALUMNO;
            System.out.printf("\n---------------------ELIMINAR UN %s---------------------", rol.toString());

            while (true) {
                boolean flag = true;
                showListNumeroControl();
                numeroControl = Ask.forString("el numero de control del alumno");
                index = Id.validNumeroControl(numeroControl, rol.toString());
                if (index == -1) {
                    System.out.println("No se encontro al alumno, ¿Desea intentarlo de nuevo?");
                    System.out.println("1. SI \n2. NO");
                    if (Ask.forInt("el numero de opcion") == 1)
                        flag = false;
                    else
                        break;

                }
                if (flag) {
                    Alumno alumnoAux = Alumno.getAlumno(CarreraActual.getInstancia().getCarreraActual(), numeroControl);
                    ArrayList<Alumno> listaAlumnosAux = Sistema.carreras
                            .get(CarreraActual.getInstancia().getCarreraActual()).getSemestres()
                            .get(alumnoAux.getSemestre()).getGrupos().get(alumnoAux.getGrupo()).getAlumnosGrupo();
                    int indexAlumnoGrupo = 0;
                    for (int i = 0; i < listaAlumnosAux.size(); i++) {
                        if (listaAlumnosAux.get(i).getNumeroControl().equals(alumnoAux.getNumeroControl())) {
                            indexAlumnoGrupo = i;
                            break;
                        }
                    }
                    Sistema.carreras.get(CarreraActual.getInstancia().getCarreraActual()).getSemestres()
                            .get(alumnoAux.getSemestre()).getGrupos().get(alumnoAux.getGrupo()).getAlumnosGrupo()
                            .remove(indexAlumnoGrupo);
                    Sistema.historiales.get(CarreraActual.getInstancia().getCarreraActual()).remove(numeroControl);
                    Sistema.alumnos.get(CarreraActual.getInstancia().getCarreraActual()).remove(index);
                    System.out.println("El alumno fue eliminado exitosamente");
                    Sistema.guardarEnJson();
                    break;
                }
            }
        }
    }//

    public static void modificarInfo() {
        if (Sistema.alumnos.get(CarreraActual.getInstancia().getCarreraActual()).isEmpty()) {
            System.out.println("No hay alumnos regostrados");
        } else {
            String numeroControl = "";
            int index = 0;
            System.out.printf("\n---------------------MODIFICAR UN %s---------------------", Rol.ALUMNO.toString());

            while (true) {
                boolean flag = true;
                showListNumeroControl();
                numeroControl = Ask.forString("el numero de control del Alumnos");
                index = Id.validNumeroControl(numeroControl, Rol.ALUMNO.toString());
                if (index == -1) {
                    System.out.println("No se encontro al profesor, ¿Desea intentarlo de nuevo?");
                    System.out.println("1. SI \n2. NO");
                    if (Ask.forInt("el numero de opcion") == 1)
                        flag = false;
                    else
                        break;
                }
                if (flag) {
                    modificar(index);
                    System.out.println("El alumno fue modificado exitosamente");
                    Sistema.guardarEnJson();
                    break;
                }
            }
        }
    }

    public static void modificarInfoPersonal() {

        int index = Id.validNumeroControl(UsuarioEnSesion.getInstancia().getUsuarioActual().getNumeroControl(),
                "ALUMNO");
        System.out.println("\n---------------MODIFICAR INFORMACION PERSONAL---------------");
        modificar(index);

    }

    private static void modificar(int index) {
        boolean flag = true;
        while (flag) {
            System.out.println(
                    "\n¿QUÉ DESEA MODIFICAR?");
            System.out.println(
                    "1.NOMBRE  \n2.APELLIDO PATERNO \n3.APELLIDO MATERNO \n4.NOMBRE DE USUARIO  \n5.FECHA DE NACIMIENTO \n6.ESTADO \n7.GENERO \n8.DIRECCION \n9. Volver al menu principal ");
            int opcion = Ask.forInt("el número de opción");
            switch (opcion) {
                case 1 -> {
                    String nombre = Ask.forString("el nuevo nombre");

                    Sistema.alumnos.get(CarreraActual.getInstancia().getCarreraActual()).get(index)
                            .setNombre(nombre);
                    System.out.println("Se actualizó el nombre");
                }

                case 2 -> {
                    String apellidoP = Ask.forString("el nuevo apellido paterno");

                    Sistema.alumnos.get(CarreraActual.getInstancia().getCarreraActual()).get(index)
                            .setApellidoP(apellidoP);
                    System.out.println("Se actualizo el apellido paterno");
                }
                case 3 -> {
                    String apellidoM = Ask.forString("el nuevo apellido materno");
                    Sistema.alumnos.get(CarreraActual.getInstancia().getCarreraActual()).get(index)
                            .setApellidoM(apellidoM);
                    System.out.println("Se actualizo el apellido materno");
                }
                case 4 -> {
                    String nombreUsuario = DatosComun.obtenerNombreUsuario();
                    Sistema.alumnos.get(CarreraActual.getInstancia().getCarreraActual()).get(index)
                            .setNombreUsuario(nombreUsuario);
                    System.out.println("Se actualizo el nombre de usuario");
                }
                case 5 -> {
                    String fechaNacimiento = Fecha.askForDate("la nueva fecha de nacimiento");
                    Sistema.alumnos.get(CarreraActual.getInstancia().getCarreraActual()).get(index)
                            .setFechaDeNacimiento(fechaNacimiento);
                    System.out.println("Se actualizo la fecha de nacimeinto");
                }
                case 6 -> {
                    String estado = DatosComun.elegirEstado().toString();
                    Sistema.alumnos.get(CarreraActual.getInstancia().getCarreraActual()).get(index)
                            .setEstado(estado);
                    System.out.println("Se actualizo el estado");
                }
                case 7 -> {
                    String genero = DatosComun.elegirGenero().toString();
                    Sistema.alumnos.get(CarreraActual.getInstancia().getCarreraActual()).get(index)
                            .setGenero(genero);
                    System.out.println("Se actualizo el genero");
                }
                case 8 -> {
                    String direccion = Ask.forString("la direccion nueva");
                    Sistema.alumnos.get(CarreraActual.getInstancia().getCarreraActual()).get(index)
                            .setDireccion(direccion);
                    System.out.println("Se actualizo la direccion");
                }
                case 9 -> {
                    System.out.println("Volviendo al menu principal...");
                    flag = false;
                }
                default -> System.out.println("Opcion invalida, vuelva a intentarlo");
            }
            Sistema.guardarEnJson();
            if (opcion == 9)
                break;
            Usuario usuario = UsuarioEnSesion.getInstancia().getUsuarioActual();
            if (usuario instanceof Alumno) {
                Alumno alumno = (Alumno) usuario;
                System.out.printf("\nInformación del alumno actualizada: \n%s", alumno.toString());
            }
            System.out.println("\n¿Desea seguir modificando la información?");
            System.out.println("1. SI \n2. NO");
            if (Ask.forInt("el número de opción") != 1)
                flag = false;
        }

    }

    public static void consultarInfo() {
        System.out.println("\n---------------INFORMACION PERSONAL---------------");
        Alumno alumno = (Alumno) UsuarioEnSesion.getInstancia().getUsuarioActual();
        System.out.println(alumno);
    }

    public static void showList() { // todos los alumnos
        if (Sistema.alumnos.get(CarreraActual.getInstancia().getCarreraActual()).isEmpty()) {
            System.out.println("No hay alumnos regostrados");
        } else {
            System.out.printf("\n-------- A L U M N O S  DE  %s---------\n",
                    CarreraActual.getInstancia().getCarreraActual());
            for (Usuario usuario : Sistema.alumnos.get(CarreraActual.getInstancia().getCarreraActual())) {
                System.out.println((Alumno) usuario);
            }
        }

    }

    public static void showInfo() {
        if (Sistema.alumnos.get(CarreraActual.getInstancia().getCarreraActual()).isEmpty()) {
            System.out.println("No hay alumnos registrados en el sistema :(");
        } else {
            showListNumeroControl();// nombre, semestre, grupo, numero de control
            String numeroControl = Ask.forString("el numero de control del estudiante");
            int index = Id.validNumeroControl(numeroControl, Rol.ALUMNO.toString());// CORREGIR PARA QUE JALE***
            if (index == -1) {
                System.out.println("No se encontró al alumno");
                System.out.println("¿Desea intentarlo de nuevo?");
                System.out.println("1. SI \n 2. NO");
                int option = Ask.forInt("el número de opción");
                if (option == 1)
                    showInfo();// Preguntxar a Edgar aqui que planea hacer, tal venz no funciona
            } else {
                Usuario usuario = Sistema.alumnos.get(CarreraActual.getInstancia().getCarreraActual())
                        .get(index);
                Alumno alumno = (Alumno) usuario;
                System.out.printf(
                        "\n-------------------------------INFORMACIÓN DEL ALUMNO %s-------------------------------\n",
                        alumno.getNombreCompleto());
                System.out.println(alumno);
            }
        }
    }

    public static void consultarInfoSemestre() {// MOstrar la info del semestre actual, Imprimir su último periodo
        // Se obtiene el número de control del alumno
        Alumno alumno = (Alumno) UsuarioEnSesion.getInstancia().getUsuarioActual();
        String numeroControl = alumno.getNumeroControl();
        // int numeroSemestre =
        // Sistema.historiales.get(CarreraActual.getInstancia().getCarreraActual()).get(numeroControl).getPeriodos().size();//semestreActual
        // Se obtiene el String de su último periodo
        String periodoString = Coordinador.calcularUltimoPeriodo(CarreraActual.getInstancia().getCarreraActual(),
                numeroControl);
        // Se obtiene el periodo: que contiene las 3 materias
        Periodo periodo = Sistema.historiales.get(CarreraActual.getInstancia().getCarreraActual()).get(numeroControl)
                .getPeriodos().get(periodoString);
        // Se imprime el periodo
        System.out.println(periodo);
    }

    public static void consultarInfoMateria() {
        Alumno alumno = (Alumno) UsuarioEnSesion.getInstancia().getUsuarioActual();
        String numeroControl = alumno.getNumeroControl();
        String periodoString = Coordinador.calcularUltimoPeriodo(CarreraActual.getInstancia().getCarreraActual(),
                numeroControl);
        Periodo periodo = Sistema.historiales.get(CarreraActual.getInstancia().getCarreraActual()).get(numeroControl)
                .getPeriodos().get(periodoString);
        System.out.println("Para consultar información acerca de una materia del semestre actual deberá espcificarla");
        System.out.println("A continuación se elijen las opciones elija una");

        boolean flag = true;
        while (flag) {
            Periodo.showListNumeroMateria(periodo);
            int ans = Ask.forInt("el número de opción");
            switch (ans) {
                case 1:
                case 2:
                case 3:
                    Curso curso = periodo.getMateriasPeriodo().get(ans - 1);
                    System.out.println("--------------INFORMACIÓN DE LA MATERIA---------------");
                    System.out.println(curso);
                    flag = false;
                    break;
                default:
                    System.out.println("Se ingresó una opción inválida, ¿Desea intentarlo de nuevo?");
                    System.out.println("1. SI \n2. NO");
                    int option = Ask.forInt("una opción");
                    if (option != 1)
                        flag = false;
                    break;
            }
        }
    }

    public static void consultarHistorialCalficaciones() {
        Alumno alumno = (Alumno) UsuarioEnSesion.getInstancia().getUsuarioActual();
        String numeroControl = alumno.getNumeroControl();
        Historial historial = Sistema.historiales.get(CarreraActual.getInstancia().getCarreraActual())
                .get(numeroControl);
        if (historial.getPeriodos().size() == 1) {
            String periodoString = Coordinador.calcularUltimoPeriodo(CarreraActual.getInstancia().getCarreraActual(),
                    numeroControl);
            Periodo periodo = historial.getPeriodos().get(periodoString);
            System.out.println(
                    "Sólo ha cursado un semestre, por lo que su historial de calificaciones únicamente contiene la información del semestre actual");
            System.out.printf("-------------CALIFICACIONES DEL PERIODO %s-------------", periodoString);
            periodo.formatoCalificaciones();
        } else {
            while (true) {
                System.out.println("Deberá seleccionar de que periodo desea consultar información");
                historial.showListPeriodo();
                String nombrePeriodo = historial.getNombrePeriodo();
                if (nombrePeriodo == null) {
                    System.out.println("Se ingresó una opción inválida");
                    System.out.println("¿Desea intentarlo de nuevo?");
                    System.out.println("1. SI \n2. NO");
                    int ans = Ask.forInt("el número de opción: ");
                    if (ans != 1)
                        break;
                } else {
                    System.out.printf(
                            "-----------------HISTORIAL DE CALIFICACIONES DEL SEMESTRE %s---------------------",
                            nombrePeriodo);
                    Periodo periodo = Sistema.historiales.get(CarreraActual.getInstancia().getCarreraActual())
                            .get(numeroControl).getPeriodos().get(nombrePeriodo);
                    periodo.formatoCalificaciones();
                    break;
                }
            }
        }
    }
    /*
     * while (true) {
     * System.out.
     * println("Debe espcificar el periodo del cuál desea consultar información");
     * }
     * 
     * if
     * (Sistema.historiales.get(CarreraActual.getInstancia().getCarreraActual()).get
     * (numeroControl).getPeriodos().size() == 1) {
     * Alumno alumno = (Alumno)UsuarioEnSesion.getInstancia().getUsuarioActual();
     * String numeroControl = alumno.getNumeroControl();
     * System.out.
     * println("Usted está cursando su primer semestre, por lo que sólo cuenta con infomación del semestre actual"
     * );
     * int semestreActual =
     * Sistema.semestreActual.get(CarreraActual.getInstancia().getCarreraActual());
     * String periodoString = NumeroPeriodo.numerosPeriodo.get(semestreActual);
     * Periodo periodo =
     * Sistema.historiales.get(CarreraActual.getInstancia().getCarreraActual()).get(
     * numeroControl).getPeriodos().get(periodoString);
     * 
     * System.out.println(periodo);
     * }
     */

    private static String calcularUltimoPeriodo() {// ----Maybe borrar---
        Alumno alumno = (Alumno) UsuarioEnSesion.getInstancia().getUsuarioActual();
        String numeroControl = alumno.getNumeroControl();
        int numeroSemestre = Sistema.historiales.get(CarreraActual.getInstancia().getCarreraActual()).get(numeroControl)
                .getPeriodos().size();
        String periodoString = NumeroPeriodo.numerosPeriodo.get(numeroSemestre);
        return periodoString;
    }

    public static Alumno getAlumno(String nombreCarrera, String numeroControl) {
        Alumno alumno = null;
        for (Alumno alumnoActual : Sistema.alumnos.get(nombreCarrera)) {
            if (alumnoActual.getNumeroControl().equals(numeroControl)) {
                return alumnoActual;
            }
        }

        return alumno;
    }

    public static boolean validNumeroControl(String numeroControl, ArrayList<Alumno> alumnos) {
        for (Alumno alumno : alumnos) {
            if (alumno.getNumeroControl().equals(numeroControl)) {
                return true;
            }
        }
        return false;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    // MÉTODOS AUXILIARES-------------------------
    public static void showListNumeroControl() {
        System.out
                .println(
                        "\n----------------------------LISTA DE NÚMEROS DE CONTROL DE ALUMNOS-------------------------");
        for (Alumno alumno : Sistema.alumnos.get(CarreraActual.getInstancia().getCarreraActual())) {
            System.out.printf(
                    " | NOMBRE COMPLETO: %s | SEMESTRE ACTUAL: %s | GRUPO ACTUAL: %s | NÚMERO DE CONTROL: %s |",
                    alumno.getNombreCompleto(), alumno.getSemestre(), alumno.getGrupo(), alumno.getNumeroControl());
            System.out.println(
                    "\n--------------------------------------------------------------");
        }
    }

    private HashMap<String, Periodo> incializarHistorial() {
        HashMap<String, Periodo> historial = new HashMap<>();
        String cad = NombrePeriodo.AGOSTO_DICIEMBRE_2023.toString();
        historial.put(cad, new Periodo(getCursos(cad, getCarrera(), getSemestre(), getGrupo()), cad));
        return historial;
    }

    public static ArrayList<Curso> getCursos(String periodo, String carrera, String semestre, String grupo) {
        ArrayList<Curso> cursos = new ArrayList<>();
        ArrayList<Materia> materias = Materia.getListaMateriasFromString(carrera, semestre, grupo);
        for (int i = 0; i < 3; i++) {
            cursos.add(new Curso(periodo, materias.get(i)));
        }
        return cursos;
    }

    public static void actualizarEstatusPeriodo(String carrera, String numeroControl) {
        String periodo = Coordinador.calcularUltimoPeriodo(carrera, numeroControl);
        ArrayList<Curso> cursos = Sistema.historiales.get(carrera).get(numeroControl).getPeriodos().get(periodo)
                .getMateriasPeriodo();
        for (Curso curso : cursos) {
            if (curso.isCalificacionAsignada()) {
                if (curso.getCalificacionFinal() >= 70) {
                    Sistema.historiales.get(carrera).get(numeroControl).getPeriodos().get(periodo)
                            .setEstatus(EstatusPeriodo.APROBADO.toString());
                } else {
                    Sistema.historiales.get(carrera).get(numeroControl).getPeriodos().get(periodo)
                            .setEstatus(EstatusPeriodo.REPROBADO.toString());
                    break;
                }
            } else {
                Sistema.historiales.get(carrera).get(numeroControl).getPeriodos().get(periodo)
                        .setEstatus(EstatusPeriodo.CURSANDO.toString());
                break;
            }
        }
    }

    // --------------------------------------

    @Override
    public String toString() {
        String dato = String.format(
                "\n %s \n | SEMESTRE: %s | GRUPO: %s |", super.toString(), getSemestre(), getGrupo());
        return dato;

    }

}