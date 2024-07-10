/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

import java.io.Serializable;
import javax.swing.*;

/**
 *
 * @author ASHLE
 */
public class Nivel implements Serializable {

    private String nombre;
    private int nivel;
    private int ataque;
    private int defensa;
    private int vida;
    private int exp;
    private int vida_max;
    private int exp_max;

    public Nivel(String nombre, int nivel, int ataque, int defensa, int vida, int exp, int vida_max, int exp_max) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.ataque = ataque;
        this.defensa = defensa;
        this.vida = vida;
        this.exp = exp;
        this.vida_max = vida_max;
        this.exp_max = exp_max;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getExp_max() {
        return exp_max;
    }

    public void setExp_max(int exp_max) {
        this.exp_max = exp_max;
    }

    public void setVida_max(int vida_max) {
        this.vida_max = vida_max;
    }

    public int getVida_max() {
        return vida_max;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getNivel() {
        return nivel;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getVida() {
        return vida;
    }

    public int getExp() {
        return exp;
    }

}
