package com.umcsuser.current.db;

import com.umcsuser.current.models.Train;

import java.util.List;

public class TrainDB implements Database{
    private List<Train> trains;

    @Override
    public void readDatabase(String filePath) {

    }

    @Override
    public void saveDatabase(String filePath) {

    }

    public void addTrain(Train train){}

    public void removeTrain(String trainID){}

}
