package Aplicacion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class inicioAplicacion extends Application {
    GameContainer container;
    @Override
    public void start(Stage stage) throws IOException {
        container = new GameContainer();
        FXMLLoader fxmlLoader = new FXMLLoader(inicioAplicacion.class.getClassLoader().getResource("vistaMenu.fxml"));
        container.setStage(stage);
        container.setFxmlLoader(fxmlLoader);
        Scene scene = new Scene(fxmlLoader.load(), 1366, 768);
        ((ControladorGeneral)fxmlLoader.getController()).setContainer(container);
        stage.setFullScreen(false);
        stage.setResizable(false);
        stage.setTitle("PASAPALABRA");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}