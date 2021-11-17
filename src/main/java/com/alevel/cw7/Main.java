package com.alevel.cw7;

import com.alevel.cw7.models.Player;
import com.alevel.cw7.models.Type;
import com.alevel.cw7.services.UserService;

public class Main {
    public static void main(String[] args) {
        new UserService().start();
    }
}
