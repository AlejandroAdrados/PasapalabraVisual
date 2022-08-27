package Aplicacion;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.Serializable;

/**
 * Clase que almacena la escena y el fxmlloader a lo largo de la ejecución (Indispensable para cambiar entre vistas).
 */
public class Contenedor implements Serializable {
    private Stage escenario;
    private FXMLLoader fxmlLoader;
    private Ficheros gestorFicheros;
    private Sistema sistema;
    private boolean partidaCargada;

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

    public boolean isPartidaCargada() {
        return partidaCargada;
    }

    public void setPartidaCargada(boolean partidaCargada) {
        this.partidaCargada = partidaCargada;
    }
}
