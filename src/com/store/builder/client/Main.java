package com.store.builder.client;

import com.store.builder.builder.PurchaseBuilder;
import com.store.builder.director.PurchaseDirector;
import com.store.builder.model.PaymentMethod;
import com.store.builder.model.ProductType;
import com.store.builder.model.Purchase;

public class Main {

    public static void main(String[] args) {
        demoDirectorScenarios();
        demoManualBuild();
        demoValidationFailure();
    }

    private static void demoDirectorScenarios() {
        System.out.println("***** Чек через Director *****\n");

        PurchaseDirector director = new PurchaseDirector();

        PurchaseBuilder builder1 = new PurchaseBuilder()
                .addItem(ProductType.T_SHIRT, "M", "чёрный", 2);
        Purchase regular = director.createRegularPurchase(builder1, "Акарыс С.");
        regular.printReceipt();

        PurchaseBuilder builder2 = new PurchaseBuilder()
                .addItem(ProductType.HOODIE, "L", "серый", 1)
                .addItem(ProductType.CAP, "one size", "чёрный", 1);
        Purchase student = director.createStudentPurchase(builder2, "Санжар К.", "Акарыс С.");
        student.printReceipt();

        PurchaseBuilder builder3 = new PurchaseBuilder()
                .addItem(ProductType.ZIP_HOODIE, "XL", "синий", 1)
                .addItem(ProductType.PANTS, "32", "чёрный", 1);
        Purchase installment = director.createInstallmentPurchase(builder3, "Асыл Р.", "Абылай Д.");
        installment.printReceipt();

        PurchaseBuilder builder4 = new PurchaseBuilder()
                .addItem(ProductType.HOODIE, "M", "белый", 1);
        Purchase gift = director.createGiftPurchase(builder4, "Абылай Д.", "С днём рождения!");
        gift.printReceipt();
    }

    private static void demoManualBuild() {
        System.out.println("***** Ручная сборка напрямую через PurchaseBuilder *****\n");

        Purchase customPurchase = new PurchaseBuilder()
                .forCustomer("Аружан К.")
                .servedBy("Акарыс С.")
                .addItem(ProductType.T_SHIRT, "S", "белый", 1)
                .addItem(ProductType.SOCKS, "one size", "чёрный", 3)
                .withPaymentMethod(PaymentMethod.CASH)
                .asStudentPurchase()
                .build();

        customPurchase.printReceipt();
    }

    private static void demoValidationFailure() {
        System.out.println("****** Демонстрация валидации build() *****\n");
        try {
            new PurchaseBuilder()
                    .addItem(ProductType.CAP, "one size", "чёрный", 1)
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Ошибка при попытке оформить покупку без кассира: " + e.getMessage());
        }
    }
}