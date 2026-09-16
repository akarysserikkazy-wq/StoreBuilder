package com.store.builder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Purchase {

    private static final int GIFT_WRAP_FEE = 1500;
    private static final int STUDENT_DISCOUNT_PERCENT = 5;

    private final String customerName;
    private final String cashierName;
    private final List<PurchaseItem> items;
    private final PaymentMethod paymentMethod;
    private final boolean studentDiscount;
    private final boolean giftWrapped;
    private final String giftMessage;

    public Purchase(String customerName,
                    String cashierName,
                    List<PurchaseItem> items,
                    PaymentMethod paymentMethod,
                    boolean studentDiscount,
                    boolean giftWrapped,
                    String giftMessage) {
        this.customerName = customerName;
        this.cashierName = cashierName;
        this.items = Collections.unmodifiableList(new ArrayList<>(items));
        this.paymentMethod = paymentMethod;
        this.studentDiscount = studentDiscount;
        this.giftWrapped = giftWrapped;
        this.giftMessage = giftMessage;
    }

    public int calculateTotal() {
        int itemsTotal = 0;
        for (PurchaseItem item : items) {
            itemsTotal += item.getSubtotal();
        }

        if (studentDiscount) {
            itemsTotal -= itemsTotal * STUDENT_DISCOUNT_PERCENT / 100;
        }

        if (giftWrapped) {
            itemsTotal += GIFT_WRAP_FEE;
        }

        return itemsTotal;
    }

    public void printReceipt() {
        System.out.println("========================================");
        System.out.println("Покупатель: " + (customerName != null ? customerName : "не указан"));
        System.out.println("Кассир: " + cashierName);
        System.out.println("----------------------------------------");
        for (PurchaseItem item : items) {
            System.out.println("  " + item);
        }
        System.out.println("----------------------------------------");
        System.out.println("Оплата: " + paymentMethod.getDisplayName());
        if (studentDiscount) {
            System.out.println("Студенческая скидка: -" + STUDENT_DISCOUNT_PERCENT + "%");
        }
        if (giftWrapped) {
            System.out.println("Подарочная упаковка: да" +
                    (giftMessage != null && !giftMessage.isBlank() ? " (\"" + giftMessage + "\")" : ""));
        }
        System.out.println("ИТОГО: " + calculateTotal() + " тг.");
        System.out.println("========================================\n");
    }

    public List<PurchaseItem> getItems() {
        return items;
    }

    public String getCashierName() {
        return cashierName;
    }
}