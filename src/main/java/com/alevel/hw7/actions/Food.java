package com.alevel.hw7.actions;

import com.alevel.hw7.models.Player;

public class Food {
    public void doAction(Player player) {
        double factor = 1.0 * player.isHungry() * player.isMiserable();
        if (player.isSick()) {
            factor *= 2;
        }

        player.updateSatiety(5);
        player.updatePurity(-2 * factor);
        System.out.printf("%s ate\n", player.getName());
    }
}
