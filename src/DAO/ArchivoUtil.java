package DAO;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoUtil {

    public static <T extends Serializable> List<T> leerObjetos(String rutaArchivo) {
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            return (List<T>) stream.readObject();
        } catch (EOFException e) {
            // Si el archivo está vacío, devuelve una lista vacía
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Error al leer objetos desde el archivo", e);
        }
    }

    public static <T extends Serializable> void escribirObjetos(String rutaArchivo, List<T> objetos) {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            stream.writeObject(objetos);
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir objetos en el archivo", e);
        }
    }
}