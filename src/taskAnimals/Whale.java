package taskAnimals;

public class Whale extends Animal implements Mammal, LiveInWater {
    private final boolean hasFur = false;
    private final boolean waterEnvironment = true;

    public Whale() {
        super(true);
    }

    @Override
    public boolean hasFur() {
        return hasFur;
    }

    @Override
    public boolean getWaterEnvironment() {
        return waterEnvironment;
    }

    @Override
    public void displayInfo() {
        System.out.println("Кит: Позвоночник: " + hasSpine() + ", Шерсть: " + hasFur + ", Живёт в воде: "
                + waterEnvironment);
    }
}