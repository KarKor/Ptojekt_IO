package com.umcsuser.current.users;

import com.umcsuser.current.db.FineDB;
import com.umcsuser.current.db.TicketDB;
import com.umcsuser.current.db.TransferDB;
import com.umcsuser.current.models.Fine;
import com.umcsuser.current.models.Ticket;
import com.umcsuser.current.models.Transfer;
import com.umcsuser.current.tools.Randomizer;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Passenger extends User{
    private TicketDB tickets = new TicketDB();
    private TransferDB transfers = new TransferDB();
    private Randomizer randomizer = new Randomizer();
    private FineDB fines = new FineDB();

    public Passenger(String login, String password, Role role) {
        super(login, password, role);
    }

    public void buyTicket() throws InterruptedException {
        tickets.readDatabase("tickets.csv");
        transfers.readDatabase("transfers.csv");
        ArrayList<Transfer> transfers1 = transfers.getTransfers();
        transfers.viewTransfers();
        String transferID = "";
        boolean correct = false;
        Scanner sc = new Scanner(System.in);
        while(!correct) {
            System.out.println("Select transfer (ID)");
            transferID = sc.nextLine();
            for (Transfer transfer : transfers1) {
                if (Objects.equals(transfer.getID(), transferID)) {
                    correct = true;
                    break;
                }
            }
            System.out.println("incorrect transfer ID");
        }
        System.out.println("How many? (1-5)");
        int amount = sc.nextInt();
        int price = randomizer.randomize(30, 70);
        System.out.println("Price to pay:" + price*amount);
        while(true) {
            System.out.println("\nSelect payment method:\n 1. Card\n 2. Blik");
            int option = sc.nextInt();
            if (option == 1) {
                System.out.println("Insert credit card number");
                sc.nextLine();
                System.out.println("Insert security code");
                sc.nextLine();
                System.out.println("Insert expiration date");
                sc.nextLine();
                System.out.println("Payment successful");
                break;
            } else if (option == 2) {
                System.out.println("Insert blik code");
                sc.nextLine();
                System.out.println("Confirm payment in your bank's app");
                TimeUnit.SECONDS.sleep(10);
                System.out.println("Payment successful");
                break;
            }
            System.out.println("incorrect payment method");
        }
        for(int i=0; i<amount; i++){
            tickets.addTicket(new Ticket(UUID.randomUUID().toString(), price, transferID, this.getID()));
        }
        tickets.saveDatabase("tickets.csv");
        System.out.println("Ticket(s) successfully purchased");


    }

    public void buyRandomTicket() throws InterruptedException {tickets.readDatabase("tickets.csv");
        transfers.readDatabase("transfers.csv");
        ArrayList<Transfer> transfers1 = transfers.getTransfers();

        Scanner sc = new Scanner(System.in);
        System.out.println("How many? (1-5)");
        int amount = sc.nextInt();
        System.out.println("Select low-end price (one ticket)");
        int low = sc.nextInt();
        System.out.println("Select high-end price (one ticket)");
        int high = sc.nextInt();
        int price = randomizer.randomize(low, high);
        System.out.println("Price to pay:" + price*amount);
        while(true) {
            System.out.println("\nSelect payment method:\n 1. Card\n 2. Blik");
            int option = sc.nextInt();
            if (option == 1) {
                System.out.println("Insert credit card number");
                sc.nextLine();
                System.out.println("Insert security code");
                sc.nextLine();
                System.out.println("Insert expiration date");
                sc.nextLine();
                System.out.println("Payment successful");
                break;
            } else if (option == 2) {
                System.out.println("Insert blik code");
                sc.nextLine();
                System.out.println("Confirm payment in your bank's app");
                TimeUnit.SECONDS.sleep(10);
                System.out.println("Payment successful");
                break;
            }
            System.out.println("incorrect payment method");
        }
        String transferID = String.valueOf(randomizer.randomize(1,4));
        for(int i=0; i<amount; i++){
            tickets.addTicket(new Ticket(UUID.randomUUID().toString(), price, transferID, this.getID()));
        }
        tickets.saveDatabase("tickets.csv");
        String startLocation = "";
        String endLocation = "";
        for(Transfer transfer : transfers1){
            if(Objects.equals(transfer.getID(), transferID)){
                startLocation = transfer.getStartLocation();
                endLocation = transfer.getEndLocation();
            }
        }
        System.out.println("Ticket(s) successfully purchased for a train from: " + startLocation + " to: " + endLocation);
    }

    public void returnTicket(){
        this.checkTickets();
        System.out.println("Choose ticket to return (ID)");
        Scanner sc = new Scanner(System.in);
        String ticketID = sc.nextLine();

        ArrayList<Ticket> temp = tickets.getTickets();
        for(Ticket ticket: temp){
            if(Objects.equals(ticket.getID(), ticketID)){
                System.out.println("Selected ticket will be returned and " + ticket.getPrice()*0.8 + "PLN will be refunded to your bank account.\n Continue> (y/n)");
                if(Objects.equals(sc.nextLine().toLowerCase(), "n")) {
                    System.out.println("operation aborted");
                    return;
                }
                tickets.removeTicket(ticketID);
            }
        }
        System.out.println("Ticket returned successfully");
    }

    public void showTicket(){
        this.checkTickets();
        System.out.println("Choose ticket to show (ID)");
        Scanner sc = new Scanner(System.in);
        String ticketID = sc.nextLine();

        ArrayList<Ticket> temp = tickets.getTickets();
        for(Ticket ticket: temp){
            if(Objects.equals(ticket.getID(), ticketID)){
                System.out.println(ticket.toString());
            }
        }
    }

    public void checkTickets(){
        tickets.readDatabase("tickets.csv");
        ArrayList<Ticket> temp = tickets.getTickets();
        for(Ticket ticket: temp){
            if(Objects.equals(ticket.getPassengerID(), this.getID())){
                System.out.println(ticket.toString());
            }
        }
    }

    public void checkFines(){
        fines.readDatabase("fines.csv");
        ArrayList<Fine> temp = fines.getFines();
        for(Fine fine: temp){
            if(Objects.equals(fine.getPassengerID(), this.getID())){
                System.out.println(fine.toString());
            }
        }
    }
}
