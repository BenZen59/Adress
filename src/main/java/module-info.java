module fr.fs.adress {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.fs.adress to javafx.fxml;
    exports fr.fs.adress;
    exports fr.fs.adress.view;
    opens fr.fs.adress.view to javafx.fxml;
}