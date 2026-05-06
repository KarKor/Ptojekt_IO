package com.umcsuser.current.users;

public class Admin extends User{
    public Admin(String login, String password, Role role) {
        super(login, password, role);
    }

    public void addTrain(String model, String company, String ID){}
    public void removeTrain(String trainID){}
}
