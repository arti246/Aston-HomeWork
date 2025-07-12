package HomeWork3;

public class Product {
    private String name;
    private double price;
    private int count;

    public Product(String name, double price, int count) {
        if (price < 0 || count < 0) {
            throw new MyException("Цена или количество не могут быть отрицательными!");
        }
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTotalCost() {
        return this.count * this.price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}