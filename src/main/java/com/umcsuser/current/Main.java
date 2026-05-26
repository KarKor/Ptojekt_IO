package com.umcsuser.current;

import com.umcsuser.current.users.User;

public class Main {
    public static void main(String[] args) {
        UI ui = new UI();

        User user = ui.login();
        ui.start(user);
    }
}
