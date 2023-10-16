package fr.fs.adress.dao;

import fr.fs.adress.model.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
    public List<Person> loadContacts(String filePath) throws IOException {
        List<Person> contacts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    String firstname = parts[0].trim();
                    String lastname = parts[1].trim();
                    contacts.add(new Person(firstname, lastname));
                }
            }
        }
        return contacts;
    }
}
