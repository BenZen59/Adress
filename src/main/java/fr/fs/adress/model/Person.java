package fr.fs.adress.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

public class Person {
    private String firstname;
    private String lastname;

    private String street;
    private int postalCode;
    private String city;
    private ObjectProperty<LocalDate> birthday;

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        street = "some street";
        postalCode = 1234;
        city = "some city";
        this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }
}