package com.alevel.hw6;

class Engine {
    final private String type;
    final private int power;
    private boolean start;

    public Engine(String type, int power) {
        this.type = type;
        this.power = power;
        start = false;
    }

    @Override
    public String toString() {
        return "{" +
                "type='" + type + '\'' +
                ", power=" + power +
                ", start=" + start +
                '}';
    }

    public void startEngine() {
        start = true;
    }

    public void stopEngine() {
        start = false;
    }

    public boolean isStart() {
        return start;
    }

    public String getType() {
        return type;
    }

    public int getPower() {
        return power;
    }
}
