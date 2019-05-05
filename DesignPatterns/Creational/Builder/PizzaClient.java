//Product
class Pizza {
  private String dough;
  private String sauce;
  private String topping;

  public String getDough(){
    return this.dough;
  }
  public void setDough(String dough) {
    this.dough = dough;
  }
  public String getSauce(){
    return this.sauce;
  }
  public void setSauce(String sauce) {
    this.sauce = sauce;
  }
  public String getTopping(){
    return this.topping;
  }
  public void setTopping(String topping) {
    this.topping = topping;
  }

  public String toString() {
    return "Pizza with : " + this.dough + " * " + this.sauce + " * " +  this.topping;
  }
}

//Abstract builder
abstract class PizzaBuilder {

  protected Pizza pizza;

  public Pizza getPizza(){
    return pizza;
  }

  public void createNewPizza() {
    pizza = new Pizza();
  }

  public abstract void buildDough();
  public abstract void buildSauce();
  public abstract void buildTopping();
}

//Concrete builder
class HawaiianPizzaBuilder extends PizzaBuilder {

  public void buildDough(){
    pizza.setDough("cross");
  }

  public void buildSauce(){
    pizza.setSauce("mild");
  }

  public void buildTopping(){
    pizza.setTopping("ham+pineapple");
  }
}

//Another concrete builder
class SpicyPizzaBuilder extends PizzaBuilder {

  public void buildDough() {
    pizza.setDough("pan baked");
  }

  public void buildSauce(){
    pizza.setSauce("hot");
  }

  public void buildTopping(){
    pizza.setTopping("pepperoni+salami");
  }
}

//Director
class Waiter {

  private PizzaBuilder pizzaBuilder;

  public Waiter(PizzaBuilder pizzaBuilder){
    this.pizzaBuilder = pizzaBuilder;
  }

  public Pizza getPizza(){
    return pizzaBuilder.getPizza();
  }

  public void buildPizza(){
    pizzaBuilder.createNewPizza();
    pizzaBuilder.buildDough();
    pizzaBuilder.buildSauce();
    pizzaBuilder.buildTopping();
  }
}

//Client
public class PizzaClient {
  public static void main(String[] args) {
    HawaiianPizzaBuilder hp = new HawaiianPizzaBuilder();
    SpicyPizzaBuilder sp = new SpicyPizzaBuilder();
    Waiter wt = new Waiter(hp);
    Waiter wt1 = new Waiter(sp);
    wt.buildPizza();
    wt1.buildPizza();
    System.out.println(wt.getPizza());
    System.out.println(wt1.getPizza());
  }
}