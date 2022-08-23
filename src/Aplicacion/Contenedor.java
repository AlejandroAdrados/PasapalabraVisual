package Aplicacion;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

/**
 * Clase que almacena la escena y el fxmlloader a lo largo de la ejecución (Indispensable para cambiar entre vistas).
 */
public class Contenedor {
    private Stage Escenario;
    private FXMLLoader fxmlLoader;

    public Stage getEscenario() {
        return Escenario;
    }

    public void setEscenario(Stage escenario) {
        this.Escenario = escenario;
    }

    public FXMLLoader getFxmlLoader() {
        return fxmlLoader;
    }

    public void setFxmlLoader(FXMLLoader fxmlLoader) {
        this.fxmlLoader = fxmlLoader;
    }
}
