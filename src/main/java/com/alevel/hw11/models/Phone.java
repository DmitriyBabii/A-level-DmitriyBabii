package com.alevel.hw11.models;

import lombok.Getter;

import java.util.Objects;

@Getter
public abstract class Phone {
    private String type;
    private final String model;
    private final int year;
    private final Memory phoneMemory;
    private boolean isBroken;

    public Phone(String model, int year, Memory phoneMemory, boolean isBroken) {
        this.model = model;
        this.year = year;
        this.phoneMemory = phoneMemory;
        this.isBroken = isBroken;
    }

    public abstract boolean call();

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    protected void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", phoneMemory=" + phoneMemory +
                ", isBroken=" + isBroken +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return isBroken == phone.isBroken;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isBroken);
    }
}
