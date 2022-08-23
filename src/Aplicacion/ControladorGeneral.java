package Aplicacion;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Clase padre de todos los controladores e implementa el método para cambiar entre vistas.
 * Además almacena en ella el contenedor de información que se utiliza en la ejecución.
 */
public class ControladorGeneral {

    private Contenedor contenedor;

    /**
     * Método que implementan todos los controladores y se utiliza para cambiar entre diferentes vistas (Archivos fxml).
     * @param vista
     */
    protected void cargarVista(String vista){
        try {
            FXMLLoader loader = new FXMLLoader(inicioAplicacion.class.getClassLoader().getResource(vista));
            Parent root = loader.load();
            Scene escena = new Scene(root);
            getContenedor().setFxmlLoader(loader);
            if(getContenedor().getFxmlLoader().getController() instanceof ControladorGeneral){
                ((ControladorGeneral)getContenedor().getFxmlLoader().getController()).setContenedor(getContenedor());
            }
            Stage escenario = getContenedor().getEscenario();
            escenario.setScene(escena);
            escenario.toFront();
            escenario.show();
            if(getContenedor().getFxmlLoader().getController() instanceof ControladorGeneral){
                ((ControladorGeneral)getContenedor().getFxmlLoader().getController()).onLoad();
            }

        } catch (Exception e) {
            System.out.println("Error de carga de " + vista);
        }
    }

    public void onLoad(){

    }


    public Contenedor getContenedor() {
        return contenedor;
    }

    public void setContenedor(Contenedor contenedor) {
        this.contenedor = contenedor;
    }
}