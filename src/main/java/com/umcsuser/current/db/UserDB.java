package com.umcsuser.current.db;

import com.umcsuser.current.users.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDB implements Database{
    private final List<User> users=new ArrayList<>();

    @Override
    public void readDatabase(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                String[] parts = linia.split(";");
                if(Role.valueOf(parts[2])==Role.ADMIN) {
                    users.add(new Admin(
                            parts[0], parts[1], Role.valueOf(parts[2])
                    ));
                }
                if(Role.valueOf(parts[2])==Role.CONDUCTOR) {
                    users.add(new Conductor(
                            parts[0], parts[1], Role.valueOf(parts[2])
                    ));
                }
                if(Role.valueOf(parts[2])==Role.PASSENGER) {
                    users.add(new Passenger(
                            parts[0], parts[1], Role.valueOf(parts[2])
                    ));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveDatabase(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for(User user : users) {
                writer.write(user.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addUser(User user){
        users.add(user);
        saveDatabase("users.csv");
    }

    public void removeUser(String userID){
        users.removeIf(user->user.getID().equals(userID));
        saveDatabase("users.csv");
    }

    public ArrayList<User> getUsers() {
        return (ArrayList<User>) users;
    }
}
