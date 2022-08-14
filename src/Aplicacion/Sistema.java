package Aplicacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
*Clase que controla la operativa general del programa
 */
public class Sistema{
    private ArrayList<Jugador> jugadores;
    private Jugador jugador1, jugador2, jugadorActual;

    Ficheros ficheros;

    /**
     * Constructor de la clase
     *
     * @param ficheros
     */
    public Sistema(Ficheros ficheros){
        this.ficheros=ficheros;
        jugador1 = new Jugador("Alejandro");
        jugador2 = new Jugador("Ana");
        jugadorActual= jugador1;
    }

    /**
     * Se lee por pantalla el nombre del jugador
     * y se guarda dicho jugador en el fichero
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void crearJugador() throws IOException, ClassNotFoundException {
        ficheros.leerJugadores();
        System.out.println("Introduce el nombre del jugador ");
        Scanner leer = new Scanner(System.in);
        String nombre = leer.nextLine();
        Jugador jugadorNuevo = new Jugador(nombre);
        ficheros.guardarJugador(jugadorNuevo);
    }

    /**
     * Muestra la lista de jugadores
     */
    public void verJugadores() {
        if(jugadores.isEmpty()){
            System.out.println("No hay jugadores registrados hasta el momento");
        }else{
            System.out.println("Los jugadores registrados son:");
            for (int i = 0; i < jugadores.size(); i++) {
                System.out.println(i+1 + ". " + getJugadores().get(i).getNombre());
            }
        }
    }

    /**
     * Cada vez que se carga el menú principal se actualiza
     * la lista de jugadores desde el fichero
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void actualizarJugadores() throws IOException, ClassNotFoundException {
        ficheros.leerJugadores();
        jugadores=ficheros.getJugadores();
    }

    public void probar() throws IOException {
        while(true) {
            GestorPalabras gestorPalabras = new GestorPalabras();
            System.out.println("Escribe la letra");
            Scanner leer = new Scanner(System.in);
            char caracter = leer.next().charAt(0);
            Palabra palabra = gestorPalabras.darDefinicion(caracter - 96);
            System.out.println("Letra:" + palabra.getLetra());
            System.out.println("Enunciado:" + palabra.getPregunta());
            System.out.println("Solución:" + palabra.getSolucion());
        }
    }

    /**
     * Método que cambia el jugadorActual
     */
   public void cambiarTurno(){
        if(jugadorActual== jugador1){
            jugadorActual= jugador2;
        }else{
            jugadorActual= jugador1;
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



    public Jugador getJugador(String jugador1) {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugador1.equals(jugadores.get(i).getNombre())) {
                return jugadores.get(i);
            }
        }
        return null;

    }
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

}
