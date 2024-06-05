package escuela.deserializers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import escuela.models.ProfesorModel;
import sistema.Sistema;

import usuarios.Trabajadores.Profesor;
import usuarios.constantes.NombreCarrera;

public class ProfesorDeserializer {
    public static void deserialize() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("profesores.json"));
            Gson gson = new Gson();
            ProfesorModel profesoresModel = gson.fromJson(reader, ProfesorModel.class);

            ArrayList<Profesor> sistemas = new ArrayList<>(profesoresModel.getListaSistemas());
            ArrayList<Profesor> materiales = new ArrayList<>(profesoresModel.getListaMateriales());
            ArrayList<Profesor> electronica = new ArrayList<>(profesoresModel.getListaElectronica());

            Sistema.profesores.put(NombreCarrera.SISTEMAS.toString(), sistemas);
            Sistema.profesores.put(NombreCarrera.MATERIALES.toString(), materiales);
            Sistema.profesores.put(NombreCarrera.ELECTRONICA.toString(), electronica);

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
