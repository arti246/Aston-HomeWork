package HomeWork5;

import HomeWork5.Adapter.LegacyLoyaltySystem;
import HomeWork5.Adapter.LoyaltyAdapter;
import HomeWork5.Builder.PizzaBuilder;
import HomeWork5.Builder.ComplexPizza;
import HomeWork5.ChainOfResponsibilities.*;
import HomeWork5.Decorator.MushroomsDecorator;
import HomeWork5.Decorator.Pizza;
import HomeWork5.Decorator.PizzaClassic;
import HomeWork5.Proxy.PizzaMenu;
import HomeWork5.Proxy.ProxyPizzaMenu;
import HomeWork5.Strategy.CardPayment;
import HomeWork5.Strategy.PaymentStrategy;

public class Pizzeria {
    public static void main(String[] args) {
        PizzaMenu menu = new ProxyPizzaMenu();
        menu.display();

        Pizza pizza = new MushroomsDecorator(new PizzaClassic());
        System.out.println(pizza.getDescription() + " - " + pizza.getCoast());

        PizzaBuilder builder = new PizzaBuilder(500);
        ComplexPizza complexPizza = builder
                .addCheese()
                .addPepperoni()
                .build();

        System.out.println(complexPizza.getDescription());

        OrderHandler handler = new AllergyCheckHandler();
        handler.setNext(new FreeDeliveryHandler());
        handler.setNext(new StockCheckHandler());
        handler.handle(complexPizza);

        PaymentStrategy payment = new CardPayment();
        payment.pay(complexPizza.getTotalPrice());

        LegacyLoyaltySystem legacySystem = new LegacyLoyaltySystem();
        PaymentStrategy loyaltyPayment = new LoyaltyAdapter(legacySystem);
        loyaltyPayment.pay(150);
    }
}
