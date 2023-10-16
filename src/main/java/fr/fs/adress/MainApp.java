package fr.fs.adress;

import fr.fs.adress.controller.ContactController;
import fr.fs.adress.controller.MenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // On charge les contrôleurs
            FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("view/Menu.fxml"));
            FXMLLoader contactLoader = new FXMLLoader(getClass().getResource("view/Contact.fxml"));
            // Chargement des vues
            BorderPane menuLayout = menuLoader.load();
            AnchorPane contactLayout = contactLoader.load();
            // Obtention des contrôleurs
            MenuController menuController = menuLoader.getController();
            ContactController contactController = contactLoader.getController();
            menuController.setContactController(contactController);
            Scene scene = new Scene(menuLayout);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Address App");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
