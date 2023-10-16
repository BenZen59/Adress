package fr.fs.adress.controller;

import fr.fs.adress.dao.ContactDAO;
import fr.fs.adress.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.io.File;
import java.io.IOException;
import java.util.List;

public class ContactController {
    @FXML
    private TableView<Person> tableView;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
    private final ContactDAO contactDAO;


    public ContactController() {
        contactDAO = new ContactDAO();
    }

    @FXML
    private void initialize() {
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastname"));
    }

    public ContactDAO getContactDAO() {
        return contactDAO;
    }

    @FXML
    void openFile(File selectedFile) throws IOException {
        List<Person> contacts = contactDAO.loadContacts(selectedFile.getAbsolutePath());
        tableView.getItems().setAll(contacts);
    }
}
