package HomeWork1.taskAnimals;

public class Fish extends Animal implements LiveInWater {
    private final boolean waterEnvironment = true;

    public Fish() {
        super(true);
    }

    @Override
    public boolean getWaterEnvironment() {
        return waterEnvironment;
    }

    @Override
    public void displayInfo() {
        System.out.println("Рыба: Позвоночник: " + hasSpine() + ", Живёт в воде: " + waterEnvironment);
    }
}