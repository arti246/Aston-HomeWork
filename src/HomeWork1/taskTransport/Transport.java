package HomeWork1.taskTransport;

public abstract class Transport {
    private boolean hasWheels; // Имеет колёса
    private boolean hasPropeller; // Имеет винт
    private boolean hasWink; // Имеет крылья
    private boolean hasCarriesCargo; // Возит грузы

    public Transport(boolean hasWheels, boolean hasPropeller,  boolean hasWink, boolean hasCarriesCargo) {
        this.hasWheels = hasWheels; 
        this.hasPropeller = hasPropeller;
        this.hasWink = hasWink;
        this.hasCarriesCargo = hasCarriesCargo;
    }

    public boolean isHasWheels() {
        return hasWheels;
    }

    public boolean isHasPropeller() {
        return hasPropeller;
    }

    public boolean isHasWink() {
        return hasWink;
    }

    public boolean isHasCarriesCargo() {
        return hasCarriesCargo;
    }

    public abstract void printInfo();
}