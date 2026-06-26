module com.example.showmilhao {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires com.google.gson;
    requires java.desktop;
    requires java.prefs;

    opens com.example.showmilhao to javafx.fxml;
    opens com.example.showmilhao.controller to javafx.fxml;
    opens com.example.showmilhao.model to com.google.gson;

    exports com.example.showmilhao;

}