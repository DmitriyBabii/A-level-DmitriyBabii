package com.alevel.cw7.actions;

import com.alevel.cw7.models.Player;

import java.util.Random;

public class Game {

    private final static Random RAND = new Random();
    private int countGames = 0;

    public void doAction(Player player) {
        double factor = 1.0 * player.isHungry() * player.isMiserable();
        int chanceToSick = 10;
        int wonCoins = 1 + RAND.nextInt(10);
        if (player.isSick()) {
            factor *= 2;
        }

        if (++countGames == 5) {
            player.updateAge();
            countGames = 0;
        }

        player.updateSatiety(-3 * factor);
        player.updateHappiness(6);
        player.updateMoney(wonCoins);

        if (!player.isSick()) {
            player.setSick(RAND.nextInt(101) <= (chanceToSick * player.isUnPurity()));
        }
        System.out.printf("%s won %d coins\n", player.getName(), wonCoins);
    }
}
