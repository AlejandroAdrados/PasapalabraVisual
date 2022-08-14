package Aplicacion;

import java.io.Serializable;

/**
 * Clase que almacena la información necesaria del jugador
 */

//TODO AÑADIR HOMBRE O MUJER
public class Jugador implements Serializable {

    private String nombre;
    private int puntos;
    private long dinero;
    private int turno;

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntos = 0;
        turno = 1;
        dinero=0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void aumentarPuntos() {
        puntos++;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
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
