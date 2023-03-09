/**
* Engine represents the locomotive engine, storing information about the train's fuel type, max fuel capacity, and refuel method.
* 
* @author Linh Pham
* @version 1.5
* @since 8.3
*/
public class Engine {

  FuelType fuelType;
  double maxFuel;
  double currentFuel;

  /** Creates an Engine from fuel type and current fuel level
  * @param fuelType The engine's fuel type.
  * @param currentFuel The engine's current fuel level.
  */
  public Engine(FuelType fuelType, double currentFuel) {
    this.fuelType = fuelType;
    this.maxFuel = 100;
    this.currentFuel = currentFuel;
  }

  /** Refuels the engine if its fuel level is lower than the max capacity.
  * @throws Exception if the fuel's level is already at max.
  */
  public void refuel() {
    if (this.currentFuel == this.maxFuel) {
      throw new RuntimeException("The fuel level is already at max");
    }
    this.currentFuel = this.maxFuel;

  }

  /** Makes the Engine go and decreases fuel level by 10 units each time the train runs.
  * @throws Exception if the fuel level is equal to or below 0.
  */
  public void go() {
    if (this.currentFuel <= 0) {
      throw new RuntimeException("Insufficient fuel level, needs refuel ASAP.");
    }
    this.currentFuel -= 10;
    System.out.println("The train is running. The remaining fuel level is " + this.currentFuel);

  }

  /**
  * Our main method to test the attributes of Engine.
  * @throws IOException if an error occurs
  **/
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