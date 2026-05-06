package com.umcsuser.current.db;

import com.umcsuser.current.models.Train;

import java.io.*;
import java.util.List;

public class TrainDB implements Database{
    private List<Train> trains;

    @Override
    public void readDatabase(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                System.out.println(linia);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveDatabase(String filePath) {

    }

    public void addTrain(Train train){}

    public void removeTrain(String trainID){}

}
