/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pasapalabravisual;

/**
 *
 *  * @author Julia Martínez Vélez
 * @author Ana León Cruz
 * @author Marta Soria Morales
 */
import java.io.Serializable;
import java.util.ArrayList;

//TODO Clase a eliminar
public class BancoPalabras implements Serializable {

    private ArrayList<PalabraAntigua> palabrasA;
    private ArrayList<PalabraAntigua> palabrasB;
    private ArrayList<PalabraAntigua> palabrasC;
    private ArrayList<PalabraAntigua> palabrasD;
    private ArrayList<PalabraAntigua> palabrasE;
    private ArrayList<PalabraAntigua> palabrasF;
    private ArrayList<PalabraAntigua> palabrasG;
    private ArrayList<PalabraAntigua> palabrasHES;
    private ArrayList<PalabraAntigua> palabrasI;
    private ArrayList<PalabraAntigua> palabrasJ;
    private ArrayList<PalabraAntigua> palabrasL;
    private ArrayList<PalabraAntigua> palabrasM;
    private ArrayList<PalabraAntigua> palabrasN;
    private ArrayList<PalabraAntigua> palabrasÑ;
    private ArrayList<PalabraAntigua> palabrasO;
    private ArrayList<PalabraAntigua> palabrasP;
    private ArrayList<PalabraAntigua> palabrasQ;
    private ArrayList<PalabraAntigua> palabrasR;
    private ArrayList<PalabraAntigua> palabrasSES;
    private ArrayList<PalabraAntigua> palabrasT;
    private ArrayList<PalabraAntigua> palabrasU;
    private ArrayList<PalabraAntigua> palabrasV;
    private ArrayList<PalabraAntigua> palabrasXES;
    private ArrayList<PalabraAntigua> palabrasY;
    private ArrayList<PalabraAntigua> palabrasZ;

    public BancoPalabras() {
        ArrayList<Definicion> defs = new ArrayList<>();
        defs.add(new Definicion("Hay un ... en mí"));
        defs.add(new Definicion("La familia que eliges. "));
        this.palabrasA = new ArrayList<>();
        palabrasA.add(new PalabraAntigua("amigo", "A", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Con mi .... sabanero."));
        defs.add(new Definicion("Diminutivo de burro."));
        palabrasB = new ArrayList<>();
        this.palabrasB.add(new PalabraAntigua("burrito", "B", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Cortar una parte del cuerpo"));
        defs.add(new Definicion("Mutilar"));
        palabrasA.add(new PalabraAntigua("amputar", "A", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Trozo pequeño de chocolate."));
        defs.add(new Definicion("Persona atractiva."));
        palabrasB.add(new PalabraAntigua("bombón", "B", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Máquina para hacer fotos."));
        defs.add(new Definicion("Aparato con el que se hacen imágenes."));
        palabrasC = new ArrayList<>();
        palabrasC.add(new PalabraAntigua("cámara", "C", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Tumor maligno."));
        defs.add(new Definicion("Signo del zodiaco."));
        palabrasC.add(new PalabraAntigua("cáncer", "C", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Parada de un trabajo o esfuerzo."));
        defs.add(new Definicion("Intermedio."));
        palabrasD = new ArrayList<>();
        palabrasD.add(new PalabraAntigua("descanso", "D", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Situación de persona sin trabajo."));
        defs.add(new Definicion("Paro."));
        palabrasD.add(new PalabraAntigua("desempleo", "D", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Apuntar a una persona en el patrón."));
        defs.add(new Definicion("Censar."));
        palabrasE = new ArrayList<>();
        palabrasE.add(new PalabraAntigua("empadronar", "E", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Producir miedo."));
        defs.add(new Definicion("Aterrar."));
        palabrasE.add(new PalabraAntigua("espantar", "E", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Mantenerse sobre un líquido."));
        defs.add(new Definicion("Antónimo de hundirse."));
        palabrasF = new ArrayList<>();
        palabrasF.add(new PalabraAntigua("flotar", "F", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Hecho de convertirse en un líquido."));
        defs.add(new Definicion("Unión."));
        palabrasF.add(new PalabraAntigua("fusión", "F", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Anteojos."));
        defs.add(new Definicion("Objeto formado por dos lentes."));
        palabrasG = new ArrayList<>();
        palabrasG.add(new PalabraAntigua("gafas", "G", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Consumo."));
        defs.add(new Definicion("Desembolso."));
        palabrasG.add(new PalabraAntigua("gasto", "G", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Pronunciar sonidos."));
        defs.add(new Definicion("Comunicarse."));
        palabrasHES = new ArrayList<>();
        palabrasHES.add(new PalabraAntigua("hablar", "H", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Gran belleza."));
        defs.add(new Definicion("Lindo."));
        palabrasHES.add(new PalabraAntigua("hermoso", "H", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Canción de C Tangana."));
        defs.add(new Definicion("Que no se puede gobernar."));
        palabrasI = new ArrayList<>();
        palabrasI.add(new PalabraAntigua("ingobernable", "I", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Que no sucede casi nunca."));
        defs.add(new Definicion("Raro."));
        palabrasI.add(new PalabraAntigua("insólito", "I", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Puede ser de pata negra."));
        defs.add(new Definicion("Embutido de color rojo."));
        palabrasJ = new ArrayList<>();
        palabrasJ.add(new PalabraAntigua("Jamón", "J", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Persona que trabaja en un jardín."));
        defs.add(new Definicion("Se encarga de cuidar las plantas."));
        palabrasJ.add(new PalabraAntigua("Jardinero", "J", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Pelo de oveja."));
        defs.add(new Definicion("Dinero."));
        palabrasL = new ArrayList<>();
        palabrasL.add(new PalabraAntigua("lana", "L", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Lo contrario a oscuro."));
        defs.add(new Definicion("Las ventanas hacen el patio más ......"));
        palabrasL.add(new PalabraAntigua("Luminoso", "L", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Tiene 4 patas y sirve para apoyar cosas"));
        defs.add(new Definicion("Te sientas en la silla y estudias en la ...."));
        palabrasM = new ArrayList<>();
        palabrasM.add(new PalabraAntigua("Mesa", "M", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Los puedes cocinar a la carbonara o a la boloñesa"));
        defs.add(new Definicion("Pasta con forma de cilindros"));
        palabrasM.add(new PalabraAntigua("Macarrones", "M", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Sirve para oler cosas"));
        defs.add(new Definicion("Los mocos salen por la..."));
        palabrasN = new ArrayList<>();
        palabrasN.add(new PalabraAntigua("Nariz", "N", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("El día 25 de diciembre es..."));
        defs.add(new Definicion("Día en el que nace el niño Jesús"));
        palabrasN.add(new PalabraAntigua("Navidad", "N", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Tenemos 10 dedos y 10..."));
        defs.add(new Definicion("Recubrimiento del dedo"));
        palabrasÑ = new ArrayList<>();
        palabrasÑ.add(new PalabraAntigua("Uña", "Ñ", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("El país en el que vivimos"));
        defs.add(new Definicion("País situado en la Península Ibérica"));
        palabrasÑ.add(new PalabraAntigua("España", "Ñ", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Animal salvaje de 3 letras"));
        defs.add(new Definicion("Puede ser un peluche también"));
        palabrasO = new ArrayList<>();
        palabrasO.add(new PalabraAntigua("Oso", "O", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Nueva variante del Covid-19"));
        defs.add(new Definicion("Variante que ha contagiado a mucha gente en Navidad"));
        palabrasO.add(new PalabraAntigua("Ómicron", "O", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Fruta amarilla"));
        defs.add(new Definicion("Fruta que come Rafael Nadal"));
        palabrasP = new ArrayList<>();
        palabrasP.add(new PalabraAntigua("Plátano", "P", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Animal de compañía de 4 patas"));
        defs.add(new Definicion("Animal que hace el anuncio de Scottex"));
        palabrasP.add(new PalabraAntigua("Perro", "P", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Comida amarilla que le gusta a los ratones"));
        defs.add(new Definicion("Contiene gran cantidad de lactosa"));
        palabrasQ = new ArrayList<>();
        palabrasQ.add(new PalabraAntigua("Queso", "Q", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Cuando te quedas sin dinero"));
        defs.add(new Definicion("Estoy en números rojos, estoy en..."));
        palabrasQ.add(new PalabraAntigua("Quiebra", "Q", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Extraño"));
        defs.add(new Definicion("Inusual"));
        palabrasR = new ArrayList<>();
        palabrasR.add(new PalabraAntigua("Raro", "R", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Enfado muy grande."));
        defs.add(new Definicion("Efermedad que sufren algunos animales."));
        palabrasR.add(new PalabraAntigua("rabia", "R", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Que sobresale."));
        defs.add(new Definicion("Saliente."));
        palabrasSES = new ArrayList<>();
        palabrasSES.add(new PalabraAntigua("saltón", "S", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Manera respetuosa de dirigirse a los mayores."));
        defs.add(new Definicion("Persona mayor."));
        palabrasSES.add(new PalabraAntigua("señor", "S", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Lisiado."));
        defs.add(new Definicion("Inválido."));
        palabrasT = new ArrayList<>();
        palabrasT.add(new PalabraAntigua("tullido", "T", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Modo de andar de los caballos."));
        defs.add(new Definicion("Paliza."));
        palabrasT.add(new PalabraAntigua("trote", "T", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Persona que va a la universidad."));
        defs.add(new Definicion("Licenciado."));
        palabrasU = new ArrayList<>();
        palabrasU.add(new PalabraAntigua("universitario", "U", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Algo que es bueno."));
        defs.add(new Definicion("Quimera."));
        palabrasU.add(new PalabraAntigua("utopía", "U", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Vomitona."));
        defs.add(new Definicion("Acción de vomitar."));
        palabrasV = new ArrayList<>();
        palabrasV.add(new PalabraAntigua("vómito", "V", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Fuerza que tiene una persona para hacer algo."));
        defs.add(new Definicion("Capacidad de las personas para decidir lo que van a hacer."));
        palabrasV.add(new PalabraAntigua("voluntad", "V", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Odio hacia los extranjeros."));
        defs.add(new Definicion("Apatía hacia personas que no son de tu país."));
        palabrasXES = new ArrayList<>();
        palabrasXES.add(new PalabraAntigua("xenofobia", "X", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Instrumento musical."));
        defs.add(new Definicion("Tiene láminas de madera o metal que son golpeadas."));
        palabrasXES.add(new PalabraAntigua("xilófono", "X", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Drogadicto."));
        defs.add(new Definicion("Persona que consume droga."));
        palabrasY = new ArrayList<>();
        palabrasY.add(new PalabraAntigua("yonqui", "Y", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Reposar."));
        defs.add(new Definicion("Estar tumbado."));
        palabrasY.add(new PalabraAntigua("yacer", "Y", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Lo que nos ponemos en los pies para andar."));
        defs.add(new Definicion("Calzado."));
        palabrasZ = new ArrayList<>();
        palabrasZ.add(new PalabraAntigua("zapato", "Z", defs));

        defs = new ArrayList<>();
        defs.add(new Definicion("Muchacho."));
        defs.add(new Definicion("Mozo."));
        palabrasZ.add(new PalabraAntigua("zagal", "Z", defs));

    }

    public PalabraAntigua cogerPalabra(String letra) {
        if (letra.equals("A")) {
            return palabrasA.get((int) (Math.random() * palabrasA.size()));
        }
        if (letra.equals("B")) {
            return palabrasB.get((int) (Math.random() * palabrasB.size()));
        }
        if (letra.equals("C")) {
            return palabrasC.get((int) (Math.random() * palabrasC.size()));
        }
        if (letra.equals("D")) {
            return palabrasD.get((int) (Math.random() * palabrasD.size()));
        }
        if (letra.equals("E")) {
            return palabrasE.get((int) (Math.random() * palabrasE.size()));
        }
        if (letra.equals("F")) {
            return palabrasF.get((int) (Math.random() * palabrasF.size()));
        }
        if (letra.equals("G")) {
            return palabrasG.get((int) (Math.random() * palabrasG.size()));
        }
        if (letra.equals("H")) {
            return palabrasHES.get((int) (Math.random() * palabrasHES.size()));
        }
        if (letra.equals("I")) {
            return palabrasI.get((int) (Math.random() * palabrasI.size()));
        }
        if (letra.equals("J")) {
            return palabrasJ.get((int) (Math.random() * palabrasJ.size()));
        }
        if (letra.equals("L")) {
            return palabrasL.get((int) (Math.random() * palabrasL.size()));
        }
        if (letra.equals("M")) {
            return palabrasM.get((int) (Math.random() * palabrasM.size()));
        }
        if (letra.equals("N")) {
            return palabrasN.get((int) (Math.random() * palabrasN.size()));
        }
        if (letra.equals("Ñ")) {
            return palabrasÑ.get((int) (Math.random() * palabrasÑ.size()));
        }
        if (letra.equals("O")) {
            return palabrasO.get((int) (Math.random() * palabrasO.size()));
        }
        if (letra.equals("P")) {
            return palabrasP.get((int) (Math.random() * palabrasP.size()));
        }
        if (letra.equals("Q")) {
            return palabrasQ.get((int) (Math.random() * palabrasQ.size()));
        }
        if (letra.equals("R")) {
            return palabrasR.get((int) (Math.random() * palabrasR.size()));
        }
        if (letra.equals("S")) {
            return palabrasSES.get((int) (Math.random() * palabrasSES.size()));
        }

        if (letra.equals("T")) {
            return palabrasT.get((int) (Math.random() * palabrasT.size()));
        }

        if (letra.equals("U")) {
            return palabrasU.get((int) (Math.random() * palabrasU.size()));
        }
        if (letra.equals("V")) {
            return palabrasV.get((int) (Math.random() * palabrasV.size()));
        }
        if (letra.equals("X")) {
            return palabrasXES.get((int) (Math.random() * palabrasXES.size()));
        }

        if (letra.equals("Y")) {
            return palabrasY.get((int) (Math.random() * palabrasY.size()));
        }

        if (letra.equals("Z")) {
            return palabrasZ.get((int) (Math.random() * palabrasZ.size()));
        }

        return null;
    }

}
