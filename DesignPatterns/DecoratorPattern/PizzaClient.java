interface Payments {
  public int getCost();
}

class Pizza implements Payments {

  @Override
  public int getCost(){
    System.out.println("Basic pizza cost....");
    return 100;
  }
}

class PizzaDecorator implements Payments {

  protected Payments payments;

  public PizzaDecorator(Payments payments) {
    this.payments = payments;
  }

  @Override
  public int getCost(){
    return this.payments.getCost();
  }
}

class PeppyPannerPizza extends PizzaDecorator {

  public PeppyPannerPizza(Payments payments){
    super(payments);
  }

  @Override
  public int getCost(){
    int cost = super.getCost() + 10;
    System.out.println("Peppy panner pizza");
    return cost;
  }
}


class Margherita extends PizzaDecorator {

  public Margherita(Payments payments) {
    super(payments);
  }

  public int getCost(){
    int cost = super.getCost() + 10;
    System.out.println("Margherita pizza");
    return cost;
  }
}


public class PizzaClient{
  public static void main(String[] args) {
    Payments basic_cost = new PeppyPannerPizza(new Pizza());
    System.out.println(basic_cost.getCost());
  }
}
