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
                if (parts.length == 6) {
                    String firstname = parts[0].trim();
                    String lastname = parts[1].trim();
                    String street = parts[2].trim();
                    String postal = parts[3].trim();
                    String city = parts[4].trim();
                    String birthday = parts[5].trim();
                    contacts.add(new Person(firstname, lastname, street, postal,city,birthday));
                }
            }
        }
        return contacts;
    }
}
