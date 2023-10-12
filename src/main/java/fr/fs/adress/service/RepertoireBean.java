package fr.fs.adress.service;

import fr.fs.adress.dao.ContactDAO;
import fr.fs.adress.model.Person;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

import java.io.File;
import java.util.ArrayList;

public class RepertoireBean {
    private File file;
    private ArrayList<Person> allContacts;
    private FilteredList<Person> filteredList;
    private SortedList<Person> sortedList;
    private boolean saved;
    public RepertoireBean(File file) {
        Person searched = new Person();
        this.file = file;
        ContactDAO contactDAO = new ContactDAO(file);

        saved =true;
    }
}
