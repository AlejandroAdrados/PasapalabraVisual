package Aplicacion;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ControladorMenu extends ControladorGeneral {
    @FXML
    public void jugar(){
        loadView("vistaJuego.fxml");
    }

    @FXML
    public void adminMenu(){
        loadView("vistaAdmin.fxml");
    }

    @FXML
    public void comoJugar() throws IOException {
            File instrucciones = new File("Resources/Instrucciones.pdf");
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
}
