package com.umcsuser.current.models;

import com.umcsuser.current.users.Conductor;
import com.umcsuser.current.users.Passenger;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private List<Conductor> conductors;
    private List<Passenger> passengers;
    private String model;
    private String company;
    private String ID;

    public Train(String company, String ID, String model) {
        this.company = company;
        this.ID = ID;
        this.model=model;
        conductors=new ArrayList<>();
        passengers=new ArrayList<>();
    }

    public String getID() {
        return ID;
    }

    public String toCSV(){
        return this.ID+';'+this.model+';'+this.company+';';
    }
}
