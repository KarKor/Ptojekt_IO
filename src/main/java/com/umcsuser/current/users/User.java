package com.umcsuser.current.users;

import com.umcsuser.current.db.TransferDB;
import com.umcsuser.current.db.UserDB;

import java.util.*;

public abstract class User {
    private String ID;
    private String login;
    private String password;
    private Role role;
    private TransferDB transfers;

    public User(String login, String password, Role role) {
        this.ID=UUID.randomUUID().toString();
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getID() {
        return ID;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void viewTransfers(){
        transfers.viewTransfers();
    }

    public boolean logIn(String login, String password){
        UserDB udb = new UserDB();
        List<User> users=udb.getUsers();

        for(User user: users){
            if(Objects.equals(user.getLogin(), login)){
                if(Objects.equals(user.getPassword(), password)) return true;
            }
        }
        return false;
    }

    public String toCSV(){
        return this.ID+';'+this.login+';'+this.password+';'+this.role;
    }
}
