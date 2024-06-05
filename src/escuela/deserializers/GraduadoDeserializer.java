package escuela.deserializers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import escuela.models.GraduadoModel;
import sistema.Sistema;
import usuarios.Alumnos.Graduado;
import usuarios.constantes.NombreCarrera;

public class GraduadoDeserializer {
    public static void deserialize() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("graduados.json"));
            Gson gson = new Gson();
            GraduadoModel graduadosModel = gson.fromJson(reader, GraduadoModel.class);

            ArrayList<Graduado> sistemas = new ArrayList<>(graduadosModel.getListaSistemas());
            ArrayList<Graduado> materiales = new ArrayList<>(graduadosModel.getListaMateriales());
            ArrayList<Graduado> electronica = new ArrayList<>(graduadosModel.getListaElectronica());

            Sistema.graduados.put(NombreCarrera.SISTEMAS.toString(), sistemas);
            Sistema.graduados.put(NombreCarrera.MATERIALES.toString(), materiales);
            Sistema.graduados.put(NombreCarrera.ELECTRONICA.toString(), electronica);

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
