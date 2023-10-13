package fr.fs.adress;

import java.io.IOException;

import fr.fs.adress.model.Person;
import fr.fs.adress.controller.PersonEditDialogController;
import fr.fs.adress.controller.ContactController;
import fr.fs.adress.service.RepertoireBean;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private static BorderPane rootLayout;
    private RepertoireBean repertoireBean;
    private ObservableList<Person> personData = FXCollections.observableArrayList();

    private MainApp mainApp;

    public MainApp() {
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");
        // Set the application icon.
        this.primaryStage.getIcons().add(new Image("file:src/main/resources/images/addressbook.png"));
        initRootLayout();

    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Menu.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showContact() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Contact.fxml"));
            AnchorPane contact = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(contact);
            // Give the controller access to the main app.
            ContactController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();

        }
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
            PersonEditDialogController controller = loader.getController();
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

    //Getter
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static BorderPane getRootLayout() {
        return rootLayout;
    }

    public RepertoireBean getRepertoireBean() {
        return repertoireBean;
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }

    //Setter

    public void setRepertoireBean(RepertoireBean repertoireBean) {
        this.repertoireBean = repertoireBean;
        showContact();
    }

    public static void main(String[] args) {
        launch(args);
    }
}