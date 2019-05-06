enum CarType {
  MICRO, LUXURY
}

abstract class Car {

  private CarType model;
  private Location location;
  
  public Car(CarType model, Location location) {
    this.model = model;
    this.location = location;
  }

  abstract void construct();

  public CarType getModel(){
    return this.model;
  }

  public void setModel(CarType model){
    this.model = model;
  }

  public Location getLocation(){
    return this.location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public String toString(){
    return "CarModel - " + this.model + " located in - " + this.location;
  }

}

class LuxuryCar extends Car {

  public LuxuryCar(Location location){
    super(CarType.LUXURY, location);
    construct();
  }

  protected void construct(){
    System.out.println("Connecting to LuxuryCar");
  }
}

class MicroCar extends Car {

  public MicroCar(Location location) {
    super(CarType.MICRO, location);
    construct();
  }

  protected void construct(){
    System.out.println("Connecting to MicroCar");
  }
}

enum Location {
  USA, INDIA
}

class IndiaCarFactory {

  public static Car buildCar(CarType model) {
    Car car = null;
    switch(model) {
      case MICRO:
        car = new MicroCar(Location.INDIA);
        break;
      case LUXURY:
        car = new LuxuryCar(Location.INDIA);
        break;
      default:
        break;
    }
    return car;
  }
}

class UsaCarFactory {

  public static Car buildCar(CarType model) {
    Car car = null;
    switch(model) {
      case MICRO:
        car = new MicroCar(Location.USA);
        break;
      case LUXURY:
        car = new LuxuryCar(Location.USA);
        break;
      default:
        break;
    }
    return car;
  }
}

class CarFactory {

  private CarFactory() {

  }

  public static Car buildCar(CarType model){
    Car car = null;

    //We can add location logic here to identify the location dynamically
    Location location = Location.INDIA;

    switch(location) {
      case USA:
        car = UsaCarFactory.buildCar(model);
        break;
      case INDIA:
        car = IndiaCarFactory.buildCar(model);
        break;
      default:
        System.out.println("Not present in your location");
    }
    return car;
  }
}

public class CarClient {
  public static void main(String[] args) {
    System.out.println(CarFactory.buildCar(CarType.MICRO));
    System.out.println(CarFactory.buildCar(CarType.LUXURY));
  }
}
