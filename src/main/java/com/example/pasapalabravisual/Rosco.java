package com.example.pasapalabravisual;

/**
 *
 *  * @author Julia Martínez Vélez
 * @author Ana León Cruz
 * @author Marta Soria Morales
 */
import java.util.ArrayList;

public class Rosco {

    private int numeroLetras;
    private ArrayList<String> letras;
    private ArrayList<String> roscoJug;
    private Jugador jugador;
    private ArrayList<PalabraAntigua> palabraAntiguas;
    private ArrayList<PalabraAntigua> numeroAciertos;
    private ArrayList<PalabraAntigua> numeroFallos;

    public Rosco(Jugador jugador, BancoPalabras banco, int numeroLetras) {
        this.numeroLetras = numeroLetras;
        this.jugador = jugador;
        this.letras = new ArrayList<String>();
        letras.add("A");
        letras.add("B");
        letras.add("C");
        letras.add("D");
        letras.add("E");
        letras.add("F");
        letras.add("G");
        letras.add("H");
        letras.add("I");
        letras.add("J");
        letras.add("L");
        letras.add("M");
        letras.add("N");
        letras.add("Ñ");
        letras.add("O");
        letras.add("P");
        letras.add("Q");
        letras.add("R");
        letras.add("S");
        letras.add("T");
        letras.add("U");
        letras.add("V");
        letras.add("X");
        letras.add("Y");
        letras.add("Z");

        this.palabraAntiguas = new ArrayList<PalabraAntigua>();
        for (int i = 0; i < numeroLetras; i++) {
            palabraAntiguas.add(new PalabraAntigua(letras.get(i), banco));
        }
    }

    public ArrayList<PalabraAntigua> getNumeroFallos() {
        return numeroFallos;
    }

    public void setNumeroFallos(ArrayList<PalabraAntigua> numeroFallos) {
        this.numeroFallos = numeroFallos;
    }

    public ArrayList<PalabraAntigua> getNumeroAciertos() {
        return numeroAciertos;
    }

    public int getNumeroLetras() {
        return numeroLetras;
    }

    @Override
    public String toString() {
        return jugador.getNombre() + ", tu rosco tiene " + numeroLetras + " letras: " + roscoJug;
    }

    public ArrayList<PalabraAntigua> contarAciertosFallos(String intento, PalabraAntigua solucion, Rosco rosco) {
        if (solucion.getTermino().equals(intento)) {
            numeroAciertos.add(solucion);
            return numeroAciertos;
        } else {
            numeroFallos.add(solucion);
            return numeroFallos;
        }
    }

    public boolean dosVueltasRosco() {
        int contador = 0;
        while (contador <= 2) {
            for (int i = 0; i < roscoJug.size(); i++) {
                if (i == (roscoJug.size() - 1)) {
                    contador += 1;
                }
            }
        }
        return true;
    }

    public ArrayList<PalabraAntigua> getPalabras() {
        return palabraAntiguas;
    }

    public boolean roscoAcabado() {
        for (int i = 0; i <= roscoJug.size(); i++) {
            if (i == roscoJug.size()) {
                return true;
            }
        }
        return false;
    }

}
