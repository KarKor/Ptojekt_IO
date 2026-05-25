package com.umcsuser.current.db;

import com.umcsuser.current.models.Ticket;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDB implements Database{
    private ArrayList<Ticket> tickets=new ArrayList<>();

    @Override
    public void readDatabase(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                String parts[] = linia.split(";");
                tickets.add(new Ticket(
                        parts[0], Integer.parseInt(parts[1]),parts[2],parts[3]
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveDatabase(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for(Ticket ticket:tickets){
                writer.write(ticket.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addTicket(Ticket ticket){
        tickets.add(ticket);
        saveDatabase("tickets.csv");
    }

    public void removeTicket(String ticketID){
        tickets.removeIf(ticket -> ticket.getID().equals(ticketID));
        saveDatabase("tickets.csv");
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }
}
