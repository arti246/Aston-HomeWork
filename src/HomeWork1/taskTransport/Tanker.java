package HomeWork1.taskTransport;

import HomeWork1.taskTransport.interfaces.CarriesCargo;
import HomeWork1.taskTransport.interfaces.Propeller;

public class Tanker extends Transport implements Propeller, CarriesCargo {
    private double maxSpinSpeed;

    public Tanker() {
        super(false, true, false, true);
        this.maxSpinSpeed = 120.0;
    }

    @Override
    public void printInfo() {
        loadCargo("Sugar");
        startPropeller();
    }

    @Override
    public void loadCargo(String cargo) {
        System.out.println("Грузовик загружен: " + cargo);
    }

    @Override
    public void unloadCargo() {
        System.out.println("Грузовик c " + getMaxSpinSpeed() +" максимальной скоростью разгружен");
    }

    @Override
    public void startPropeller() {
        System.out.println("Пропеллер танкера запущен");
    }

    @Override
    public void diactivatePropeller() {
        System.out.println("Пропеллер танкера отключен");
    }

    @Override
    public double getMaxSpinSpeed() {
        return maxSpinSpeed;
    }
}
