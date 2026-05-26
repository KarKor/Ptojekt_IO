package com.umcsuser.current.db;

import com.umcsuser.current.models.Fine;
import com.umcsuser.current.models.Transfer;

import java.io.*;
import java.util.ArrayList;

public class FineDB implements Database{
    private final ArrayList<Fine> fines = new ArrayList<>();

    @Override
    public void readDatabase(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                String[] parts = linia.split(";");
                fines.add(new Fine(
                        parts[0], parts[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveDatabase(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for(Fine fine: fines){
                writer.write(fine.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addFine(Fine fine){
        fines.add(fine);
        saveDatabase("fines.csv");
    }

    public void removeFine(String fineID){
        fines.removeIf(fine -> fine.getFineID().equals(fineID));
        saveDatabase("fines.csv");
    }

    public ArrayList<Fine> getFines() {
        return fines;
    }
}
