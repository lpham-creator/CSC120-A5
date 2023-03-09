/**
* Passengers on the Cars, who can board Cars and get off them.
* @author Linh Pham
* @version 1.5
* @since 8.3
*/
public class Passenger {

  private String name;

  /** Creates a Passenger with name
  * @param name The passenger's name.
  */
  public Passenger(String name) {
    this.name = name;
  }

  /**
   * Returns the name of the passenger.
   * @param Passenger A passenger's object.
   * @return The passenger's name.
   */
  public String getName(Passenger s){
    return s.name;
  }

  /**
   * Board the car for the passenger.
   * @param  The car that the passenger boards.
   * @throws Exception if error happens.
   */
  public void boardCar(Car c) {
    try {
      c.addPassenger(this);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  /**
   * Get off the car for the passenger.
   * @param  The car that the passenger gets off.
   * @throws Exception if error happens.
   */
  public void getOffCar(Car c) {
    try {
      c.removePassenger(this);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}