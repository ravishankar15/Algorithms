abstract class OrderProcessTemplate {
  public boolean isGift;

  public abstract void doSelect();

  public abstract void doPayment();

  public final void giftWrap() {
    try {
      System.out.println("Giftwrap successfull");
    } catch(Exception e) {
      System.out.println("Giftwrap unsuccessfull");
    }
  }

  public abstract void doDelivery();

  public final void processOrder(boolean isGift) {
    doSelect();
    doPayment();
    if(isGift){
      giftWrap();
    }
    doDelivery();
  }
}


class NetOrder extends OrderProcessTemplate {

  public void doSelect() {
    System.out.println("Item added to online shopping cart");
    System.out.println("Get giftWrap preference");
    System.out.println("Get delivery address");
  }

  public void doPayment() {
    System.out.println("Online payment through Netbanking, card or paytm");
  }

  public void doDelivery() {
    System.out.println("Ship the item through post to delivery address");
  }
}

class StoreOrder extends OrderProcessTemplate {

  public void doSelect() {
    System.out.println("Customer chooses the item from the shelf");
  }

  public void doPayment() {
    System.out.println("Pays at counter through cash/POS");
  }

  public void doDelivery() {
    System.out.println("Item deliverd to in delivery counter");
  }
}


public class StoreClient {
  public static void main(String[] args) {
    OrderProcessTemplate netOrder = new NetOrder();
    netOrder.processOrder(true);
    System.out.println("***********");
    OrderProcessTemplate storeOrder = new StoreOrder();
    storeOrder.processOrder(true);
  }
}