package com.umcsuser.current.users;

import com.umcsuser.current.db.FineDB;
import com.umcsuser.current.db.TicketDB;
import com.umcsuser.current.models.Fine;
import com.umcsuser.current.models.Ticket;
import com.umcsuser.current.tools.Randomizer;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public class Conductor extends User{
    private TicketDB tickets = new TicketDB();
    private FineDB fines = new FineDB();

    public Conductor(String login, String password, Role role) {
        super(login, password, role);
    }

    public void sellTicket(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert passenger's ID");
        String passengerID = sc.nextLine();
        System.out.println("Insert transfer's ID");
        String transferID = sc.nextLine();
        Randomizer randomizer = new Randomizer();
        int price = randomizer.randomize(30, 70);
        System.out.println("Price for the passenger to pay: " + price + "\nProceed once the passenger has paid in cash");
        sc.nextLine();
        tickets.addTicket(new Ticket(UUID.randomUUID().toString(), price, transferID, passengerID));
        System.out.println("Ticket sold successfully");
        tickets.saveDatabase("tickets.csv");
    }

    public void checkTicket(){
        Scanner sc = new Scanner(System.in);
        tickets.readDatabase("tickets.csv");
        System.out.println("Insert passenger's ID");
        String passengerID = sc.nextLine();
        System.out.println("Insert ticket's ID");
        String ticketID = sc.nextLine();
        ArrayList<Ticket> tickets1 = tickets.getTickets();
        for(Ticket ticket: tickets1){
            if(Objects.equals(ticket.getID(), ticketID)){
                if(Objects.equals(ticket.getPassengerID(), passengerID)){
                    System.out.println("Ticket data matches the provided data");
                    return;
                }
            }
        }
        System.out.println("Ticket data doesn't match the provided data");
    }

    public Fine giveFine(String passengerID){
        String fineID = UUID.randomUUID().toString();
        Fine fine = new Fine(fineID, passengerID);
        fines.addFine(fine);
        System.out.println("Successfully issued a fine for passenger ID: " + passengerID);
        return fine;
    }
}