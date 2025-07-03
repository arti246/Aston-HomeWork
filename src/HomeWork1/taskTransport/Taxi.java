package HomeWork1.taskTransport;

import HomeWork1.taskTransport.interfaces.Wheels;

public class Taxi extends Transport implements Wheels {
    private int countWheels;

    public Taxi() {
        super(true, false, false, false);
        this.countWheels = 4;
    }

    @Override
    public void printInfo() {
        System.out.println("Такси с " + getCountWheels() + " колёсами");
    }

    @Override
    public int getCountWheels() {
        return countWheels;
    }

    @Override
    public void setCountWheels(int countWheels) {
        this.countWheels = countWheels;
    }
}
