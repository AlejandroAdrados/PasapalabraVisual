package com.example.pasapalabravisual;

import java.io.*;
import java.util.ArrayList;

/**
 * Clase que controla el manejo de ficheros del programa
 */
public class Ficheros implements Serializable{
    private ArrayList<Jugador> jugadores;
    private File ficheroJugadores = new File("Resources/Jugadores.txt");

    public ArrayList<Jugador> leerJugadores() throws IOException, ClassNotFoundException {
        if (!ficheroJugadores.exists()){
            jugadores = new ArrayList<>();
        }
        else {
            ObjectInputStream leyendoFichero = new ObjectInputStream(
                    new FileInputStream("Resources/Jugadores.txt"));
            jugadores = (ArrayList<Jugador>) leyendoFichero.readObject();
            leyendoFichero.close();
        }
        return jugadores;
    }

    public void guardarJugador(Jugador jugador) throws IOException {
        jugadores.add(jugador);
        if (!ficheroJugadores.exists()){
            ficheroJugadores.createNewFile();
        }
        ObjectOutputStream escribiendoFichero = new ObjectOutputStream(
                new FileOutputStream("Resources/Jugadores.txt") );
        escribiendoFichero.writeObject(jugadores);
        escribiendoFichero.close();
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

}
