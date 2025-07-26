package HomeWork5.ChainOfResponsibilities;

import HomeWork5.Builder.ComplexPizza;

public class StockCheckHandler extends OrderHandler{
    @Override
    public boolean handle(ComplexPizza pizza) {
        System.out.println("Проверка ингредиентов: OK");
        return handleNext(pizza);
    }
}
