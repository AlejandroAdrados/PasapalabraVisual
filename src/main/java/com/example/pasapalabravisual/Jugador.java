package com.example.pasapalabravisual;

import java.io.Serializable;

/**
 *
 *  * @author Julia Martínez Vélez
 * @author Ana León Cruz
 * @author Marta Soria Morales
 */

public class Jugador implements Serializable {

    private String nombre;
    private int puntos;
    private long dinero;
    private int turno;

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntos = 25;
        turno = 1;
        dinero=0;
    }

    public Jugador(String nombre, int puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public String Jugar() {
        Jugador jugador = this;
        if (jugador.puntos >= 5) {
            jugador.puntos -= 5;
            return "Puedes jugar " + jugador.nombre + ", te quedan " + jugador.puntos + " puntos";
        } else {
            return "Lo siento " + jugador.nombre + ", no tienes puntos suficientes. Tan solo tienes " + puntos + " puntos.";
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public long getDinero() {
        return dinero;
    }

    public void setDinero(long dinero) {
        this.dinero = dinero;
    }

    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", puntos=" + puntos + ", dinero=" + dinero + '}';
    }

    public boolean agotarPuntos(Jugador jugador) {
        if (jugador.puntos > 0) {
            return false;
        } else {
            return true;
        }
    }

    public int getTurno() {
        return turno;
    }

    public void aumentarTurno(){
        turno++;
    }
}
