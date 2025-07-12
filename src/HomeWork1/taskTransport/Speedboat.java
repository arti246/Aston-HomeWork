package HomeWork1.taskTransport;

import HomeWork1.taskTransport.interfaces.CarriesCargo;
import HomeWork1.taskTransport.interfaces.Propeller;

public class Speedboat extends Transport implements Propeller, CarriesCargo {
    private double maxSpinSpeed;

    public Speedboat() {
        super(false, true, false, true);
        this.maxSpinSpeed = 60.0;
    }
    @Override
    public void printInfo() {
        System.out.println("Катер с макс. скоростью " + getMaxSpinSpeed() + "км/ч");
    }

    @Override
    public void loadCargo(String cargo) {
        System.out.println("Катер загружен: " + cargo);
    }

    @Override
    public void unloadCargo() {
        System.out.println("Катер c " + getMaxSpinSpeed() +" максимальной скоростью разгружен");
    }

    @Override
    public void startPropeller() {
        System.out.println("Пропеллер катера запущен");
    }

    @Override
    public void diactivatePropeller() {
        System.out.println("Пропеллер катера отключен");
    }

    @Override
    public double getMaxSpinSpeed() {
        return maxSpinSpeed;
    }
}
