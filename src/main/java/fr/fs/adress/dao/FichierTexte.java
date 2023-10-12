package fr.fs.adress.dao;

import java.io.*;
import java.util.ArrayList;

public class FichierTexte {
    private File file;

    public FichierTexte(File file) {
        this.file = file;
    }

    public void lire(File file) {
        try {
            FileReader fileReader = new FileReader(file); // flux qui se connecte au fichier
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close(); //fermeture du flux
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ecrire(File file) {
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
