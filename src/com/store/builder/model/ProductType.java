package com.store.builder.model;

public enum ProductType {
    T_SHIRT("Базовая футболка", 7990),
    HOODIE("Худи оверсайз", 18990),
    ZIP_HOODIE("Зипка (зип-худи)", 21990),
    PANTS("Штаны", 15990),
    CAP("Кепка", 5990),
    SOCKS("Носки (пара)", 990);

    private final String displayName;
    private final int basePrice;

    ProductType(String displayName, int basePrice) {
        this.displayName = displayName;
        this.basePrice = basePrice;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getBasePrice() {
        return basePrice;
    }
}