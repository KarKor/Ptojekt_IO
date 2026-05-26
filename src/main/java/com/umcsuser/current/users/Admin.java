package com.umcsuser.current.users;

import com.umcsuser.current.db.TrainDB;
import com.umcsuser.current.models.Train;

public class Admin extends User{
    private TrainDB trains = new TrainDB();

    public Admin(String login, String password, Role role) {
        super(login, password, role);
    }

    public void addTrain(String model, String company, String ID){
        trains.readDatabase("trains.csv");
        trains.addTrain(new Train(ID, model, company));
        System.out.println("Train successfully added!");
    }

    public void removeTrain(String trainID){
        trains.readDatabase("trains.csv");
        trains.removeTrain(trainID);
        System.out.println("Train successfully removed!");
    }
}