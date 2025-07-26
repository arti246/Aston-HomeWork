package HomeWork5.Adapter;

import HomeWork5.Strategy.PaymentStrategy;

public class LoyaltyAdapter implements PaymentStrategy {
    private LegacyLoyaltySystem legacySystem;

    public LoyaltyAdapter(LegacyLoyaltySystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    public void pay(double amount) {
        legacySystem.applyDiscount((int) (amount / 10));
    }
}
