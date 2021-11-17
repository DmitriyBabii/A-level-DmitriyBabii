package com.alevel.cw7.actions;

import com.alevel.cw7.models.Player;

public class Heal {
    public void doAction(Player player) {

        if (player.isSick()) {
            int price = 50;
            if (player.getMoney() < price) {
                System.out.printf("%s have no %d coins\n", player.getName(), price);
                return;
            }
            player.updateMoney(-price);
            if (player.getHappiness() > 10) {
                player.setHappiness(10);
            }
            if (player.getSatiety() > 70) {
                player.setSatiety(70);
            }
            if (player.getPurity() < 80) {
                player.setPurity(80);
            }
            player.setSick(false);
            System.out.printf("%s recovered\n", player.getName());

        } else {
            System.out.printf("%s don't need treatment\n", player.getName());
        }


    }
}
