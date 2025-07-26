package HomeWork5.Decorator;

public class MushroomsDecorator implements Pizza {
    private Pizza pizza;

    public MushroomsDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + грибы";
    }

    @Override
    public double getCoast() {
        return pizza.getCoast() + 40;
    }
}
