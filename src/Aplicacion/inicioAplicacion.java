package Aplicacion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class inicioAplicacion extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(inicioAplicacion.class.getClassLoader().getResource("vistaJuego.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1920, 720);
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.setTitle("PASAPALABRA");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}