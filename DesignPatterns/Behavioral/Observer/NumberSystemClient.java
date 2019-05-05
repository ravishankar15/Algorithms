import java.util.ArrayList;
import java.util.List;

abstract class Subject {
  protected List<Observer> obsList;

  public Subject() {
    obsList = new ArrayList<Observer>();
  }

  protected void registerObserver(Observer obs){
    obsList.add(obs);
  }

  protected void unregisterObserver(Observer obs) {
    obsList.remove(obsList.indexOf(obs));
  }
  public abstract void notifyObservers();
}

class NumberSystemSubject extends Subject {
  private int value;

  public NumberSystemSubject(int value){
    super();
    this.value = value;
  }

  public void notifyObservers(){
    for(Observer obs: obsList) {
      obs.update(this.value);
    }
  }
}

interface Observer{
  public void update(int value);
}

class HexObserver implements Observer {
  public void update(int value){
    System.out.println(" " + Integer.toHexString(value));
  }
}

class OctObserver implements Observer {
  public void update(int value) {
    System.out.println(" " + Integer.toOctalString(value));
  }
}
class BinObserver implements Observer {
  public void update(int value) {
    System.out.println(" " + Integer.toBinaryString(value));
  }
}

public class NumberSystemClient {
  public static void main(String[] args) {
    HexObserver hex = new HexObserver();
    OctObserver oct = new OctObserver();
    BinObserver bin = new BinObserver();

    Subject sub = new NumberSystemSubject(55);
    sub.registerObserver(hex);
    sub.registerObserver(oct);
    sub.notifyObservers();

    System.out.println("************");
    sub.registerObserver(bin);
    sub.notifyObservers();
  }
}