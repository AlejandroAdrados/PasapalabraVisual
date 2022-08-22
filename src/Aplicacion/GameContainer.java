package Aplicacion;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class GameContainer {
    private Stage stage;
    private FXMLLoader fxmlLoader;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public FXMLLoader getFxmlLoader() {
        return fxmlLoader;
    }

    public void setFxmlLoader(FXMLLoader fxmlLoader) {
        this.fxmlLoader = fxmlLoader;
    }
}
