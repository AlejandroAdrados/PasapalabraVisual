module com.example.pasapalabravisual {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pasapalabravisual to javafx.fxml;
    exports com.example.pasapalabravisual;
}