package ru.uxair.flight.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SeatCategory {
    FIRST("First"),
    BUSINESS("Business"),
    ECONOMY("Economy");

    private final String category;
}


