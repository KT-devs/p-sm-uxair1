package ru.uxair.flight.entity;

public enum SeatCategory {
    FIRST("Первый класс"), BUSINESS("Бизнес класс"), ECONOMY("Эконом класс");
    private final String name;

    SeatCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

