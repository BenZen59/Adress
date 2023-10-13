package fr.fs.adress.controller;

import java.awt.*;
import java.io.*;

import fr.fs.adress.MainApp;
import fr.fs.adress.dao.FichierTexte;
import fr.fs.adress.service.ParametresBean;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

public class MenuController{

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

    public MenuController () {

    }

    private void sauver() {
    }

    private void initializeLayout() {
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    public void handleOuvrir() throws IOException {
        MainApp mainApp = new MainApp();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Fichiers csv", "*.txt")
        );
        fileChooser.setInitialDirectory(new File("C:\\Benku\\Dev\\Java"));
        File selectedFile = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
        FichierTexte.lire(selectedFile);
        if (selectedFile != null) {
            System.out.println("Fichier sélectionné : " + selectedFile.getAbsolutePath());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Contact.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            MainApp.getRootLayout().setCenter(personOverview);
            MenuController controller = loader.getController();
            controller.setMainApp(mainApp);
        }
    }
}

