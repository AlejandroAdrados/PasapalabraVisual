package Aplicacion;

import java.io.Serializable;

/**
 * Clase que almacena la letra, el enunciado y la palabra en cuestión
 */
public class Palabra implements Serializable {
    private String letra;
    private String pregunta;
    private String solucion;

    public Palabra(String letra, String solucion, String pregunta) {
        this.letra = letra;
        this.pregunta = pregunta;
        this.solucion = solucion;
    }

    public String getLetra() {
        return letra;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getSolucion() {
        return solucion;
    }
}
