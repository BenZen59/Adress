package fr.fs.adress.dao;

import fr.fs.adress.model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FichierTexte {
    private File file;

    public FichierTexte(File file) {
        this.file = file;
    }

    public static List<Person> lire(File file) {
        List<Person> list = new ArrayList<>();

        try {

            FileReader fileReader = new FileReader(file); // flux qui se connecte au fichier
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split("\\|");
                if(fields.length == 2){
                    String firstName = fields[0];
                    String lastName = fields[1];
                    list.add(new Person(firstName,lastName));
                }
            }
            bufferedReader.close(); //fermeture du flux
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void ecrire(File file) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Benoit");
        list.add("ZENONE");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String s : list) {
                bufferedWriter.write(s + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
