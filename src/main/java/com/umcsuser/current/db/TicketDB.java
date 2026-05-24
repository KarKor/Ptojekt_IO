package com.umcsuser.current.db;

import com.umcsuser.current.models.Ticket;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDB implements Database{
    private List<Ticket> tickets = new ArrayList<>();

    public List<Ticket> getTickets() {
        return tickets;
    }

    @Override
    public void readDatabase(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                String[] dane = linia.split(";");
                if (dane.length >= 3) {
                    String ID = dane[0];
                    int price = Integer.parseInt(dane[1]);
                    String transferID = dane[2];

                    Ticket ticket = new Ticket(ID, price, transferID);
                    tickets.add(ticket);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveDatabase(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Ticket ticket : tickets) {
                writer.write(ticket.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisywania pliku z biletami: " + e.getMessage());
        }
    }

    public void addTicket(Ticket ticket){
        if (ticket != null) {
            tickets.add(ticket);
            System.out.println("Pomyślnie dodano nowy bilet.");
        }
    }

    public void removeTicket(String ticketID){
        boolean isRemoved = tickets.removeIf(ticket -> ticket.getID().equals(ticketID));

        if (isRemoved) {
            System.out.println("Usunięto bilet o ID: " + ticketID);
        } else {
            System.out.println("Nie znaleziono biletu o ID: " + ticketID);
        }
    }
}
