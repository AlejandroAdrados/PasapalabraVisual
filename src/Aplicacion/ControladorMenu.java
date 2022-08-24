package Aplicacion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Clase que controla la operativa de la vista del menú (vistaMenu.fxml).
 */
public class ControladorMenu extends ControladorGeneral {

    @FXML
    private ComboBox<String> comboJ1,comboJ2;
    @FXML
    private AnchorPane paneNormal,paneJugadores,paneInvisible;
    @FXML
    private ImageView avatarJ1, avatarJ2;
    private String j1Seleccionado, j2Seleccionado;

    /**
     * Carga la vista del juego.
     */
    @FXML
    private void jugar(){
        cargarVista("Vistas/vistaJuego.fxml");
    }

    /**
     * Carga la vista del menú de administrador.
     */
    @FXML
    private void adminMenu(){
        cargarVista("Vistas/vistaAdmin.fxml");
    }

    /**
     * Abre el archivo pdf de las instrucciones (Ubicado en Resources) con el visor predeterminado.
     * @throws IOException
     */
    @FXML
    public void comoJugar() throws IOException {
            File instrucciones = new File("Resources/Instrucciones/Instrucciones.pdf");
            Desktop.getDesktop().open(instrucciones);
    }

    /**
     * Método para cambiar la imagen cuando el ratón está sobre ella
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
        for(Jugador jugador : getContenedor().getGestorFicheros().getJugadores()){
            comboJ1.getItems().add(jugador.getNombre());
            comboJ2.getItems().add(jugador.getNombre());
        }

    }
    @FXML
    private void volver(){
        cargarVista("Vistas/vistaMenu.fxml");
    }

    @FXML
    private void empezar(){
        if (j1Seleccionado != null && j2Seleccionado != null && !j1Seleccionado.equals(j2Seleccionado)) {
            Jugador j1 = getContenedor().getGestorFicheros().buscarJugador(j1Seleccionado);
            Jugador j2 = getContenedor().getGestorFicheros().buscarJugador(j2Seleccionado);
            getContenedor().setSistema(new Sistema(getContenedor().getGestorFicheros(),j1,j2));
            jugar();
        } else {
            System.out.println("Error con los nombres de los jugadores."); //TODO Mostrar error en interfaz gráfica
        }

    }

    public void seleccionJ1() {
        j1Seleccionado=comboJ1.getValue();
        Jugador jugador = getContenedor().getGestorFicheros().buscarJugador(j1Seleccionado);
        avatarJ1.setImage(avatarJugador(jugador));

    }

    public void seleccionJ2() {
        j2Seleccionado=comboJ2.getValue();
        Jugador jugador = getContenedor().getGestorFicheros().buscarJugador(j2Seleccionado);
        avatarJ2.setImage(avatarJugador(jugador));
    }
}
