package com.umcsuser.current;

import com.umcsuser.current.db.TrainDB;
import com.umcsuser.current.db.UserDB;
import com.umcsuser.current.models.Train;
import com.umcsuser.current.users.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {
    private UserDB users = new UserDB();
    private Passenger passenger;
    private Admin admin;
    private Conductor conductor;


    public  User login(){
        users.readDatabase("users.csv");
        System.out.println("Enter your login and password");
        Scanner sc = new Scanner(System.in);
        String login = sc.nextLine();
        String password = sc.nextLine();
        ArrayList<User> users1 = users.getUsers();
        for(User user : users1){
            if(user.getLogin().equals(login)){
                if (user.getPassword().equals(password)){
                    return user;
                } else {
                    System.out.println("Incorrect password");
                    return null;
                }
            } else {
                System.out.println("Incorrect login");
            }
        }
        return null;

    }

    public void start(User user){
        System.out.println("what do you wish to do?");
        Scanner sc = new Scanner(System.in);
        if(user.getRole()==Role.PASSENGER){
            System.out.println("1. See departures\n 2. Buy ticket\n 3. Return ticket\n 4. Show ticker\n 5. See your tickets\n 6. Ticket gacha");
            int choice = sc.nextInt();
            sc.nextLine();
            Passenger p = (Passenger) user;
            switch (choice) {
                case 1:
                    p.viewTransfers();
                    break;
                case 2:
                    try {
                        p.buyTicket();
                    } catch (InterruptedException e) {
                        System.out.println("Transakcja przerwana.");
                    }
                    break;
                case 3:
                    p.returnTicket();
                    break;
                case 4:
                    p.showTicket();
                    break;
                case 5:
                    p.checkTickets();
                    break;
                case 6:
                    try {
                        p.buyRandomTicket();
                    } catch (InterruptedException e) {
                        System.out.println("Transakcja przerwana.");
                    }
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } else if (user.getRole()==Role.CONDUCTOR) {
            System.out.println("1. See departures\n 2. Sell ticket\n 3. Check ticket\n 4. Give fine");
            int choice = sc.nextInt();
            sc.nextLine();

            Conductor c = (Conductor) user;

            switch (choice) {
                case 1:
                    c.viewTransfers();
                    break;
                case 2:
                    c.sellTicket();
                    break;
                case 3:
                    c.checkTicket();
                    break;
                case 4:
                    System.out.println("Enter passenger ID:");
                    String passengerID = sc.nextLine();
                    c.giveFine(passengerID);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } else if (user.getRole()==Role.ADMIN) {
            System.out.println("1. See departures\n 2. See trains\n 3. Add train\n 4. Remove train\n 5. See ongoing transfers");
            int choice = sc.nextInt();
            sc.nextLine();

            Admin a = (Admin) user;

            switch (choice) {
                case 1:
                case 5:
                    a.viewTransfers();
                    break;
                case 2:
                    TrainDB tdb = new TrainDB();
                    tdb.readDatabase("trains.csv");
                    ArrayList<Train> trains = tdb.getTrains();
                    for (Train t : trains) {
                        System.out.println(t.toCSV());
                    }
                    break;
                case 3:
                    System.out.println("Enter train ID:");
                    String id = sc.nextLine();
                    System.out.println("Enter train model:");
                    String model = sc.nextLine();
                    System.out.println("Enter train company:");
                    String company = sc.nextLine();
                    a.addTrain(model, company, id);
                    break;
                case 4:
                    System.out.println("Enter train ID to remove:");
                    String removeId = sc.nextLine();
                    a.removeTrain(removeId);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

    }
}