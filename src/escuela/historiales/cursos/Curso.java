package escuela.historiales.cursos;

import escuela.materias.Materia;

public class Curso {
    private String periodo;
    private Materia materia;
    private boolean calificacionAsignada;
    private double calificacionFinal;

    public Curso(String periodo, Materia materia) {
        this.periodo = periodo;
        this.materia = materia;
        this.calificacionAsignada = false;
        this.calificacionFinal = 0.0;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public boolean isCalificacionAsignada() {
        return calificacionAsignada;
    }

    public void setCalificacionAsignada(boolean calificacionAsignada) {
        this.calificacionAsignada = calificacionAsignada;
    }

    public double getCalificacionFinal() {
        return calificacionFinal;
    }

    public void setCalificacionFinal(double calificacionFinal) {
        this.calificacionFinal = calificacionFinal;
    }

    // namas que en este quiero mejor poner la información de cada curso, como
    // imprimir sus atributos

    /*
     * 
     * private Materia materia; ->usar el toString() de materia
     * private boolean calificacionAsignada;
     * private double calificacionFinal;
     * con que muestre esto está perfecto mira
     * ta bien?? smn, namas en el de materia usas el toString de materia, arre, smn
     * smn, si algo me avisas ;)
     */
    @Override
    public String toString() {

        String calificacionAsignada = "";

        if (isCalificacionAsignada() == true)
            calificacionAsignada = "CALIFICACION ASIGNADA";
        else
            calificacionAsignada = "CALIFICACION NO ASIGNADA";

        return String.format(

                "\n| MATERIA |\n%s\n" +
                        "| CALIFICACION | \t | OBSERVACIONES        |\n" +
                        "| %.2f         | \t | %s |\n\n",
                materia.toString(), getCalificacionFinal(), calificacionAsignada);
    }

}
