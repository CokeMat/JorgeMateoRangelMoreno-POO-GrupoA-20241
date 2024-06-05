package escuela.carreras;

import java.time.LocalDate;
import java.util.*;

import escuela.grupos.Grupo;
import escuela.materias.*;
import escuela.materias.utils.*;
import escuela.semestres.Semestre;
import sistema.Sistema;
import usuarios.Trabajadores.Coordinador;
import usuarios.utils.helpers.DatosComun;
import utils.*;

public class Carrera {
        private String id, nombreCarrera, fechaCreacion;
        private int cantidadGrupos, cantidadAlumnos, cantidadMaterias;
        private Coordinador coordinador;
        private HashMap<String, Semestre> semestres = new HashMap<>();// En las Keys van PRIMERO, SEGUNDO, TERCERO
        private HashMap<String, ArrayList<Materia>> materias = new HashMap<>(); // En las Keys va como:
                                                                                // NombreMateria.CALCULO1.toString() ---

        public Carrera() {
        }

        public Carrera(String nombreCarrera, Coordinador coordinador) {
                this.nombreCarrera = nombreCarrera;
                this.coordinador = coordinador;
                this.cantidadMaterias = 18;
                this.fechaCreacion = DatosComun.formateoFecha(LocalDate.now());
                this.id = Id.generate(this.nombreCarrera);
                incializarMaterias();
                incializarSemestres(getMaterias());
                this.cantidadGrupos = calcularCantidadGrupos();// CORREGIR
                this.cantidadAlumnos = calcularCantidadAlumnos(nombreCarrera);
        }

        private int calcularCantidadGrupos() {
                int r = 0;
                String cadenaSemestre = "";
                for (int i = 0; i < 3; i++) {
                        if (i == 0)
                                cadenaSemestre = "PRIMERO";
                        else if (i == 1)
                                cadenaSemestre = "SEGUNDO";
                        else
                                cadenaSemestre = "TERCERO";
                }
                for (Grupo grupo : semestres.get(cadenaSemestre).getGrupos().values()) {
                        r += grupo.getAlumnosGrupo().size();
                }
                return r;
        }

        private int calcularCantidadAlumnos(String nombreCarrera) {
                return Sistema.alumnos.get(nombreCarrera).size();
        }

        // Getters y Setters
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

        public int getCantidadGrupos() {
                int suma = 0;
                for (Semestre semestre : Sistema.carreras.get(CarreraActual.getInstancia().getCarreraActual())
                                .getSemestres().values()) {
                        for (Grupo grupo : semestre.getGrupos().values()) {
                                suma++;
                        }
                }
                return suma;
        }

        public void setCantidadGrupos(int cantidadGrupos) {
                this.cantidadGrupos = cantidadGrupos;
        }

        public int getCantidadAlumnos() {
                cantidadAlumnos = calcularCantidadAlumnos(getNombreCarrera());
                return cantidadAlumnos;
        }

        public void setCantidadAlumnos(int cantidadAlumnos) {
                this.cantidadAlumnos = cantidadAlumnos;
        }

        public int getCantidadMaterias() {
                return cantidadMaterias;
        }

        public void setCantidadMaterias(int cantidadMaterias) {
                this.cantidadMaterias = cantidadMaterias;
        }

        public String getFechaCreacion() {
                return fechaCreacion;
        }

        public void setFechaCreacion(String fechaCreacion) {
                this.fechaCreacion = fechaCreacion;
        }

        public Coordinador getCoordinador() {
                return coordinador;
        }

        public void setCoordinador(Coordinador coordinador) {
                this.coordinador = coordinador;
        }

        @Override
        public String toString() {
                return String.format(
                                "\n| ID:%s | NOMBRE DE LA CARRERA:%s | NOMBRE DEL COORDINADOR:%s | CANTIDAD DE GRUPOS: %d |"
                                                +
                                                "|CANTIDAD DE ALUMNOS: %d | CANTIDAD DE MATERIAS: %d | FECHA DE CREACION: %s |\n ",
                                getId(), getNombreCarrera(), getCoordinador().getNombreCompleto(), getCantidadGrupos(),
                                getCantidadAlumnos(), getCantidadMaterias(),
                                Fecha.imprimirFechaCompleta(getFechaCreacion()));
        }

        // LÓGICA CHIDA

        public HashMap<String, Semestre> getSemestres() {
                return semestres;
        }

        public HashMap<String, ArrayList<Materia>> getMaterias() {
                return materias;
        }

        private void incializarSemestres(HashMap<String, ArrayList<Materia>> materias) {
                semestres.put("PRIMERO", new Semestre(1, nombreCarrera, materias));
                semestres.put("SEGUNDO", new Semestre(2, nombreCarrera, materias));
                semestres.put("TERCERO", new Semestre(3, nombreCarrera, materias));
        }

        private void incializarMaterias() {
                switch (nombreCarrera) {
                        case "SISTEMAS" -> {// quiero que me genere una lista con n materias del nombre y la carrera
                                getMaterias().put(NombreMateriaSistemas.PROGRAMACION1.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaSistemas.PROGRAMACION1.toString())));
                                getMaterias().put(NombreMateriaSistemas.PROGRAMACION2.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaSistemas.PROGRAMACION2.toString())));
                                getMaterias().put(NombreMateriaSistemas.PROGRAMACION3.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaSistemas.PROGRAMACION3.toString())));
                                getMaterias().put(NombreMateriaSistemas.PROBABILIDAD1.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaSistemas.PROBABILIDAD1.toString())));
                                getMaterias().put(NombreMateriaSistemas.PROBABILIDAD2.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaSistemas.PROBABILIDAD2.toString())));
                                getMaterias().put(NombreMateriaSistemas.PROBABILIDAD3.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaSistemas.PROBABILIDAD3.toString())));
                                getMaterias().put(NombreMateriaSistemas.CALCULO1.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaSistemas.CALCULO1.toString())));
                                getMaterias().put(NombreMateriaSistemas.CALCULO2.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaSistemas.CALCULO2.toString())));
                                getMaterias().put(NombreMateriaSistemas.CALCULO3.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaSistemas.CALCULO3.toString())));
                        }
                        case "ELECTRONICA" -> {
                                getMaterias().put(NombreMateriaElectronica.CALCULO1.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaElectronica.CALCULO1.toString())));
                                getMaterias().put(NombreMateriaElectronica.CALCULO2.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaElectronica.CALCULO2.toString())));
                                getMaterias().put(NombreMateriaElectronica.CALCULO3.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaElectronica.CALCULO3.toString())));
                                getMaterias().put(NombreMateriaElectronica.REDES1.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaElectronica.REDES1.toString())));
                                getMaterias().put(NombreMateriaElectronica.REDES2.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaElectronica.REDES2.toString())));
                                getMaterias().put(NombreMateriaElectronica.REDES3.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaElectronica.REDES3.toString())));
                                getMaterias().put(NombreMateriaElectronica.CIRCUITOS1.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaElectronica.CIRCUITOS1.toString())));
                                getMaterias().put(NombreMateriaElectronica.CIRCUITOS2.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaElectronica.CIRCUITOS2.toString())));
                                getMaterias().put(NombreMateriaElectronica.CIRCUITOS3.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaElectronica.CIRCUITOS3.toString())));
                        }
                        case "MATERIALES" -> {
                                getMaterias().put(NombreMateriaMateriales.CALCULO1.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaMateriales.CALCULO1.toString())));
                                getMaterias().put(NombreMateriaMateriales.CALCULO2.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaMateriales.CALCULO2.toString())));
                                getMaterias().put(NombreMateriaMateriales.CALCULO3.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaMateriales.CALCULO3.toString())));
                                getMaterias().put(NombreMateriaMateriales.CONTABILIDAD1.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaMateriales.CONTABILIDAD1.toString())));
                                getMaterias().put(NombreMateriaMateriales.CONTABILIDAD2.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaMateriales.CONTABILIDAD2.toString())));
                                getMaterias().put(NombreMateriaMateriales.CONTABILIDAD3.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaMateriales.CONTABILIDAD3.toString())));
                                getMaterias().put(NombreMateriaMateriales.ESTADISTICA1.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaMateriales.ESTADISTICA1.toString())));
                                getMaterias().put(NombreMateriaMateriales.ESTADISTICA2.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaMateriales.ESTADISTICA2.toString())));
                                getMaterias().put(NombreMateriaMateriales.ESTADISTICA3.toString(), new ArrayList<>(
                                                Materia.generarMaterias(2, getNombreCarrera(),
                                                                NombreMateriaMateriales.ESTADISTICA3.toString())));
                        }
                }
        }

}
