package com.store.builder.model;

import java.util.Objects;

public final class PurchaseItem {

    private final ProductType productType;
    private final String size;
    private final String color;
    private final int quantity;

    public PurchaseItem(ProductType productType, String size, String color, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Количество должно быть положительным: " + quantity);
        }
        this.productType = Objects.requireNonNull(productType, "productType не может быть null");
        this.size = Objects.requireNonNull(size, "size не может быть null");
        this.color = Objects.requireNonNull(color, "color не может быть null");
        this.quantity = quantity;
    }

    public int getSubtotal() {
        return productType.getBasePrice() * quantity;
    }

    public ProductType getProductType() {
        return productType;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("%-22s размер=%-4s цвет=%-8s x%d = %d тг.",
                productType.getDisplayName(), size, color, quantity, getSubtotal());
    }
}