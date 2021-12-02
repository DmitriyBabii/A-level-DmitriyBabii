package com.alevel.hw11.models;

public class FlipPhone extends PushButtonPhone {

    public FlipPhone(String model, int year, Memory phoneMemory) {
        this(model, year, phoneMemory, false);
    }

    public FlipPhone(String model, int year, Memory phoneMemory, boolean isBroken) {
        super(model, year, phoneMemory, isBroken);
        this.setType("FlipPhone");
    }

    @Override
    public boolean call() {
        return pushSomeButton();
    }

    @Override
    public boolean pushSomeButton() {
        return openPhoneCover();
    }

    public boolean openPhoneCover() {
        return !this.isBroken();
    }

}
