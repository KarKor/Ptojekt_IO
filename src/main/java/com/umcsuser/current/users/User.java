package com.umcsuser.current.users;

import com.umcsuser.current.db.TransferDB;

public abstract class User {
    private String ID;
    private String login;
    private String password;
    private Role role;
    private TransferDB transfers;

    public User(String login, String password, Role role) {
        //ID przez UUID
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

    public void viewTransfers(){}

    public void logIn(String login, String password){}
}
