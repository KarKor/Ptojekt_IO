package com.umcsuser.current.models;

public class Ticket {
    private String ID;
    private int price;
    private String transferID;

    public Ticket(String ID, int price, String transferID) {
        this.ID = ID;
        this.price = price;
        this.transferID = transferID;
    }

    public String getID() {
        return ID;
    }

    public int getPrice() {
        return price;
    }

    public String  toCSV() {
        return this.ID + ";" + this.price + ";" + this.transferID;
    }
}
