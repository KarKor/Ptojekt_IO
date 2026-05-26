package com.umcsuser.current.users;

import com.umcsuser.current.db.TrainDB;
import com.umcsuser.current.models.Train;

public class Admin extends User{
    private TrainDB trainDB;

    public Admin(String login, String password, Role role) {
        super(login, password, role);
    }

    public void addTrain(String model, String company, String ID){
        trainDB.addTrain(new Train(model, ID, company));
    }
    public void removeTrain(String trainID){
        trainDB.removeTrain(trainID);
    }
}