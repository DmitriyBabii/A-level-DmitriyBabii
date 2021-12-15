package com.alevel.hw7.actions;

import com.alevel.hw7.models.Player;

import java.util.Random;

public class Work {

    private final static Random RAND = new Random();
    private int countWork = 0;

    public void doAction(Player player) {
        double factor = 1.0 * player.isHungry() * player.isMiserable();
        int chanceToSick = 10;
        int earnedCoins = 5 + RAND.nextInt(16);
        if (player.isSick()) {
            factor *= 2;
        }

        if (player.getAge() >= 5 && !player.isUnHappy()) {
            if (++countWork == 6) {
                player.updateAge();
                countWork = 0;
            }

            player.updateMoney(earnedCoins);
            player.updateSatiety(-4 * factor);
            player.updateHappiness(-2 * factor);

            if (!player.isSick()) {
                player.setSick(RAND.nextInt(101) <= (chanceToSick * player.isUnPurity()));
            }

            System.out.printf("%s earned %d coins\n", player.getName(), earnedCoins);

        } else {
            if (player.getAge() < 5) {
                System.out.printf("%s is not 5 years old\n", player.getName());
            } else {
                System.out.printf("%s is unhappy\n", player.getName());
            }
        }
    }
}
