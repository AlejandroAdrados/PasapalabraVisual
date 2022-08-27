package Aplicacion;

import java.io.*;
import java.util.ArrayList;

/**
 * Clase que controla el manejo de ficheros del programa
 */
public class Ficheros implements Serializable {
    private ArrayList<Jugador> jugadores;
    private File ficheroJugadores = new File("Resources/Jugadores.txt");
    private File ficheroPartida = new File("Resources/PartidaGuardada.txt");

    /**
     * Método que carga los jugadores del fichero jugadores.txt en una lista.
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void leerJugadores() throws IOException, ClassNotFoundException {
        if (!ficheroJugadores.exists()) {
            jugadores = new ArrayList<>();
        } else {
            ObjectInputStream leyendoFichero = new ObjectInputStream(
                    new FileInputStream("Resources/Jugadores.txt"));
            jugadores = (ArrayList<Jugador>) leyendoFichero.readObject();
            leyendoFichero.close();
        }
    }

    /**
     * Método que guarda un jugador nuevo en el fichero jugadores.txt (Si no existe el fichero lo crea).
     *
     * @param jugador
     * @throws IOException
     */
    public void guardarJugador(Jugador jugador) throws IOException {
        jugadores.add(jugador);
        if (!ficheroJugadores.exists()) {
            ficheroJugadores.createNewFile();
        }
        ObjectOutputStream escribiendoFichero = new ObjectOutputStream(
                new FileOutputStream("Resources/Jugadores.txt"));
        escribiendoFichero.writeObject(jugadores);
        escribiendoFichero.close();
    }

    /**
     * Método que elimina un jugador en concreto del fichero jugadores.txt
     *
     * @param jugador
     * @throws IOException
     */
    public void eliminarJugador(Jugador jugador) throws IOException {
        jugadores.remove(jugador);
        ObjectOutputStream escribiendoFichero = new ObjectOutputStream(
                new FileOutputStream("Resources/Jugadores.txt"));
        escribiendoFichero.writeObject(jugadores);
        escribiendoFichero.close();
    }

    /**
     * Método que a partir del nombre del jugador devuelve el tipo Jugador.
     *
     * @param nombreJugador
     * @return
     */
    public Jugador buscarJugador(String nombreJugador) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equals(nombreJugador)) {
                return jugador;
            }
        }
        return null;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void guardarPartida(Partida partida) throws IOException {
        if (!ficheroPartida.exists()) {
            ficheroPartida.createNewFile();
        }
        ObjectOutputStream escribiendoFichero = new ObjectOutputStream(
                new FileOutputStream("Resources/PartidaGuardada.txt"));
        escribiendoFichero.writeObject(partida);
        escribiendoFichero.close();
    }

    public Partida cargarPartida() throws IOException, ClassNotFoundException {
        if (!ficheroPartida.exists()) {
            return null;
        } else {
            ObjectInputStream leyendoFichero = new ObjectInputStream(
                    new FileInputStream("Resources/PartidaGuardada.txt"));
            Partida partida = (Partida) leyendoFichero.readObject();
            leyendoFichero.close();
            return partida;
        }
    }
}
