package HomeWork5.ChainOfResponsibilities;

import HomeWork5.Builder.ComplexPizza;

public class AllergyCheckHandler extends OrderHandler {
    public boolean handle(ComplexPizza pizza) {
        if (pizza.getDescription().contains("орехи")) {
            System.out.println("Внимание: аллергены в заказе!");
            return false;
        }
        return handleNext(pizza);
    }
}
