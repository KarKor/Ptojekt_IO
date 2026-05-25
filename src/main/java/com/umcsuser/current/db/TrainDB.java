package com.umcsuser.current.db;

import com.umcsuser.current.models.Train;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TrainDB implements Database{
    private final ArrayList<Train> trains=new ArrayList<>();

    @Override
    public void readDatabase(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                String[] parts = linia.split(";");
                trains.add(
                        new Train(parts[0], parts[1], parts[2]
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveDatabase(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for(Train train : trains){
                writer.write(train.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addTrain(Train train){
        trains.add(train);
        saveDatabase("trains.csv");
    }

    public void removeTrain(String trainID){
        trains.removeIf(train -> train.getID().equals(trainID));
        saveDatabase("trains.csv");
    }

    public ArrayList<Train> getTrains() {
        return trains;
    }
}
