package fr.fs.adress.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.File;
import java.io.IOException;

public class MenuController {
    @FXML
    private AnchorPane contentPane;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu fichier;
    @FXML
    private MenuItem nouveau;
    @FXML
    private MenuItem ouvrir;
    @FXML
    private MenuItem enregistrer;
    @FXML
    private MenuItem enregistrerSous;

    private Stage primaryStage; //référence au primary Stage

    private ContactController contactController;

    public MenuController(){

    }

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
        fileChooser.setInitialDirectory(new File("C:\\Benku\\Dev\\Java"));
        File selectedFile = fileChooser.showOpenDialog(new Stage());

        if (selectedFile != null) {
            try {
                // Chargement de la vue Contact.fxml dans une nouvelle scène
                FXMLLoader contactLoader = new FXMLLoader(getClass().getResource("/fr/fs/adress/view/Contact.fxml"));
                AnchorPane contactLayout = contactLoader.load();
                // Obtenez le contrôleur ContactController
                ContactController contactController = contactLoader.getController();
                contactController.openFile(selectedFile);
                // Affichage de la nouvelle scène
                contentPane.getChildren().setAll(contactLayout);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void handleSave(ActionEvent event){
        ContactController controller = contactController;
        controller.saveFile();
    }

    @FXML
    private void handleSaveAs(ActionEvent event){

    }
}

