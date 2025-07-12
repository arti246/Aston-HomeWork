package HomeWork1.taskAnimals;

public class Cat extends Animal implements Mammal {
    private final boolean hasFur = true;

    public Cat() {
        super(true);
    }

    @Override
    public boolean hasFur() {
        return hasFur;
    }

    @Override
    public void displayInfo() {
        System.out.println("Кошка: Позвоночник: " + hasSpine() + ", Шерсть: " + hasFur);
    }
}