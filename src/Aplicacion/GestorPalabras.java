package Aplicacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Clase que controla la operativa del fichero de palabras
 */
public class GestorPalabras {

    /**
     * A partir de una letra produce una definición aleatoria con su respuesta
     * @param numLetra
     * @return
     * @throws IOException
     */
    public Palabra darDefinicion(int numLetra) throws IOException {
        String palabraConLetra = null;
        String palabrasConLetra = null;
        Palabra palabra = null;
        int i;
        int j;
        char letra = (char) (96 + numLetra);
        File archivoPalabras = new File("Resources/Palabras.txt");
        BufferedReader lector = new BufferedReader(new FileReader("Resources/Palabras.txt"));
        StringBuilder cadena = new StringBuilder();
        String line = null;
        while ((line = lector.readLine()) != null) {
            cadena.append(line);
        }
        lector.close();
        String contenido = cadena.toString();
        ArrayList<Palabra> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(contenido, "#"); //Cambia de letra
        for (i = 0; i < numLetra; i++) {  //Solo se seleccionan las palabras de esa letra
            palabrasConLetra = tokenizer.nextToken();
        }
        StringTokenizer tokenizer2 = new StringTokenizer(palabrasConLetra, "/"); //Cambia palabras en la misma letra
        int numeroPalabrasLetra = tokenizer2.countTokens();
        //System.out.println("Palabras en letra " + letra + " = " + numeroPalabrasLetra);
        int random = (int) ((Math.random()*10+1) % numeroPalabrasLetra);
        //System.out.println("Numero aleatorio = " + random);
        for (j=0; j <= random; j++){
            palabraConLetra = tokenizer2.nextToken();
        }
        StringTokenizer tokenizer3 = new StringTokenizer(palabraConLetra, "|"); //Divide letra, solucion, enunciado
        palabra = new Palabra(tokenizer3.nextToken(), tokenizer3.nextToken(), tokenizer3.nextToken());
        return palabra;

    }
}
