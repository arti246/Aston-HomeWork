package HomeWork5.Proxy;

public class ProxyPizzaMenu implements PizzaMenu{
    private RealPizzaMenu realMenu;

    @Override
    public void display() {
        if (realMenu == null) {
            System.out.println("Загрузка меню...");
            realMenu = new RealPizzaMenu();
        }
        realMenu.display();
    }
}
