package com.umcsuser.current.models;

import com.umcsuser.current.db.UserDB;
import com.umcsuser.current.users.Passenger;
import com.umcsuser.current.users.User;

import java.util.List;
import java.util.Objects;

public class Fine {
    private String passengerID;

    public Fine(String passengerID) {
        this.passengerID = passengerID;
    }

    public Passenger getPassengerInfo(){
        UserDB udb = new UserDB();
        List<User> users=udb.getUsers();

        for(User user: users){
            if(Objects.equals(user.getID(), this.passengerID)) return (Passenger) user;
        }
        return null;
    }
}
