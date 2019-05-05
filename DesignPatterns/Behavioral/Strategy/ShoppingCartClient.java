import java.util.ArrayList;
import java.util.List;

class Item {
  private String upcCode;
  private int price;

  public Item(String upcCode, int price) {
    this.upcCode = upcCode;
    this.price = price;
  }

  public String getUpcCode() {
    return this.upcCode;
  }

  public int getPrice() {
    return this.price;
  }
}

class ShoppingCart {
  private List<Item> items;

  public ShoppingCart() {
    this.items = new ArrayList<Item>();
  }

  public void addItem(Item item) {
    this.items.add(item);
  }

  public void removeItem(Item item) {
    this.items.remove(item);
  }

  public int calculateTotal() {
    int sum = 0;
    for(Item item: items){
      sum = sum + item.getPrice();
    }
    return sum;
  }

  public void pay(PaymentStrategy paymentMethod) {
    int amount = calculateTotal();
    paymentMethod.pay(amount);
  }
}

interface PaymentStrategy {
  public void pay(int amount);
}

class CreditCardStrategy implements PaymentStrategy {

  private String name;
  private String cardNumber;
  private String cvv;
  private String dateOfExpiry;

  public CreditCardStrategy(String name, String cardNumber, String cvv, String dateOfExpiry) {
    this.name = name;
    this.cardNumber = cardNumber;
    this.cvv = cvv;
    this.dateOfExpiry = dateOfExpiry;
  }

  public void pay(int amount) {
    System.out.println(amount + " paid with credit/debit card");
  }
}

class PaytmStrategy implements PaymentStrategy {

  private String email;
  private String password;

  public PaytmStrategy(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public void pay(int amount) {
    System.out.println(amount + " paid via paytm");
  }
}

public class ShoppingCartClient {
  public static void main(String[] args) {
    ShoppingCart cart = new ShoppingCart();
    cart.addItem(new Item("1234", 10));
    cart.addItem(new Item("5678", 40));

    cart.pay(new PaytmStrategy("ravi@gmail.com", "pass1234"));
    cart.pay(new CreditCardStrategy("Ravi", "123456781234","786", "12/15"));
  }
}

