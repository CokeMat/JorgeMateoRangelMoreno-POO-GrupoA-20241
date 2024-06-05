package escuela.grupos;

import usuarios.Alumnos.Alumno;
import usuarios.Trabajadores.Coordinador;
import usuarios.utils.helpers.DatosComun;
import utils.*;

import java.util.ArrayList;

import escuela.historiales.Historial;
import escuela.historiales.cursos.Curso;
import escuela.historiales.periodos.Periodo;
import escuela.materias.Materia;
import escuela.semestres.Semestre;
import sistema.Sistema;

public class Grupo {
    private String carrera;
    private ArrayList<Alumno> alumnosGrupo;
    private String tipoGrupo;
    private String IDsemestre;
    private ArrayList<Materia> materiasGrupo;
    private String IDgrupo, periodo;

    public Grupo(String carrera, String IDsemestre, String tipoGrupo, ArrayList<Materia> materiasGrupo, String periodo) {
        this.carrera = carrera;
        this.alumnosGrupo = new ArrayList<>();
        this.IDsemestre = IDsemestre;
        this.tipoGrupo = tipoGrupo;
        this.materiasGrupo = materiasGrupo;
        this.IDgrupo = Id.generate(carrera + tipoGrupo);
        this.periodo = periodo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public ArrayList<Alumno> getAlumnosGrupo() {
        return alumnosGrupo;
    }

    public void setAlumnosGrupo(ArrayList<Alumno> alumnosGrupo) {
        this.alumnosGrupo = alumnosGrupo;
    }

    public String getTipoGrupo() {
        return tipoGrupo;
    }

    public String getIDsemestre() {
        return IDsemestre;
    }

    public void setIDsemestre(String iDsemestre) {
        IDsemestre = iDsemestre;
    }

    public ArrayList<Materia> getMateriasGrupo() {
        return materiasGrupo;
    }

    public void setMateriasGrupo(ArrayList<Materia> materiasGrupo) {
        this.materiasGrupo = materiasGrupo;
    }

    public String getIDgrupo() {
        return IDgrupo;
    }

    

    @Override
    public String toString() {
        String cad =  String.format(
            "\n| ID DE GRUPO: %s | CARRERA: %s | GRUPO: %s | CANTIDAD DE ALUMNOS: %d |\n" +
                    "| SEMESTRE: %s |\n | MATERIAS: ", getIDgrupo(), getCarrera(), getTipoGrupo(), getAlumnosGrupo().size(), getIDsemestre());
        for (Materia materia : getMateriasGrupo()) {
            cad += String.format("%s / ", materia.getNombre());
        }
        cad += "|";
        return cad;
    }

    public static void showList() {
        String carrera = CarreraActual.getInstancia().getCarreraActual();
        System.out.printf("\n-------- G R U P O S  DE   %s---------\n", carrera);

        String semestre = "";
        for (int ans = 1; ans <= 3; ans++) {
            switch (ans) {
                case 1 -> semestre = "PRIMERO";
                case 2 -> semestre = "SEGUNDO";
                case 3 -> semestre = "TERCERO";
            }
            System.out.printf("\n* * * * * * * * * * * * S E M E S T R E : %s * * * * * * * * * * * * ", semestre);
            for (int i = 0; i < 2; i++) {
                char letter = (char) ('A' + i);
                System.out.printf("\n---------------------- G R U P O  %s ----------------------",
                        String.valueOf(letter));
                System.out.println(
                        Sistema.carreras.get(carrera).getSemestres().get(semestre).getGrupos()
                                .get(String.valueOf(letter)));
            }
        }
    }

    public static void showInfo() {
        String carrera = CarreraActual.getInstancia().getCarreraActual();
        int opcion = 0;
        Grupo grupo = null;

        while (opcion != 1 || opcion != 2) {
            showList();
            String semestre = seleccionarSemestre();
            System.out.println("SEMESTRE SELECCIONADO: " + semestre);
            System.out.println("¿De que grupo le gustaria ver su información?");
            System.out.println("1. A \n2. B");
            opcion = Ask.forInt("la opcion");
            switch (opcion) {
                case 1 -> grupo = Sistema.carreras.get(carrera).getSemestres().get(semestre).getGrupos()
                        .get(String.valueOf('A'));
                case 2 -> grupo = Sistema.carreras.get(carrera).getSemestres().get(semestre).getGrupos()
                        .get(String.valueOf('B'));
                default -> System.out.println("Opcion invalida, intente de nuevo");
            }
            if (grupo != null)
                break;
        }
        char letra = opcion == 1 ? 'A' : 'B';
        System.out.printf("\n------------ INFORMACION DEL GRUPO %c ------------\n", letra);
        System.out.println(grupo);
        System.out.println("------------------------------ L I S T A  D E  A L U M N O S ------------------------------");
        for (Alumno alumno : grupo.getAlumnosGrupo()) {
            System.out.println(alumno);
        }
    }

    private static String seleccionarSemestre() {
        String semestre = "";
        while (semestre.equals("")) {
            System.out.println("Elija el semestre del cual desea ver los grupos");
            System.out.println("1. PRIMERO");
            System.out.println("2. SEGUNDO");
            System.out.println("3 .TERCERO ");
            int ans = Ask.forInt("una opción(numérica)");
            switch (ans) {
                case 1 -> semestre = "PRIMERO";
                case 2 -> semestre = "SEGUNDO";
                case 3 -> semestre = "TERCERO";
                default -> System.out.println("Se ingresó una opción inválida");
            }
        }
        return semestre;
    }

    public static void cambiarAlumnoGrupo(){
        //Primero se obtiene al alumno que quiero cambiar
        System.out.println("Primero debemos conocer el grupo en el que se encuentra el alumno que desea cambiar");
        System.out.println("Ingrese los datos solicitados porfavor");
        String carrera = CarreraActual.getInstancia().getCarreraActual();
        String semestre = seleccionarSemestre();
        System.out.println("Ahora ingrese el tipo de grupo en el que se encuentra el alumno");
        String grupo = DatosComun.elegirGrupo(carrera, semestre);
        ArrayList<Alumno> alumnos = Sistema.carreras.get(carrera).getSemestres().get(semestre).getGrupos()
                .get(grupo).getAlumnosGrupo();
        System.out.printf("\nCARRERA: %s - SEMESTRE: %s - GRUPO: %s\n", carrera, semestre, grupo);
        if (alumnos.isEmpty()) {
            System.out.println("Este grupo no tiene ningún alumno registrado");
        }
        else{
            String numeroControl = "";
            boolean flag = false;
            while (true) {
                flag = false;
                int i = 0;
                //Se imprimen los números de control
                for (Alumno alumno : alumnos) {
                    i++;
                    System.out.printf("\n%d. | NOMBRE: %s | NUMERO DE CONTROL: %s |", i, alumno.getNombreCompleto(),alumno.getNumeroControl());//dejame ver que tampoco me acuerdo que hice aqui 
                }
                numeroControl = Ask.forString("el número de control del alumno que desea cambiar de grupo");
                if (Alumno.validNumeroControl(numeroControl, alumnos)) {//aquí hay que veririficar que el número de control ingresado sea válido
                    flag = true;
                    break;
                }
                else{
                    System.out.println("Se ingresó un número de control inválido");
                    System.out.println("¿Desea intentarlo de nuevo?");
                    System.out.println("1. SI\n2. NO");
                    int ans = Ask.forInt("una opción");
                    if (ans != 1) {break;    
                    }
                }

            }
            if (flag) {
                Alumno alumnoPrueba = Alumno.getAlumno(carrera, numeroControl);
                //grupo = alumnoPrueba.getGrupo();
                
                //forma artesanal
                
                int indexAlumno = 0;
                for (Alumno alumno : Sistema.carreras.get(carrera).getSemestres().get(semestre).getGrupos()
                .get(grupo).getAlumnosGrupo()) {
                    if (alumno.getNumeroControl().equals(alumnoPrueba.getNumeroControl())) {
                        break;
                    }
                    else{
                        indexAlumno++;
                    }
                }

                //indexAlumno = Sistema.carreras.get(carrera).getSemestres().get(semestre).getGrupos()
                //.get(grupo).getAlumnosGrupo().indexOf(alumnoPrueba);//no obtiene bien el índice

                System.out.println("Ahora ingrese el grupo al cual desea cambiar el alumno");
                String nuevoGrupo = DatosComun.elegirGrupo(carrera, semestre);

                
                if (nuevoGrupo.equals(Sistema.carreras.get(carrera).getSemestres().get(semestre).getGrupos()
                .get(grupo).getAlumnosGrupo().get(indexAlumno).getGrupo())) {//cuando intenta cambiarlo al mismo grupo en el que ya está
                    System.out.println("El alumno ya se encuentra en el grupo");
                    System.out.println("Por lo que no es necesario cambiarlo de grupo");
                }
                else{
                    //verificamos que haya cupo en el otro grupo
                    
                    if (Sistema.carreras.get(carrera).getSemestres().get(semestre).getGrupos()
                    .get(nuevoGrupo).getAlumnosGrupo().size() < 20) {
                        Alumno auxAlumno = Sistema.carreras.get(carrera).getSemestres().get(semestre).getGrupos()
                        .get(grupo).getAlumnosGrupo().get(indexAlumno);
                        //le cambiamos en su historial las materias del grupo anterior con las del grupo nuevo
                        String periodoActual = Coordinador.calcularUltimoPeriodo(carrera, numeroControl);
                        Periodo periodo = Sistema.historiales.get(carrera).get(auxAlumno.getNumeroControl()).getPeriodos().get(periodoActual);
                        boolean bandera = true;
                        for (Curso curso : periodo.getMateriasPeriodo()) {//verificar si no tiene ya una materia con calificacion asignada
                            if (curso.isCalificacionAsignada()) {
                                System.out.println("No es posible cambiar al alumno de grupo, debido a que ya tiene al menos una calificación asignada");
                                bandera = false;
                                break;
                            }
                        }
                        if (bandera) {
                            //le cambiamos su atributo grupo
                            auxAlumno.setGrupo(nuevoGrupo);
                            //lo eliminamos del grupo anterior
                            Sistema.carreras.get(carrera).getSemestres().get(semestre).getGrupos()
                            .get(grupo).getAlumnosGrupo().remove(indexAlumno);
                            //lo agregamos al nuevo grupo
                            Sistema.carreras.get(carrera).getSemestres().get(semestre).getGrupos()
                            .get(nuevoGrupo).getAlumnosGrupo().add(auxAlumno);

                            //cambiarle su historial de materias
                            int indexAlum = 0;
                            for (Alumno alumno : Sistema.alumnos.get(CarreraActual.getInstancia().getCarreraActual())) {
                                if (auxAlumno.getNumeroControl().equals(alumno.getNumeroControl())) {
                                    break;
                                }
                                else{
                                    indexAlum++;
                                }
                            }
                            Sistema.alumnos.get(CarreraActual.getInstancia().getCarreraActual()).get(indexAlum).setGrupo(nuevoGrupo);//cambirle su atributo en la lista de alumnos de Sistema
                            Sistema.historiales.get(carrera).put(auxAlumno.getNumeroControl(), new Historial(auxAlumno.getNumeroControl(), periodoActual));
                            System.out.println("El alumno ha sido cambiado de grupo con exito");//HashMap<String, Periodo> ya con el Periodo con las otras 3 materias cargadas
                            Sistema.guardarEnJson();
                        }
                    }
                    else{
                        System.out.printf("\nNo fue posible cambiar al alumno ya que el grupo %s, está en su cupo máximo", nuevoGrupo);
                    }
                }                
            }
        }
    }

    //quien hizo este metodo me esta ahorrando chamba, tu pusiste esto? XD 
    public static Grupo getGrupo(String nombreCarrera, Materia materia){
        Grupo grupo = null;
        for (Semestre semestre : Sistema.carreras.get(nombreCarrera).getSemestres().values()) {//PRIMERO, SEGUNDO Y TERCERO
            for (Grupo grupoActual : semestre.getGrupos().values()) {//grupo A y B
                for (Materia materiaActual : grupoActual.getMateriasGrupo()) {
                    if (materia.getId().equals(materiaActual.getId())) {
                        return grupoActual;
                    }
                }//hola
            }
        }
        return grupo;
    }
    
    public static String preguntarGrupo(){
        String grupo="";
        while(grupo == ""){
            System.out.println("1. Grupo A \n2. Grupo B\n");
            int option = Ask.forInt("la opcion del grupo");
            switch(option){
                case 1 -> grupo = "A";
                case 2 -> grupo = "B";
                default -> System.out.println("Opción invalida, vuelva a intentarlo.");
            }
        }
        return grupo;
    }

    public void setTipoGrupo(String tipoGrupo) {
        this.tipoGrupo = tipoGrupo;
    }

    public void setIDgrupo(String iDgrupo) {
        IDgrupo = iDgrupo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
