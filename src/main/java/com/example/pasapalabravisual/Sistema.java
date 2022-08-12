package com.example.pasapalabravisual;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
*Clase que controla la operativa general del programa
 */
public class Sistema{
    private ArrayList<Jugador> jugadores;
    private ArrayList<Partida> partidas;
    private BancoPalabras banco;

    private Jugador jugador1Clase, jugador2Clase, jugadorActual;

    Ficheros ficheros;

    /**
     * Constructor de la clase
     *
     * @param ficheros
     */
    public Sistema(Ficheros ficheros){
        this.ficheros=ficheros;
        jugador1Clase=new Jugador("Alejandro");
        jugador2Clase=new Jugador("Ana");
        jugadorActual=jugador1Clase;
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

    public boolean poderJugar(Jugador jugador1) {
        if (jugador1.getPuntos() >= 5) {
            jugador1.setPuntos(jugador1.getPuntos() - 5);
            System.out.println("Puedes jugar " + jugador1.getNombre() + ", te quedan " + jugador1.getPuntos() + " puntos");
            return true;
        } else {
            System.out.println("Lo siento " + jugador1.getNombre() + ", no tienes puntos suficientes. Tan solo tienes " + jugador1.getPuntos() + " puntos.");
            return false;
        }

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

   public void jugar(Jugador jugador) throws IOException {
        Boolean siguienteTurno=false;
        GestorPalabras gestorPalabras = new GestorPalabras();
       Palabra palabra=null;
       System.out.println(jugador.getNombre() + " es tu turno.");
       while(jugador.getTurno()<27 && siguienteTurno==false) {
           palabra = gestorPalabras.darDefinicion(jugador.getTurno());
           System.out.println("Empieza por " + palabra.getLetra());
           System.out.println(palabra.getPregunta());
           Scanner sc = new Scanner(System.in);
           String respuestaUsuario = sc.nextLine();
           if (respuestaUsuario.equals("Pasapalabra")) {
               System.out.println(jugador.getNombre() + " pasó el turno.");
               siguienteTurno=true;
           } else if (respuestaUsuario.equals(palabra.getSolucion())) {
               System.out.println("Respuesta correcta");
           }else{
               siguienteTurno=true;
               System.out.println("Respuesta errónea");
           }
           jugador.aumentarTurno();
       }
   }


   public void partida(Jugador jugador1, Jugador jugador2) throws IOException {
        jugador1Clase=jugador1;
        jugador2Clase=jugador2;
        jugadorActual=jugador1;
        while(jugador1.getTurno()<26 || jugador2.getTurno()<26) {
            if (jugador1.getTurno() < 26) {
                jugar(jugador1);
            }
            if (jugador2.getTurno() < 26) {
                jugar(jugador2);
            }
        }
   }

   public void cambiarTurno(){
        if(jugadorActual==jugador1Clase){
            jugadorActual=jugador2Clase;
        }else{
            jugadorActual=jugador1Clase;
        }
   }

    public Jugador getJugador1Clase() {
        return jugador1Clase;
    }

    public Jugador getJugador2Clase() {
        return jugador2Clase;
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public void jugarAntiguo(Jugador jugador1, Jugador jugador2) {

        if (poderJugar(jugador1) && poderJugar(jugador2)) {

            int numeroLetras = this.letrasRosco();
            Partida partida = new Partida(jugador1, jugador2, banco, numeroLetras);

        }
    }

    public int letrasRosco() {
        System.out.println("Introduce hasta qué letra quieres (en mayúscula): ");
        Scanner leer = new Scanner(System.in);
        String numeroLetras = leer.nextLine();
        ArrayList<String> letras = new ArrayList<String>();
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

        ArrayList<String> nuevaLista = new ArrayList<>();
        boolean sePuede = true;
        Iterator<String> it = letras.iterator();
        String otra = null;
        int n = 0;
        while ((it.hasNext()) && (sePuede)) {
            otra = it.next();
            nuevaLista.add(otra);
            n++;
            if (otra.equals(numeroLetras)) {
                sePuede = false;
            }

        }

        System.out.println(nuevaLista);
        return n;

    }

    public ArrayList<String> infoPartidas() {
        ArrayList<String> nuevaLista = new ArrayList<>();
        for (Partida partida : partidas) {
            nuevaLista.add(partida.toString());
        }
        return nuevaLista;
    }

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

    /*public void backUpPartidas(){
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
     */
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

    /* public void restaurarPartidas(String ruta) { 
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
            return "La palabra es " + palabraAntigua.getTermino() + " y está acertada.";
        } else {
            return "No tienes suficientes puntos para comprar la palabra.";
        }
    }

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

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    //To change body of generated methods, choose Tools | Templates.

}
