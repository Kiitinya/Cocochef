/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

import java.io.*;
import static java.lang.Thread.sleep;
import java.net.*;
import java.util.Random;

/**
 *
 * @author ASHLE
 */
public class Servidor {

    public static void main(String[] args) throws InterruptedException {

        try {
            System.out.println("Servidor\n\n");
            int v = 0;
            while (v != 7) {
                v = Protocolo.RecibirTCP(2000);
                if (v == 7) {
                    System.out.println("El juego ha sido cerrado");
                    System.exit(0);
                }
                //System.out.println("Recibiendo: " + v);
                if (v == 8) {
                    System.out.println("Nuevo juego");
                }
                if (v == 9) {
                    System.out.println("Cargando juego");
                }
                if (v == 10) {
                    System.out.println("Subiendo de nivel");
                }
                if (v == 12) {
                    System.out.println("¡Omelett, ha atacado!");
                    sleep(500);
                    Protocolo.EnviarTCP((1 + ""), 3000);
                }
                if (v == 13) {
                    System.out.println("¡Omelett, ha atacado!");
                    sleep(500);
                    EnemigoAleatorio(3, 0);
                }
                if (v == 14) {
                    String valor = 100 + "";
                    System.out.println("El enemigo ha atacado");
                    Protocolo.EnviarTCP(valor, 3000);
                    EnemigoAleatorio(4, 0);
                }
                if (v == 15) {
                    System.out.println("¡Nuevo enemigo!");
                    String valor = 200 + "";
                    Protocolo.EnviarTCP(valor, 3000);
                }
                if (v == 16) {
                    System.out.println("Volver al menu de combate");
                }
                if (v == 17) {
                    EnemigoAleatorio(2, 1);
                }
            }
        } catch (IOException ex) {
            System.out.println("Error i/o");
        }
    }

    public static void EnemigoAleatorio(int maximo, int minimo) throws InterruptedException, IOException {
        sleep(500);
        Random random = new Random();
        int value = random.nextInt(maximo + minimo) + 1;
        String valor = value + "";
        //System.out.println(valor);
        Protocolo.EnviarTCP(valor, 3000);
    }
}
