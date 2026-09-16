package com.store.builder.director;

import com.store.builder.builder.PurchaseBuilder;
import com.store.builder.model.PaymentMethod;
import com.store.builder.model.Purchase;

public class PurchaseDirector {

    public Purchase createRegularPurchase(PurchaseBuilder builder, String cashierName) {
        return builder
                .servedBy(cashierName)
                .withPaymentMethod(PaymentMethod.CARD)
                .build();
    }

    public Purchase createStudentPurchase(PurchaseBuilder builder, String customerName, String cashierName) {
        return builder
                .forCustomer(customerName)
                .servedBy(cashierName)
                .withPaymentMethod(PaymentMethod.CARD)
                .asStudentPurchase()
                .build();
    }

    public Purchase createInstallmentPurchase(PurchaseBuilder builder, String customerName, String cashierName) {
        return builder
                .forCustomer(customerName)
                .servedBy(cashierName)
                .withPaymentMethod(PaymentMethod.INSTALLMENT)
                .build();
    }

    public Purchase createGiftPurchase(PurchaseBuilder builder, String cashierName, String giftMessage) {
        return builder
                .servedBy(cashierName)
                .withPaymentMethod(PaymentMethod.CASH)
                .withGiftWrap(giftMessage)
                .build();
    }
}