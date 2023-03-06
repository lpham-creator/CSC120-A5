public class Engine {

    FuelType fuelType;
    double maxFuel;
    double currentFuel;

    public Engine(FuelType fuelType, double currentFuel) {
        this.fuelType = fuelType;
        this.maxFuel = 100;
        this.currentFuel = currentFuel;
    }

    public void refuel(){
        if (this.currentFuel == this.maxFuel) { // Already enrolled
            throw new RuntimeException("The fuel level is already at max");
        }
        this.currentFuel = this.maxFuel;

    }

    public void go(){
        if (this.currentFuel == 0) { // Already enrolled
            throw new RuntimeException("Insufficient fuel level, needs refuel ASAP.");
        }
        this.currentFuel -= 10;
        System.out.println("The train is running. The remaining fuel level is " + this.currentFuel);


    }

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 40.0);
        try {
            while (true) {
                myEngine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Out of fuel
        }
    }

}