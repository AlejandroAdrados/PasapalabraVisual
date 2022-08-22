package Aplicacion;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.util.ResourceBundle;

public class ControladorGeneral {

    private GameContainer container;

    protected void loadView(String view){
        try {
            FXMLLoader loader = new FXMLLoader(inicioAplicacion.class.getClassLoader().getResource(view));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            getContainer().setFxmlLoader(loader);
            if(getContainer().getFxmlLoader().getController() instanceof ControladorGeneral){
                ((ControladorGeneral)getContainer().getFxmlLoader().getController()).setContainer(getContainer());
            }
            Stage appStage = getContainer().getStage();
            appStage.setScene(scene);
            appStage.toFront();
            appStage.show();
            if(getContainer().getFxmlLoader().getController() instanceof ControladorGeneral){
                ((ControladorGeneral)getContainer().getFxmlLoader().getController()).onLoad();
            }

        } catch (Exception e) {
            System.out.println("Error de carga de " + view);
        }
    }

    public void onLoad(){

    }


    public GameContainer getContainer() {
        return container;
    }

    public void setContainer(GameContainer container) {
        this.container = container;
    }
}
