package com.alevel.hw23.models;

public enum InfoSQL {

    PASSWORD("Babii0706"),
    URL("jdbc:mysql://localhost:3306/homework?serverTimezone=Europe/Moscow&useSSL=false&allowPublicKeyRetrieval=true"),
    USER("root");

    private String info;

    public String get() {
        return info;
    }

    InfoSQL(String info) {
        this.info = info;
    }
}
