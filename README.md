# Assignment #1 — Builder Pattern (Software Design Patterns)
## Student: Serikkazy Akarys
## Group: SE-2514

### About the product.

The application simulates the checkout process at a clothing store. Purchase (receipt) is a complex object: cashier (mandatory), customer (optional), a list of items from a fixed product catalog, payment method, 5% student discount, gift wrapping.

The product catalog and prices are fixed and defined via the ProductType enum.

### Clean Code Requirements
#### 1. Meaningful, intention-revealing names for classes/methods/variables
   
purchaseBuilder.servedBy("Акарыс С.");

purchaseBuilder.asStudentPurchase();

#### 2. Small methods, each doing one thing

public int calculateTotal() { ... }   - only the amount calculation

public void printReceipt() { ... }    - only the receipt output

public Purchase build() { ... }       - only validation + assembly

#### 3. Consistent formatting and small, focused classes

private static final int GIFT_WRAP_FEE = 1500;

public enum PaymentMethod { CASH, CARD, INSTALLMENT }

Even the product catalog and prices themselves are defined in the ProductType enum.

#### 4. Validated construction (e.g., build() throws a clear exception on invalid state)

public Purchase build() {
    if (cashierName == null || cashierName.isBlank()) {
        throw new IllegalStateException(
            "Нельзя оформить покупку без кассира!");
    }
    if (items.isEmpty()) {
        throw new IllegalStateException(
            "Покупка должна содержать хотя бы одну позицию!");
    }
    ...
}

#### 5. No magic numbers/strings

PurchaseItem stores only the data for a single item, PurchaseBuilder is responsible only for building, PurchaseDirector is responsible only for ready‑made scenarios, and Purchase is responsible only for its immutable state and calculating the total amount.
