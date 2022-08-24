package Aplicacion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase que inicia la aplicación
 */
public class inicioAplicacion extends Application {
    Contenedor contenedor;

    /**
     * Método que carga la información necesaria para el inicio de la primera vista.
     * @param stage the primary stage for this application, onto which
     *              the application scene can be set.
     *              Applications may create other stages, if needed, but they will not be
     *              primary stages.
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        contenedor = new Contenedor();
        Ficheros gestorFicheros = new Ficheros();
        contenedor.setGestorFicheros(gestorFicheros);
        FXMLLoader fxmlLoader = new FXMLLoader(inicioAplicacion.class.getClassLoader().getResource("Vistas/vistaMenu.fxml"));
        contenedor.setEscenario(stage);
        contenedor.setFxmlLoader(fxmlLoader);
        Scene escena = new Scene(fxmlLoader.load(), 1366, 768);
        ((ControladorGeneral)fxmlLoader.getController()).setContenedor(contenedor);
        stage.setFullScreen(false);
        stage.setResizable(false);
        stage.setTitle("PASAPALABRA");
        stage.setScene(escena);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}