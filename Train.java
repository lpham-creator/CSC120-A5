import java.util.ArrayList;
/**
 * The train, which is attached to a list of car and has a composition relationship with the Engine.
 * @author Linh Pham
 * @version 1.5
 * @since 8.3
 */
public class Train {

  FuelType fuelType;
  String name;
  double fuelCapacity;
  int nCars;
  int passengerCapacity;
  private final Engine engine;
  private ArrayList < Car > carList;

  /**
   * Creates a Train object with the given fuel type, fuel capacity, number of cars, and passenger capacity.
   * Initializes the Train object with an empty car list and an electric engine with a capacity of 40.0.
   * @param fuelType the fuel type for the train
   * @param fuelCapacity the fuel capacity for the train, in liters
   * @param nCars the number of cars in the train
   * @param passengerCapacity the maximum number of passengers allowed per car
   */
  public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
    this.fuelType = fuelType;
    this.fuelCapacity = fuelCapacity;
    this.nCars = nCars;
    this.passengerCapacity = passengerCapacity;
    this.carList = new ArrayList < Car > ();
    this.engine = new Engine(FuelType.ELECTRIC, 40.0);
  }

  /**
   * Returns the engine of the train.
   * @return the Engine of the Train.
   */
  public Engine getEngine() {
    return this.engine;
  }

  /**
   * Add a car to the train's Car list.
   * @param c A car object.
   * @throws Exception if the car is already attached to the train.
   */
  public void addCar(Car c) {
    if (this.carList.contains(c)) { // Already enrolled
      throw new RuntimeException(c.name + " is already attached to this train.");
    }
    this.carList.add(c);
    System.out.println(c.name + " was successfully attached to the train.");

  }

  /**
   * Get a car from the train's Car list.
   * @param i a number to get access to.
   * @throws Exception if the number is out of bounds for the car's list.
   */
  public Car getCar(int i) {
    if (this.carList.size() < i) {
      throw new RuntimeException("This car doesn't exist.");
    }
    System.out.println(carList.get(i).name);
    return carList.get(i);
  }

  /**
   * Get the train's combined max capacity from all of its cars' seats.
   * @return the train's capacity.
   */
  public int getMaxCapacity() {
    int passengerCapacity = 0;
    for (Car car: this.carList) {
      passengerCapacity += car.getCapacity();
    }
    return passengerCapacity;
  }

  /**
   * Get the train's number of seats remaining.
   * @return the train's remaining seats.
   */
  public int seatsRemaining() {
    int remainingSeats = 0;
    for (Car car: this.carList) {
      remainingSeats += car.seatsRemaining();
    }
    System.out.println("The number of seats remaining on this train is " + remainingSeats);
    return remainingSeats;
  }

  /**
   * Prints the train's list of passengers.
   */
  public void printManifest() {
    System.out.println("This is the list of all passengers on the train:");
    for (Car car: this.carList) {
      car.printManifest();
    }
  }

  /**
   * The main method of the program.
   * The main method creates a Train object with an electric engine, a fuel capacity of 500 liters, one car with a capacity of 3 passengers, and adds two Car objects to it.
   * @param args an array of command-line arguments
   */
  public static void main(String[] args) {
    Train myTrain = new Train(FuelType.ELECTRIC, 500, 1, 3);
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
      System.out.println(e);
    }
    try {
      myCar2.addPassenger(Tom);
    } catch (Exception e) {
      System.out.println(e);
    }
    myTrain.seatsRemaining();
    myTrain.printManifest();

  }

}