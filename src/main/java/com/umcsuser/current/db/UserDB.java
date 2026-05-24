package com.umcsuser.current.db;

import com.umcsuser.current.users.*;

import java.io.*;
import java.util.List;

public class UserDB implements Database{
    private List<User> users;

    @Override
    public void readDatabase(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                String[] dane = linia.split(";");

                if (dane.length >= 4) {
                    String ID = dane[0];
                    String login = dane[1];
                    String password = dane[2];

                    Role role = Role.valueOf(dane[3].toUpperCase());

                    User user = null;

                    switch (role) {
                        case ADMIN:
                            user = new Admin(login, password, role);
                            break;
                        case PASSENGER:
                            user = new Passenger(login, password, role);
                            break;
                        case CONDUCTOR:
                            user = new Conductor(login, password, role);
                            break;
                    }

                    if (user != null) {
                        user.setID(ID);
                        users.add(user);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveDatabase(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (User user : users) {
                writer.write(user.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisywania pliku z użytkownikami: " + e.getMessage());
        }
    }

    public void addUser(User user){
        if (user != null) {
            users.add(user);
            System.out.println("Pomyślnie dodano użytkownika: " + user.getLogin());
        }
    }

    public void removeUser(String userID){
        boolean isRemoved = users.removeIf(user -> user.getID().equals(userID));

        if (isRemoved) {
            System.out.println("Usunięto użytkownika o ID: " + userID);
        } else {
            System.out.println("Nie znaleziono użytkownika o ID: " + userID);
        }
    }

    public List<User> getUsers() {
        return users;
    }
}
