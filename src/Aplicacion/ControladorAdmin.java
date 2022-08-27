package Aplicacion;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Clase que controla la operativa de la vista del menú de administrador (vistaAdmin.fxml).
 */
public class ControladorAdmin extends ControladorGeneral implements Initializable {

    @FXML
    private AnchorPane paneNormal, paneCreacion, paneInvisible, paneInvisible2; //paneCreacion contiene los items de creación o edición de jugadores
    //paneInvisible sirve para volver al paneNormal desde paneCreacion //paneInvisible2 oculta el mensaje de error
    @FXML
    private ImageView avatar, creacionAvatar, editar, eliminar;
    @FXML
    private Label nombre, jugadas, aciertos, textoEscribaNombre, textoSeleccioneAvatar;
    @FXML
    private TextField creacionNombre;
    @FXML
    private Polygon flechaIzquierda, flechaDerecha;
    @FXML
    private VBox error;
    private Ficheros gestorFicheros;
    private ArrayList<Jugador> jugadores;
    private String nombreJugadorSeleccionado;
    private Boolean edicion = false; //Indica si se está creando o editando un jugador
    private Jugador jugador;


    /**
     * Método que devuelve el jugador que selecciona el usuario en la lista
     *
     * @return Jugador seleccionado
     */
    private Jugador jugadorSeleccionado() {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equals(nombreJugadorSeleccionado)) {
                return jugador;
            }
        }
        return null;
    }

    /**
     * Método que muestra la interfaz de creación o edición de jugador
     */
    @FXML
    private void mostrarMenuCreacionJugador() {
        paneNormal.setOpacity(0.53);
        paneCreacion.setVisible(true);
        paneInvisible.setMouseTransparent(false);
        paneNormal.setMouseTransparent(true);
    }

    /**
     * Método que actualiza los datos del jugador seleccionado en la interfaz gráfica
     */
    private void actualizarDatosPantalla() {
        jugador = jugadorSeleccionado();
        nombre.setText("NOMBRE: " + jugador.getNombre().toUpperCase());
        jugadas.setText("PARTIDAS JUGADAS: " + jugador.getPartidasJugadas());
        if (jugador.getPartidasJugadas() != 0) {
            aciertos.setText("MEDIA DE ACIERTOS: " + jugador.getPuntosTotales() / jugador.getPartidasJugadas());
        } else {
            aciertos.setText("MEDIA DE ACIERTOS: " + 0);
        }
        avatar.setImage(avatarJugador(jugador));
        editar.setVisible(true);
        eliminar.setVisible(true);
    }

    /**
     * Método para crear o editar un jugador (según booleano edicion).
     * - Si lo crea solo requiere nombre y avatar introducido por el usuario.
     * - Si lo edita requiere nombre y avatar introducido por el usuario y transifere los puntos totales y
     * partidas jugdadas del jugador inicial.
     *
     * @throws IOException
     */
    @FXML
    private void crearJugador() throws IOException {
        String nombre = creacionNombre.getText();
        if (nombre.isEmpty()) {
            mostrarError();
        } else {
            String avatar;
            if ((creacionAvatar.getImage().getUrl().endsWith("Resources/ImagenesAvatares/AvatarMujer.png"))) {
                avatar = "Resources/ImagenesAvatares/AvatarMujer.png";
            } else {
                avatar = "Resources/ImagenesAvatares/AvatarHombre.png";
            }
            Jugador jugadorNuevo;
            if (edicion) {
                jugadorNuevo = new Jugador(nombre, avatar, jugador.getPartidasJugadas(), jugador.getPuntosTotales());
                gestorFicheros.eliminarJugador(jugador);
                edicion = false;
            } else {
                jugadorNuevo = new Jugador(nombre, avatar);
            }
            gestorFicheros.guardarJugador(jugadorNuevo);
            paneCreacion.setVisible(false);
            paneNormal.setOpacity(1);
            cargarVista("Vistas/vistaAdmin.fxml");
        }
    }

    /**
     * Método que lanza el menú de creación de jugador con los datos del jugador actual y lo elimina para crear uno nuevo
     */
    @FXML
    private void editarJugador() {
        jugador = jugadorSeleccionado();
        mostrarMenuCreacionJugador();
        creacionAvatar.setImage(avatarJugador(jugador));
        creacionNombre.setText(jugador.getNombre());
        edicion = true;
    }

    /**
     * Elimina el jugador seleccionado por el usuario.
     *
     * @throws IOException
     */
    @FXML
    private void eliminarJugador() throws IOException {
        jugador = jugadorSeleccionado();
        gestorFicheros.eliminarJugador(jugador);
        cargarVista("Vistas/vistaAdmin.fxml");
    }

    /**
     * Método que carga los elementos necesarios antes de mostrar la vista.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gestorFicheros = new Ficheros();
        ListView<String> lista = new ListView<>();
        try {
            gestorFicheros.leerJugadores();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        jugadores = gestorFicheros.getJugadores();
        Label noJugadores = null;
        Boolean hayJugadores;
        if (jugadores.isEmpty()) {
            noJugadores = new Label();
            noJugadores.setLayoutX(185);
            noJugadores.setLayoutY(340);
            noJugadores.setFont(new Font(20));
            noJugadores.setText("NO HAY JUGADORES REGISTRADOS");
            hayJugadores = false;
        } else {
            for (int i = 0; i < jugadores.size(); i++) {
                lista.getItems().add(jugadores.get(i).getNombre());
            }
            hayJugadores = true;
        }
        lista.setPrefHeight(320);
        lista.setPrefWidth(341);
        lista.setLayoutX(175);
        lista.setLayoutY(198);
        lista.getOnEditStart();
        paneNormal.getChildren().add(lista);
        if (!hayJugadores) {
            paneNormal.getChildren().add(noJugadores);
        }
        lista.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                nombreJugadorSeleccionado = newValue;
                actualizarDatosPantalla();
            }
        });
    }

    /**
     * Método para cambiar la imagen cuando el ratón está sobre ella
     *
     * @param mouseEvent
     */
    @FXML
    private void imagenDentro(MouseEvent mouseEvent) {  //Código de color #0c2f91
        ImageView imageView = (ImageView) mouseEvent.getSource();
        File file = new File ("Resources/ImagenesAdmin/"+imageView.getId()+"2.png");
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
    }

    /**
     * Método para cambiar la imagen cuando el ratón está fuera de ella
     *
     * @param mouseEvent
     */
    @FXML
    private void imagenFuera(MouseEvent mouseEvent) { //Código de color #0842e3
        ImageView imageView = (ImageView) mouseEvent.getSource();
        File file = new File ("Resources/ImagenesAdmin/"+imageView.getId()+".png");
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
    }

    /**
     * Método que se lanza tras dar a la flecha izquierda de creación de usuario cambiando el avatar.
     */
    @FXML
    private void avatarAnterior() {
        File file = new File("Resources/ImagenesAvatares/AvatarHombre.png");
        Image image = new Image(file.toURI().toString());
        creacionAvatar.setImage(image);
    }

    /**
     * Método que se lanza tras dar a la flecha derecha de creación de usuario cambiando el avatar.
     */
    @FXML
    private void avatarSiguiente() {
        File file = new File("Resources/ImagenesAvatares/AvatarMujer.png");
        Image image = new Image(file.toURI().toString());
        creacionAvatar.setImage(image);
    }

    /**
     * Método que se ejecuta cuando el menú de creación está desplegado y se hace click fuera de éste. Con él se
     * cierra el menú de creación y vuelve a cargar la vista original.
     */
    @FXML
    private void volver() {
        cargarVista("Vistas/vistaAdmin.fxml");
    }

    /**
     * Método que se ejecuta al hacer click en el botón atrás y su función es cargar la vista del menú principal.
     */
    @FXML
    private void menu() {
        cargarVista("Vistas/vistaMenu.fxml");
    }

    /**
     * Método que oculta el mensaje de error.
     */
    @FXML
    private void volverError() {
        textoEscribaNombre.setVisible(true);
        textoSeleccioneAvatar.setVisible(true);
        creacionAvatar.setVisible(true);
        flechaDerecha.setVisible(true);
        flechaIzquierda.setVisible(true);
        creacionNombre.setVisible(true);
        error.setVisible(false);
        paneInvisible2.setMouseTransparent(true);
    }

    /**
     * Método que muestra el mensaje de error.
     */
    private void mostrarError() {
        textoEscribaNombre.setVisible(false);
        textoSeleccioneAvatar.setVisible(false);
        creacionAvatar.setVisible(false);
        flechaDerecha.setVisible(false);
        flechaIzquierda.setVisible(false);
        creacionNombre.setVisible(false);
        error.setVisible(true);
        paneInvisible2.setMouseTransparent(false);
    }
}