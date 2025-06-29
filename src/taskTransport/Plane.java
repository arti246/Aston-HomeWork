package taskTransport;

import taskTransport.interfaces.CarriesCargo;
import taskTransport.interfaces.Propeller;
import taskTransport.interfaces.Wheels;
import taskTransport.interfaces.Wink;

public class Plane extends Transport implements Wheels, Propeller, Wink, CarriesCargo {
    private int countWheels;
    private double maxSpinSpeed;
    private double squareWink;

    public Plane() {
        super(true, true, true, true);
    }

    @Override
    public void printInfo() {
        System.out.println("Самолёт с площадью крыла " + getSquareWink() + "кв. м.");
        this.countWheels = 5;
        this.maxSpinSpeed = 1500.0;
        this.squareWink = 5.0;
    }

    @Override
    public void loadCargo(String cargo) {
        System.out.println("Самолёт загружен: " + cargo);
    }

    @Override
    public void unloadCargo() {
        System.out.println("Самолёт разгружен");
    }

    @Override
    public void startPropeller() {
        System.out.println("Пропеллер самолёта запущен");
    }

    @Override
    public void diactivatePropeller() {
        System.out.println("Пропеллер самолёта отключён");
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

    @Override
    public double getSquareWink() {
        return squareWink;
    }
}