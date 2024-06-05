package escuela.deserializers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import escuela.historiales.Historial;
import escuela.models.HistorialModel;
import sistema.Sistema;
import usuarios.constantes.NombreCarrera;

public class HistorialDeserializer {
    public static void deserialize() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("historiales.json"));
            Gson gson = new Gson();
            HistorialModel carrerasModel = gson.fromJson(reader, HistorialModel.class);

            HashMap<String, Historial> sistemas = carrerasModel.getListaSistemas();
            HashMap<String, Historial> materiales = carrerasModel.getListaElectronica();
            HashMap<String, Historial> electronica = carrerasModel.getListaMateriales();

            Sistema.historiales.put(NombreCarrera.SISTEMAS.toString(), sistemas);
            Sistema.historiales.put(NombreCarrera.MATERIALES.toString(), materiales);
            Sistema.historiales.put(NombreCarrera.ELECTRONICA.toString(), electronica);

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
