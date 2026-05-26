package com.umcsuser.current;

import com.umcsuser.current.db.UserDB;
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
                    if (user.getRole().equals(Role.ADMIN)){
                        return new Admin(user.getLogin(), user.getPassword(), user.getRole());
                    }
                    if (user.getRole().equals(Role.CONDUCTOR)){
                        return new Conductor(user.getLogin(), user.getPassword(), user.getRole());
                    }
                    if (user.getRole().equals(Role.PASSENGER)){
                        return new Passenger(user.getLogin(), user.getPassword(), user.getRole());
                    }
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
        } else if (user.getRole()==Role.CONDUCTOR) {
            System.out.println("1. See departures\n 2. Sell ticket\n 3. Check ticket\n 4. Give fine");
        } else if (user.getRole()==Role.ADMIN) {
            System.out.println("1. See departures\n 2. See trains\n 3. Add train\n 4. Remove train\n 5. See ongoing transfers");
        }

    }
}