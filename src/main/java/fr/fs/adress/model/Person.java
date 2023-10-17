package fr.fs.adress.model;

public class Person {
    private String firstname;
    private String lastname;

    private String street;
    private int postalCode;
    private String city;
    private String birthday;
    public Person(){
        this(null,null,null,null,null,null);
    }
    public Person(String firstname, String lastname, String street, Integer postalCode, String city, String birthday) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.birthday = birthday;

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



    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}