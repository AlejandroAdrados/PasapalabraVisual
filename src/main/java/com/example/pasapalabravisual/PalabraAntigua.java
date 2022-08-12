package com.example.pasapalabravisual;

/**
 *
 * @author Julia Martínez Vélez
 * @author Ana León Cruz
 * @author Marta Soria Morales
 */
import java.util.ArrayList;
import java.util.Objects;

public class PalabraAntigua {

    private String termino;
    private String letra;
    private ArrayList<Definicion> listaDef;
    private int numDefActual = 0;

    public PalabraAntigua(String termino, String letra, ArrayList<Definicion> listaDef) {
        this.termino = termino;
        this.letra = letra;
        this.listaDef = listaDef;

    }

    public PalabraAntigua(String letra, BancoPalabras banco) {
        PalabraAntigua palabraAntigua = banco.cogerPalabra(letra);
        this.termino = palabraAntigua.getTermino();
        this.letra = letra;
        this.listaDef = palabraAntigua.getListaDef();

    }

    public ArrayList<Definicion> getListaDef() {
        return listaDef;
    }

    public String getTermino() {
        return termino;
    }

    public String getLetra() {
        return letra;
    }

//La primera definición que se imprime va a ser la primera de la lista.
//Según se vayan comprando pistas, aparecen las siguientes definiciones.
    public Definicion defSig(PalabraAntigua palabraAntigua, ArrayList<Definicion> listaDef, Definicion definicion) {

        int posicion = listaDef.indexOf(definicion);
        return listaDef.get(posicion + 1);

    }

    public String devuelve33(String termino) {
        int j = termino.length();
        int n = (int) 33 * j / 100;
        return termino.substring(0, n);
    }

    public String compraPista(PalabraAntigua palabraAntigua, Jugador jugador, Definicion definicion) {
        if (jugador.getPuntos() >= 5) {
            jugador.setPuntos(jugador.getPuntos() - 5);
            if ((palabraAntigua.getListaDef().size()) > 1) {
                return "La definición que has comprado es: " + palabraAntigua.defSig(palabraAntigua, palabraAntigua.getListaDef(), definicion);
            } else {
                return "El 33% de la palabra es: " + palabraAntigua.devuelve33(palabraAntigua.getTermino());
            }
        } else {
            return "No tienes suficientes puntos para comprar la pista.";
        }
    }

    public String compraDirecta(PalabraAntigua palabraAntigua, Jugador jugador) {
        if (jugador.getPuntos() >= 20) {
            jugador.setPuntos(jugador.getPuntos() - 20);
            //LA PALABRA ESTÁ ACERTADA palabra = ESTADO.ACERTADA
            return "La palabra es " + palabraAntigua.termino + " y está acertada.";
        } else {
            return "No tienes suficientes puntos para comprar la palabra.";
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.termino);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PalabraAntigua other = (PalabraAntigua) obj;
        if (!Objects.equals(this.termino, other.termino)) {
            return false;
        }
        return true;
    }

    public String estadoPalabra(PalabraAntigua palabraAntigua, String sugerencia) {
        if (palabraAntigua.termino.equals(sugerencia)) {
            return "La palabra está acertada";
        } else {
            return "La palabra NO está acertada";

        }

    }

    private String getDefinicion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
