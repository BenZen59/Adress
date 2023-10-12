package fr.fs.adress.model;

import javafx.fxml.FXML;

import java.util.List;


public class PersonListWrapper {
    private List<Person> persons;

    private List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
