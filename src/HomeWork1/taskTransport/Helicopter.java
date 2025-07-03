package HomeWork1.taskTransport;

import HomeWork1.taskTransport.interfaces.CarriesCargo;
import HomeWork1.taskTransport.interfaces.Propeller;
import HomeWork1.taskTransport.interfaces.Wheels;

public class Helicopter extends Transport implements Wheels, Propeller, CarriesCargo {
    private int countWheels;
    private double maxSpinSpeed;

    public Helicopter() {
        super(true, true, false, true);
        this.countWheels = 3;
        this.maxSpinSpeed = 1200.0;
    }

    @Override
    public void printInfo() {
        System.out.println("Вертолёт с " + getCountWheels() + " колёсами");
    }

    @Override
    public void loadCargo(String cargo) {
        System.out.println("Вертолёт загружен: " + cargo);
    }

    @Override
    public void unloadCargo() {
        System.out.println("Вертолёт разгружен");
    }

    @Override
    public void startPropeller() {
        System.out.println("Пропеллер вертолёта запущен");
    }

    @Override
    public void diactivatePropeller() {
        System.out.println("Пропеллер вертолёта отключён");
    }

    @Override
    public double getMaxSpinSpeed() {
        return maxSpinSpeed;
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
