package com.alevel.cw7.services;

import com.alevel.cw7.actions.*;
import com.alevel.cw7.models.Player;
import com.alevel.cw7.models.Type;

import java.util.Random;
import java.util.Scanner;

public class UserService {
    private final static Scanner IN = new Scanner(System.in);
    private final static Random RAND = new Random();

    public void start() {
        Player player = userInputStartInformation();
        doActions(player);
    }

    private Player userInputStartInformation() {
        int typeNumber = -1;
        String playerName;

        System.out.println("Choose your animal type:");
        final Type[] types = Type.values();
        StringBuilder playerType = new StringBuilder();

        for (int i = 0; i < types.length; i++) {
            playerType.append(i).append(") ")
                    .append(types[i]).append("\n");
        }
        System.out.println(playerType);

        do {
            try {
                System.out.print("Enter number from 0 to " + (types.length - 1) + "\n--->");
                typeNumber = Integer.parseInt(IN.next());
            } catch (Exception ex) {
                System.out.println("You need to enter the number");
            }
        } while (typeNumber < 0 || typeNumber >= types.length);

        do {
            System.out.println("Enter your character's name between 3 and 20 characters: ");
            playerName = IN.next().trim();
        } while (playerName.length() < 3 || playerName.length() > 20);

        return new Player(playerName, types[typeNumber]);
    }

    private void doActions(Player player) {
        Food food = new Food();
        Game game = new Game();
        Heal heal = new Heal();
        Shop shop = new Shop();
        Work work = new Work();

        MainMenu[] mainElements = MainMenu.values();
        StringBuilder mainMenu = new StringBuilder();

        mainMenu.append("\nMENU:\n");
        for (int i = 0; i < mainElements.length; i++) {
            mainMenu.append(i).append(") ")
                    .append(mainElements[i]);
            if (i != mainElements.length - 1) {
                mainMenu.append("\n");
            }
        }

        boolean exit = false;
        do {
            System.out.println(player);
            System.out.println(mainMenu);

            try {
                System.out.print("--->");
                switch (Integer.parseInt(IN.next())) {
                    case 0: {
                        food.doAction(player);
                        break;
                    }
                    case 1: {
                        game.doAction(player);
                        break;
                    }
                    case 2: {
                        for (int i = 0, price = 100; i < 3; i++, price += 50) {
                            System.out.println(i + ") buy for " + price);
                        }
                        System.out.print("--->");
                        shop.doAction(player, Integer.parseInt(IN.next()));
                        break;
                    }
                    case 3: {
                        work.doAction(player);
                        break;
                    }
                    case 4: {
                        heal.doAction(player);
                        break;
                    }
                    case 5: {
                        exit = true;
                        break;
                    }
                    default: {
                        System.out.println("Enter number between 0 and " + (mainElements.length - 1));
                    }
                }
            } catch (Exception ex) {
                System.out.println("You need to enter the number");
            }
        } while (!exit);

    }
}
