/*
  Component interface: 
    The interface or abstract class defining the methods that will be implemented. In this case Car will be our interface
*/
interface Car {
  public void assemble();
}

/*
  Component Implementation:
    The basic implementation of the component interface. BasicCar class is our component implementation
*/
class BasicCar implements Car {

  @Override
  public void assemble(){
    System.out.println("Basic car...");
  }
}

/*
  Decorator:
    Decorator class implements the component interface and it has a HAS-A relationship with the component interface. 
    The component variable should be accessible to the child decorator classes. So we will make this variable protected
*/
class CarDecorator implements Car {
  protected Car car;

  public CarDecorator(Car car) {
    this.car = car;
  }

  @Override
  public void assemble(){
    this.car.assemble();
  }
}

/*
  Concrete Decorators:
    Extending the base decorator functionality and modifying the component behaviour accordingly. SportsCar and LuxuryCar are decorator classes
*/
class SportsCar extends CarDecorator {

  public SportsCar(Car car){
    super(car);
  }

  @Override
  public void assemble() {
    super.assemble();
    System.out.println(" Adding features of the sports car ");
  }
}

class LuxuryCar extends CarDecorator {

  public LuxuryCar(Car car) {
    super(car);
  }

  @Override
  public void assemble() {
    super.assemble();
    System.out.println(" Adding features of the Luxury car ");
  }

}


public class CarClient {
  public static void main(String[] args) {
    Car sportsCar = new SportsCar(new BasicCar());
    sportsCar.assemble();
    System.out.println("\n**********");
    Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
    sportsLuxuryCar.assemble();
  }
}