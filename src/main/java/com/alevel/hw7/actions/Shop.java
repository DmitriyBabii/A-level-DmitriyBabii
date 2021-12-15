package com.alevel.hw7.actions;

import com.alevel.hw7.models.Player;
import com.alevel.hw7.models.Present;

import java.util.Random;

public class Shop {

    private final Random RAND = new Random();

    public void doAction(Player player, int playerChoose) {
        Present[] variantsPresent = Present.values();
        int variant = RAND.nextInt(variantsPresent.length);
        int price;

        switch (playerChoose) {
            case 0: {
                price = 100;
                if (player.getMoney() < price) {
                    System.out.printf("%s have no %d coins\n", player.getName(), price);
                    break;
                }
                player.updateMoney(-price);
                player.setPresents(addPresent(player, variantsPresent[variant]));
                player.updateHappiness(20);
                System.out.printf("%s received a %s as a gift\n", player.getName(), variantsPresent[variant]);
                break;
            }
            case 1: {
                price = 150;
                if (player.getMoney() < price) {
                    System.out.printf("%s have no %d coins\n", player.getName(), price);
                    break;
                }
                player.updateMoney(-price);
                player.setPresents(addPresent(player, variantsPresent[variant]));
                player.updateHappiness(25);
                System.out.printf("%s received a %s as a gift\n", player.getName(), variantsPresent[variant]);
                break;
            }
            case 2: {
                price = 200;
                if (player.getMoney() < price) {
                    System.out.printf("%s have no %d coins\n", player.getName(), price);
                    break;
                }
                player.updateMoney(-price);
                player.setPresents(addPresent(player, variantsPresent[variant]));
                player.updateHappiness(30);
                System.out.printf("%s received a %s as a gift\n", player.getName(), variantsPresent[variant]);
                break;
            }
            default: {
                System.out.println("Enter number between 0 and 2");
            }
        }
    }

    private Present[] addPresent(Player player, Present item) {
        Present[] tmp = new Present[player.getPresents().length + 1];

        for (int i = 0; i < player.getPresents().length; i++) {
            tmp[i] = player.getPresents()[i];
        }
        tmp[player.getPresents().length] = item;
        return tmp;
    }
}
