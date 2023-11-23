package fr.fs.adress.controller;

import fr.fs.adress.MainApp;
import fr.fs.adress.dao.ContactDAO;
import fr.fs.adress.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ContactController {
    @FXML
    private TableView<Person> tableView;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    private MainApp mainApp;
    private final ContactDAO contactDAO;
    private ObservableList<Person> personData = FXCollections.observableArrayList();


    public ContactController() {
        contactDAO = new ContactDAO();
    }

    @FXML
    private void initialize() {
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    public ContactDAO getContactDAO() {
        return contactDAO;
    }

    @FXML
    public void openFile(File selectedFile) throws IOException {
        List<Person> contacts = contactDAO.loadContacts(selectedFile.getAbsolutePath());
        tableView.getItems().setAll(contacts);
    }

    @FXML
    public void saveFile(String selectedFile) {
        /*String data =  "|" + lastname + "|" + street + "|" + postalCode + "|" + city + "|" + birthday;
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile, true))){
            writer.write(data);
            writer.newLine();
        }catch (IOException e){
            e.printStackTrace();
        }*/
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        tableView.setItems(mainApp.getPersonData());
    }

    private void showPersonDetails(Person person) {
        if (person != null) {
            // Fill the labels with info from the person object.
            firstNameLabel.setText(person.getFirstname());
            lastNameLabel.setText(person.getLastname());
            streetLabel.setText(person.getStreet());
            postalCodeLabel.setText(person.getPostalCode());
            cityLabel.setText(person.getCity());
            birthdayLabel.setText((person.getBirthday()));

        } else {
            // Person is null, remove all the text.
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
            postalCodeLabel.setText("");
            cityLabel.setText("");
            birthdayLabel.setText("");
        }
    }


    @FXML
    private void handleNewPerson() {
        this.mainApp = new MainApp();
        Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            tableView.getItems().add(tempPerson);

        }
    }

    @FXML
    private void handleEditPerson() {
        this.mainApp = new MainApp();
        Person selectedPerson = tableView.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);

            }
        } else {

            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }


}
