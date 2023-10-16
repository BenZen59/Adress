package fr.fs.adress.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class MenuController {
    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu fichier;
    @FXML
    private MenuItem nouveau;
    @FXML
    private MenuItem ouvrir;


    private ContactController contactController;

    public void setContactController(ContactController contactController) {
        this.contactController = contactController;
    }
    @FXML
    private void handleOpen(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File selectedFile = fileChooser.showOpenDialog(new Stage());

        if (selectedFile != null) {
            try {
                contactController.openFile(selectedFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

