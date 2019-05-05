import java.util.Random; 

class HandlerB {
  private static final Random RANDOM = new Random();
  private static int nextID = 1;
  private int id = nextID++;

  public boolean execute(int num) {
    if(RANDOM.nextInt(4) != 0){
      System.out.println("  " + id + "-busy");
      return false;
    }
    System.out.println(id + " -handled " + num);
    return true;
  }
}

public class HandlerClientB {
  public static void main(String[] args) {
    HandlerB[] handler = { new HandlerB(), new HandlerB(), new HandlerB() };
    for(int i=0; i<6; i++) {
      System.out.println("Operation #" + i + ":");
      int j=0;
      while(!handler[j].execute(i)){
        j = (j+1) % handler.length;
      }
      System.out.println();
    }
  }
}