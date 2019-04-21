interface Chain {
  public abstract void setNext(Chain next);
  public abstract void process(Number request);
}

class Number {
  private int number;

  public Number(int number) {
    this.number = number;
  }

  public int getNumber(){
    return this.number;
  }
}

class NegativeProcessor implements Chain {

  private Chain next;

  public void setNext(Chain next) {
    this.next = next;
  }

  public void process(Number request) {
    if (request.getNumber() < 0) {
      System.out.println("NegativeProcessor : " + request.getNumber());
    } else {
      next.process(request);
    }
  }
}

class ZeroProcessor implements Chain {

  private Chain next;

  public void setNext(Chain next) {
    this.next = next;
  }

  public void process(Number request) {
    if(request.getNumber() == 0) {
      System.out.println("ZeroProcessor : " + request.getNumber());
    } else {
      next.process(request);
    }
  }
}

class PositiveProcessor implements Chain {

  private Chain next;

  public void setNext(Chain next) {
    this.next = next;
  }

  public void process(Number request) {
    if(request.getNumber() > 0) {
      System.out.println("PositiveProcessor : " + request.getNumber());
    } else {
      next.process(request);
    }
  }
}


public class NumberTypeClient {
  public static void main(String[] args) {
    Chain c1 = new NegativeProcessor();
    Chain c2 = new ZeroProcessor();
    Chain c3 = new PositiveProcessor();

    c1.setNext(c2);
    c2.setNext(c3);

    c1.process(new Number(90));
    c1.process(new Number(-90));
    c1.process(new Number(0));
    c1.process(new Number(91));
  }
}