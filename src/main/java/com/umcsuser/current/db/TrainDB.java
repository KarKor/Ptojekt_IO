package com.umcsuser.current.db;

import com.umcsuser.current.models.Train;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TrainDB implements Database{
    private List<Train> trains = new ArrayList<>();

    public List<Train> getTrains() {
        return trains;
    }

    @Override
    public void readDatabase(String filePath) {
        trains.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                String[] dane = linia.split(";");
                if (dane.length >= 3) {
                    String ID = dane[0];
                    String model = dane[1];
                    String company = dane[2];

                    Train train = new Train(company, ID, model);
                    trains.add(train);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveDatabase(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Train train : trains) {
                writer.write(train.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisywania pliku z pociągami: " + e.getMessage());
        }
    }

    public void addTrain(Train train){
        if (train != null) {
            trains.add(train);
            System.out.println("Pomyślnie dodano nowy pociąg.");
        }
    }

    public void removeTrain(String trainID){
        boolean isRemoved = trains.removeIf(train -> train.getID().equals(trainID));
        if (isRemoved) {
            System.out.println("Usunięto pociąg o ID: " + trainID);
        } else {
            System.out.println("Nie znaleziono pociągu o ID: " + trainID);
        }
    }

}
