package com.example.pasapalabravisual;

/**
 *
 *  * @author Julia Martínez Vélez
 * @author Ana León Cruz
 * @author Marta Soria Morales
 */
import java.io.Serializable;
import java.util.Scanner;

public class Partida implements Serializable {

    private long bote;
    private int numeroPartida;
    private Rosco rosco1;
    private Rosco rosco2;
    private Jugador ganador;

    public Rosco getRosco1() {
        return rosco1;
    }

    public Rosco getRosco2() {
        return rosco2;
    }

    public Partida(Jugador jug1, Jugador jug2, BancoPalabras banco, int numeroLetras) {
        this.rosco1 = new Rosco(jug1, banco, numeroLetras);
        this.rosco2 = new Rosco(jug2, banco, numeroLetras);
        ganador = null;

        System.out.println("Primer jugador: ");
        for (int i = 0; i < numeroLetras; i++) {
            System.out.println("Con la letra " + this.rosco1.getPalabras().get(i).getLetra() + ". Esta es la definición: ");
            System.out.println(this.rosco1.getPalabras().get(i).getListaDef().get(0).getDef());
            System.out.println("Intenta adivinar la palabra:  ");
            Scanner leer = new Scanner(System.in);
            String opcion = leer.nextLine();
            if (opcion.equals(this.rosco1.getPalabras().get(i).getTermino())) {
                System.out.println("¡Has acertado!");

            } else {
                System.out.println("Has fallado. ");
            }
        }
        System.out.println("Rosco terminado.");
        System.out.println("Segundo jugador: ");
        for (int i = 0; i < numeroLetras; i++) {
            System.out.println("Con la letra " + this.rosco2.getPalabras().get(i).getLetra() + ". Esta es la definición: ");
            System.out.println(this.rosco2.getPalabras().get(i).getListaDef().get(0).getDef());
            System.out.println("Intenta adivinar la palabra:  ");
            Scanner leer = new Scanner(System.in);
            String opcion = leer.nextLine();
            if (opcion.equals(this.rosco2.getPalabras().get(i).getTermino())) {
                System.out.println("¡Has acertado!");

            } else {
                System.out.println("Has fallado. Sigue intentándolo.");
            }
        }
        System.out.println("Rosco terminado.");

    }

    public long getBote() {
        return bote;
    }

    public void setBote(long bote) {
        this.bote = bote;
    }

    public long ganarPartida(Rosco rosco, Jugador jugador) {
        if (rosco.roscoAcabado() && (rosco.getNumeroAciertos().size() == rosco.getNumeroLetras())) {
            jugador.setDinero(jugador.getDinero() + bote);
            return jugador.getDinero();
        }
        return jugador.getDinero();
    }

    public boolean acabarPartida(Rosco rosco) {
        if (rosco.dosVueltasRosco() == true) {
            return true;
        }
        return false;
    }

    public String toString(Jugador jugador1, Jugador jugador2, Rosco rosco) {
        return "Partida{" + "bote=" + bote + ", jugador1=" + jugador1.getNombre()
                + ", jugador2=" + jugador2.getNombre() + ", rosco=" + rosco + ", numeroPartida="
                + numeroPartida + ",marcador" + jugador1.getPuntos() + "-" + jugador2.getPuntos();
    }

    public String empate(Rosco roscoJug1, Rosco roscoJug2, Jugador j1, Jugador j2) {
        if (roscoJug1.getNumeroAciertos().size() == (roscoJug2.getNumeroAciertos().size())) {
            if (roscoJug1.getNumeroFallos().size() < roscoJug2.getNumeroFallos().size()) {
                return "El jugador " + j1.getNombre() + " ha ganado.";
            }
            if (roscoJug1.getNumeroFallos().size() > roscoJug2.getNumeroFallos().size()) {
                return "El jugador " + j2.getNombre() + " ha ganado.";
            }
        }
        return "No hay empate.";
    }

}
