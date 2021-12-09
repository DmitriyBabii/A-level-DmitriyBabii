package com.alevel.hw11.models;

public class PushButtonPhone extends Phone {

    public PushButtonPhone(String model, int year, Memory phoneMemory) {
        this(model, year, phoneMemory, false);
    }

    public PushButtonPhone(String model, int year, Memory phoneMemory, boolean isBroken) {
        super(model, year, phoneMemory, isBroken);
        this.setType("PushButtonPhone");
    }

    @Override
    public boolean call() {
        return pushSomeButton();
    }

    public boolean pushSomeButton() {
        return !this.isBroken();
    }
}
