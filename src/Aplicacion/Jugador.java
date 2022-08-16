package Aplicacion;

import java.io.Serializable;

/**
 * Clase que almacena la información necesaria del jugador
 */

//TODO AÑADIR HOMBRE O MUJER
public class Jugador implements Serializable {

    private String nombre;
    private int puntos;
    private int indice; //Índice que sigue el jugador en su respectiva lista
    private int letrasRespondidas; //Número de letras respondidas (Acertadas o falladas)

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntos = 0;
        letrasRespondidas = 0;
        indice =0;
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

    public int getLetrasRespondidas() {
        return letrasRespondidas;
    }

    public void aumentarLetrasRespondidas(){
        letrasRespondidas++;
    }

    public void aumentarIndice(){indice++;}

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
}
