package com.store.builder.model;

public enum PaymentMethod {
    CASH("Наличными"),
    CARD("Картой"),
    INSTALLMENT("Рассрочка Kaspi");

    private final String displayName;

    PaymentMethod(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}