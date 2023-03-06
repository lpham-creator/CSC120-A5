import java.util.ArrayList;
public class Car {
    String name;
    private ArrayList<Passenger>passengerList;
    int maxCapacity;

    public Car(String name, int maxCapacity) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.passengerList = new ArrayList<Passenger>();
}

    public int getCapacity(){
        System.out.println("The maximum capacity of this car is " + this.maxCapacity + ".");
        return this.maxCapacity;

}
    public int seatsRemaining(){
        int occupiedSeats = this.passengerList.size();
        int availableSeats = this.maxCapacity - occupiedSeats;
        System.out.println("The number of seats remaining on " + this.name + " is " + availableSeats + ".");
        return availableSeats;
}

    public void addPassenger(Passenger p){
        if (this.passengerList.contains(p)) { // Already enrolled
            throw new RuntimeException(p.name + " is already on the car.");
        }
        if (this.passengerList.size() >= this.maxCapacity) { // Entering class is full
            throw new RuntimeException(this.name + " is already at capacity; cannot add " + p.name);
        }
        this.passengerList.add(p);
        System.out.println(p.name + " was successfully boarded on " + this.name + ".");
    
}

    public void removePassenger(Passenger p){
        if (!this.passengerList.contains(p)) { // Not enrolled
            throw new RuntimeException(p.name + " is not in the car.");
        }
        this.passengerList.remove(p);
        System.out.println(p.name + " left " + this.name + ".");
}

    public void printManifest(){
        if (this.passengerList.size()==0) { // Not enrolled
            System.out.println("This car is EMPTY.");
        }
        for (int i = 0; i < passengerList.size(); i++) {
            System.out.println(passengerList.get(i).name);
        }
}

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
