package HomeWork5.ChainOfResponsibilities;

import HomeWork5.Builder.ComplexPizza;

public class FreeDeliveryHandler extends OrderHandler{

    @Override
    public boolean handle(ComplexPizza pizza) {
        if (pizza.getTotalPrice() > 600) {
            System.out.println("Доставка бесплатная!");
        } else {
            System.out.println("Доставка платная - 150 руб.");
            pizza.changePrice(150);
        }
        return handleNext(pizza);
    }
}
