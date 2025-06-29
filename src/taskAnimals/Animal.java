package taskAnimals;

public abstract class Animal {
    private final boolean hasSpine; // Есть ли позвоночник

    public Animal(boolean hasSpine) {
        this.hasSpine = hasSpine;
    }

    public boolean hasSpine() {
        return hasSpine;
    }

    public abstract void displayInfo();
}
