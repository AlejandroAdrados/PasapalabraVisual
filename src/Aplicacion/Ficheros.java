package Aplicacion;

import java.io.*;
import java.util.ArrayList;

/**
 * Clase que controla el manejo de ficheros del programa
 */
public class Ficheros implements Serializable{
    private ArrayList<Jugador> jugadores;
    private File ficheroJugadores = new File("Resources/Jugadores.txt");

    /**
     * Método que carga los jugadores del fichero jugadores.txt en una lista.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void leerJugadores() throws IOException, ClassNotFoundException {
        if (!ficheroJugadores.exists()){
            jugadores = new ArrayList<>();
        }
        else {
            ObjectInputStream leyendoFichero = new ObjectInputStream(
                    new FileInputStream("Resources/Jugadores.txt"));
            jugadores = (ArrayList<Jugador>) leyendoFichero.readObject();
            leyendoFichero.close();
        }
    }

    /**
     * Método que guarda un jugador nuevo en el fichero jugadores.txt (Si no existe el fichero lo crea).
     * @param jugador
     * @throws IOException
     */
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

    /**
     * Método que elimina un jugador en concreto del fichero jugadores.txt
     * @param jugador
     * @throws IOException
     */
    public void eliminarJugador(Jugador jugador) throws IOException {
        jugadores.remove(jugador);
        ObjectOutputStream escribiendoFichero = new ObjectOutputStream(
                new FileOutputStream("Resources/Jugadores.txt") );
        escribiendoFichero.writeObject(jugadores);
        escribiendoFichero.close();
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

}
