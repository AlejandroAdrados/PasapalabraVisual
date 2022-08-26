package Aplicacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que controla la operativa general del programa
 */
public class Sistema {
    private ArrayList<Jugador> jugadores;
    private Jugador jugador1, jugador2, jugadorActual;
    private ArrayList<Palabra> palabrasJ1 = new ArrayList<>();
    private ArrayList<Palabra> palabrasJ2 = new ArrayList<>();
    private ArrayList<Palabra> palabrasJugadorActual;
    Ficheros ficheros;

    /**
     * Constructor de la clase
     *
     * @param ficheros
     */
    public Sistema(Ficheros ficheros, Jugador j1, Jugador j2) {
        this.ficheros = ficheros;
        jugador1 = j1;
        jugador2 = j2;
        jugadorActual = jugador1;
        palabrasJugadorActual = palabrasJ1;
    }

    /**
     * Método que inicializa el rosco de cada jugador y lo guarda en su respectiva lista
     *
     * @throws IOException
     */
    public void cargarRosco() throws IOException {
        GestorPalabras gestorPalabras = new GestorPalabras();
        for (int i = 1; i <= 25; i++) {
            palabrasJ1.add(gestorPalabras.darDefinicion(i));
            palabrasJ2.add(gestorPalabras.darDefinicion(i));
        }
    }

    /**
     * Método que elimina la palabra respondida por el usuario de su respectiva lista
     */
    public void palabraRespondida() {
        palabrasJugadorActual.remove(jugadorActual.getIndice());
        jugadorActual.aumentarLetrasRespondidas();
    }

    /**
     * Método que cambia el turno entre los jugadores si es posible
     *
     * @return Boolean si se ha cambiado el turno o no
     */
    public Boolean cambiarTurno() {
        if (jugadorActual.equals(jugador1) && jugador2.getLetrasRespondidas() < 25) {
            jugadorActual = jugador2;
            palabrasJugadorActual = palabrasJ2;
            return true;
        } else if (jugadorActual.equals(jugador2) && jugador1.getLetrasRespondidas() < 25) {
            jugadorActual = jugador1;
            palabrasJugadorActual = palabrasJ1;
            return true;
        } else {
            if (jugador1.getLetrasRespondidas() == 25 && jugador2.getLetrasRespondidas() == 25) {
                System.out.println("PARTIDA TERMINADA");
                System.exit(0);
            }
            return false;
        }
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public ArrayList<Palabra> getPalabrasJugadorActual() {
        return palabrasJugadorActual;
    }

    //Métodos antiguos

    /*
    public void backupJugadores() {

        try {
            FileOutputStream out = new FileOutputStream("Jugadores.bin");
            ObjectOutputStream so = new ObjectOutputStream(out);
            for (int i = 0; i < jugadores.size(); i++) {
                System.out.println("Metiendo usuario en fichero: " + jugadores.get(i).getNombre());
            }
            so.writeObject(this.jugadores);
            so.close();
            out.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void backUpPartidas(){
            try {
        FileOutputStream out = new FileOutputStream ("Partidas.bin"); 
        ObjectOutputStream so= new ObjectOutputStream(out);
        for(int i = 0; i<partidas.size();i++){
            System.out.println("Metiendo rosco 1: " + partidas.get(i).getRosco1());
            System.out.println("Metiendo rosco 2: " + partidas.get(i).getRosco2());
            so.writeObject(partidas.get(i).getRosco1()); 
            so.writeObject(partidas.get(i).getRosco2()); 
        }
        so.close();
        out.close();
            }
            catch (IOException ex) {
        System.err.println(ex.getMessage()); }} 

    public void restaurarJugadores(String ruta) {
        try {
            FileInputStream in = new FileInputStream(ruta);
            ObjectInputStream si = new ObjectInputStream(in);
            this.jugadores = (ArrayList<Jugador>) si.readObject();
            si.close();
            System.out.println("Lectura correcta");
        } catch (FileNotFoundException ex) {
            System.err.println("File Not Found");
        } catch (IOException ex) {
            System.err.println("Error de IO. La lectura ha fallado");
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        }
    }

     public void restaurarPartidas(String ruta) {
            try {
        FileInputStream in = new FileInputStream(ruta); 
        ObjectInputStream si = new ObjectInputStream(in); 
        this.partidas = (ArrayList<Partida>) si.readObject();
        si.close();
        System.out.println("Lectura correcta");
    } catch (FileNotFoundException ex) { System.err.println("File Not Found");
    } catch (IOException ex) {
    System.err.println("Error de IO. La lectura ha fallado");
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
    } }*/
}
