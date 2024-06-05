package escuela.deserializers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import escuela.models.AlumnoModel;
import sistema.Sistema;
import usuarios.Alumnos.Alumno;
import usuarios.constantes.NombreCarrera;

public class AlumnoDeserializer {
    public static void deserialize() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("alumnos.json"));
            Gson gson = new Gson();
            AlumnoModel alumnosModel = gson.fromJson(reader, AlumnoModel.class);

            ArrayList<Alumno> sistemas = new ArrayList<>(alumnosModel.getListaSistemas());
            ArrayList<Alumno> materiales = new ArrayList<>(alumnosModel.getListaMateriales());
            ArrayList<Alumno> electronica = new ArrayList<>(alumnosModel.getListaElectronica());

            Sistema.alumnos.put(NombreCarrera.SISTEMAS.toString(), sistemas);
            Sistema.alumnos.put(NombreCarrera.MATERIALES.toString(), materiales);
            Sistema.alumnos.put(NombreCarrera.ELECTRONICA.toString(), electronica);

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (JsonSyntaxException e) {
            System.out.println(e);
        } catch (JsonParseException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
