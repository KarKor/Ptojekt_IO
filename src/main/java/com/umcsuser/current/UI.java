package com.umcsuser.current;

import com.umcsuser.current.db.UserDB;
import com.umcsuser.current.users.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {
    private UserDB users;
    private Passenger passenger;
    private Admin admin;
    private Conductor conductor;

    public  User login(){
        System.out.println("Enter your login and password");
        Scanner sc = new Scanner(System.in);
        String login = sc.nextLine();
        String password = sc.nextLine();
        ArrayList<User> users1 = users.getUsers();
        for(User user : users1){
            if(user.getLogin().equals(login) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;

    }

    public void start(User user){}
}
