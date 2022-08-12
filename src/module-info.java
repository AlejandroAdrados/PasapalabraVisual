module Aplicacion {
    requires javafx.controls;
    requires javafx.fxml;


    opens Aplicacion to javafx.fxml;
    exports Aplicacion;
}