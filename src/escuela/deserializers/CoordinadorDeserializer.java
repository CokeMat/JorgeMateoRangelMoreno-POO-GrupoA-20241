package escuela.deserializers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import escuela.models.CoordinadorModel;

import sistema.Sistema;
import usuarios.Trabajadores.Coordinador;

import usuarios.constantes.NombreCarrera;

public class CoordinadorDeserializer {
    public static void deserialize() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("coordinadores.json"));
            Gson gson = new Gson();
            CoordinadorModel coordinadoresModel = gson.fromJson(reader, CoordinadorModel.class);

            Coordinador sistemas = coordinadoresModel.getCoordinadorSistemas();
            Coordinador materiales = coordinadoresModel.getCoordinadorMateriales();
            Coordinador electronica = coordinadoresModel.getCoordinadorElectronica();

            Sistema.coordinadores.put(NombreCarrera.SISTEMAS.toString(), sistemas);
            Sistema.coordinadores.put(NombreCarrera.MATERIALES.toString(), materiales);
            Sistema.coordinadores.put(NombreCarrera.ELECTRONICA.toString(), electronica);

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
