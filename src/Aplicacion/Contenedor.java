package Aplicacion;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

/**
 * Clase que almacena la escena y el fxmlloader a lo largo de la ejecución (Indispensable para cambiar entre vistas).
 */
public class Contenedor {
    private Stage escenario;
    private FXMLLoader fxmlLoader;
    private Ficheros gestorFicheros;
    private Sistema sistema;

    public Stage getEscenario() {
        return escenario;
    }

    public void setEscenario(Stage escenario) {
        this.escenario = escenario;
    }

    public FXMLLoader getFxmlLoader() {
        return fxmlLoader;
    }

    public void setFxmlLoader(FXMLLoader fxmlLoader) {
        this.fxmlLoader = fxmlLoader;
    }

    public Ficheros getGestorFicheros() {
        return gestorFicheros;
    }

    public void setGestorFicheros(Ficheros gestorFicheros) {
        this.gestorFicheros = gestorFicheros;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }
}
