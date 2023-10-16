package fr.fs.adress.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
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

    private Stage primaryStage; //référence au primary Stage
    private ContactController contactController;

    public void setContactController(ContactController contactController) {
        this.contactController = contactController;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private void handleOpen(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File selectedFile = fileChooser.showOpenDialog(new Stage());

        if (selectedFile != null) {
            try {
                // Chargement de la vue Contact.fxml dans une nouvelle scène
                FXMLLoader contactLoader = new FXMLLoader(getClass().getResource("/fr/fs/adress/view/Contact.fxml"));
                AnchorPane contactLayout = contactLoader.load();
                Scene contactScene = new Scene(contactLayout);
                // Obtenez le contrôleur ContactController
                ContactController contactController = contactLoader.getController();
                contactController.openFile(selectedFile);
                // Affichage de la nouvelle scène
                primaryStage.setScene(contactScene);
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

