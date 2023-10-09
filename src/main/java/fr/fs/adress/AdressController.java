package fr.fs.adress;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AdressController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}