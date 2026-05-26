package com.umcsuser.current.models;

public class Ticket {
    private String ID;
    private int price;
    private String transferID;
    private String passengerID;

    public Ticket(String ID, int price, String transferID, String passengerID) {
        this.ID = ID;
        this.price = price;
        this.transferID = transferID;
        this.passengerID = passengerID;
    }

    public String getID() {
        return ID;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ID: '" + ID +
                ", passengerID: '" + passengerID +
                ", transferID: '" + transferID;
    }

    public String toCSV(){
        return this.ID+';'+this.price+';'+this.transferID;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public String getTransferID() {
        return transferID;
    }
}