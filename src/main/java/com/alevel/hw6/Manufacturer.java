package com.alevel.hw6;

enum Manufacturer {
    Nissan("Ниссан"), Porsche("Порше"), Audi("Ауди"),
    Hyundai("Хендай"), Ford("Форд"), Volkswagen("Вольгсваген"),
    Honda("Хонда"), BMW("БМВ"), Mercedes_Benz("Мерседес-Бенз"),
    Toyota("Тойота");

    private String russianName;

    Manufacturer(String russianName) {
        this.russianName = russianName;
    }

    public String getRussianName() {
        return russianName;
    }
}
