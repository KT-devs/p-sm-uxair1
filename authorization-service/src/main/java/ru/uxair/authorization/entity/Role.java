package ru.uxair.authorization.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {

    ADMIN("ADMIN"),
    SUPERADMIN("SUPERADMIN"),
    MANAGER("MANAGER"),
    CUSTOMER("CUSTOMER");

    private final String role;

}