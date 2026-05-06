package com.umcsuser.current.db;

import com.umcsuser.current.models.Ticket;

import java.util.List;

public class TicketDB implements Database{
    private List<Ticket> tickets;

    @Override
    public void readDatabase(String filePath) {

    }

    @Override
    public void saveDatabase(String filePath) {

    }

    public void addTicket(Ticket ticket){}

    public void removeTicket(String ticketID){}
}
