package usuarios.Trabajadores;

import java.util.*;

import escuela.carreras.Carrera;
import escuela.grupos.Grupo;
import escuela.historiales.cursos.Curso;
import escuela.materias.Materia;
import escuela.semestres.Semestre;
import sistema.Sistema;
import usuarios.Usuario;
import usuarios.Alumnos.Alumno;
import usuarios.utils.Rol;
import usuarios.utils.helpers.DatosComun;
import utils.*;

public class Profesor extends Trabajador {
    private static Random ran = new Random();
    public static int CONTADOR = 0;
    private ArrayList<String> materiasImpartidas;

    public Profesor(String nombre, String apellidoP, String apellidoM, String fechaDeNacimiento, String fechaDeRegistro,
            String direccion, String estado, String genero, String nombreUsuario,
            String contrasena,
            double sueldo, String carrera) {// PARA CUANDO SE INICIALIZA EL PROGRAMA
        super(nombre, apellidoP, apellidoM, fechaDeNacimiento,
                fechaDeRegistro, direccion, estado, genero,
                nombreUsuario, contrasena, Rol.PROFESOR, carrera, sueldo);
        this.materiasImpartidas = Materia.generarMateriasRandom(3);
        CONTADOR++;
    }// PREGUNTAR QUE PEDO SIEMPRE @isra
     // NO BORRAR

    public Profesor(String nombre, String apellidoP, String apellidoM, String fechaDeNacimiento, String fechaDeRegistro,
            String direccion, String estado, String genero, String nombreUsuario, String contrasena,
            double sueldo, String carrera, ArrayList<String> materiasImpartidas) {// PARA CUANDO SE REGISTRA UN PROFESOR
        super(nombre, apellidoP, apellidoM, fechaDeNacimiento, fechaDeRegistro, direccion, estado, genero,
                nombreUsuario, contrasena, Rol.PROFESOR, carrera, sueldo);
        this.materiasImpartidas = materiasImpartidas;
        CONTADOR++;
    }

    public static void registrar() {
        ArrayList<String> datos = DatosComun.obtenerDatosComun(Rol.PROFESOR);
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
        Double sueldo = Ask.forDouble("el salario del profesor");
        // MENU INTERACTIVO DONDE PUEDA ELEGIR LAS MATERIAS
        ArrayList<String> materiasImpartidas = DatosComun.materiasProfesor(nombre);
        Sistema.profesores.get(CarreraActual.getInstancia().getCarreraActual())
                .add(new Profesor(nombre, apellidoP, apellidoM, fechaNacimiento, fechaRegistro, direccion, state,
                        gender, nombreUsuario, contrasena, sueldo, carrera, materiasImpartidas));
        Sistema.guardarEnJson();
        System.out.println("\n----------------------------Profesor registrado----------------------------");
    }

    public static void eliminar() {
        boolean flag = true;
        String numeroControl = "";
        int index = 0;
        Rol rol = Rol.PROFESOR;
        System.out.printf("\n---------------------ELIMINAR UN %s---------------------", rol.toString());

        while (true) {
            showListNumeroControl();
            numeroControl = Ask.forString("el numero de control del profesor");
            index = Id.validNumeroControl(numeroControl, rol.toString());
            if (index == -1) {
                System.out.println("No se encontro al profesor, ¿Desea intentarlo de nuevo?");
                System.out.println("1. SI \n2. NO");
                if (Ask.forInt("el numero de opcion") == 1)
                    flag = false;
                else
                    break;
            }
            if (flag) {
                if (veriricarProfesorActivo(numeroControl)) {
                    System.out.println("Este profesor tiene grupos asignados, por lo que no es posible eliminarlo");
                } else {
                    Sistema.profesores.get(CarreraActual.getInstancia().getCarreraActual()).remove(index);
                    System.out.println("El profesor fue eliminado exitosamente");
                    Sistema.guardarEnJson();
                }
                break;
            }
        }
    }

    private static boolean veriricarProfesorActivo(String numeroControl) {
        for (Carrera carrera : Sistema.carreras.values()) {
            for (ArrayList<Materia> listaMaterias : carrera.getMaterias().values()) {
                for (Materia materia : listaMaterias) {
                    if (materia.getProfesor().getNumeroControl().equals(numeroControl)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void consultarInfo() {
        System.out.println("\n---------------INFORMACION PERSONAL---------------");
        Profesor profesor = (Profesor) UsuarioEnSesion.getInstancia().getUsuarioActual();
        System.out.println(profesor);
    }

    public static void modificarInfo() {

        String numeroControl = "";
        int index = 0;
        System.out.printf("\n---------------------MODIFICAR UN %s---------------------", Rol.PROFESOR.toString());

        while (true) {
            boolean flag = true;
            showListNumeroControl();
            numeroControl = Ask.forString("el numero de control del profesor");
            index = Id.validNumeroControl(numeroControl, Rol.PROFESOR.toString());
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
                System.out.println("El profesor fue modificado exitosamente");
                Sistema.guardarEnJson();
                break;
            }
        }
    }

    public static void modificarInfoPersonal() {
        int index = Id.validNumeroControl(UsuarioEnSesion.getInstancia().getUsuarioActual().getNumeroControl(),
                "PROFESOR");
        System.out.println("\n---------------MODIFICAR INFORMACION PERSONAL---------------");
        modificar(index);
    }

    private static void modificar(int index) {
        boolean flag = true;

        while (flag) {
            System.out.println("\n¿QUÉ DESEA MODIFICAR?");
            System.out.println(
                    "1.NOMBRE  \n2.APELLIDO PATERNO \n3.APELLIDO MATERNO \n4.NOMBRE DE USUARIO  \n5.FECHA DE NACIMIENTO \n6.ESTADO \n7.GENERO \n8.DIRECCION \n9. Volver al menu principal ");
            int opcion = Ask.forInt("el número de opción");
            switch (opcion) {
                case 1 -> {
                    String nombre = Ask.forString("el nuevo nombre");
                    Sistema.profesores.get(CarreraActual.getInstancia().getCarreraActual()).get(index)
                            .setNombre(nombre);
                    System.out.println("Se actualizó el nombre");
                }

                case 2 -> {
                    String apellidoP = Ask.forString("el nuevo apellido paterno");
                    Sistema.profesores.get(CarreraActual.getInstancia().getCarreraActual()).get(index)
                            .setApellidoP(apellidoP);
                    System.out.println("Se actualizo el apellido paterno");
                }
                case 3 -> {
                    String apellidoM = Ask.forString("el nuevo apellido materno");
                    Sistema.profesores.get(CarreraActual.getInstancia().getCarreraActual()).get(index)
                            .setApellidoM(apellidoM);
                    System.out.println("Se actualizo el apellido materno");
                }
                case 4 -> {
                    String nombreUsuario = DatosComun.obtenerNombreUsuario();
                    Sistema.profesores.get(CarreraActual.getInstancia().getCarreraActual()).get(index)
                            .setNombreUsuario(nombreUsuario);
                    System.out.println("Se actualizo el nombre de usuario");
                }
                case 5 -> {
                    String fechaNacimiento = Fecha.askForDate("la nueva fecha de nacimiento");
                    Sistema.profesores.get(CarreraActual.getInstancia().getCarreraActual()).get(index)
                            .setFechaDeNacimiento(fechaNacimiento);
                    System.out.println("Se actualizo la fecha de nacimeinto");
                }
                case 6 -> {
                    String estado = DatosComun.elegirEstado().toString();
                    Sistema.profesores.get(CarreraActual.getInstancia().getCarreraActual()).get(index)
                            .setEstado(estado);
                    System.out.println("Se actualizo el estado");
                }
                case 7 -> {
                    String genero = DatosComun.elegirGenero().toString();
                    Sistema.profesores.get(CarreraActual.getInstancia().getCarreraActual()).get(index)
                            .setGenero(genero);
                    System.out.println("Se actualizo el genero");
                }
                case 8 -> {
                    String direccion = Ask.forString("la direccion nueva");
                    Sistema.profesores.get(CarreraActual.getInstancia().getCarreraActual()).get(index)
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
            System.out.println("-------------------------------INFORMACION ACTUALIZADA-------------------------------");
            System.out.println(Sistema.profesores.get(CarreraActual.getInstancia().getCarreraActual()).get(index));
            System.out.println("¿Desea seguir modificando la información?");
            System.out.println("1. SI \n2. NO");
            if (Ask.forInt("el número de opción") != 1)
                flag = false;
        }
        // su perra madre, me espante jorch, perdon amiguito, xd
    }

    public static void showList() {// TODOS LOS PROFESORES
        String carrera = CarreraActual.getInstancia().getCarreraActual();
        System.out.printf("\n-------- P R O F E S O R E S   DE   %s---------\n", carrera);
        for (Profesor profesor : Sistema.profesores.get(carrera)) {
            System.out.println(profesor);
        }
    }

    public static void showInfo() {// UN PROFESOR EN ESPECIFICO

        if (Sistema.profesores.get(CarreraActual.getInstancia().getCarreraActual()).isEmpty()) {
            System.out.println("No hay profesores registrados en el sistema :(");
        } else {
            showListNumeroControl();// nombre, semestre, grupo, numero de control
            String numeroControl = Ask.forString("el numero de control del profesor");
            int index = Id.validNumeroControl(numeroControl, Rol.PROFESOR.toString());// CORREGIR PARA QUE JALE***
            if (index == -1) {
                System.out.println("No se encontró al profesor");
                System.out.println("¿Desea intentarlo de nuevo?");
                System.out.println("1. SI \n 2. NO");
                int option = Ask.forInt("el número de opción");
                if (option == 1)
                    showInfo();// Preguntar a Edgar aqui que planea hacer, tal venz no funciona
            } else {
                Usuario usuario = Sistema.profesores.get(CarreraActual.getInstancia().getCarreraActual()).get(index);
                System.out.printf("-------------------------INFORMACIÓN DEL PROFESOR %s-------------------------",
                        usuario.getNombreCompleto());
                if (usuario instanceof Profesor) {
                    Profesor profe = (Profesor) usuario;
                    System.out.println(profe);
                } else {
                    Coordinador coordinador = (Coordinador) usuario;
                    System.out.println(coordinador);
                }
            }
        }
    }

    public static void verGrupos() {// Reciclar lógica del de asignar
        // para que un profesor pueda ver todos sus grupos
        Map<String, Grupo> gruposProfesor = new LinkedHashMap<>();// en la key va el nombre de la materia CALCULO1
        ArrayList<String> listaNombreMateria = new ArrayList<>();
        Profesor profesor = (Profesor) UsuarioEnSesion.getInstancia().getUsuarioActual();
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
                        System.out.println(
                                "----------------------INFORMACION DEL GRUPO-------------------------------------------");
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
        // cuando tengas el grupo buscas entre sus materias el numero de control del
        // profesor otra vez y de ahí obtienes los datos para mostrarlos en la lista
        // uff no sé como hacerle pa este pedo
        // esq hay un problemita, pq cuando cargue las materias, les puse el atributo de
        // Profesor como null, tengo q asignarles un profe al crearlas xd
        // ahh ya, y no puedes cargarlos a la vez, chales
        // smn tengo q corregirle eso :c
        // por ?

    }// hola

    public static void asignarCalificacion() {// hola
        Profesor profesor = (Profesor) UsuarioEnSesion.getInstancia().getUsuarioActual();
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
                HashMap<String, Grupo> gruposProfesor = new LinkedHashMap<>();
                // verificar que realmente imparta la materia
                for (Materia materia : Sistema.carreras.get(nombreCarrera).getMaterias().get(nombreMateria)) {
                    if (materia.getProfesor().getNumeroControl().equals(profesor.getNumeroControl())) {
                        // aqui aseguramos que la imparte
                        Grupo grupo = Grupo.getGrupo(nombreCarrera, materia);
                        gruposProfesor.put(materia.getId(), grupo);// si hay 2 aquí tendrían la misma key, cuidado con
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
                                    System.out.printf("\n| NOMBRE DEL ALUMNO: %s | NÚMERO DE CONTROL DEL ALUMNO: %s |",
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
                                    System.out.printf("\n| NOMBRE DEL ALUMNO: %s | NÚMERO DE CONTROL DEL ALUMNO: %s |",
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
                    String periodoActual = Coordinador.calcularUltimoPeriodo(nombreCarrera, numeroControl);
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
                            Alumno.actualizarEstatusPeriodo(nombreCarrera, numeroControl);
                            Sistema.guardarEnJson();
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

    /*
     * String IDmateria = "";
     * ArrayList<String> listaIDmateriasProfesor = new ArrayList<>();
     * ArrayList<Grupo> gruposProfesor = new ArrayList<>();
     * 
     * for (int i = 0; i < 3; i++) {
     * nombreCarrera = "";
     * IDmateria = "";
     * listaIDmateriasProfesor = new ArrayList<>();
     * 
     * switch (i) {
     * case 0 -> nombreCarrera = "SISTEMAS";
     * case 1 -> nombreCarrera = "ELECTRONICA";
     * case 2 -> nombreCarrera = "MATERIALES";
     * }
     * for (int k = 0; k < listaMaterias.size(); k++) {
     * if
     * (Sistema.carreras.get(nombreCarrera).getMaterias().containsKey(listaMaterias.
     * get(k))) {//ya se q la carrera actual tiene la materia del profe
     * String auxMateria = listaMaterias.get(k);//guardo el nombre de la materia
     * for (Materia materia :
     * Sistema.carreras.get(nombreCarrera).getMaterias().get(auxMateria)) {//el
     * arraylist que tiene la materia del grupo y el grupo b
     * if
     * (materia.getProfesor().getNumeroControl().equals(profesor.getNumeroControl())
     * ) {
     * listaIDmateriasProfesor.add(materia.getId());//maybe ponerle A o B al final
     * para luego extraer
     * 
     * //ID de la materia que imparte el profesor
     * System.out.println("ID DE LA MATERIA QUE IMPARTE EL PROFESOR: " +
     * materia.getId());
     * System.out.println("GRUPO QUE LLEVA LA MATERIA: " + materia.getGrupo());
     * }
     * }
     * }
     * if (!listaIDmateriasProfesor.isEmpty()) {//ahora es para obtener el grupo y
     * con ello la lista de alumnos
     * 
     * for (Semestre semestre :
     * Sistema.carreras.get(nombreCarrera).getSemestres().values()) {//me regresa
     * PRIMERO, SEGUNDO, TERCERO
     * for (Grupo grupo : semestre.getGrupos().values()) {//me regresa grupo A y
     * grupo B
     * for (Materia materia : grupo.getMateriasGrupo()) {//la lista de las 3
     * materias del grupo A
     * for (int j = 0; j < listaIDmateriasProfesor.size(); j++) {
     * if (materia.getId().equals(listaIDmateriasProfesor.get(j))) {
     * System.out.println("------------------");
     * System.out.println(materia.getId());
     * System.out.println("------------------");
     * System.out.println(listaIDmateriasProfesor.get(j));
     * gruposProfesor.add(grupo);
     * System.out.
     * println("*******SE AGREGA A LA LISTA EL GRUPO AL QUE DA CLASE EL PROFESOR******"
     * );
     * }
     * }
     * }
     * }
     * }
     * }
     * }
     * }
     * 
     * 
     * if (gruposProfesor.isEmpty()) {
     * System.out.println("Usted no tiene asignado ningún grupo");
     * }
     * else{
     * System.out.println("TAMAÑO LISTA: " + gruposProfesor.size());
     * boolean flag = false;
     * if (gruposProfesor.size() == 1) {//solo tiene un grupo
     * System.out.println("Usted sólo tiene asignado un grupo");
     * System.out.println("Estos son los alumnos del grupo");
     * for (Alumno alumno : gruposProfesor.get(0).getAlumnosGrupo()) {
     * System.out.printf("\n | NOMBRE DEL ALUMNO: %s | NÚMERO DE CONTROL %s | ",
     * alumno.getNombreCompleto(), alumno.getNumeroControl());
     * }
     * System.out.
     * println("Ahora ingrese el número de control del alumno para agregarle su calificacion"
     * );
     * String ansNumeroControl = Ask.forString("el número de control");
     * for (ArrayList<Alumno> listaAlumnos : Sistema.alumnos.values()) {//verificar
     * el numero de control ingresado en consola
     * for (Alumno alumno : listaAlumnos) {
     * if (alumno.getNumeroControl().equals(ansNumeroControl)) {
     * flag = true;
     * break;
     * }
     * }
     * }
     * if (!flag) {//numero de control invalido
     * System.out.println("No se encontró al alumno");
     * }
     * else{
     * Alumno alumno = Alumno.getAlumno(ansNumeroControl);
     * Historial historialAlumno =
     * Sistema.historiales.get(alumno.getCarrera()).get(ansNumeroControl);
     * String semestreActualString =
     * NumeroPeriodo.numerosPeriodo.get(Sistema.semestreActual.get(alumno.getCarrera
     * ()));
     * Curso curso = null;
     * for (Curso cursoActual :
     * historialAlumno.getPeriodos().get(semestreActualString).getMateriasPeriodo())
     * {//lista de materias del periodo actual
     * if (cursoActual.getMateria().getId().equals(IDmateria)) {
     * curso = cursoActual;
     * break;
     * }
     * }
     * while (true) {
     * double calificacion = Ask.forDouble("la calificación del alumno");
     * if (calificacion < 0 || calificacion > 100) {
     * System.out.println("La calificación ingresada no es válida, trate de nuevo");
     * }
     * else{
     * curso.setCalificacionFinal(calificacion);
     * curso.setCalificacionAsignada(true);
     * System.out.println("La calificación fue asignada");
     * }
     * }
     * }
     * }
     * else{//tiene varios grupos
     * System.out.println("Usted tiene asignados varios grupos");
     * System.out.println("Debe elegir primero el grupo al cual pertenece el alumno"
     * );
     * int n = 1;
     * for (Grupo grupo : gruposProfesor) {//se muestran las opciones de grupo
     * System.out.printf("\n%d. %s", n, grupo.getIDgrupo());
     * n++;
     * }
     * int ansOption = Ask.forInt("el número de opción");
     * if (ansOption >= 1 && ansOption <= gruposProfesor.size()) {
     * System.out.println("***************GRUPO ELEGIDO******************");
     * System.out.printf("\n***************%s*****************",
     * gruposProfesor.get(ansOption - 1).getIDgrupo());
     * if (gruposProfesor.get(ansOption - 1).getAlumnosGrupo().isEmpty()) {
     * System.out.println("Este grupo no cuenta aún con ningún alumno");
     * }
     * else{
     * System.out.println("Estos son los alumnos del grupo elegido");
     * System.out.println("TAMAÑO LISTA DE ALUMNOS DEL GRUPO ELEGIDO: " +
     * gruposProfesor.get(ansOption - 1).getAlumnosGrupo().size());
     * for (Alumno alumno : gruposProfesor.get(ansOption - 1).getAlumnosGrupo()) {
     * System.out.printf("\n | NOMBRE DEL ALUMNO: %s | NÚMERO DE CONTROL %s | ",
     * alumno.getNombreCompleto(), alumno.getNumeroControl());
     * }
     * System.out.
     * println("Ahora ingrese el número de control del alumno para agregarle su calificacion"
     * );
     * String ansNumeroControl = Ask.forString("el número de control");
     * for (ArrayList<Alumno> listaAlumnos : Sistema.alumnos.values()) {//verificar
     * el numero de control ingresado en consola
     * for (Alumno alumno : listaAlumnos) {
     * if (alumno.getNumeroControl().equals(ansNumeroControl)) {
     * flag = true;
     * break;
     * }
     * }
     * }
     * if (!flag) {//numero de control invalido
     * System.out.println("No se encontró al alumno");
     * }
     * else{
     * Alumno alumno = Alumno.getAlumno(ansNumeroControl);
     * Historial historialAlumno =
     * Sistema.historiales.get(alumno.getCarrera()).get(ansNumeroControl);
     * String semestreActualString =
     * NumeroPeriodo.numerosPeriodo.get(Sistema.semestreActual.get(alumno.getCarrera
     * ()));
     * Curso curso = null;
     * for (Curso cursoActual :
     * historialAlumno.getPeriodos().get(semestreActualString).getMateriasPeriodo())
     * {//lista de materias del periodo actual
     * if (cursoActual.getMateria().getId().equals(IDmateria)) {
     * curso = cursoActual;
     * break;
     * }
     * }
     * while (true) {
     * double calificacion = Ask.forDouble("la calificación del alumno");
     * if (calificacion < 0 || calificacion > 100) {
     * System.out.println("La calificación ingresada no es válida, trate de nuevo");
     * }
     * else{
     * curso.setCalificacionFinal(calificacion);
     * curso.setCalificacionAsignada(true);
     * System.out.println("La calificación fue asignada");
     * }
     * }
     * }
     * }
     * 
     * }
     * else{
     * System.out.println("Ingresó una opción inválida");
     * }
     * }
     * }
     * 
     * //si arraylist de grupos vacio es pq no tiene ningun grupo
     * 
     * //me va a devolver la lista de alumos que lleva la materia que imparte el
     * maestro
     * //de esta se van a mostrar los números de control
     * //de ahí obtenemos el historial del alumno con su número de control
     * //de su historial del actual periodo obtenemos la materia contenida en el
     * arreglo("CALCULO1");
     * //preguntamos la calificación
     * //se la asignamos a la materia que tiene ahorita el alumno
     * //----no :c----
     * 
     * }
     */

    // public static void modificarCalificacion()

    @Override
    public String toString() {
        String cad = "";
        cad += String.format("\n %s", super.toString());
        cad += "\n ---------------MATERIAS IMPARTIDAS POR EL PROFESOR---------------\n";
        for (String nombreMateria : materiasImpartidas) {
            cad += nombreMateria + "\n";
        }
        return cad;
    }// ey

    // AUXILIARES-------------------------
    public static void showListNumeroControl() {
        System.out
                .println(
                        "\n----------------------------LISTA DE NÚMEROS DE CONTROL DE PROFESORES-------------------------");
        for (Usuario usuario : Sistema.profesores.get(CarreraActual.getInstancia().getCarreraActual())) {
            Profesor profesor = (Profesor) usuario;
            System.out.printf(
                    " | NOMBRE COMPLETO: %s | NÚMERO DE CONTROL: %s |",
                    profesor.getNombreCompleto(), profesor.getNumeroControl());
            System.out.println(
                    "\n-------------------------------------------------------------");
        }
    }

    public boolean imparteMateria(String materia) {
        for (String nombreMateria : getMateriasImpartidas()) {
            if (materia.equals(nombreMateria))
                return true;
        }
        return false;
    }

    public static Usuario getProfesorMateria(String nombreMateria) {
        ArrayList<Usuario> profes = new ArrayList<>();
        for (ArrayList<Profesor> lista : Sistema.profesores.values()) {
            for (Profesor profesor : lista) {
                if (profesor.imparteMateria(nombreMateria)) {
                    profes.add(profesor);
                }
            }
        }
        if (!profes.isEmpty()) {
            return profes.get(ran.nextInt(profes.size()));
        } else {
            String nombreCarrera = "";
            switch (ran.nextInt(3) + 1) {
                case 1 -> nombreCarrera = "SISTEMAS";
                case 2 -> nombreCarrera = "ELECTRONICA";
                case 3 -> nombreCarrera = "MATERIALES";
            }
            // elejimos un maestro al azar para agregarselo
            int indexRandom = ran.nextInt(Sistema.profesores.get(nombreCarrera).size());
            Sistema.profesores.get(nombreCarrera).get(indexRandom).getMateriasImpartidas().add(nombreMateria);
            return Sistema.profesores.get(nombreCarrera).get(indexRandom);
        }
        // En caso de que no haya un maestro que imparta la asignatura
        // agarramos un maestro de un maestro al azar y le metemos la materia a su lista
        // de materias
    }

    public static Profesor getProfesor(String numeroControl) {
        Profesor profesor = null;
        for (ArrayList<Profesor> lista : Sistema.profesores.values()) {
            for (Profesor profesorActual : lista) {
                if (profesorActual.getNumeroControl().equals(numeroControl)) {
                    return profesorActual;
                }
            }
        }
        return profesor;
    }

    public static int getContador() {
        return CONTADOR;
    }

    /*
     * public static ArrayList<Usuario> getProfesoresMateria(String materia) {
     * ArrayList<Usuario> profesores = new ArrayList<>();
     * for (ArrayList<Usuario> lista : Sistema.profesores.values()) {
     * for (Usuario usuario : lista) {
     * if (usuario instanceof Profesor) {
     * Profesor profesor = (Profesor) usuario;
     * if (profesor.imparteMateria(materia, profesor)) {
     * profesores.add(profesor);
     * }
     * } else {
     * Coordinador coordinador = (Coordinador) usuario;
     * if (coordinador.imparteMateria(materia, coordinador)) {
     * profesores.add(coordinador);
     * }
     * }
     * }
     * }
     * return profesores;
     * }
     */
    // ------------------------

    // getter y settes
    public ArrayList<String> getMateriasImpartidas() {

        return materiasImpartidas;
    }

    public void setMateriasImpartidas(ArrayList<String> materiasImpartidas) {
        this.materiasImpartidas = materiasImpartidas;
    }

}
