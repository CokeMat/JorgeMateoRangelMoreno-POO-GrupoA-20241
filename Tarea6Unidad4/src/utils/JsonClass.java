package utils;

import biblioteca.Biblioteca;
import com.google.gson.*;
import libros.constants.Genero;
import usuarios.helpers.Rol;
import java.io.*;
import java.util.*;

public class JsonClass {
    static Gson json = new GsonBuilder().setPrettyPrinting().create();


    public static void addUsuarioJson(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.json"));
            json.toJson(Biblioteca.usuarios, writer);
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }catch (Exception error){
        System.out.println(error);
        }
    }
    public static void addLibroJson(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("libros.json"));
            json.toJson(Biblioteca.libros, writer);
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }catch (Exception error){
            System.out.println(error);
        }
    }
    public static void add(){
        addUsuarioJson();
        addLibroJson();
    }
}
