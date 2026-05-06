package com.umcsuser.current.db;

import com.umcsuser.current.users.User;

import java.io.*;
import java.util.List;

public class UserDB implements Database{
    private List<User> users;

    @Override
    public void readDatabase(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                System.out.println(linia);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveDatabase(String filePath) {

    }

    public void addUser(User user){}

    public void removeUser(String userID){}

    public List<User> getUsers() {
        return users;
    }
}
