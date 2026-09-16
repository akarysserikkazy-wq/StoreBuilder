package com.store.builder.builder;

import com.store.builder.model.PaymentMethod;
import com.store.builder.model.ProductType;
import com.store.builder.model.Purchase;
import com.store.builder.model.PurchaseItem;

import java.util.ArrayList;
import java.util.List;

public class PurchaseBuilder {

    private String customerName;
    private String cashierName;
    private final List<PurchaseItem> items = new ArrayList<>();
    private PaymentMethod paymentMethod = PaymentMethod.CARD;
    private boolean studentDiscount = false;
    private boolean giftWrapped = false;
    private String giftMessage = "";

    public PurchaseBuilder forCustomer(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public PurchaseBuilder servedBy(String cashierName) {
        this.cashierName = cashierName;
        return this;
    }

    public PurchaseBuilder addItem(ProductType productType, String size, String color, int quantity) {
        this.items.add(new PurchaseItem(productType, size, color, quantity));
        return this;
    }

    public PurchaseBuilder withPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public PurchaseBuilder asStudentPurchase() {
        this.studentDiscount = true;
        return this;
    }

    public PurchaseBuilder withGiftWrap(String giftMessage) {
        this.giftWrapped = true;
        this.giftMessage = giftMessage;
        return this;
    }

    public Purchase build() {
        if (cashierName == null || cashierName.isBlank()) {
            throw new IllegalStateException("Нельзя оформить покупку без кассира!");
        }
        if (items.isEmpty()) {
            throw new IllegalStateException("Покупка должна содержать хотя бы одну позицию!");
        }

        return new Purchase(
                customerName,
                cashierName,
                new ArrayList<>(items),
                paymentMethod,
                studentDiscount,
                giftWrapped,
                giftMessage
        );
    }
}