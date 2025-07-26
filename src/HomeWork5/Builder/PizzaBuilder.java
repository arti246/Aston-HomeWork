package HomeWork5.Builder;

public class PizzaBuilder {
    private final ComplexPizza pizza;

    public PizzaBuilder(double basePrice) {
        this.pizza = new ComplexPizza(basePrice);
    }

    public PizzaBuilder addCheese() {
        pizza.addIngredient("сыр", 50);
        return this;
    }

    public PizzaBuilder addPepperoni() {
        pizza.addIngredient("пепперони", 80);
        return this;
    }

    public PizzaBuilder addCustomIngredient(String name, double price) {
        pizza.addIngredient(name, price);
        return this;
    }


    public ComplexPizza build() {
        return pizza;
    }
}
