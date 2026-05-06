package com.umcsuser.current.models;

public class Ticket {
    private String ID;
    private int price;
    private Transfer transfer;

    public Ticket(String ID, int price, Transfer transfer) {
        this.ID = ID;
        this.price = price;
        this.transfer = transfer;
    }

    public String getID() {
        return ID;
    }

    public int getPrice() {
        return price;
    }
}
