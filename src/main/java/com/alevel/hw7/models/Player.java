package com.alevel.hw7.models;

import java.util.Arrays;

public class Player {
    private final String name;
    private final Type type;
    private int age;
    private double satiety;
    private double money;
    private double purity;
    private double happiness;
    private Present[] presents;

    private boolean sick;

    public Player(String name, Type type) {
        this.name = name;
        this.type = type;
        this.age = 1;
        this.satiety = 100;
        this.purity = 100;
        this.happiness = 50;
        presents = new Present[0];
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSatiety() {
        return satiety;
    }

    public double getMoney() {
        return money;
    }

    public double getPurity() {
        return purity;
    }

    public double getHappiness() {
        return happiness;
    }

    public Present[] getPresents() {
        return presents;
    }

    public void setHappiness(double happiness) {
        this.happiness = happiness;
    }

    public void setSick(boolean sick) {
        this.sick = sick;
    }


    public void setSatiety(double satiety) {
        this.satiety = satiety;
    }

    public void setPresents(Present[] presents) {
        this.presents = presents;
    }

    public void setPurity(double purity) {
        this.purity = purity;
    }

    public int isUnPurity() {
        return (purity < 50) ? 3 : 1;
    }

    public double isHungry() {
        return (satiety < 50.0) ? 1.5 : 1.0;
    }

    public boolean isSick() {
        return sick;
    }


    public boolean isUnHappy() {
        return (happiness < 20);
    }

    public double isMiserable() {
        return (happiness < 10) ? 1.2 : 1;
    }

    public void updateAge() {
        this.age++;
    }

    public void updateSatiety(double satiety) {
        this.satiety += satiety;
        if (this.satiety > 100) {
            this.satiety = 100;
        } else if (this.satiety < 0) {
            this.satiety = 0;
        }
    }

    public void updateMoney(int money) {
        this.money += money;
        if (this.money < 0) {
            this.money = 0;
        }
    }

    public void updatePurity(double purity) {
        this.purity += purity;
        if (this.purity > 100) {
            this.purity = 100;
        } else if (this.purity < 0) {
            this.purity = 0;
        }
    }

    public void updateHappiness(double happiness) {
        this.happiness += happiness;
        if (this.happiness > 100) {
            this.happiness = 100;
        } else if (this.happiness < 0) {
            this.happiness = 0;
        }
    }

    @Override
    public String toString() {
        return "\nSTATUS:\n" + type + ": " + name +
                "\nAge = " + age +
                "\nMoney = " + money +
                "\nPresents = " + (presents.length == 0 ? "have no presents" : Arrays.toString(presents)) +

                "\nSatiety = " + (satiety < 50 ? TextColor.RED.ansi :
                (satiety < 60) ? TextColor.YELLOW.ansi : TextColor.GREEN.ansi) + satiety + TextColor.RESET.ansi +

                "\nPurity = " + (purity < 50 ? TextColor.RED.ansi :
                (purity < 60) ? TextColor.YELLOW.ansi : TextColor.GREEN.ansi) + purity + TextColor.RESET.ansi +

                "\nHappiness = " + (happiness < 10 ? TextColor.RED.ansi :
                (happiness < 20) ? TextColor.YELLOW.ansi : TextColor.GREEN.ansi) + happiness + TextColor.RESET.ansi +

                "\nSick = " + (isSick() ? (TextColor.RED.ansi + "sick") : (TextColor.GREEN.ansi + "healthy")) + TextColor.RESET.ansi;
    }
}
