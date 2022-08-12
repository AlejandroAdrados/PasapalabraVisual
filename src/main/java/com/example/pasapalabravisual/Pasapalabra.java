package com.example.pasapalabravisual;

import java.io.IOException;
import java.util.Scanner;

/**
 * * @author Julia Martínez Vélez
 *
 * @author Ana León Cruz
 * @author Marta Soria Morales
 */
public class Pasapalabra {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Ficheros ficheros = new Ficheros();
        Sistema sistema = new Sistema(ficheros);

        while (true) {
            sistema.actualizarJugadores();
            System.out.println("Elige la opción.");
            System.out.println("1- Crear jugador");
            System.out.println("2- Ver jugadores");
            System.out.println("3- JUGAR");
            System.out.println("4- Probar");
            System.out.println("5- Salir");
            Scanner leer = new Scanner(System.in);
            String opcion = leer.nextLine();
            switch (opcion) {
                case "1":
                    sistema.crearJugador();
                    break;
                case "2":
                    sistema.verJugadores();
                    break;
                case "3": {
                    System.out.println("Introduce el primer jugador:  ");
                    leer = new Scanner(System.in);
                    String jugador1 = leer.nextLine();
                    Jugador j1 = sistema.getJugador(jugador1);
                    System.out.println("Introduce el segundo jugador:  ");
                    leer = new Scanner(System.in);
                    String jugador2 = leer.nextLine();
                    Jugador j2 = sistema.getJugador(jugador2);
                    if (j1 != null && j2 != null && !j1.equals(j2)) {
                        sistema.partida(j1, j2);
                    } else {
                        System.out.println("Error con los nombres de los jugadores.");
                    }
                    break;
                }
                case "4":
                    sistema.probar();
                    break;
                case "5":
                    System.exit(0);

            }

            /*if (opcion.equals("3")) {
                sistema.backupJugadores();
                //sistema.backUpPartidas();
            }
            if (opcion.equals("4")) {
                sistema.restaurarJugadores("Jugadores.bin");
                //sistema.restaurarPartidas("Partidas.bin");
            }*/


            //CREAMOS TRES JUGADORES:
        /* Jugador jugador1 = new Jugador("Pepito"); //25 puntos
        Jugador jugador2 = new Jugador("Juanita"); //25 puntos
        Jugador jugador3 = new Jugador("Manolo", 10); //10 puntos
        
        //Probamos el método toString para los 3 jugadores
        System.out.println(jugador1);
        System.out.println(jugador2);
        System.out.println(jugador3);
        System.out.println( " ");
        
        System.out.println(jugador1.Jugar());
        System.out.println(jugador2.Jugar());
        System.out.println(jugador3.Jugar());
        
        //Ponemos que Manolo tiene 3 puntos, ¿Ahora puede jugar? NO
        jugador3.setPuntos(3);
        System.out.println(jugador3.Jugar());
        System.out.println( " ");
        
        //CREAMOS UN ROSCO CON 7 LETRAS PARA EL JUGADOR 1
        Rosco rosco1 = new Rosco(7, jugador1);
        System.out.println(rosco1);
        //CREAMOS UN ROSCO CON 7 LETRAS PARA EL JUGADOR 2
        Rosco rosco2 = new Rosco(7, jugador2);
        System.out.println(rosco2);
        System.out.println( " ");
        
        //CREAMOS TRES LISTAS DE DEFINICIONES:
        
        //La primera con 2 definiciones
        String listaDef1[] = new String[2];
        listaDef1[0] = "Fruta amarilla";
        listaDef1[1] = "Comida saludable";
        
        //La segunda con 3 definiciones
        String listaDef2[] = new String[3];
        listaDef2[0] = "Tabla con cuatro patas";
        listaDef2[1] = "Soporte para apoyar cosas";
        listaDef2[2] = "Sitio donde estudias";
        
        //La tercera con una definición
        String listaDef3[] = new String[1];
        listaDef3[0] = "Animal peligroso";
        
        //UNA VEZ CREADAS LAS DEFINICIONES, CREAMOS 3 PALABRAS
        //Cada palabra lleva asociada su lista de definiciones
        Palabra p1 = new Palabra("Platano", "P", listaDef1);
        Palabra p2 = new Palabra("Mesa", "M", listaDef2);
        Palabra p3 = new Palabra("Hipopotamo", "H", listaDef3);
        
        System.out.println("Palabra 1: " + p1);
        System.out.println("Palabra 2: " + p2);
        System.out.println("Palabra 3: " + p3);
        System.out.println( " ");
        
        //VAMOS A PROBAR EL MÉTODO DEFSIG, que me da la definición siguiente de la lista
        System.out.println("Definición 2 de Platano: " + p1.defSig(p1, listaDef1));
        //Vuelvo a imprimir la palabra 1, para comprobar que se ha quedado la 2ª def
        System.out.println("Palabra 1: " + p1);
        System.out.println( " ");
        
        //Vamos a prpbar el método devuelve33 (que me da el 33% de la palabra):     
        System.out.println("El 33% de " + p1.getTermino() + " es: " + p1.devuelve33(p1.getTermino()));

        
        jugador2.setPuntos(10);
        
        //VAMOS A PROBAR EL MÉTODO COMPRARPISTA
        //PRIMERO, CON VARIAS DEFINICIONES:
        //Te da la siguiente definición
        System.out.println(p2.compraPista(p2, jugador1));
        System.out.println( " ");
        
        //AHORA, CON UNA SOLA DEFINICIÓN:
        //Te da el 33% de la palabra
        System.out.println(p3.compraPista(p3, jugador1));
        System.out.println( " ");
        
        //COMPROBAMOS QUE LE RESTA LOS 5 PUNTOS QUE CUESTA LA PISTA (HA COMPRADO 2 PISTAS)
        System.out.println(jugador1.getNombre() + ", te quedan " + jugador1.getPuntos() + " puntos.");
        System.out.println( " ");
        
        //QUÉ PASA SI EL JUGADOR NO TIENE SUFICIENTES PUNTOS:
        jugador1.setPuntos(3);
        System.out.println(p3.compraPista(p3, jugador1));
        System.out.println( " ");

        //VAMOS A PROBAR EL MÉTODO COMPRADIRECTA
        //PRIMERO, CUANDO NO TIENE SUFICIENTES PUNTOS:
        System.out.println(p2.compraDirecta(p2, jugador1));
        System.out.println( " ");
        
        //AHORA, CUANDO SÍ PUEDE COMPRAR LA PALABRA:
        jugador1.setPuntos(50);
        System.out.println(p2.compraDirecta(p2, jugador1));
        System.out.println( " ");
        
        //COMPROBAMOS QUE LE RESTA LOS 20 PUNTOS QUE CUESTA
        System.out.println(jugador1.getNombre() + ", te quedan " + jugador1.getPuntos() + " puntos.");


        //Vamos a preguntarnos si el jugador 1 ha agobtado sus puntos
        System.out.println(jugador1.getNombre() + " ha agotado sus puntos: " + jugador1.agotarPuntos(jugador1)); //FALSE
        jugador1.setPuntos(0);
        System.out.println(jugador1.getNombre() + " ha agotado sus puntos: " + jugador1.agotarPuntos(jugador1)); //TRUE
        System.out.println( " ");
        
        //Vamos a probar el método estadoPalabra:
        System.out.println(p1.estadoPalabra(p1, "Fruta"));
        System.out.println(p1.estadoPalabra(p1, "Platano"));
        System.out.println( " ");
        
        ////Vamos a probar el toString de partida
        //Partida partida1 = new Partida (200000);
        System.out.println("Partida 1: " + partida1);*/
        }
    }
}
