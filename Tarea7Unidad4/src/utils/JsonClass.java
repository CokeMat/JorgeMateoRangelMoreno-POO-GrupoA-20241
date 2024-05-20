package utils;

import biblioteca.Biblioteca;
import com.google.gson.*;
import libros.Libro;
import libros.constants.Genero;
import usuarios.helpers.Rol;
import java.io.*;
import java.util.*;
import usuarios.Usuario;

public class JsonClass {
    static Gson json = new GsonBuilder().setPrettyPrinting().create();


    public static void addUsuarioJson(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.json"));
            json.toJson(Biblioteca.usuarios, writer);
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public static void addLibroJson(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("libros.json"));
            json.toJson(Biblioteca.libros, writer);
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void mostrarUsuarios(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("usuarios.json"));
            Gson gson = new Gson();
            UsuarioModel usuariosModel = gson.fromJson(reader, UsuarioModel.class);

            ArrayList<Usuario> usuariosTrabajadores = new ArrayList<>(usuariosModel.getTrabajadores());

            ArrayList<Usuario> usuariosClientes = new ArrayList<>(usuariosModel.getClientes());

            ArrayList<Usuario> usuariosGerente = new ArrayList<>(usuariosModel.getClientes());

            Biblioteca.usuarios.put(Rol.TRABAJADOR.toString(), usuariosTrabajadores);
            Biblioteca.usuarios.put(Rol.CLIENTE.toString(), usuariosClientes);
            Biblioteca.usuarios.put(Rol.GERENTE.toString(), usuariosGerente);
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

    public static void mostrarLibros(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("libros.json"));
            Gson gson = new Gson();
            LibroModel librosModel = gson.fromJson(reader, LibroModel.class);

            ArrayList<Libro> librosAccion = new ArrayList<>(librosModel.getAccion());

            ArrayList<Libro> librosComedia = new ArrayList<>(librosModel.getComedia());

            ArrayList<Libro> librosTerror = new ArrayList<>(librosModel.getTerror());

            Biblioteca.libros.put(Genero.ACCION.toString(), librosAccion);
            Biblioteca.libros.put(Genero.TERROR.toString(), librosTerror);
            Biblioteca.libros.put(Genero.COMEDIA.toString(), librosComedia);

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
