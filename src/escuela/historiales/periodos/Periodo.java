package escuela.historiales.periodos;

import java.util.ArrayList;

import escuela.historiales.cursos.Curso;
import escuela.historiales.periodos.utils.EstatusPeriodo;

public class Periodo {
    private ArrayList<Curso> materiasPeriodo;
    private Double promedioFinal;
    private String periodo, estatus;
    private boolean isAprobado;

    public Periodo(ArrayList<Curso> materiasPeriodo, String periodo) {
        this.materiasPeriodo = materiasPeriodo;
        this.promedioFinal = 0.0;
        this.periodo = periodo;
        this.estatus = EstatusPeriodo.CURSANDO.toString();
        this.isAprobado = false;
    }

    public static void showListNumeroMateria(Periodo periodo) {
        int n = 1;
        for (Curso curso : periodo.getMateriasPeriodo()) {
            System.out.printf("\n%d. %s ", n, curso.getMateria().getNombre());
            n++;
        }
    }

    public ArrayList<Curso> getMateriasPeriodo() {
        return materiasPeriodo;
    }

    public void setMateriasPeriodo(ArrayList<Curso> materiasPeriodo) {
        this.materiasPeriodo = materiasPeriodo;
    }

    public Double getPromedioFinal() {
        double suma = 0;
        for (Curso curso : materiasPeriodo) {
            suma += curso.getCalificacionFinal();
        }
        this.promedioFinal = (suma / 3);
        return (suma / 3);
    }

    public void setPromedioFinal(Double promedioFinal) {
        this.promedioFinal = promedioFinal;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public boolean isAprobado() {
        return isAprobado;
    }

    public void setAprobado(boolean isAprobado) {
        this.isAprobado = isAprobado;
    }

    @Override
    public String toString() {
        String cad = "";
        for (Curso curso : materiasPeriodo) {
            cad += curso.toString();
        }
        cad += String.format("\n | PERIODO: %s | ESTATUS: %s | ", getPeriodo(), getEstatus());
        cad += String.format("| PROMEDIO FINAL: %.2f|", getPromedioFinal());
        cad += String.format("| ESTATUS DEL PERIODO: %s |", getEstatus());
        return cad;
    }

    public void formatoCalificaciones() {// ya tengo un objeto de tipo Periodo
        // Como en el mindbox
        System.out.println("\n |    MATERIA    | \t |  CALIFICAION  | \t |   OBSERVACIONES   | ");
        boolean pendientePorAsignar = false;

        for (Curso curso : getMateriasPeriodo()) {
            String nombreMateria = curso.getMateria().getNombre();
            String cad = String.format("\n | %s | ", nombreMateria);

            // Ajustar el número de espacios después del nombre de la materia para alinearlo
            int espaciosRestantes = 15 - nombreMateria.length();
            for (int i = 0; i < espaciosRestantes; i++) {
                cad += " ";
            }

            cad += String.format("| %.0f | ", curso.getCalificacionFinal());

            if (!curso.isCalificacionAsignada()) {
                cad += " | CALIFICACION NO ASIGNADA | ";
                pendientePorAsignar = true;
            } else {
                if (curso.getCalificacionFinal() >= 70)
                    cad += " | CURSO APROBADO | ";
                else
                    cad += " | CURSO NO APROBADO | ";
            }
            System.out.print(cad);
        }
        System.out.printf("\n ***ESTATUS DEL PERIODO: %s ***", getEstatus());

        if (pendientePorAsignar) {
            System.out.println("\nNo han sido asignada todas las calificaciones");
            System.out.println("Por lo que aún no podemos determinar su calificación final de este periodo");
        } else {
            System.out.printf("\n | CALIFICACION FINAL DEL PERIODO %.2f |", getPromedioFinal());
        }
    }

}
