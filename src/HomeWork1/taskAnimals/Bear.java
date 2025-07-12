package HomeWork1.taskAnimals;

public class Bear extends Animal implements Mammal {
    private final boolean hasFur = true;

    public Bear() {
        super(true);
    }

    @Override
    public boolean hasFur() {
        return hasFur;
    }

    @Override
    public void displayInfo() {
        System.out.println("Медведь: Позвоночник: " + hasSpine() + ", Шерсть: " + hasFur);
    }
}