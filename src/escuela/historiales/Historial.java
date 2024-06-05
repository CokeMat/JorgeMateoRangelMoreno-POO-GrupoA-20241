package escuela.historiales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import escuela.historiales.cursos.Curso;
import escuela.historiales.periodos.Periodo;
import escuela.materias.Materia;
import sistema.Sistema;
import usuarios.Alumnos.Alumno;
import utils.Ask;
import utils.CarreraActual;

public class Historial {
    private String numeroControlAlumno;
    private HashMap<String, Periodo> periodos;// en esta key va a ir más bien el número de periodo:
                                              // "AGOSTO_DICIEMBRE_2023"

    public Historial(String numeroControlAlumno, String nombrePeriodo) {// este es cuando se crea por primera vez
        this.numeroControlAlumno = numeroControlAlumno;
        this.periodos = incializarPeriodos(nombrePeriodo);
        // AQUI EDGAR
    }

    public String getNumeroControlAlumno() {
        return numeroControlAlumno;
    }

    public void setNumeroControlAlumno(String numeroControlAlumno) {
        this.numeroControlAlumno = numeroControlAlumno;
    }

    public HashMap<String, Periodo> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(HashMap<String, Periodo> periodos) {
        this.periodos = periodos;
    }

    public HashMap<String, Periodo> incializarPeriodos(String nombrePeriodo) {
        HashMap<String, Periodo> mapa = new HashMap<>();
        // int numeroPeriodo =
        // Sistema.semestreActual.get(CarreraActual.getInstancia().getCarreraActual());//Corregirlo
        // String periodoString = NumeroPeriodo.numerosPeriodo.get(numeroPeriodo);
        Alumno alumno = getAlumno(getNumeroControlAlumno());
        Periodo periodo = new Periodo(
                getCursos(nombrePeriodo, alumno.getCarrera(), alumno.getSemestre(), alumno.getGrupo()), nombrePeriodo);
        mapa.put(nombrePeriodo, periodo);
        return mapa;
    }

    public static Alumno getAlumno(String numeroControl) {
        Alumno alumno = null;
        for (Alumno alumnoActual : Sistema.alumnos.get(CarreraActual.getInstancia().getCarreraActual())) {
            if (alumnoActual.getNumeroControl().equals(numeroControl)) {
                return alumnoActual;
            }
        }
        return alumno;
    }

    public static ArrayList<Curso> getCursos(String periodo, String carrera, String semestre, String grupo) {
        ArrayList<Curso> cursos = new ArrayList<>();
        ArrayList<Materia> materias = Materia.getListaMateriasFromString(carrera, semestre, grupo);
        for (int i = 0; i < 3; i++) {
            cursos.add(new Curso(periodo, materias.get(i)));
        }
        return cursos;
    }

    public void showListPeriodo() {
        Set<String> keys = getPeriodos().keySet();
        int n = 1;
        for (String nombrePeriodo : keys) {
            System.out.printf("\n%d. %s", n, nombrePeriodo);
            n++;
        }
    }

    public String getNombrePeriodo() {
        String nombrePeriodo = null;
        Set<String> keys = getPeriodos().keySet();
        int ans = Ask.forInt("el número del periodo");// 4 keys, tons el valor que ingresa puede ser 1, 2, 3 o 4
        if (ans >= 1 || ans <= getPeriodos().size()) {
            int n = 1;
            for (String periodoActual : keys) {
                if (n == ans) {
                    nombrePeriodo = periodoActual;
                    break;
                } else
                    n++;
            }
        }
        return nombrePeriodo;
    }

    public static Historial getHistorial(String carrera, String numControl) {
        Historial historial = null;
        historial = Sistema.historiales.get(carrera).get(numControl);
        return historial;
    }

}
