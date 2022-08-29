package Aplicacion;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Clase que controla la operativa de la vista del juego (vistaJuego.fxml).
 */
public class ControladorJuego extends ControladorGeneral { //TODO Sumar partidas totales y puntos totales
    @FXML
    private Label pregunta;
    @FXML
    private Label letra;
    @FXML
    private Label turno, tiempo;
    @FXML
    private Label puntos;
    @FXML
    private TextField respuesta;
    @FXML
    private ImageView avatar, imagenTurno, pasapalabra;
    @FXML
    private Button jugar;
    @FXML
    AnchorPane pane2;
    private Palabra palabra;
    private ArrayList<Node> listaElementosJ1 = new ArrayList<>();
    private ArrayList<Node> listaElementosJ2 = new ArrayList<>();


    /**
     * Inicializa el juego y carga todas las palabras del rosco en cada jugador.
     */
    public void cargarRosco() throws IOException, ClassNotFoundException {
        if (getContenedor().isPartidaCargada()) {
            Partida partida = getContenedor().getGestorFicheros().cargarPartida();
            for (String rutaLetra : partida.getLetrasJ1()) {
                File archivo = new File(rutaLetra);
                Image image = new Image(archivo.toURI().toString());
                ImageView imageView = new ImageView(image);
                imageView.setVisible(true);
                imageView.setFitHeight(796);
                imageView.setFitWidth(1366);
                imageView.setPickOnBounds(true);
                imageView.setPreserveRatio(true);
                listaElementosJ1.add(imageView);
            }
            for (String rutaLetra : partida.getLetrasJ2()) {
                File archivo = new File(rutaLetra);
                Image image = new Image(archivo.toURI().toString());
                ImageView imageView = new ImageView(image);
                imageView.setVisible(true);
                imageView.setFitHeight(796);
                imageView.setFitWidth(1366);
                imageView.setPickOnBounds(true);
                imageView.setPreserveRatio(true);
                listaElementosJ2.add(imageView);
            }
            if (getContenedor().getSistema().getJugadorActual().equals(getContenedor().getSistema().getJugador1())) {
                pane2.getChildren().addAll(listaElementosJ2);
            } else {
                pane2.getChildren().addAll(listaElementosJ1);
            }
            cambiarTurno();
        } else {
            listaElementosJ1.addAll(pane2.getChildren());
            listaElementosJ2.addAll(pane2.getChildren());
            try {
                getContenedor().getSistema().cargarRosco();
            } catch (IOException e) {
                System.out.println("Error al cargar rosco");
            }
        }
        turno.setText("Turno de " + getContenedor().getSistema().getJugadorActual().getNombre());
        avatar.setImage(avatarJugador(getContenedor().getSistema().getJugadorActual()));
        tiempo();
    }

    /**
     * Método que escribe en la interfaz gráfica la pregunta
     *
     * @throws IOException
     */
    @FXML
    public void preguntar() throws IOException {
        jugar.setVisible(false);
        respuesta.setVisible(true);
        avatar.setVisible(true);
        imagenTurno.setVisible(true);
        pasapalabra.setVisible(true);
        if (getContenedor().getSistema().getJugadorActual().getIndice() < getContenedor().getSistema().getPalabrasJugadorActual().size() && !getContenedor().getSistema().getPalabrasJugadorActual().isEmpty()) {
        } else if (!getContenedor().getSistema().getPalabrasJugadorActual().isEmpty()) {
            getContenedor().getSistema().getJugadorActual().setIndice(0);
        } else { //Lista vacía => Jugador ha terminado
            cambiarTurno();
            if (getContenedor().getSistema().getJugadorActual().getIndice() < getContenedor().getSistema().getPalabrasJugadorActual().size() && !getContenedor().getSistema().getPalabrasJugadorActual().isEmpty()) {
            } else if (!getContenedor().getSistema().getPalabrasJugadorActual().isEmpty()) {
                getContenedor().getSistema().getJugadorActual().setIndice(0);
            } else {
                cambiarTurno(); //Ambos jugadores han terminado
            }
        }
        palabra = getContenedor().getSistema().getPalabrasJugadorActual().get(getContenedor().getSistema().getJugadorActual().getIndice());
        letra.setText("Empieza por " + palabra.getLetra());
        pregunta.setText(palabra.getPregunta());
        respuesta.setText("");
        puntos.setText(getContenedor().getSistema().getJugadorActual().getPuntos() + "");
    }

    /**
     * Método que se ejecuta tras dar al botón responder
     *
     * @throws IOException
     */
    @FXML
    private void responder() throws IOException {
        String usuario = respuesta.getText();
        if (usuario.equals(palabra.getSolucion())) {
            cambiarLetra(true);
            getContenedor().getSistema().getJugadorActual().aumentarPuntos();
            getContenedor().getSistema().palabraRespondida();
        } else {
            cambiarLetra(false);
            getContenedor().getSistema().palabraRespondida();
            cambiarTurno();
        }
        preguntar();
    }

    /**
     * Método que se ejecuta tras dar al botón de pasapalabra
     *
     * @throws IOException
     */
    @FXML
    private void pasapalabra() throws IOException {
        getContenedor().getSistema().getJugadorActual().aumentarIndice();
        cambiarTurno();
        preguntar();
    }

    /**
     * Cambia el turno del jugador, cambiando avatar y rosco de cada uno
     */
    private void cambiarTurno() {
        if (getContenedor().getSistema().cambiarTurno()) {
            if (getContenedor().getSistema().getJugadorActual().equals(getContenedor().getSistema().getJugador1())) {
                listaElementosJ1.clear();
                listaElementosJ1.addAll(pane2.getChildren());
                pane2.getChildren().clear();
                pane2.getChildren().addAll(listaElementosJ2);
            } else {
                listaElementosJ2.clear();
                listaElementosJ2.addAll(pane2.getChildren());
                pane2.getChildren().clear();
                pane2.getChildren().addAll(listaElementosJ1);
                File file = new File("Resources/ImagenesAvatares/AvatarMujer.png");
                Image image = new Image(file.toURI().toString());
                avatar.setImage(avatarJugador(getContenedor().getSistema().getJugadorActual()));
            }
            turno.setText("Turno de " + getContenedor().getSistema().getJugadorActual().getNombre());
            avatar.setImage(avatarJugador(getContenedor().getSistema().getJugadorActual()));
        }
    }

    /**
     * Cambia el color de la letra dependiendo de acierto o error
     *
     * @param acierto
     */
    private void cambiarLetra(Boolean acierto) {
        String letra = palabra.getLetra();
        File archivo;
        if (acierto) {
            archivo = new File("Resources/LETRASPASAPALABRA/" + letra + "VERDE.png");
        } else {
            archivo = new File("Resources/LETRASPASAPALABRA/" + letra + "ROJO.png");
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
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.
     */

    /**
     * Método que cambia la apariencia del botón pasapalabra al pasar el ratón por  él.
     */
    @FXML
    private void imagenDentro(MouseEvent mouseEvent) {  //Código de color #0c2f91
        ImageView imageView = (ImageView) mouseEvent.getSource();
        File file = new File("Resources/ImagenesJuego/" + imageView.getId() + "2.png");
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
    }

    /**
     * Método que cambia la apariencia del botón pasapalabra al pasar el ratón por  él.
     */
    @FXML
    private void imagenFuera(MouseEvent mouseEvent) { //Código de color #0842e3
        ImageView imageView = (ImageView) mouseEvent.getSource();
        File file = new File("Resources/ImagenesJuego/" + imageView.getId() + ".png");
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
    }

    @FXML
    private void guardarPartida() throws IOException {
        ArrayList<String> letrasJ1 = new ArrayList<>();
        ArrayList<String> letrasJ2 = new ArrayList<>();
        cambiarTurno();
        for (Node node : listaElementosJ1) {
            ImageView imagen = (ImageView) node;
            int i = imagen.getImage().getUrl().indexOf("Resources/LETRASPASAPALABRA/");
            letrasJ1.add(imagen.getImage().getUrl().substring(i));
        }
        for (Node node : listaElementosJ2) {
            ImageView imagen = (ImageView) node;
            int i = imagen.getImage().getUrl().indexOf("Resources/LETRASPASAPALABRA/");
            letrasJ2.add(imagen.getImage().getUrl().substring(i));
        }
        Partida partida = new Partida(getContenedor().getSistema(), letrasJ1, letrasJ2);
        getContenedor().getGestorFicheros().guardarPartida(partida);
        System.out.println("PARTIDA GUARDADA");
        System.exit(0);
    }

    @FXML
    private void abandonar() {
        System.exit(0);
    }

    private void tiempo() {
        int tiempoJugadorActual = getContenedor().getSistema().getJugadorActual().getTiempo();
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                getContenedor().getSistema().getJugadorActual().setTiempo(getContenedor().getSistema().getJugadorActual().getTiempo() - 1);
                Platform.runLater(() -> {
                    tiempo.setText(String.valueOf(getContenedor().getSistema().getJugadorActual().getTiempo()));
                    if (getContenedor().getSistema().getJugadorActual().getTiempo() <= 0) {
                        cambiarTurno();
                        try {
                            preguntar();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
        };
        timer.schedule(task, tiempoJugadorActual,1000);
    }
}