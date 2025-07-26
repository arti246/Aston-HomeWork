package HomeWork5.Decorator;

public class PizzaClassic implements Pizza {

    @Override
    public String getDescription() {
        return "Классическая пицца";
    }

    @Override
    public double getCoast() {
        return 500;
    }
}