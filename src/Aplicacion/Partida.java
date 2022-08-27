package Aplicacion;

import javafx.scene.Node;

import java.io.Serializable;
import java.util.ArrayList;

public class Partida implements Serializable {
    private Sistema sistema;
    private ArrayList<String> letrasJ1;
    private ArrayList<String> letrasJ2;


    public Partida(Sistema sistema, ArrayList<String> letrasJ1, ArrayList<String> letrasJ2) {
        this.sistema = sistema;
        this.letrasJ1 = letrasJ1;
        this.letrasJ2 = letrasJ2;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public ArrayList<String> getLetrasJ1() {
        return letrasJ1;
    }

    public ArrayList<String> getLetrasJ2() {
        return letrasJ2;
    }
}
