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
import javafx.scene.text.Font;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControladorAdmin extends ControladorGeneral implements Initializable {

    @FXML
    private AnchorPane pane, paneNormal, paneCreacion;
    @FXML
    private ImageView avatar, creacionAvatar;
    @FXML
    private Label nombre, jugadas, aciertos, noJugadores;
    @FXML
    private TextField creacionNombre;

    private Ficheros gestorFicheros;

    private ArrayList<Jugador> jugadores;
    private void seleccionLista(String nombreLista){
        nombre.setText("NOMBRE: " + nombreLista.toUpperCase());
        jugadas.setText("PARTIDAS JUGADAS: " + 38);
        aciertos.setText("MEDIA DE ACIERTOS: " + 19);
        File file;
        Jugador jugadorBuscado=null;
        for(Jugador jugador : jugadores) {
            if (jugador.getNombre().equals(nombreLista)) {
                jugadorBuscado=jugador;
                break;
            }
        }
        if(jugadorBuscado.getAvatar()==0){
            file = new File("Resources/AvatarHombre.png");}
        else{
            file = new File("Resources/AvatarMujer.png");}
        Image image = new Image(file.toURI().toString());
        avatar.setImage(image);
    }

    @FXML
    public void menuCreacionJugador(){
        paneNormal.setOpacity(0.53);
        paneCreacion.setVisible(true);
    }

    @FXML
    private void crearJugador() throws IOException {
        String nombre = creacionNombre.getText();
        int avatar;
        if((creacionAvatar.getImage().getUrl().endsWith("Resources/AvatarMujer.png"))){
            avatar=1;
        }
        else{
            avatar=0;
        }
        Jugador jugadorNuevo = new Jugador(nombre,avatar);
        gestorFicheros.guardarJugador(jugadorNuevo);
        paneCreacion.setVisible(false);
        paneNormal.setOpacity(1);
        loadView("vistaAdmin.fxml");
    }

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
        if(jugadores.isEmpty()){
            noJugadores = new Label();
            noJugadores.setLayoutX(185);
            noJugadores.setLayoutY(307);
            noJugadores.setFont(new Font(20));
            noJugadores.setText("NO HAY JUGADORES REGISTRADOS");
            hayJugadores=false;
        }else{
            for (int i = 0; i < jugadores.size(); i++) {
                lista.getItems().add(jugadores.get(i).getNombre());
            }
            hayJugadores=true;
        }

        lista.setPrefHeight(320);
        lista.setPrefWidth(341);
        lista.setLayoutX(175);
        lista.setLayoutY(198);
        paneNormal.getChildren().add(lista);
        if(!hayJugadores){
            paneNormal.getChildren().add(noJugadores);
        }
        lista.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                seleccionLista(newValue);
            }
        });
    }

    /**
     * Método para cambiar la imagen cuando el ratón está sobre ella
     * @param mouseEvent
     */
    @FXML
    private void imagenDentro(MouseEvent mouseEvent) {  //Código de color #0c2f91
        ImageView imageView = (ImageView) mouseEvent.getSource();
        if (imageView.getId().equals("anadir")) {
            File file = new File("Resources/ImagenesAdmin/anadir2.png");
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
        } else if (imageView.getId().equals("eliminar")) {
            File file = new File("Resources/ImagenesAdmin/eliminar2.png");
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
        } else if (imageView.getId().equals("editar")) {
            File file = new File("Resources/ImagenesAdmin/editar2.png");
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
        if (imageView.getId().equals("anadir")) {
            File file = new File("Resources/ImagenesAdmin/anadir.png");
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
        } else if (imageView.getId().equals("eliminar")) {
            File file = new File("Resources/ImagenesAdmin/eliminar.png");
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
        } else if (imageView.getId().equals("editar")) {
            File file = new File("Resources/ImagenesAdmin/editar.png");
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
        }
    }

    public void avatarAnterior() {
        File file = new File("Resources/AvatarHombre.png");
        Image image = new Image(file.toURI().toString());
        creacionAvatar.setImage(image);
    }

    public void avatarSiguiente() {
        File file = new File("Resources/AvatarMujer.png");
        Image image = new Image(file.toURI().toString());
        creacionAvatar.setImage(image);
    }
}
