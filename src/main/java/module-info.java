module fr.fs.adress {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires io;
    requires kernel;
    requires layout;


    opens fr.fs.adress to javafx.fxml;
    opens fr.fs.adress.model to javafx.base;
    exports fr.fs.adress;
    exports fr.fs.adress.controller;
    opens fr.fs.adress.controller to javafx.fxml;
}