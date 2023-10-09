module fr.fs.adress {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.fs.adress to javafx.fxml;
    exports fr.fs.adress;
}