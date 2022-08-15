package Aplicacion;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class controladorJuego implements Initializable{
    @FXML
    private Label pregunta,letra,turno,puntos;
    @FXML
    private TextField respuesta;
    @FXML
    private ImageView avatar, imagenTurno, pasapalabra;
    @FXML
    private Button jugar;
    @FXML
    AnchorPane pane2;

    Ficheros ficheros = new Ficheros();
    Sistema sistema = new Sistema(ficheros);
    GestorPalabras gestorPalabras = new GestorPalabras();
    private Palabra palabra;

    private ArrayList<Node> listaElementosJ1 = new ArrayList<>();
    private ArrayList<Node> listaElementosJ2 = new ArrayList<>();
    public void preguntar() throws IOException {
        jugar.setVisible(false);
        respuesta.setVisible(true);
        avatar.setVisible(true);
        imagenTurno.setVisible(true);
        pasapalabra.setVisible(true);
        palabra = gestorPalabras.darDefinicion(sistema.getJugadorActual().getTurno());
        letra.setText("Empieza por " + palabra.getLetra());
        pregunta.setText(palabra.getPregunta());
        turno.setText("Turno de " + sistema.getJugadorActual().getNombre());
        respuesta.setText("");
        puntos.setText(sistema.getJugadorActual().getPuntos() + "");
    }


    /**
     * Método que se ejecuta tras dar al botón responder
     * @throws IOException
     */
    public void responder() throws IOException {
        String usuario = respuesta.getText();
        if (usuario.equals(palabra.getSolucion())) {
            cambiarLetra(sistema.getJugadorActual().getTurno(),true);
            sistema.getJugadorActual().aumentarPuntos();
            sistema.getJugadorActual().aumentarTurno();
        } else {
            cambiarLetra(sistema.getJugadorActual().getTurno(),false);
            sistema.getJugadorActual().aumentarTurno();
            cambiarTurno();
        }
        preguntar();
    }

    public void pasapalabra() throws IOException {
        sistema.getJugadorActual().aumentarTurno();
        cambiarTurno();
        preguntar();
    }

    /**
     * Cambia el turno del jugador, cambiando avatar y rosco de cada uno
     */
    private void cambiarTurno(){
        sistema.cambiarTurno();
        if(sistema.getJugadorActual().getNombre()=="Ana"){
            listaElementosJ1.clear();
            listaElementosJ1.addAll(pane2.getChildren());
            pane2.getChildren().clear();
            pane2.getChildren().addAll(listaElementosJ2);
            File file = new File("Resources/AvatarMujer.png");
            Image image = new Image(file.toURI().toString());
            avatar.setImage(image);
        }else{
            listaElementosJ2.clear();
            listaElementosJ2.addAll(pane2.getChildren());
            pane2.getChildren().clear();
            pane2.getChildren().addAll(listaElementosJ1);
            File file = new File("Resources/AvatarHombre.png");
            Image image = new Image(file.toURI().toString());
            avatar.setImage(image);
        }
    }

    /**
     * Cambia el color de la letra dependiendo de acierto o error
     * @param numLetra
     * @param acierto
     */
    private void cambiarLetra(int numLetra, Boolean acierto){
        File archivo;
        if(acierto) {
            archivo = new File("Resources/LETRASPASAPALABRA/" + numLetra + "VERDE.png");
        } else{
            archivo = new File("Resources/LETRASPASAPALABRA/" + numLetra + "ROJO.png");
        }
        Image image = new Image(archivo.toURI().toString());
        ImageView imageView = new ImageView(image);
        imageView.setVisible(true);
        imageView.setFitHeight(796);
        imageView.setFitWidth(1366);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        pane2.getChildren().add(imageView);
    }

    /**
     * Inicializa las listas de elementos de ambos jugadores al rosco vacío.
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listaElementosJ1.addAll(pane2.getChildren());
        listaElementosJ2.addAll(pane2.getChildren());
        File file = new File("Resources/AvatarHombre.png");
        Image image = new Image(file.toURI().toString());
        avatar.setImage(image);
    }

    public void entrarImagen(){
        File file = new File("Resources/PasapalabraDentro.png");
        Image image = new Image(file.toURI().toString());
        pasapalabra.setImage(image);
    }

    public void salirImagen(){
        File file = new File("Resources/PasapalabraFuera.png");
        Image image = new Image(file.toURI().toString());
        pasapalabra.setImage(image);
    }
}