package ru.uxair.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ContactType {
    EMAIL("EMAIL"), PHONE("PHONE"), WHATSAPP("WHATSAPP"), TELEGRAM("TELEGRAM");
    private final String contact;
}
