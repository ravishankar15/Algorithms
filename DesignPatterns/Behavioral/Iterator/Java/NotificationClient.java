class Notification {

  private String notification;

  public Notification(String notification) {
    this.notification = notification;
  }

  public String getNotification() {
    return this.notification;
  }
}

interface Iterator{
  public boolean hasNext();
  public Object next();
}

class NotificationIterator implements Iterator {

  private Notification[] notificationArr;
  private int pos;

  public NotificationIterator(Notification[] notificationArr){
    this.notificationArr = notificationArr;
    this.pos = 0;
  }

  public Object next() {
    Notification notification = notificationArr[pos++];
    return notification;
  }

  public boolean hasNext(){
    if(pos >= notificationArr.length || notificationArr[pos] == null)
      return false;
    return true;
  }
}

interface Collection {
  public Iterator createIterator();
}

class NotificationCollection implements Collection {
  private static final int MAX_ITEMS = 6;
  private int numberOfItems = 0;
  private Notification[] notificationArr;

  public NotificationCollection(){
    notificationArr = new Notification[MAX_ITEMS];
  }

  public void addItem(String str){
    Notification notification = new Notification(str);
    if(numberOfItems >= MAX_ITEMS){
      System.out.println("Full");
    } else {
      notificationArr[numberOfItems] = notification;
      numberOfItems++;
    }
  }

  public Iterator createIterator(){
    return new NotificationIterator(notificationArr);
  }
}


class NotificationBar {

  private NotificationCollection notifications;

  public NotificationBar(NotificationCollection notifications){
    this.notifications = notifications;
  }

  public void printNotifications(){
    Iterator it = notifications.createIterator();
    System.out.println("Notification Bar ....");
    while(it.hasNext()){
      Notification nt = (Notification)it.next();
      System.out.println(nt.getNotification());
    }
  }
}


public class NotificationClient {
  public static void main(String[] args) {
    NotificationCollection ntc = new NotificationCollection();
    ntc.addItem("Notification-1");
    ntc.addItem("Notification-2");
    ntc.addItem("Notification-3");
    NotificationBar ntb = new NotificationBar(ntc);
    ntb.printNotifications();
  }
}