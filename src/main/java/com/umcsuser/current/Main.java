package com.umcsuser.current;

import com.umcsuser.current.users.User;

public class Main {
    public static void main(String[] args) {
        UI ui = new UI();

        User user = ui.login();
        if (user != null) {
            while (true) {
                ui.start(user);
            }
        } else {
            System.out.println("Zamykanie programu...");
        }
    }
}