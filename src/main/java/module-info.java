module fr.fs.adress {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens fr.fs.adress to javafx.fxml;
    exports fr.fs.adress;
    exports fr.fs.adress.controller;
    opens fr.fs.adress.controller to javafx.fxml;
}