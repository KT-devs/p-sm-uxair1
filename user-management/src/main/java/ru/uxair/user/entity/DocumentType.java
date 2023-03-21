package ru.uxair.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DocumentType {
    NATIONAL_PASSPORT("NATIONAL_PASSPORT"), INTERNATIONAL_PASSPORT("INTERNATIONAL_PASSPORT");
    private final String type;
}
