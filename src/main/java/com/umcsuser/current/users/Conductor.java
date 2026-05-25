package com.umcsuser.current.users;

import com.umcsuser.current.models.Fine;

public class Conductor extends User{
    public Conductor(String login, String password, Role role) {
        super(login, password, role);
    }

    //public Fine giveFine(String passengerID){}
}
