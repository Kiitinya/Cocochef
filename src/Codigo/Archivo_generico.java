/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

/**
 *
 * @author ASHLE
 */
import java.io.*;
import java.util.ArrayList;

public class Archivo_generico<T> {

    String nombre_archivo;
    File archivo = null;

    public Archivo_generico() {
        nombre_archivo = "archivo_obj.ser";
    }

    public Archivo_generico(String nombre_archivo_in) {
        nombre_archivo = nombre_archivo_in;
    }

    public boolean nuevoArchivo() {
        boolean resultado = false;
        if(archivo!=null){
        archivo.delete();
        }
        try {
            archivo = new File(nombre_archivo);
            resultado = archivo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public ArrayList<T> leerRegistros() {
        ArrayList<T> informacion = new ArrayList();
        FileInputStream file_InputStream = null;
        ObjectInputStream entrada = null;

        try {
            file_InputStream = new FileInputStream(nombre_archivo);
            entrada = new ObjectInputStream(file_InputStream);
            informacion = (ArrayList<T>) entrada.readObject();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (file_InputStream != null) {
                    file_InputStream.close();
                    file_InputStream = null;
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return informacion;
    }

    public boolean actualizarRegistros(ArrayList<T> informacion) {
        boolean resultado = false;
        FileOutputStream file_OutputStream = null;
        ObjectOutputStream salida = null;

        try {
            file_OutputStream = new FileOutputStream(nombre_archivo);
            salida = new ObjectOutputStream(file_OutputStream);
            salida.writeObject(informacion);

            resultado = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (file_OutputStream != null) {
                    file_OutputStream.close();
                    file_OutputStream = null;
                }
                if (salida != null) {
                    salida.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return resultado;
    }
}

