package ru.uxair.flight.entity;

public enum FlightStatus {
    SCHEDULED("Запланированный"), ONTIME("По расписанию"), DELAYED("Отложенный"), DEPARTED("Отправился"), ARRIVED("Прилетел"), CANCELED("Отменён");
    private final String name;

    FlightStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
