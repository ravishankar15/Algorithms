interface Payments {
  public int getCost();
}

class Pizza implements Payments {

  public int getCost(){
    System.out.println("Basic pizza cost....");
    return 100;
  }
}

class PeppyPannerPizza implements Payments {

  public int getCost(){
    System.out.println("Peppy Panner Pizza cost ....");
    return 200;
  }
}

class PizzaDecorator implements Payments {

  protected Payments payments;

  public PizzaDecorator(Payments payments) {
    this.payments = payments;
  }

  public int getCost(){
    return this.payments.getCost();
  }
}

class Panner extends PizzaDecorator {

  public Panner(Payments payments){
    super(payments);
  }

  public int getCost(){
    int cost = super.getCost() + 10;
    System.out.println("Added Panner");
    return cost;
  }
}


class Cheese extends PizzaDecorator {

  public Cheese(Payments payments) {
    super(payments);
  }

  public int getCost(){
    int cost = super.getCost() + 10;
    System.out.println("Added Cheese");
    return cost;
  }
}


public class PizzaClient{
  public static void main(String[] args) {
    Payments basic_cost = new Panner(new Pizza());
    System.out.println(basic_cost.getCost());

    Payments basic_cost_1 = new Cheese(new Panner(new PeppyPannerPizza()));
    System.out.println(basic_cost_1.getCost());
  }
}
