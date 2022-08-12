package com.example.pasapalabravisual;

/**
 *
 * * @author Julia Martínez Vélez
 * @author Ana León Cruz
 * @author Marta Soria Morales
 */

public class Pista extends Ayuda {

    private final int COSTEPISTA;
    private TipoPista pista;

    public int getCOSTEPISTA() {
        return COSTEPISTA;
    }

    public Pista(TipoPista pista) {
        COSTEPISTA = 5;
        this.pista = pista;

    }
}
