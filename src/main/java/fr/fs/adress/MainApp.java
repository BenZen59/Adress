package fr.fs.adress;

import fr.fs.adress.controller.ContactController;
import fr.fs.adress.controller.ContactEditController;
import fr.fs.adress.controller.MenuController;
import fr.fs.adress.model.Person;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    private Stage primaryStage;
    private ObservableList<Person> personData = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
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
            // Passez la référence primaryStage au MenuController
            menuController.setPrimaryStage(primaryStage);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }

    public boolean showPersonEditDialog(Person person) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            ContactEditController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
