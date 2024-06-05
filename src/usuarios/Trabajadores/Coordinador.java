package usuarios.Trabajadores;

import java.util.*;

import escuela.carreras.Carrera;
import escuela.grupos.Grupo;
import escuela.historiales.Historial;
import escuela.historiales.cursos.Curso;
import escuela.historiales.periodos.Periodo;
import escuela.historiales.periodos.utils.EstatusPeriodo;
import escuela.historiales.periodos.utils.NumeroPeriodo;
import escuela.materias.Materia;
import escuela.semestres.Semestre;
import sistema.Sistema;
import usuarios.Alumnos.Alumno;
import usuarios.Alumnos.Graduado;
import usuarios.utils.Rol;
import usuarios.utils.helpers.DatosComun;
import utils.*;

public class Coordinador extends Trabajador {
    private ArrayList<String> materiasImpartidas;

    public Coordinador(String nombre, String apellidoP, String apellidoM, String fechaDeNacimiento,
            String fechaRegistro, String direccion, String estado, String genero, String nombreUsuario,
            String contrasena,
            String carrera, double sueldo, ArrayList<String> materiasImpartidas) {// PARA CUANDO SE INCIALIZA EL
                                                                                  // PRGORAMA
        super(nombre, apellidoP, apellidoM, fechaDeNacimiento, fechaRegistro, direccion,
                estado, genero, nombreUsuario, contrasena, Rol.COORDINADOR, carrera, sueldo);
        this.materiasImpartidas = materiasImpartidas;
    }

    public static void apartadoAlumnos() {// ----------------LISTO
        boolean flag = true;
        while (flag) {
            System.out.println("\n-----------------APARTADO DE ALUMNOS-----------------");
            System.out.println("1. Registrar alumno");
            System.out.println("2. Eliminar un alumno");
            System.out.println("3. Mostrar lista  alumnos");
            System.out.println("4. Consultar información de un alumno");
            System.out.println("5. Modificar información de un alumno");
            System.out.println("6. Consultar la boleta de calificaciones de un alumno");
            // System.out.println("6. Consultar");
            System.out.println("7. Volver a menu anterior");
            int opcion = Ask.forInt("una opción: ");
            switch (opcion) {
                case 1 -> Alumno.registrar();// -----------LISTO
                case 2 -> Alumno.eliminar();// -----------LISTO
                case 3 -> Alumno.showList();// -----------LISTO
                case 4 -> Alumno.showInfo();// -----------LISTO
                case 5 -> Alumno.modificarInfo();// -----------LISTO
                case 6 -> Coordinador.showHistorialCalificacionesAlumno();// -----------LISTO
                case 7 -> {
                    flag = false;
                    System.out.println("Saliendo del sistema...");
                }
                default -> System.out.println("Se ingreso una opción inválida, intente de nuevo");
            }
        }
    }

    public static void apartadoProfesores() {
        int opcion = 0;
        boolean flag = true;

        while (flag) {
            System.out.println("\n-----------------APARTADO DE PROFESORES-----------------");
            System.out.println("1. Registrar profesor");// -----------LISTO
            System.out.println("2. Eliminar profesor");// -----------LISTO
            System.out.println("3. Mostrar lista de profesores");// -----------LISTO
            System.out.println("4. Consultar informacion de un profesor");// -----------LISTO
            System.out.println("5. Modificar la informacion de un profesor");// -----------LISTO
            System.out.println("6. Volver a menu anterior");
            opcion = Ask.forInt("una opcion");

            switch (opcion) {
                case 1 -> Profesor.registrar();// -----------LISTO
                case 2 -> Profesor.eliminar();// -----------LISTO
                case 3 -> Profesor.showList();// -----------LISTO
                case 4 -> Profesor.showInfo();// -----------LISTO
                case 5 -> Profesor.modificarInfo();// -----------LISTO
                case 6 -> {
                    flag = false;
                    System.out.println("Saliendo del sistema...");
                }
                default -> System.out.println("Se ingreso una opción inválida, intente de nuevo");
            }

        }

    }

    public static void apartadoDocente() {
        int opcion = 0;
        boolean flag = true;

        while (flag) {
            System.out.println("\n-----------------APARTADO DE DOCENTE-----------------");
            System.out.println("1. Ver mis grupos");// -----------LISTO
            System.out.println("2. Asignar calificaciones");// -----------LISTO
            System.out.println("3. Asignarme un grupo para darle clase");// -----------FASE DE PRUEBA
            System.out.println("4. Volver al menu anterior");
            opcion = Ask.forInt("una opcion");

            switch (opcion) {
                case 1 -> Coordinador.verGrupos();
                case 2 -> Coordinador.asignarCalificacion();
                case 3 -> Coordinador.autoAsignarGrupo();// SI SE PUEDE :))
                case 4 -> {
                    flag = false;
                    System.out.println("Saliendo del sistema...");
                }
                default -> System.out.println("Se ingreso una opción inválida, intente de nuevo");
            }

        }
    }

    public static void apartadoGrupos() {
        int opcion = 0;
        boolean flag = true;

        while (flag) {
            System.out.println("\n-----------------APARTADO GRUPOS-----------------");
            System.out.println("1. Cambiar alumno de grupo");// -----------LISTO
            System.out.println("2. Ver la lista de grupos");// -----------LISTO
            System.out.println("3. Consultar la información de un grupo");// -----------LISTO
            System.out.println("4. Avanzar a un grupo de semestre");// -------------FALTA PROBARLO----------------
            System.out.println("5. Volver al menu anterior");
            opcion = Ask.forInt("una opcion");

            switch (opcion) {
                case 1 -> Grupo.cambiarAlumnoGrupo();
                case 2 -> Grupo.showList();
                case 3 -> Grupo.showInfo();
                case 4 -> avanzarGrupoSemestre();
                case 5 -> {
                    flag = false;
                    System.out.println("Saliendo del sistema...");
                }
                default -> System.out.println("Se ingreso una opción inválida, intente de nuevo");
            }
        }
    }

    public static void apartadoMaterias() {
        int opcion = 0;
        boolean flag = true;

        while (flag) {
            System.out.println("\n--------------------APARTADO MATERIAS---------------------");
            System.out.println("1. Ver la lista de materias de la carrera");// -----------LISTO
            System.out.println("2. Consultar la información de una materia");// -----------LISTO
            System.out.println("3. Asignar profesor a una materia");// -----------LISTO
            System.out.println("4. Volver al menu anterior");
            opcion = Ask.forInt("una opcion");

            switch (opcion) {
                case 1 -> Materia.showList();
                case 2 -> Materia.showInfo();
                case 3 -> asignarMateriaProfesor();
                case 4 -> {
                    flag = false;
                    System.out.println("Saliendo del sistema...");
                }
                default -> System.out.println("Se ingreso una opción inválida, intente de nuevo");
            }

        }
    }

    public static void modificarInfoPersonal() {
        System.out.println("\n---------------MODIFICAR INFORMACION PERSONAL---------------");
        modificar();
    }

    private static void modificar() {
        boolean flag = true;
        while (flag) {
            System.out.println(
                    "\n¿QUÉ DESEA MODIFICAR?");
            System.out.println(
                    "1.NOMBRE  \n2.APELLIDO PATERNO \n3.APELLIDO MATERNO \n4.NOMBRE DE USUARIO  \n5.FECHA DE NACIMIENTO \n6.ESTADO \n7.GENERO \n8.DIRECCION \n9. Volver al menu principal ");
            int opcion = Ask.forInt("el número de opción");
            String nombreCarrera = CarreraActual.getInstancia().getCarreraActual();
            switch (opcion) {
                case 1 -> {
                    String nombre = Ask.forString("el nuevo nombre");
                    Sistema.coordinadores.get(nombreCarrera).setNombre(nombre);
                    System.out.println("Se actualizó el nombre");
                }
                case 2 -> {
                    String apellidoP = Ask.forString("el nuevo apellido paterno");
                    Sistema.coordinadores.get(nombreCarrera).setApellidoP(apellidoP);
                    System.out.println("Se actualizo el apellido paterno");
                }
                case 3 -> {
                    String apellidoM = Ask.forString("el nuevo apellido materno");
                    Sistema.coordinadores.get(nombreCarrera).setApellidoM(apellidoM);
                    System.out.println("Se actualizo el apellido materno");
                }
                case 4 -> {
                    String nombreUsuario = DatosComun.obtenerNombreUsuario();
                    Sistema.coordinadores.get(nombreCarrera).setNombreUsuario(nombreUsuario);
                    System.out.println("Se actualizo el nombre de usuario");
                }
                case 5 -> {
                    String fechaNacimiento = Fecha.askForDate("la nueva fecha de nacimiento");
                    Sistema.coordinadores.get(nombreCarrera).setFechaDeNacimiento(fechaNacimiento);
                    System.out.println("Se actualizo la fecha de nacimeinto");
                }
                case 6 -> {
                    String estado = DatosComun.elegirEstado().toString();
                    Sistema.coordinadores.get(nombreCarrera).setEstado(estado);
                    System.out.println("Se actualizo el estado");
                }
                case 7 -> {
                    String genero = DatosComun.elegirGenero().toString();
                    Sistema.coordinadores.get(nombreCarrera).setGenero(genero);
                    System.out.println("Se actualizo el genero");
                }
                case 8 -> {
                    String direccion = Ask.forString("la direccion nueva");
                    Sistema.coordinadores.get(nombreCarrera).setDireccion(direccion);
                    System.out.println("Se actualizo la direccion");
                }
                case 9 -> {
                    System.out.println("Volviendo al menu principal...");
                    flag = false;
                }
                default -> System.out.println("Opcion invalida, vuelva a intentarlo");
            }
            Sistema.guardarEnJson();
            consultarInfo();
            System.out.println("¿Desea seguir modificando la información?");
            System.out.println("1. SI \n2. NO");
            if (Ask.forInt("el número de opción") != 1)
                flag = false;
        }
    }

    public static void consultarInfo() {
        System.out.println("\n---------------INFORMACION PERSONAL---------------");
        Coordinador coordinador = (Coordinador) UsuarioEnSesion.getInstancia().getUsuarioActual();
        System.out.println(coordinador);

    }

    public boolean imparteMateria(String materia, Coordinador profesor) {
        for (String nombreMateria : profesor.getMateriasImpartidas()) {
            if (materia.equals(nombreMateria))
                return true;
        }
        return false;
    }

    public static void asignarCalificacion() {// hola
        Coordinador profesor = (Coordinador) UsuarioEnSesion.getInstancia().getUsuarioActual();
        ArrayList<String> listaMaterias = profesor.getMateriasImpartidas();
        System.out.println("Debemos obtener los datos de la materia y del alumno para poder asignarle su calificación");
        int ansOption = 0;
        String nombreMateria = "";

        while (true) {
            System.out.println("Ingrese el número de opción para la materia");
            int n = 1;
            for (String materia : listaMaterias) {
                System.out.printf("\n %d. %s", n, materia);
                n++;
            }
            ansOption = Ask.forInt("la opción numérica");
            if (ansOption >= 1 && ansOption <= listaMaterias.size()) {
                nombreMateria = listaMaterias.get(ansOption - 1);
                break;
            } else {
                System.out.println("Ingresó una opción inválida");
                System.out.println("¿Desea intentarlo de nuevo?");
                System.out.println("1. SI\n2. NO");
                int ans = Ask.forInt("una opción");
                if (ans != 1) {
                    break;
                }
            }
        }
        String nombreCarrera = "";
        if (!nombreMateria.equals("")) {
            System.out.println("Ahora seleccione una opción para la carrera");
            while (true) {
                System.out.println("Ingrese el número de opción para la carrera");
                for (int i = 1; i <= 3; i++) {
                    if (i == 1)
                        System.out.println("1. SISTEMAS");
                    else if (i == 2)
                        System.out.println("2. ELECTRONICA");
                    else
                        System.out.println("3. MATERIALES");
                }
                ansOption = Ask.forInt("la opción numérica");
                if (ansOption >= 1 && ansOption <= 3) {
                    switch (ansOption) {
                        case 1 -> nombreCarrera = "SISTEMAS";
                        case 2 -> nombreCarrera = "ELECTRONICA";
                        case 3 -> nombreCarrera = "MATERIALES";
                    }
                    break;
                } else {
                    System.out.println("Ingresó una opción inválida");
                    System.out.println("¿Desea intentarlo de nuevo?");
                    System.out.println("1. SI\n2. NO");
                    int ans = Ask.forInt("una opción: ");
                    if (ans != 1) {
                        break;
                    }
                }
            }
        }
        // sino aqui se acaba
        String numeroControl = "";
        if (!nombreCarrera.equals("")) {
            if (Sistema.carreras.get(nombreCarrera).getMaterias().containsKey(nombreMateria)) {
                boolean flag = false;
                HashMap<String, Grupo> gruposProfesor = new HashMap<>();
                // verificar que realmente imparta la materia
                for (Materia materia : Sistema.carreras.get(nombreCarrera).getMaterias().get(nombreMateria)) {
                    if (materia.getProfesor().getNumeroControl().equals(profesor.getNumeroControl())) {
                        // aqui aseguramos que la imparte
                        Grupo grupo = Grupo.getGrupo(nombreCarrera, materia);
                        gruposProfesor.put(materia.getId(), grupo);// si hay 2 aquí tendrían la misma key, cuidado con
                                                                   // eso
                        flag = true;
                    }
                }
                if (flag) {
                    if (gruposProfesor.size() == 1) {// SOLO UN GRUPO
                        System.out.println("Usted sólo cuenta con un grupo");

                        Set<String> claves = gruposProfesor.keySet();
                        String keyMapa = "";
                        for (String string : claves) {
                            keyMapa = string;
                        }
                        if (gruposProfesor.get(keyMapa).getAlumnosGrupo().isEmpty()) {
                            System.out.println("No hay alumnos registrados en el grupo");
                        } else {
                            while (true) {
                                System.out.println("Aquí está la lista de números de control para este grupo");
                                for (Alumno alumno : gruposProfesor.get(keyMapa).getAlumnosGrupo()) {
                                    System.out.printf(" | NOMBRE DEL ALUMNO: %s | NÚMERO DE CONTROL DEL ALUMNO: %s |",
                                            alumno.getNombreCompleto(), alumno.getNumeroControl());
                                }
                                System.out.println("\nAhora debe ingresar el número de control del alumno");
                                numeroControl = Ask.forString("el número de control del alumno");
                                if (Alumno.getAlumno(nombreCarrera, numeroControl) == null) {
                                    System.out.println("No se encontró al alumno, ¿desea intentarlo de nuevo?");
                                    System.out.println("1. SI\n 2. NO");
                                    int ans = Ask.forInt("una opción: ");
                                    if (ans != 1) {
                                        numeroControl = "";
                                        break;
                                    }
                                } else
                                    break;
                            }
                        }

                    } else {
                        // debe elegir primero la key si grupo A o grupo B
                        System.out.println("Usted imparte esta materia a más de un grupo, elija el grupo");
                        String keyMapa = "";
                        boolean bandera = true;
                        while (bandera) {// obtenemos la key
                            System.out.println("Elija una opción");
                            for (int i = 0; i < 2; i++) {
                                if (i == 0)
                                    System.out.println((i + 1) + ". GRUPO A");
                                else if (i == 1)
                                    System.out.println((i + 1) + ". GRUPO B");
                            }
                            int ans = Ask.forInt("el número de opción: ");
                            if (ans >= 1 && ans <= 2) {
                                Set<String> claves = gruposProfesor.keySet();
                                int n = 1;// para los alumnos
                                for (String string : claves) {
                                    if (n == ans) {
                                        keyMapa = string;
                                        bandera = false;
                                        break;
                                    } else {
                                        n++;
                                    }
                                }
                            } else {
                                System.out.println("Opción inválida trate de nuevo");
                            }
                        }

                        // obtener la key con un fori
                        if (gruposProfesor.get(keyMapa).getAlumnosGrupo().isEmpty()) {
                            System.out.println("Este grupo no tiene alumnos registrados");
                        } else {
                            System.out.println("Aquí está la lista de números de control para este grupo");
                            while (true) {
                                for (Alumno alumno : gruposProfesor.get(keyMapa).getAlumnosGrupo()) {
                                    System.out.printf(" | NOMBRE DEL ALUMNO: %s | NÚMERO DE CONTROL DEL ALUMNO: %s |",
                                            alumno.getNombreCompleto(), alumno.getNumeroControl());
                                }
                                System.out.println("\nAhora debe ingresar el número de control del alumno");
                                numeroControl = Ask.forString("el número de control del alumno");
                                if (Alumno.getAlumno(nombreCarrera, numeroControl) == null) {
                                    System.out.println("No se encontró al alumno, ¿desea intentarlo de nuevo?");
                                    System.out.println("1. SI\n 2. NO");
                                    int ans = Ask.forInt("una opción: ");
                                    if (ans != 1) {
                                        numeroControl = "";
                                        break;
                                    }
                                } else
                                    break;
                            }
                        }
                    }
                } else {
                    System.out.println("No se econtró ningún grupo que lo tenga a usted asignado como profesor");
                }
            } else {
                System.out.println("La carrera que ingresó no cuenta con esta materia");
            }
        }
        if (!numeroControl.equals("")) {
            System.out.println("\nAhora debe ingresar la calificación del alumno");
            while (true) {
                double calificacion = Ask.forDouble("la calificación: ");
                if (calificacion >= 0 && calificacion <= 100) {
                    String periodoActual = NumeroPeriodo.numerosPeriodo.get(Sistema.semestreActual.get(nombreCarrera));
                    for (Curso curso : Sistema.historiales.get(nombreCarrera).get(numeroControl).getPeriodos()
                            .get(periodoActual).getMateriasPeriodo()) {
                        if (curso.getMateria().getNombre().equals(nombreMateria)) {
                            int indexCurso = Sistema.historiales.get(nombreCarrera).get(numeroControl).getPeriodos()
                                    .get(periodoActual).getMateriasPeriodo().indexOf(curso);
                            Sistema.historiales.get(nombreCarrera).get(numeroControl).getPeriodos()
                                    .get(periodoActual).getMateriasPeriodo().get(indexCurso)
                                    .setCalificacionAsignada(true);
                            Sistema.historiales.get(nombreCarrera).get(numeroControl).getPeriodos()
                                    .get(periodoActual).getMateriasPeriodo().get(indexCurso)
                                    .setCalificacionFinal(calificacion);
                            curso.setCalificacionFinal(calificacion);
                            curso.setCalificacionAsignada(true);
                            System.out.println("Se asignó la calificación!");
                            break;
                        }
                    }

                    break;
                } else {
                    System.out.println("Ingresó un valor inválido para la calificación");
                    System.out.println("¿Desea intentarlo de nuevo?");
                    System.out.println("1. SI\n2. NO");
                    int ans = Ask.forInt("una opción");
                    if (ans != 1)
                        break;

                }
            }

        }
    }

    public static void verGrupos() {// Reciclar lógica del de asignar
        // para que un profesor pueda ver todos sus grupos
        Map<String, Grupo> gruposProfesor = new LinkedHashMap<>();// en la key va el nombre de la materia CALCULO1
        ArrayList<String> listaNombreMateria = new ArrayList<>();
        Coordinador profesor = (Coordinador) UsuarioEnSesion.getInstancia().getUsuarioActual();
        // ver en los grupos de todas las carreras
        for (Carrera carrera : Sistema.carreras.values()) {
            for (Semestre semestre : carrera.getSemestres().values()) {
                for (Grupo grupo : semestre.getGrupos().values()) {
                    for (Materia materia : grupo.getMateriasGrupo()) {
                        if (materia.getProfesor().getNumeroControl().equals(profesor.getNumeroControl())) {
                            gruposProfesor.put(grupo.getIDgrupo(), grupo);
                            listaNombreMateria.add(materia.getNombre());
                        }
                    }
                }
            }
        }
        if (gruposProfesor.isEmpty()) {
            System.out.println("Usted no tiene ningún grupo asignado");
        } else {
            if (gruposProfesor.size() == 1) {
                Set<String> set = gruposProfesor.keySet();
                String idGrupo = "";
                for (String string : set) {
                    idGrupo = string;
                }
                System.out.println("Usted cuenta únicamente con un grupo");
                System.out.println("Esta es la información del grupo");
                System.out.println("-----------------INFORMACIÓN DEL GRUPO-----------------------");
                System.out.printf("\n| MATERIA QUE IMPARTE AL GRUPO: %s | ", listaNombreMateria.get(0));
                Grupo grupo = gruposProfesor.get(idGrupo);
                System.out.println(grupo);
                if (!grupo.getAlumnosGrupo().isEmpty()) {
                    System.out.println("¿Desea ver la lista de alumnos del grupo?");
                    System.out.println("1. SI\n2. NO");
                    int ans = Ask.forInt("una opción");
                    if (ans == 1) {
                        System.out.println(
                                "--------------------LISTA DE ALUMNOS DE SU GRUPO------------------------------");
                        for (Alumno alumno : grupo.getAlumnosGrupo()) {
                            System.out.println(alumno);
                        }
                    }
                }
                // desea ver la lista de alumnos?? sino es 0 claro
            } else {
                System.out.println(
                        "Usted cuenta con varios grupos, elija cual es el grupo del cual desea ver información");
                while (true) {
                    int n = 0;
                    for (Grupo grupo : gruposProfesor.values()) {
                        System.out.printf("\n%d. | CARRERA: %s | TIPO DE GRUPO: %s | MATERIA: %s |", (n + 1),
                                grupo.getCarrera(), grupo.getTipoGrupo(), listaNombreMateria.get(n));
                        n++;
                    }
                    System.out.println("\nSeleccione el número del grupo del cual desea consultar información");
                    int ans = Ask.forInt("una opción");
                    if (ans >= 1 && ans <= gruposProfesor.size()) {
                        Set<String> claves = gruposProfesor.keySet();
                        int k = 1;
                        String nombreClave = "";
                        for (String string : claves) {
                            if (k == ans) {
                                nombreClave = string;
                                break;
                            } else {
                                k++;
                            }
                        }
                        Grupo grupo = gruposProfesor.get(nombreClave);
                        System.out.println("----------------------INFORMACION DEL GRUPO---------------------");
                        System.out.println(grupo);
                        if (!grupo.getAlumnosGrupo().isEmpty()) {
                            System.out.println("¿Desea ver la lista de alumnos del grupo?");
                            System.out.println("1. SI\n2. NO");
                            int option = Ask.forInt("una opción");
                            if (option == 1) {
                                System.out.println(
                                        "--------------------LISTA DE ALUMNOS DE SU GRUPO------------------------------");
                                for (Alumno alumno : grupo.getAlumnosGrupo()) {
                                    System.out.println(alumno);
                                }
                            }
                        }
                        break;
                    } else {
                        System.out.println("Se ingresó una opción inválida, ¿desea intentarlo de nuevo?");
                        System.out.println("1. SI\n2. NO");
                        int ansOption = Ask.forInt("una opción");
                        if (ansOption != 1)
                            break;
                    }
                }
            }
        }
    }

    public static void autoAsignarGrupo() {
        String carrera = CarreraActual.getInstancia().getCarreraActual();
        Coordinador profesor = (Coordinador) UsuarioEnSesion.getInstancia().getUsuarioActual();
        ArrayList<String> listaMaterias = profesor.getMateriasImpartidas();
        System.out.println(" ---------------- AUTO-ASIGNAR MATERIA DE UN GRUPO COMO COORDINADOR ----------------");
        System.out.println("Ahora debe seleccionar la materia que desea asignarle al grupo");
        String materiaSeleccionada = "";
        while (true) {
            materiaSeleccionada = "";
            System.out.println("Materias que imparte el profesor");
            int n = 1;
            for (String string : profesor.getMateriasImpartidas()) {
                System.out.printf("\n %d. | %s |", n, string);
                n++;
            }
            System.out.println("\nIngrese el número de materia para seleccionar");
            int ans = Ask.forInt("una opción");
            if (ans >= 1 && ans <= listaMaterias.size()) {
                materiaSeleccionada = listaMaterias.get(ans - 1);
                break;
            } else {
                System.out.println("Se ingresó una opción inválida, desea intentar de nuevo??");
                System.out.println("1. SI\n2. NO");
                if (Ask.forInt("una opción") != 1) {
                    break;
                }
            }
        }
        if (!materiaSeleccionada.equals("")) {
            // obtener los grupos de la carrera que tengan esta materia
            ArrayList<Grupo> gruposConMateria = new ArrayList<>();
            int i = 0;
            boolean flag = true;
            Set<String> semestreSet = Sistema.carreras.get(carrera).getSemestres().keySet();
            List<String> myList = new ArrayList<>(semestreSet);
            for (Semestre semestre : Sistema.carreras.get(carrera).getSemestres().values()) {
                for (Grupo grupo : semestre.getGrupos().values()) {// Grupo A y grupo B

                    for (Materia materiaActual : grupo.getMateriasGrupo()) {
                        if (materiaActual.getNombre().equals(materiaSeleccionada)) {
                            gruposConMateria.add(grupo);// agrega grupo A y grupo B
                            flag = false;
                        }
                    }
                }
                if (!flag)
                    break;
                else
                    i++;
            }
            String semestreString = myList.get(i);

            System.out.printf("\nSe han encontrado %d grupos que llevan esta materia", gruposConMateria.size());
            System.out.println("Ahora seleccione cual es el grupo al cual desea asignar este profesor");
            while (true) {
                int m = 1;
                for (Grupo grupo : gruposConMateria) {
                    System.out.printf("\n %d. | TIPO DE GRUPO: %s | ID GRUPO: %s | ", m, grupo.getTipoGrupo(),
                            grupo.getIDgrupo());
                    m++;
                }
                System.out.println("\nSeleccione el NUMERO de opción");
                int ans = Ask.forInt("una opción");
                if (ans >= 1 && ans <= gruposConMateria.size()) {
                    Grupo grupoAux = gruposConMateria.get(ans - 1);
                    String tipoGrupoAux = grupoAux.getTipoGrupo();
                    // fk me falta el semestre
                    int indexMateriaGrupo = 0;
                    for (Materia materia : Sistema.carreras.get(carrera).getSemestres().get(semestreString).getGrupos()
                            .get(tipoGrupoAux).getMateriasGrupo()) {
                        if (materia.getNombre().equals(materiaSeleccionada)) {
                            break;
                        } else {
                            indexMateriaGrupo++;
                        }
                    }
                    // afectar en Sistema.grupos.getMaterias
                    Sistema.carreras.get(carrera).getSemestres().get(semestreString).getGrupos().get(tipoGrupoAux)
                            .getMateriasGrupo().get(indexMateriaGrupo).setProfesor(profesor);
                    // afectar en Sistema.materias
                    if (tipoGrupoAux.equals("A")) {
                        Sistema.carreras.get(carrera).getMaterias().get(materiaSeleccionada).get(0);
                    } else {
                        Sistema.carreras.get(carrera).getMaterias().get(materiaSeleccionada).get(1);
                    }
                    System.out.printf("Se le ha asignado al profesor la materia %s en el grupo %s de la carrera de %s",
                            materiaSeleccionada, tipoGrupoAux, carrera);
                    Sistema.guardarEnJson();
                    break;
                } else {
                    System.out.println("Ingresó una opción inválida");
                    System.out.println("1. SI\n 2. NO");
                    if (Ask.forInt("una opción") != 1) {
                        break;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        String cad = "";
        cad += String.format("\n%s", super.toString());
        cad += "\n ---------------MATERIAS IMPARTIDAS POR EL COORDINADOR---------------\n";

        for (String materia : getMateriasImpartidas()) {
            cad += String.format("%s\n", materia);
        }
        return cad;
    }

    public ArrayList<String> getMateriasImpartidas() {
        return materiasImpartidas;
    }

    public void setMateriasImpartidas(ArrayList<String> materiasImpartidas) {
        this.materiasImpartidas = materiasImpartidas;
    }

    public static void showHistorialCalificacionesAlumno() {
        String carrera = CarreraActual.getInstancia().getCarreraActual();
        if (Sistema.alumnos.get(carrera).isEmpty()) {
            System.out.println("No hay alumnos registrados");
        } else {
            while (true) {
                Alumno.showListNumeroControl();
                String numeroControl = Ask.forString("un número de control");
                if (Sistema.historiales.get(carrera).containsKey(numeroControl)) {
                    Historial historial = Sistema.historiales.get(carrera).get(numeroControl);
                    if (historial.getPeriodos().size() == 1) {
                        System.out.println("Este alumno está cursando su primer semestre");
                        System.out.println("Aquí está su información hasta el momento");
                        String periodoActual = Coordinador.calcularUltimoPeriodo(carrera, numeroControl);
                        Periodo periodoPrint = Sistema.historiales.get(carrera).get(numeroControl).getPeriodos().get(periodoActual);
                        periodoPrint.formatoCalificaciones();
                        break;
                    }
                    else{
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
                        break;
                    }  
                } 
                else {
                    System.out.println("Se ingresó un número de control inválido");
                    System.out.println("¿Desea intentar de nuevo?");
                    System.out.println("1. SI\n2. NO");
                    if (Ask.forInt("una opción") != 1)
                        break;
                }
            }
        }
    }

    public static void asignarMateriaProfesor() {// -----FASE DE PRUEBA------
        String carrera = CarreraActual.getInstancia().getCarreraActual();
        System.out.println(" ------------- ASIGNAR MATERIA DE UN GRUPO A UN PROFESOR -------------");
        Profesor.showListNumeroControl();
        String numeroControl = Ask.forString("el numero de control de profesor");
        Profesor profesor = Profesor.getProfesor(numeroControl);
        if (profesor != null) {
            ArrayList<String> listaMaterias = profesor.getMateriasImpartidas();
            if (listaMaterias.size() == 1) {
                System.out.printf("\nEste profesor sólo imparte una materia : | %s |", listaMaterias.get(0));
                String materiaSeleccionada = listaMaterias.get(0);

                if (Sistema.carreras.get(carrera).getMaterias().containsKey(materiaSeleccionada)) {
                    ArrayList<Grupo> gruposConMateria = new ArrayList<>();
                    int i = 0;
                    boolean flag = true;
                    Set<String> semestreSet = Sistema.carreras.get(carrera).getSemestres().keySet();
                    List<String> myList = new ArrayList<>(semestreSet);
                    for (Semestre semestre : Sistema.carreras.get(carrera).getSemestres().values()) {
                        for (Grupo grupo : semestre.getGrupos().values()) {
                            for (Materia materiaActual : grupo.getMateriasGrupo()) {
                                if (materiaActual.getNombre().equals(materiaSeleccionada)) {
                                    gruposConMateria.add(grupo);
                                    flag = false;
                                }
                            }
                        }
                        if (!flag)
                            break;
                        else
                            i++;
                    }
                    String semestreString = myList.get(i);

                    System.out.printf("\nSe han encontrado %d grupos que llevan esta materia", gruposConMateria.size());
                    System.out.println("Ahora seleccione cual es el grupo al cual desea asignar este profesor");
                    while (true) {
                        int m = 1;
                        for (Grupo grupo : gruposConMateria) {
                            System.out.printf("\n %d. | TIPO DE GRUPO: %s | ID GRUPO: %s | ", m, grupo.getTipoGrupo(),
                                    grupo.getIDgrupo());
                            m++;
                        }
                        System.out.println("\nSeleccione el NUMERO de opción");
                        int ans = Ask.forInt("una opción");
                        if (ans >= 1 && ans <= gruposConMateria.size()) {
                            Grupo grupoAux = gruposConMateria.get(ans - 1);
                            String tipoGrupoAux = grupoAux.getTipoGrupo();
                            // fk me falta el semestre
                            int indexMateriaGrupo = 0;
                            for (Materia materia : Sistema.carreras.get(carrera).getSemestres().get(semestreString)
                                    .getGrupos().get(tipoGrupoAux).getMateriasGrupo()) {
                                if (materia.getNombre().equals(materiaSeleccionada)) {
                                    break;
                                } else {
                                    indexMateriaGrupo++;
                                }
                            }
                            // afectar en Sistema.grupos.getMaterias
                            Sistema.carreras.get(carrera).getSemestres().get(semestreString).getGrupos()
                                    .get(tipoGrupoAux).getMateriasGrupo().get(indexMateriaGrupo).setProfesor(profesor);
                            // afectar en Sistema.materias
                            if (tipoGrupoAux.equals("A")) {
                                Sistema.carreras.get(carrera).getMaterias().get(materiaSeleccionada).get(0);
                            } else {
                                Sistema.carreras.get(carrera).getMaterias().get(materiaSeleccionada).get(1);
                            }
                            System.out.printf(
                                    "Se le ha asignado al profesor la materia %s en el grupo %s de la carrera de %s",
                                    materiaSeleccionada, tipoGrupoAux, carrera);
                            Sistema.guardarEnJson();
                            break;
                        } else {
                            System.out.println("Ingresó una opción inválida");
                            System.out.println("1. SI\n 2. NO");
                            if (Ask.forInt("una opción") != 1) {
                                break;
                            }
                        }
                    }
                } else {
                    System.out.println(
                            "La materia seleccionada no está incluida en el plan de estudios de la carrera a la cual pertenece el coordinador");
                    System.out.println("Este sólo puede asignar profesores a materias de su carrera");
                }

            } else {
                System.out.println("Ahora debe seleccionar la materia que desea asignarle al grupo");
                String materiaSeleccionada = "";
                while (true) {
                    materiaSeleccionada = "";
                    System.out.println("Materias que imparte el profesor");
                    int n = 1;
                    for (String string : profesor.getMateriasImpartidas()) {
                        System.out.printf("\n %d. | %s |", n, string);
                        n++;
                    }
                    System.out.println("\nIngrese el número de materia para seleccionar");
                    int ans = Ask.forInt("una opción");
                    if (ans >= 1 && ans <= listaMaterias.size()) {
                        materiaSeleccionada = listaMaterias.get(ans - 1);
                        break;
                    } else {
                        System.out.println("Se ingresó una opción inválida, desea intentar de nuevo??");
                        System.out.println("1. SI\n2. NO");
                        if (Ask.forInt("una opción") != 1) {
                            break;
                        }
                    }
                }
                if (!materiaSeleccionada.equals("")) {
                    if (Sistema.carreras.get(carrera).getMaterias().containsKey(materiaSeleccionada)) {
                        // obtener los grupos de la carrera que tengan esta materia
                        ArrayList<Grupo> gruposConMateria = new ArrayList<>();

                        int i = 0;
                        boolean flag = true;
                        Set<String> semestreSet = Sistema.carreras.get(carrera).getSemestres().keySet();
                        List<String> myList = new ArrayList<>(semestreSet);
                        for (Semestre semestre : Sistema.carreras.get(carrera).getSemestres().values()) {
                            for (Grupo grupo : semestre.getGrupos().values()) {// Grupo A y grupo B

                                for (Materia materiaActual : grupo.getMateriasGrupo()) {
                                    if (materiaActual.getNombre().equals(materiaSeleccionada)) {
                                        gruposConMateria.add(grupo);// agrega grupo A y grupo B
                                        flag = false;
                                    }
                                }
                            }
                            if (!flag)
                                break;
                            else
                                i++;

                        }
                        String semestreString = myList.get(i);

                        System.out.printf("\nSe han encontrado %d grupos que llevan esta materia",
                                gruposConMateria.size());
                        System.out.println("Ahora seleccione cual es el grupo al cual desea asignar este profesor");
                        while (true) {
                            int m = 1;
                            for (Grupo grupo : gruposConMateria) {
                                System.out.printf("\n %d. | TIPO DE GRUPO: %s | ID GRUPO: %s | ", m,
                                        grupo.getTipoGrupo(), grupo.getIDgrupo());
                                m++;
                            }
                            System.out.println("\nSeleccione el NUMERO de opción");
                            int ans = Ask.forInt("una opción");
                            if (ans >= 1 && ans <= gruposConMateria.size()) {
                                Grupo grupoAux = gruposConMateria.get(ans - 1);
                                String tipoGrupoAux = grupoAux.getTipoGrupo();
                                // fk me falta el semestre
                                int indexMateriaGrupo = 0;
                                for (Materia materia : Sistema.carreras.get(carrera).getSemestres().get(semestreString)
                                        .getGrupos().get(tipoGrupoAux).getMateriasGrupo()) {
                                    if (materia.getNombre().equals(materiaSeleccionada)) {
                                        break;
                                    } else {
                                        indexMateriaGrupo++;
                                    }
                                }
                                // afectar en Sistema.grupos.getMaterias
                                Sistema.carreras.get(carrera).getSemestres().get(semestreString).getGrupos()
                                        .get(tipoGrupoAux).getMateriasGrupo().get(indexMateriaGrupo)
                                        .setProfesor(profesor);
                                // afectar en Sistema.materias
                                if (tipoGrupoAux.equals("A")) {
                                    Sistema.carreras.get(carrera).getMaterias().get(materiaSeleccionada).get(0);
                                } else {
                                    Sistema.carreras.get(carrera).getMaterias().get(materiaSeleccionada).get(1);
                                }
                                System.out.printf(
                                        "Se le ha asignado al profesor la materia %s en el grupo %s de la carrera de %s",
                                        materiaSeleccionada, tipoGrupoAux, carrera);
                                Sistema.guardarEnJson();
                                break;
                            } else {
                                System.out.println("Ingresó una opción inválida");
                                System.out.println("1. SI\n 2. NO");
                                if (Ask.forInt("una opción") != 1) {
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println(
                                "La materia seleccionada no está incluida en el plan de estudios de la carrera a la cual pertenece el coordinador");
                        System.out.println("Este sólo puede asignar profesores a materias de su carrera");
                    }
                }
            }

        } else {
            System.out.println("No se encontro un profesor con ese número de control");
        }
    }

    public static void mostrarInfoCarrera() {
        System.out.printf("\n----------- INFORMACION DE LA CARRERA DE %s -----------\n",
                UsuarioEnSesion.getInstancia().getUsuarioActual().getCarrera());
        System.out.println(Sistema.carreras.get(UsuarioEnSesion.getInstancia().getUsuarioActual().getCarrera()));
    }

    public static void listaGraduados() {
        if (Sistema.graduados.get(UsuarioEnSesion.getInstancia().getUsuarioActual().getCarrera()).isEmpty()) {
            System.out.println("No hay alumnos graduados en la carrera de "
                    + UsuarioEnSesion.getInstancia().getUsuarioActual().getCarrera());
        } else {
            System.out.printf("\n-------------------- ALUMNOS GRADUADOS DE %S --------------------\n",
                    UsuarioEnSesion.getInstancia().getUsuarioActual().getCarrera());
            int i = 0;
            for (Graduado graduado : Sistema.graduados
                    .get(UsuarioEnSesion.getInstancia().getUsuarioActual().getCarrera())) {
                i++;
                System.out.printf("\n%d. Nombre: %s\n   Número de control: %s\n", i, graduado.getNombreCompleto(),
                        graduado.getNumeroControl());
            }
        }
    }

    public static void avanzarGrupoSemestre() {
        System.out.println("1. Primero \n2. Segundo \n3. Tercero");
        String semestre = DatosComun.elegirSemestre();
        String carrera = CarreraActual.getInstancia().getCarreraActual();
        // Obtener al grupo
        // Pedimos el semestre
        // Pedimos el grupo
        if (semestre.equals("TERCERO")) {
            String grupoString = Grupo.preguntarGrupo();// pedir el grupo si A o B
            Grupo grupo = Sistema.carreras.get(carrera).getSemestres().get(semestre).getGrupos().get(grupoString);
            if (grupo.getAlumnosGrupo().size() < 3) {
                System.out.println("El grupo no tiene más de 3 estudiantes, por lo que no puede avanzar");
            } else {
                if (verificarCalificacionesAsignadas(carrera, grupo.getAlumnosGrupo())) { // regresa true si todos
                    ArrayList<Alumno> graduados = new ArrayList<>();
                    ArrayList<Alumno> reprobados = new ArrayList<>();
                    ArrayList<String> listaNumeroControl = new ArrayList<>();
                    String periodoActual = calcularUltimoPeriodo(carrera, grupo.getAlumnosGrupo().get(0).getNumeroControl());
                    String nuevoPeriodo = getPeriodoSiguiente(periodoActual);
                    Sistema.carreras.get(carrera).getSemestres().get(semestre).getGrupos().get(grupoString).setPeriodo(nuevoPeriodo);

                    for (Alumno alumnoActual : Sistema.carreras.get(carrera).getSemestres().get(semestre).getGrupos().get(grupoString).getAlumnosGrupo()) { // filtro artesanal
                        String numeroControl = alumnoActual.getNumeroControl();
                        Periodo periodo = Historial.getHistorial(carrera, numeroControl).getPeriodos().get(calcularUltimoPeriodo(carrera, numeroControl));
                        if (periodo.getEstatus().equals(EstatusPeriodo.APROBADO.toString())) { // cambiar esta condición
                            graduados.add(alumnoActual); // cambiar??
                            listaNumeroControl.add(alumnoActual.getNumeroControl());
                            // Ponerle el periodo y las nuevas materias
                        } else {
                            reprobados.add(alumnoActual);
                            // Les resetea a los reprobados, sólo les cambia el nombre del periodo
                            Sistema.historiales.get(carrera).put(alumnoActual.getNumeroControl(), new Historial(numeroControl, nuevoPeriodo));
                            // Solo cambiarle el periodo
                        }
                    }

                    // Usar un Iterator para eliminar de manera segura
                    Iterator<Alumno> iterator = Sistema.alumnos.get(carrera).iterator();
                    while (iterator.hasNext()) {
                        Alumno alumno = iterator.next();
                        if (listaNumeroControl.contains(alumno.getNumeroControl())) {
                            iterator.remove(); // Usar el iterador para eliminar de la lista
                        }
                    }

                    for (Alumno aprobado : graduados) {
                        double promedioFinal = calcularPromedioFinal(carrera, aprobado.getNumeroControl());
                        String periodoGraduado = calcularUltimoPeriodo(carrera, aprobado.getNumeroControl());
                        Sistema.graduados.get(carrera).add(new Graduado(aprobado.getNombre(), aprobado.getApellidoP(), aprobado.getApellidoM(),
                                aprobado.getFechaDeNacimiento(), aprobado.getFechaDeRegistro(), aprobado.getDireccion(), aprobado.getEstado(),
                                aprobado.getGenero(), aprobado.getNombreUsuario(), aprobado.getContrasena(), aprobado.getCarrera(),
                                aprobado.getSemestre(), aprobado.getGrupo(), promedioFinal, periodoGraduado));
                    }
                    System.out.println("--------------LISTA DE ALUMNOS GRADUADOS-----------------");
                    if (graduados.isEmpty()) {
                        System.out.println("No hubo alumnos graduados en este semestre :(");
                    }
                    else{
                        for (Alumno alumno : graduados) {
                            System.out.printf("\n | NOMBRE COMPLETO: %s | NÚMERO DE CONTROL: %s | ",alumno.getNombre(), alumno.getNumeroControl());
                        }
                    }
                    System.out.println("--------------LISTA DE ALUMNOS REPROBADOS-----------------");
                    if (reprobados.isEmpty()) {
                        System.out.println("No hubo alumnos reprobados en este semestre :)");
                    }
                    else{
                        for (Alumno alumno : reprobados) {
                            System.out.printf("\n | NOMBRE COMPLETO: %s | NÚMERO DE CONTROL: %s | ",alumno.getNombre(), alumno.getNumeroControl());
                        }
                    }

                    Sistema.guardarEnJson();
                    System.out.println("Se avanzó al grupo de forma exitosa!");
                    
                } else {
                    System.out.println(
                            "Para avanzar de semestre a un grupo todos sus estudiantes deben tener sus calificación final del periodo asingada");
                    System.out.println("Se ha encontrado al menos un alumno que no la tiene");
                    System.out.println("Consulte con los profesores de la carrera para obtener más información");
                }
            }
            // condiciones....
            System.out.println("Felicidades, te has graduado");

        } else {
            String grupoString = Grupo.preguntarGrupo(); // A o B
            Grupo grupo = Sistema.carreras.get(carrera).getSemestres().get(semestre).getGrupos().get(grupoString);
            if (grupo.getAlumnosGrupo().size() < 3) {
                System.out.println("El grupo no tiene más de 3 estudiantes, por lo que no puede avanzar");
            }

            else {// Más de 3 alumnos
                if (verificarCalificacionesAsignadas(carrera, grupo.getAlumnosGrupo())) { // regresa true si todos
                                                                                          // tienen su calificación
                                                                                          // asignada
                    ArrayList<Alumno> aprobados = new ArrayList<>();
                    ArrayList<Alumno> reprobados = new ArrayList<>();
                    String periodoActual = calcularUltimoPeriodo(carrera,
                            grupo.getAlumnosGrupo().get(0).getNumeroControl());
                    String nuevoPeriodo = getPeriodoSiguiente(periodoActual);
                    Sistema.carreras.get(carrera).getSemestres().get(semestre).getGrupos().get(grupoString)
                            .setPeriodo(nuevoPeriodo);
                    ArrayList<Alumno> listaAlumnosAux = Sistema.carreras.get(carrera).getSemestres().get(semestre)
                            .getGrupos().get(grupoString).getAlumnosGrupo();
                    Iterator<Alumno> iterator = listaAlumnosAux.iterator();
                    while (iterator.hasNext()) {
                        Alumno alumnoActual = iterator.next();
                        String numeroControl = alumnoActual.getNumeroControl();
                        Periodo periodo = Historial.getHistorial(carrera, numeroControl).getPeriodos()
                                .get(calcularUltimoPeriodo(carrera, numeroControl));
                        if (periodo.getEstatus().equals(EstatusPeriodo.APROBADO.toString())) { // cambiar esta condición
                            aprobados.add(alumnoActual); // cambiar??
                            iterator.remove(); // Usar el iterador para eliminar de la lista
                        } else {
                            reprobados.add(alumnoActual);
                            // Les resetea a los reprobados, sólo les cambia el nombre del periodo
                            Sistema.historiales.get(carrera).get(alumnoActual.getNumeroControl()).getPeriodos().put(
                                    nuevoPeriodo,
                                    new Periodo(Historial.getCursos(nuevoPeriodo, carrera, semestre, grupoString),
                                            nuevoPeriodo));
                        }
                    }

                    ArrayList<Integer> posiciones = new ArrayList<>();
                    int k = 0;
                    for (Alumno alumno : aprobados) {
                        k = 0;
                        for (Alumno alumnoActual : Sistema.alumnos.get(carrera)) {
                            if (alumno.getNumeroControl().equals(alumnoActual.getNumeroControl())) {
                                posiciones.add(k);
                            } else {
                                k++;
                            }
                        }
                    }

                    for (Alumno alumno : aprobados) {
                        if (semestre.equals("PRIMERO")) {
                            alumno.setSemestre("SEGUNDO"); // PRIMER A SEGUNDO
                            // Aventarlos a grupos de segundo
                        } else {
                            alumno.setSemestre("TERCERO");
                        }
                        alumno.setGrupo(asignarGrupo(carrera, alumno.getSemestre()));
                    }

                    // Los devuelve a Sistema
                    for (int i = 0; i < aprobados.size(); i++) {
                        Sistema.alumnos.get(carrera).set(posiciones.get(i), aprobados.get(i));
                        Sistema.carreras.get(carrera).getSemestres().get(aprobados.get(i).getSemestre()).getGrupos()
                                .get(aprobados.get(i).getGrupo()).getAlumnosGrupo().add(aprobados.get(i));
                        Sistema.historiales.get(carrera).get(aprobados.get(i).getNumeroControl()).getPeriodos().put(
                                nuevoPeriodo,
                                new Periodo(
                                        Historial.getCursos(nuevoPeriodo, carrera, aprobados.get(i).getSemestre(),
                                                aprobados.get(i).getGrupo()),
                                        nuevoPeriodo));
                    } // lista de cursos
                    System.out.println("--------------LISTA DE ALUMNOS APROBADOS-----------------");
                    if (aprobados.isEmpty()) {
                        System.out.println("No hubo alumnos aprobados en este semestre :(");
                    }
                    else{
                        for (Alumno alumno : aprobados) {
                            System.out.printf("\n | NOMBRE COMPLETO: %s | NÚMERO DE CONTROL: %s | ",alumno.getNombre(), alumno.getNumeroControl());
                        }
                    }
                    System.out.println("--------------LISTA DE ALUMNOS REPROBADOS-----------------");
                    if (reprobados.isEmpty()) {
                        System.out.println("No hubo alumnos reprobados en este semestre :)");
                    }
                    else{
                        for (Alumno alumno : reprobados) {
                            System.out.printf("\n | NOMBRE COMPLETO: %s | NÚMERO DE CONTROL: %s | ",alumno.getNombre(), alumno.getNumeroControl());
                        }
                    }


                    Sistema.guardarEnJson();
                    System.out.println("Se avanzó al grupo de forma exitosa!");
                } else {
                    System.out.println(
                            "Para avanzar de semestre a un grupo todos sus estudiantes deben tener sus calificación final del periodo asingada");
                    System.out.println("Se ha encontrado al menos un alumno que no la tiene");
                    System.out.println("Consulte con los profesores de la carrera para obtener más información");
                }
            }

        }
        System.out.println("llamen a dios ");

    }

    private static String asignarGrupo(String carrera, String semestre) {
        String grupo = "A";
        if (Sistema.carreras.get(carrera).getSemestres().get(semestre).getGrupos().get(grupo).getAlumnosGrupo()
                .size() < 20) {
            grupo = "A";
        } else {
            grupo = "B";
        }
        return grupo;
    }// Aqui mero

    public static boolean verificarCalificacionesAsignadas(String carrera, ArrayList<Alumno> listaALumnos) {
        boolean flag = true;
        for (Alumno alumno : listaALumnos) {
            String numeroControl = alumno.getNumeroControl();
            String periodoString = calcularUltimoPeriodo(carrera, numeroControl);// "AGOSTO_DICIEMBRE_2023"
            for (Curso curso : Sistema.historiales.get(carrera).get(numeroControl).getPeriodos().get(periodoString)
                    .getMateriasPeriodo()) {
                if (!curso.isCalificacionAsignada()) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public static String calcularUltimoPeriodo(String carrera, String numeroControl) {
        String periodoString = "";
        Historial historial = Sistema.historiales.get(carrera).get(numeroControl);
        Set<String> keys = historial.getPeriodos().keySet();
        List<String> myList = new ArrayList<>(keys);
        // "AGOSTO DICIEMBRE", ENERO-JUNIO ...
        periodoString = myList.get(myList.size() - 1);
        return periodoString;
    }

    public static String getPeriodoSiguiente(String periodoActual) {
        String periodoSiguiente = "";
        int n = 1;
        for (String nombrePeriodo : NumeroPeriodo.numerosPeriodo.values()) {
            if (periodoActual.equals(nombrePeriodo))
                break;
            else
                n++;
        }
        // ya tengo en n el valor del periodo como integer
        periodoSiguiente = NumeroPeriodo.numerosPeriodo.get(n + 1);
        return periodoSiguiente;
    }

    public static double calcularPromedioFinal(String carrera, String numeroControl) {
        double suma = 0;
        int n = Sistema.historiales.get(carrera).get(numeroControl).getPeriodos().size();
        for (Periodo periodo : Sistema.historiales.get(carrera).get(numeroControl).getPeriodos().values()) {
            suma += periodo.getPromedioFinal();
        }
        return (suma / n);
    }

}
