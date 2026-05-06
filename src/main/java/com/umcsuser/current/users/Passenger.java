package com.umcsuser.current.users;

import com.umcsuser.current.models.Ticket;

public class Passenger extends User{
    public Passenger(String login, String password, Role role) {
        super(login, password, role);
    }

    public Ticket buyTicket(String transferID){}

    public Ticket buyRandomTicket(int amount, int priceLow, int priceHigh){}

    public void returnTicket(String ticketID){}

    public void showTicket(String ticketID){}

    public void checkTickets(){}

    public void checkFines(){}
}
