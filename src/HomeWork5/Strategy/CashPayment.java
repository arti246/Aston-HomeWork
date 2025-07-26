package HomeWork5.Strategy;

public class CashPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Оплачено " + amount + " руб. наличными");
    }
}
