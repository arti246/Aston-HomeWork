package HomeWork5.Proxy;

public class RealPizzaMenu implements PizzaMenu{
    @Override
    public void display() {
        System.out.println("Меню: Классика, Пепперони, 4 сыра");
    }
}
