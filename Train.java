import java.util.ArrayList;

public class Train {
    FuelType fuelType;
    String name;
    double fuelCapacity;
    int nCars;
    int passengerCapacity;
    private final Engine engine;
    private ArrayList<Car>carList;

    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        this.fuelType = fuelType;
        this.fuelCapacity = fuelCapacity;
        this.nCars = nCars;
        this.passengerCapacity = passengerCapacity;
        this.carList = new ArrayList<Car>();
        this.engine = new Engine(FuelType.ELECTRIC, 40.0);
    }

    public Engine getEngine(){
        return this.engine;
    }

    public void addCar(Car c){
        if (this.carList.contains(c)) { // Already enrolled
            throw new RuntimeException(c.name + " is already attached to this train.");
        }
        this.carList.add(c);
        System.out.println(c.name + " was successfully attached to the train.");
    
}

    public Car getCar(int i){
        if (this.carList.size() < i) { 
            throw new RuntimeException("This car doesn't exist.");
        }
        System.out.println(carList.get(i).name);
        return carList.get(i);
    }

    public int getMaxCapacity(){
        int passengerCapacity = 0;
        for (Car car : this.carList) {
            passengerCapacity += car.getCapacity();
        }
        return passengerCapacity;
    }

    public int seatsRemaining() {
        int remainingSeats = 0;
        for (Car car : this.carList) {
            remainingSeats += car.seatsRemaining();
        }
        System.out.println("The number of seats remaining on this train is " + remainingSeats);
        return remainingSeats;
    }

    public void printManifest() {
        System.out.println("This is the list of all passengers on the train:");
        for (Car car : this.carList) {
            car.printManifest();
        }
    }

    public static void main(String[] args) {
        Train myTrain = new Train(FuelType.ELECTRIC, 500,1,3);
        Car myCar = new Car("Car 1", 5);
        Car myCar2 = new Car("Car 2", 7);
        myTrain.addCar(myCar);
        myTrain.addCar(myCar2);
        myTrain.seatsRemaining();
        Passenger Linh = new Passenger("Linh");
        Passenger Tom = new Passenger("Tom");
        try {
            myCar.addPassenger(Linh);
        } catch (Exception e) {
            System.out.println(e); // Out of fuel
        }
        try {
            myCar2.addPassenger(Tom);
        } catch (Exception e) {
            System.out.println(e); // Out of fuel
        }
        myTrain.seatsRemaining();
        myTrain.printManifest();

        
    }





}
