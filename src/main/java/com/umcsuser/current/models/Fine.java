package com.umcsuser.current.models;

import com.umcsuser.current.db.UserDB;
import com.umcsuser.current.users.Passenger;
import com.umcsuser.current.users.User;

import java.util.List;
import java.util.Objects;

public class Fine {
    private String passengerID;
    private String fineID;

    public Fine(String fineID, String passengerID) {
        this.fineID = fineID;
        this.passengerID = passengerID;
    }

    public Passenger getPassengerInfo(){
        UserDB udb = new UserDB();
        udb.readDatabase("users.csv");
        List<User> users=udb.getUsers();

        for(User user: users){
            if(Objects.equals(user.getID(), this.passengerID)) return (Passenger) user;
        }
        return null;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public String getFineID() {
        return fineID;
    }

    public String toCSV(){
        return this.fineID + ";" + this.passengerID;
    }

    @Override
    public String toString() {
        return "ID:'" + fineID + '\'' +
                ", passengerID='" + passengerID + '\'';
    }
}