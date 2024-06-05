package escuela.materias;

import java.util.*;

import sistema.Sistema;
import usuarios.Usuario;
import usuarios.Trabajadores.Profesor;
import usuarios.utils.helpers.DatosComun;
import utils.*;

public class Materia {
    private static Random ran = new Random();
    private String nombre;
    private Usuario profesor;
    private String id;
    private String nombreCarrera;
    private String IDgrupo;

    public Materia(String nombre, Usuario profesor, String nombreCarrera, String IDgrupo) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.id = Id.generate(nombre + "-");
        this.nombreCarrera = nombreCarrera;
        this.IDgrupo = IDgrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getProfesor() {
        return profesor;
    }

    public void setProfesor(Usuario profesor) {
        this.profesor = profesor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getGrupo() {
        return IDgrupo;
    }

    public void setGrupo(String grupo) {
        this.IDgrupo = grupo;
    }

    public static ArrayList<Materia> getListaMateriasFromString(String nombreCarrera, String semestre, String grupo) {
        ArrayList<Materia> materias = Sistema.carreras.get(nombreCarrera).getSemestres().get(semestre).getGrupos()
                .get(grupo).getMateriasGrupo();
        return materias;
    }

    @Override
    public String toString() {
        String dato = String.format("| NOMBRE: %s | CARRERA: %s| ID: %s | GRUPO: %s | PROFESOR: %s",
                getNombre(), getNombreCarrera(), getId(), getGrupo(), getProfesor().getNombreCompleto());
        return dato;
    }

    public static ArrayList<String> generarMateriasRandom(int n) {// LOGICA PARA VERIFICAR QUE LAS MATERIAS NO SE
                                                                  // REPITAN
        ArrayList<String> materias = new ArrayList<>();
        while (materias.size() != n) {
            boolean flag = true;
            String materia = getMateriaRandom();// ando debuggeando
            // que esta pasando??
            // para que no haya repetidas
            if (materias.isEmpty()) {
                materias.add(materia);
            } else {
                for (String materiActual : materias) {
                    if (materiActual.equals(materia)) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    materias.add(materia);
            }
        }
        return materias;
    }

    private static String getMateriaRandom() {
        return DatosComun.materiasGeneral.get(ran.nextInt(21) + 1);
    }

    public static HashMap<Integer, String> incializarHashMaterias() {// GABOREVER
        HashMap<Integer, String> mapa = new HashMap<>();
        // 1,"CALCULO1",2,"CALCULO2", 3,
        // "CALCULO3",4,"REDES1",5,"REDES2",6,"REDES3",7,"CIRCUITOS1",8,"CIRCUITOS2",9,"CIRCUITOS3",10,"ESTADISTICA1",11,"ESTADISTICA2",12,"ESTADISTICA3",13,"CONTABILIDAD1",14,"CONTABILIDAD2",15,"CONTABILIDAD3",16,"PROGRAMACION1",17,"PROGRAMACION2",18,"PROGRAMACION3",19,"PROBABILIDAD1",20,"PROBABILIDAD2",21,"PROBABILIDAD2")
        mapa.put(1, "CALCULO1");
        mapa.put(2, "CALCULO2");
        mapa.put(3, "CALCULO3");
        mapa.put(4, "REDES1");
        mapa.put(5, "REDES2");
        mapa.put(6, "REDES3");
        mapa.put(7, "CIRCUITOS1");
        mapa.put(8, "CIRCUITOS2");
        mapa.put(9, "CIRCUITOS3");
        mapa.put(10, "ESTADISTICA1");
        mapa.put(11, "ESTADISTICA2");
        mapa.put(12, "ESTADISTICA3");
        mapa.put(13, "CONTABILIDAD1");
        mapa.put(14, "CONTABILIDAD2");
        mapa.put(15, "CONTABILIDAD3");
        mapa.put(16, "PROGRAMACION1");
        mapa.put(17, "PROGRAMACION2");
        mapa.put(18, "PROGRAMACION3");
        mapa.put(19, "PROBABILIDAD1");
        mapa.put(20, "PROBABILIDAD2");
        mapa.put(21, "PROBABILIDAD3");

        return mapa;
    }

    public static ArrayList<Materia> getMateriasGrupo(String carrera, int numeroSemestre, String tipoGrupo,
            HashMap<String, ArrayList<Materia>> mapaMaterias) {
        ArrayList<Materia> materias = new ArrayList<>();
        Materia materia1 = null, materia2 = null, materia3 = null;
        String nombreMateria1 = "", nombreMateria2 = "", nombreMateria3 = "";
        int nGrupo;
        if (tipoGrupo.equals("A")) {
            nGrupo = 0;// GRUPO A
        } else {
            nGrupo = 1;// GRUPO B
        }
        switch (carrera) {
            case "SISTEMAS" -> {
                nombreMateria1 = "CALCULO" + String.valueOf(numeroSemestre);
                nombreMateria2 = "PROGRAMACION" + String.valueOf(numeroSemestre);
                nombreMateria3 = "PROBABILIDAD" + String.valueOf(numeroSemestre);
                materia1 = mapaMaterias.get(nombreMateria1).get(nGrupo);
                materia2 = mapaMaterias.get(nombreMateria2).get(nGrupo);
                materia3 = mapaMaterias.get(nombreMateria3).get(nGrupo);
            }
            case "ELECTRONICA" -> {// AHUEVO, alm me recostó
                nombreMateria1 = "CALCULO" + String.valueOf(numeroSemestre);
                nombreMateria2 = "REDES" + String.valueOf(numeroSemestre);
                nombreMateria3 = "CIRCUITOS" + String.valueOf(numeroSemestre);
                materia1 = mapaMaterias.get(nombreMateria1).get(nGrupo);
                materia2 = mapaMaterias.get(nombreMateria2).get(nGrupo);
                materia3 = mapaMaterias.get(nombreMateria3).get(nGrupo);
            }
            case "MATERIALES" -> {
                nombreMateria1 = "CALCULO" + String.valueOf(numeroSemestre);
                nombreMateria2 = "ESTADISTICA" + String.valueOf(numeroSemestre);
                nombreMateria3 = "CONTABILIDAD" + String.valueOf(numeroSemestre);
                materia1 = mapaMaterias.get(nombreMateria1).get(nGrupo);
                materia2 = mapaMaterias.get(nombreMateria2).get(nGrupo);
                materia3 = mapaMaterias.get(nombreMateria3).get(nGrupo);
            }
        }
        materias.add(materia1);
        materias.add(materia2);
        materias.add(materia3);
        return materias;

        // usted invente
    }

    public static ArrayList<String> getMateriasCarrera(String carrera, int numeroSemestre) {
        ArrayList<String> materiasString = new ArrayList<>();
        switch (carrera) {
            case "SISTEMAS" -> {
                materiasString.add("CALCULO" + String.valueOf(numeroSemestre));
                materiasString.add("PROGRAMACION" + String.valueOf(numeroSemestre));
                materiasString.add("PROBABILIDAD" + String.valueOf(numeroSemestre));
            }
            case "ELECTRONICA" -> {// AHUEVO, alm me recostó
                materiasString.add("CALCULO" + String.valueOf(numeroSemestre));
                materiasString.add("REDES" + String.valueOf(numeroSemestre));
                materiasString.add("CIRCUITOS" + String.valueOf(numeroSemestre));
            }

            case "MATERIALES" -> {
                materiasString.add("CALCULO" + String.valueOf(numeroSemestre));
                materiasString.add("ESTADISTICA" + String.valueOf(numeroSemestre));
                materiasString.add("CONTABILIDAD" + String.valueOf(numeroSemestre));
            }
        }
        return materiasString;
    }

    public static ArrayList<String> generarMateriasFromString(String nombreMateria) {
        ArrayList<String> materias = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            materias.add(nombreMateria + String.valueOf(i));
        }
        return materias;
    }

    public static ArrayList<Materia> generarMaterias(int n, String nombreCarrera, String nombreMateria) {
        // meter lo que viste del for para la letra y ya se lo puedes asignar desde aquí
        /*
         * ArrayList<Usuario> profesoresMateria =
         * Profesor.getProfesoresMateria(nombreMateria);
         * // obtener un arreglo primitivo ya con los profesores desordenados
         * Usuario[] profesores = new Usuario[n];
         * for (int i = 0; i < profesores.length; i++) {
         * profesores[i] = profesoresMateria.get(ran.nextInt(profesoresMateria.size()));
         * }
         */
        // se rellena la lista de materias
        ArrayList<Materia> materias = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char letter = (char) ('A' + i);
            Materia materia = new Materia(nombreMateria, Profesor.getProfesorMateria(nombreMateria), nombreCarrera,
                    String.valueOf(letter));
            materias.add(materia);
        }

        return materias;
    }

    public static void showList() {
        String carrera = UsuarioEnSesion.getInstancia().getUsuarioActual().getCarrera();
        System.out.printf("\n ---------- L I S T A  D E  M A T E R I A S  D E   %s ---------- \n", carrera);
        String semestre = "";
        for (int i = 1; i <= 3; i++) {
            switch (i) {
                case 1 -> semestre = "PRIMERO";
                case 2 -> semestre = "SEGUNDO";
                case 3 -> semestre = "TERCERO";
            }
            System.out.printf("\n------------------- S E M E S T R E : %s -------------------", semestre);
            String grupo = "";
            for (int j = 1; j <= 2; j++) {
                switch (j) {
                    case 1 -> grupo = "A";
                    case 2 -> grupo = "B";
                }
                System.out.printf("\n--------------- G R U P O : %s ---------------", grupo);
                for (Materia materia : Sistema.carreras.get(carrera).getSemestres().get(semestre).getGrupos().get(grupo)
                        .getMateriasGrupo()) {
                    System.out.printf("\n | NOMBRE DE LA MATERIA: %s | GRUPO: %s | ID: %s | ", materia.getNombre(),
                            materia.getGrupo(), materia.getId());
                }
            }
        }
    }

    public static void showInfo() {// CORREGIR
        while (true) {
            showList();//
            String id = Ask.forString("el ID de la materia");
            Materia materia = validIDmateria(id);
            if (materia == null) {
                System.out.println("No se encontró la materi indicada");
                System.out.println("¿Desea intentar de nuevo?");
                System.out.println("1. SI\n2. NO");
                if (Ask.forInt("una opción") != 1) {
                    break;
                }
            } else {
                System.out.println(
                        "--------------------------INFORMACIÓN DE LA MATERIA SELECCIONADA------------------------");
                System.out.println(materia);
                break;
            }
        }
    }

    private static Materia validIDmateria(String IDmateria) {
        Materia materia = null;
        String carrera = CarreraActual.getInstancia().getCarreraActual();
        for (ArrayList<Materia> lista : Sistema.carreras.get(carrera).getMaterias().values()) {
            for (Materia materiaActual : lista) {
                if (materiaActual.getId().equals(IDmateria)) {
                    return materiaActual;
                }
            }
        }
        return materia;
    }

    public static Materia getMateria(String nombre) {
        Materia materia = null;
        for (ArrayList<Materia> lista : Sistema.carreras
                .get(UsuarioEnSesion.getInstancia().getUsuarioActual().getCarrera()).getMaterias().values()) {
            for (Materia MateriaActual : lista) {
                if (MateriaActual.getNombre().equals(nombre)) {
                    return MateriaActual;
                }
            }
        }
        return materia;
    }

    /*
     * public static ArrayList<String> generarMateriasString(int n, String
     * nombreCarrera) {
     * // Tienes que ir creando las materias //break;
     * 
     * // TOMAR LAS MATERIAS DESDE LO QUE ANDAN HACIENDO GABO Y JORCH
     * // meter lo que viste del for para la letra y ya se lo puedes asignar desde
     * aquí
     * ArrayList<String> materias = new ArrayList<>();// cual??a yayaya estee no ya
     * no isra ya con el super, vap, no
     * // hay de q
     * 
     * for (int i = 0; i < n; i++) {
     * // el nombreMateria va a ser random
     * nombreMateria.get(random.nextInt(.length()))
     * ArrayList<Usuario> profesoresMateria =
     * Profesor.getProfesoresMateria(nombreMateria);
     * // obtener un arreglo primitivo ya con los profesores desordenados
     * Usuario[] profesores = new Usuario[n];
     * for (int j = 0; j < profesores.length; j++) {
     * profesores[j] = profesoresMateria.get(ran.nextInt(profesoresMateria.size()));
     * }
     * 
     * }
     * 
     * // se rellena la lista de materias
     * for (int i = 0; i < n; i++) {
     * char letter = (char) ('A' + i);
     * Materia materia = new Materia(nombreMateria, profesores[i], nombreCarrera,
     * String.valueOf(letter));
     * materias.add(materia);
     * }
     * return materias;
     * }
     */
}
