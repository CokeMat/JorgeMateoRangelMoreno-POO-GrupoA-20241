package usuarios.Alumnos;

public class Graduado extends Alumno{

    private double promedioFinal;
    private String periodoGraduado;

    public Graduado (String nombre, String apellidoP, String apellidoM, String fechaDeNacimiento, String fechaDeRegistro,
            String direccion, String estado, String genero, String nombreUsuario, String contrasena,
            String carrera, String semestre, String grupo, double promedioFinal, String periodoGraduado) {
        super(nombre, apellidoP, apellidoM, fechaDeNacimiento, fechaDeRegistro, direccion, estado, genero, nombreUsuario, contrasena, carrera, semestre, grupo);
    this.promedioFinal = promedioFinal;
    this.periodoGraduado = periodoGraduado;
    }

    public double getPromedioFinal() {
        return promedioFinal;
    }

    public void setPromedioFinal(double promedioFinal) {
        this.promedioFinal = promedioFinal;
    }

    public String getPeriodoGraduado() {
        return periodoGraduado;
    }

    public void setPeriodoGraduado(String periodoGraduado) {
        this.periodoGraduado = periodoGraduado;
    }

    @Override
    public  String toString(){
        setGrupo("N/S");
        setSemestre("Graduado");
        return String.format("%s \n| PROMEDIO FINAL: %f | PERIODO EN EL QUE SE GRADUO: %s |", super.toString(), getPromedioFinal(), getPeriodoGraduado());
    }

    
}