package HomeWork5.Strategy;

public class CardPayment implements PaymentStrategy{

    @Override
    public void pay(double amount) {
        System.out.println("Оплачено " + amount + " руб. картой");
    }
}
