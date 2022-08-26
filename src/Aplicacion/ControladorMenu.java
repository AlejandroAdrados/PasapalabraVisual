package Aplicacion;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Clase que controla la operativa de la vista del menú (vistaMenu.fxml).
 */
public class ControladorMenu extends ControladorGeneral {

    @FXML
    private Button botonEmpezar;
    @FXML
    private Label tituloSeleccionJugadores;
    @FXML
    private VBox error;
    @FXML
    private ComboBox<String> comboJ1, comboJ2;
    @FXML
    private AnchorPane paneNormal, paneJugadores, paneInvisible, paneInvisible2;
    @FXML
    private ImageView avatarJ1, avatarJ2;
    private String j1Seleccionado, j2Seleccionado;

    /**
     * Carga la vista del juego.
     */
    @FXML
    private void jugar() {
        cargarVista("Vistas/vistaJuego.fxml");
    }

    /**
     * Carga la vista del menú de administrador.
     */
    @FXML
    private void adminMenu() {
        cargarVista("Vistas/vistaAdmin.fxml");
    }

    /**
     * Abre el archivo pdf de las instrucciones (Ubicado en Resources) con el visor predeterminado.
     *
     * @throws IOException
     */
    @FXML
    public void comoJugar() throws IOException {
        File instrucciones = new File("Resources/Instrucciones/Instrucciones.pdf");
        Desktop.getDesktop().open(instrucciones);
    }

    /**
     * Método para cambiar la imagen cuando el ratón está sobre ella
     *
     * @param mouseEvent
     */
    @FXML
    private void imagenDentro(MouseEvent mouseEvent) {  //Código de color #0c2f91
        ImageView imageView = (ImageView) mouseEvent.getSource();
        if (imageView.getId().equals("jugar")) {
            File file = new File("Resources/ImagenesMenu/jugar2.png");
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
        } else if (imageView.getId().equals("admin")) {
            File file = new File("Resources/ImagenesMenu/admin2.png");
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
        } else if (imageView.getId().equals("como")) {
            File file = new File("Resources/ImagenesMenu/como2.png");
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
        }
    }

    /**
     * Método para cambiar la imagen cuando el ratón está fuera de ella
     *
     * @param mouseEvent
     */
    @FXML
    private void imagenFuera(MouseEvent mouseEvent) { //Código de color #0842e3
        ImageView imageView = (ImageView) mouseEvent.getSource();
        if (imageView.getId().equals("jugar")) {
            File file = new File("Resources/ImagenesMenu/jugar.png");
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
        } else if (imageView.getId().equals("admin")) {
            File file = new File("Resources/ImagenesMenu/admin.png");
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
        } else if (imageView.getId().equals("como")) {
            File file = new File("Resources/ImagenesMenu/como.png");
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
        }
    }

    /**
     * Muestra el menú de selección de jugadores.
     */
    @FXML
    private void mostrarMenuPartida() {
        paneNormal.setOpacity(0.53);
        paneJugadores.setVisible(true);
        paneJugadores.setMouseTransparent(false);
        paneInvisible.setMouseTransparent(false);
        try {
            getContenedor().getGestorFicheros().leerJugadores();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (Jugador jugador : getContenedor().getGestorFicheros().getJugadores()) {
            comboJ1.getItems().add(jugador.getNombre());
            comboJ2.getItems().add(jugador.getNombre());
        }
    }

    /**
     * Oculta el menú de selección de jugadores.
     */
    @FXML
    private void volver() {
        cargarVista("Vistas/vistaMenu.fxml");
    }

    /**
     * Oculta el mensaje de error.
     */
    @FXML
    private void volverError() {
        tituloSeleccionJugadores.setVisible(true);
        botonEmpezar.setVisible(true);
        error.setVisible(false);
        paneInvisible2.setMouseTransparent(true);
    }

    /**
     * Comprueba que los jugadores seleccionados son válidos y diferentes e inicializa el juego
     */
    @FXML
    private void empezar() {
        if (j1Seleccionado != null && j2Seleccionado != null && !j1Seleccionado.equals(j2Seleccionado)) {
            Jugador j1 = getContenedor().getGestorFicheros().buscarJugador(j1Seleccionado);
            Jugador j2 = getContenedor().getGestorFicheros().buscarJugador(j2Seleccionado);
            getContenedor().setSistema(new Sistema(getContenedor().getGestorFicheros(), j1, j2));
            jugar();
        } else {
            mostrarError();
        }

    }

    /**
     * Oculta el mensaje de error.
     */
    private void mostrarError() {
        tituloSeleccionJugadores.setVisible(false);
        botonEmpezar.setVisible(false);
        error.setVisible(true);
        paneInvisible2.setMouseTransparent(false);
    }

    /**
     * Convierte el nombre del jugador 1 seleccionado en el comboBox en tipo Jugador y muestra su imagen.
     */
    public void seleccionJ1() {
        j1Seleccionado = comboJ1.getValue();
        Jugador jugador = getContenedor().getGestorFicheros().buscarJugador(j1Seleccionado);
        avatarJ1.setImage(avatarJugador(jugador));

    }

    /**
     * Convierte el nombre del jugador 2 seleccionado en el comboBox en tipo Jugador y muestra su imagen.
     */
    public void seleccionJ2() {
        j2Seleccionado = comboJ2.getValue();
        Jugador jugador = getContenedor().getGestorFicheros().buscarJugador(j2Seleccionado);
        avatarJ2.setImage(avatarJugador(jugador));
    }
}