package com.alevel.hw6;

enum Color {
    RED("#FF0000"), GREEN("#008000"),
    BLUE("#0000FF"), YELLOW("#FFFF00"),
    WHITE("#FFFFFF"), BLACK("#000000");

    private String code;

    Color(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
