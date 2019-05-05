import java.util.Random;

class HandlerA {
  private static final Random RANDOM = new Random();
  private static int nextID = 1;
  private int id = nextID++;
  private HandlerA nextInChain;

  public void execute(int num) {
    if (RANDOM.nextInt(4) != 0){
      System.out.println("  " + id + "-busy");
      nextInChain.execute(num);
    } else {
      System.out.println(id + " -handled " + num);
    }
  }

  public void add(HandlerA handler){
    if (nextInChain == null){
      nextInChain = handler;
    } else {
      nextInChain.add(handler);
    }
  }

  public void wrapAround(HandlerA root) {
    if (nextInChain == null) {
      nextInChain = root;
    } else {
      nextInChain.wrapAround(root);
    }
  }
}

public class HandlerClientA {
  public static void main(String[] args) {
    HandlerA rootChain = new HandlerA();
    rootChain.add(new HandlerA());
    rootChain.add(new HandlerA());
    rootChain.add(new HandlerA());
    rootChain.wrapAround(rootChain);

    for(int i=0; i<6; i++){
      System.out.println("Operation #" + i + ":");
      rootChain.execute(i);
      System.out.println();
    }
  }
}