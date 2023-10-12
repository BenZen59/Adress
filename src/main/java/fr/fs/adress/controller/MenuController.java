package fr.fs.adress.controller;

import java.awt.*;
import java.io.*;

import fr.fs.adress.MainApp;
import fr.fs.adress.service.ParametresBean;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

public class MenuController {
    

    private MainApp mainApp;
    private ParametresBean parametresBean;
    
    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu fichier;
    @FXML
    private MenuItem nouveau;
    @FXML
    private MenuItem ouvrir;
    public MenuController() {
        ParametresBean initializeParametresBean = new ParametresBean();
        this.mainApp = mainApp;
        initializeLayout();
        mainApp.getPrimaryStage().setOnCloseRequest(windowEvent -> sauver());
    }

    private void sauver() {
    }

    private void initializeLayout() {
    }

    @FXML
    public void handleOuvrir() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Fichiers csv", "*.txt")
        );
        fileChooser.setInitialDirectory(new File("C:\\Benku\\Dev\\Java"));
        File selectedFile = fileChooser.showOpenDialog(null);
    }
}
