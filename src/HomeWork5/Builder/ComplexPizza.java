package HomeWork5.Builder;

import java.util.HashMap;
import java.util.Map;

public class ComplexPizza {
    private final Map<String, Double> ingredients = new HashMap();
    private double price;

    public ComplexPizza(double basePrice) {
        this.price = basePrice;
    }

    public void addIngredient(String ingredient, double price) {
        ingredients.put(ingredient, price);
    }

    public double getTotalPrice() {
        return price + ingredients.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public void changePrice(double price) {
        this.price += price;
    }

    public String getDescription() {
        return "Пицца (" + price + " руб.) + " + ingredients.keySet() + " (Итого: " + getTotalPrice() + " руб.)";
    }
}