import java.util.ArrayList;
/**
 * Cars attached to the train, which have passengers' capacity.
 * @author Linh Pham
 * @version 1.5
 * @since 8.3
 */
public class Car {
  String name;
  private ArrayList < Passenger > passengerList;
  int maxCapacity;

  /** Creates a Car with name and max capacity.
   * 
   * @param name The car's name.
   * @param maxCapacity The car's max capacity.
   */
  public Car(String name, int maxCapacity) {
    this.name = name;
    this.maxCapacity = maxCapacity;
    this.passengerList = new ArrayList < Passenger > ();
  }

  /** Gets the car's max capacity.
   * 
   * @return maxCapacity The car's max capacity.
   */
  public int getCapacity() {
    System.out.println("The maximum capacity of this car is " + this.maxCapacity + ".");
    return this.maxCapacity;

  }

  /** Gets the car's number of remaining seats.
   * 
   * @return The car's remaining seats.
   */
  public int seatsRemaining() {
    int occupiedSeats = this.passengerList.size();
    int availableSeats = this.maxCapacity - occupiedSeats;
    System.out.println("The number of seats remaining on " + this.name + " is " + availableSeats + ".");
    return availableSeats;
  }

  /** Adds passengers to the car.
   * 
   * @param p The passenger who wants to board the car.
   * @throws Exception if the passenger's already on the car.
   * @throws Exception if car is already at capacity.
   */
  public void addPassenger(Passenger p) {
    if (this.passengerList.contains(p)) { // Already enrolled
      throw new RuntimeException(p.getName() + " is already on the car.");
    }
    if (this.passengerList.size() >= this.maxCapacity) { // Entering class is full
      throw new RuntimeException(this.name + " is already at capacity; cannot add " + p.getName());
    }
    this.passengerList.add(p);
    System.out.println(p.getName() + " was successfully boarded on " + this.name + ".");

  }

  /**
   * Removes the given passenger from the car's passenger list.
   * @param p the passenger to be removed from the list
   * @throws RuntimeException if the given passenger is not in the car's passenger list
   * */

  public void removePassenger(Passenger p) {
    if (!this.passengerList.contains(p)) { // Not enrolled
      throw new RuntimeException(p.getName() + " is not in the car.");
    }
    this.passengerList.remove(p);
    System.out.println(p.getName() + " left " + this.name + ".");
  }

  /**
   * Prints the list of passengers in the car.
   * If the passenger list is empty, prints a message indicating that the car is empty.
   */
  public void printManifest() {
    if (this.passengerList.size() == 0) { // Not enrolled
      System.out.println("This car is EMPTY.");
    }
    for (int i = 0; i < passengerList.size(); i++) {
      System.out.println(passengerList.get(i).getName());
    }
  }

  /**
   * Our main, which is a program that demonstrates the usage of a Car class and its methods.
   * The program creates a Car object, adds passengers, removes passengers, and prints the passenger list.
   */
  public static void main(String[] args) {
    Car myCar = new Car("Car 1", 5);
    Passenger Linh = new Passenger("Linh");
    Passenger Linh2 = new Passenger("Linh2");
    try {
      myCar.addPassenger(Linh);
      myCar.removePassenger(Linh2);
    } catch (Exception e) {
      System.out.println(e); // Out of fuel
    }
    myCar.printManifest();
    myCar.seatsRemaining();
  }
}