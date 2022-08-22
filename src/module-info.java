module Aplicacion {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens Aplicacion to javafx.fxml;
    exports Aplicacion;
}