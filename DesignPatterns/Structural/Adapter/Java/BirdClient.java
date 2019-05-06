/*
  Client: ToyDuck
  Adaptee: Bird
*/
interface Bird {
  //Birds implement this interface allwing them to fly and make sound
  public void fly();
  public void makeSound();
}

class Sparrow implements Bird {

  public void fly(){
    System.out.println("Sparrow Flying");
  }

  public void makeSound() {
    System.out.println("Sparrow speaking Chirp Chirp");
  }
}

interface ToyDuck {
  //Toy duck dont fly they make only squeaking sound
  public void squeak();
}

class PlasticToyDuck implements ToyDuck {

  public void squeak() {
    System.out.println("Squeak");
  }
}

/*
  You need to implement the interface your client expects to use
*/
class BirdAdapter implements ToyDuck {

  Bird bird;
  public BirdAdapter(Bird bird) {
    //Reference to the object we are adapting
    this.bird = bird;
  }

  public void squeak(){
    bird.makeSound();
  }
}


public class BirdClient {
  public static void main(String[] args) {
    Bird sparrow = new Sparrow();
    ToyDuck toyDuck = new PlasticToyDuck();
    //Wrap a bird in a birdadapter so that it behaves like toy duck
    ToyDuck birdAdapter = new BirdAdapter(sparrow);

    System.out.println("Sparrow ....");
    sparrow.fly();
    sparrow.makeSound();
    System.out.println("PlasticToyDuck ....");
    toyDuck.squeak();
    System.out.println("BirdAdapter ....");
    birdAdapter.squeak();

  }
}