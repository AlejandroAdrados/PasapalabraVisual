package Aplicacion;

import java.io.Serializable;

/**
 * Clase que almacena la información necesaria del jugador
 */

public class Jugador implements Serializable {

    private String nombre; //Nombre del jugador
    private int puntos; //Puntos que lleva durante una partida (Fuera de ella será 0)
    private int indice; //Índice que sigue el jugador en su respectiva lista (Fuera del juego es 0)
    private int letrasRespondidas; //Número de letras respondidas (Acertadas o falladas) (Fuera del juego es 0)
    private String avatar; //Ruta relativa de la imagen
    private int partidasJugadas; //Número que almacena el histórico de partidas jugadas por parte del jugador
    private int puntosTotales; //Número que almacena el histórico de puntos conseguidos por parte del jugador

    /**
     * Constructor de la clase cuando un jugador se crea desde el inicio.
     *
     * @param nombre
     * @param avatar
     */
    public Jugador(String nombre, String avatar) {
        this.nombre = nombre;
        this.avatar = avatar;
    }

    /**
     * Constructor de la clase cuando se edita un jugador (partidasJugadas y puntosTotales se transfieren del original)
     *
     * @param nombre
     * @param avatar
     * @param partidasJugadas
     * @param puntosTotales
     */
    public Jugador(String nombre, String avatar, int partidasJugadas, int puntosTotales) {
        this.nombre = nombre;
        this.avatar = avatar;
        this.partidasJugadas = partidasJugadas;
        this.puntosTotales = puntosTotales;
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

    public void aumentarLetrasRespondidas() {
        letrasRespondidas++;
    }

    public void aumentarIndice() {
        indice++;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String getAvatar() {
        return avatar;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public void aumentarPartidasJugadas() {
        partidasJugadas++;
    }

    public void sumarPuntosTotales() {
        puntosTotales += puntos;
    }
}
