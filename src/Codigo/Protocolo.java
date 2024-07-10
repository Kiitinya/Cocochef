/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

import java.net.*;
import java.io.*;

/**
 *
 * @author ASHLE
 */
public class Protocolo {

    public static int RecibirTCP(int puerto) throws SocketException, IOException {

        ServerSocket ss = new ServerSocket(puerto);
        
        int v = 0;
        Socket cliente = ss.accept();
        InputStream e = cliente.getInputStream();
        DataInputStream entrada = new DataInputStream(e);
        v = Integer.parseInt(entrada.readUTF());
        
        cliente.close();
        ss.close();
        return v;
    }

    public static void EnviarTCP(String n, int puerto) throws SocketException, IOException {
        try {
            Socket s = new Socket("localhost", puerto);
            OutputStream sal = s.getOutputStream();
            DataOutputStream salDatos = new DataOutputStream(sal);
            //System.out.println("Mensaje a enviar: " + n);
            salDatos.writeUTF(n);

        } catch (UnknownHostException ex) {
            System.out.println("No se encontro servidor");
        } catch (IOException ex) {
            System.out.println("Error i/o");
        }
    }
}
