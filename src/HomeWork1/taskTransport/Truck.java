package HomeWork1.taskTransport;

import HomeWork1.taskTransport.interfaces.CarriesCargo;
import HomeWork1.taskTransport.interfaces.Wheels;

public class Truck extends Transport implements Wheels, CarriesCargo {
    private int countWheels;

    public Truck() {
        super(true, false, false, true);
        this.countWheels = 8;
    }

    @Override
    public void printInfo() {
        loadCargo("Печеньками");
    }

    @Override
    public void loadCargo(String cargo) {
        System.out.println("Грузовик загружен: " + cargo);
    }

    @Override
    public void unloadCargo() {
        System.out.println("Грузовик c " + getCountWheels() +" колёсами разгружен");
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
