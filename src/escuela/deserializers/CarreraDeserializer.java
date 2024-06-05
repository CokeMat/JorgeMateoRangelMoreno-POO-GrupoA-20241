package escuela.deserializers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import escuela.carreras.Carrera;
import escuela.models.CarreraModel;
import sistema.Sistema;
import usuarios.constantes.NombreCarrera;

public class CarreraDeserializer {
    public static void deserialize() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("carreras.json"));
            Gson gson = new Gson();
            CarreraModel carrerasModel = gson.fromJson(reader, CarreraModel.class);

            Carrera sistemas = carrerasModel.getListaSistemas();
            Carrera materiales = carrerasModel.getListaElectronica();
            Carrera electronica = carrerasModel.getListaMateriales();

            Sistema.carreras.put(NombreCarrera.SISTEMAS.toString(), sistemas);
            Sistema.carreras.put(NombreCarrera.MATERIALES.toString(), materiales);
            Sistema.carreras.put(NombreCarrera.ELECTRONICA.toString(), electronica);

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
