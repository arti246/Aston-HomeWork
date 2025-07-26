package HomeWork5.ChainOfResponsibilities;

import HomeWork5.Builder.ComplexPizza;

public abstract class OrderHandler {
    private OrderHandler next;

    public OrderHandler setNext(OrderHandler next) {
        this.next = next;
        return next;
    }

    public abstract boolean handle(ComplexPizza pizza);

    protected boolean handleNext(ComplexPizza pizza) {
        if (next == null) return true;
        return next.handle(pizza);
    }
}
