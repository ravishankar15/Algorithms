class B {
  public void doIt(){
    System.out.print("B");
  }
}

class BwithX extends B {
  public void doIt(){
    super.doIt();
    doX();
  }

  public void doX(){
    System.out.print("X");
  }
}

class BwithY extends B {
  public void doIt(){
    super.doIt();
    doY();
  }

  public void doY(){
    System.out.print('Y');
  }
}

class BwithZ extends B {
  public void doIt() {
    super.doIt();
    doZ();
  }

  public void doZ(){
    System.out.print("Z");
  }
}

class BwithXY extends BwithX {
  private BwithY bWithY = new BwithY();

  public void doIt() {
    super.doIt();
    bWithY.doY();
  }
}

class BwithXYZ extends BwithXY {
  private BwithZ bWithZ = new BwithZ();

  public void doIt() {
    super.doIt();
    bWithZ.doZ();
  }
}

public class AlphabetClientB {
  public static void main(String[] args) {
    B[] arr = { new BwithX(), new BwithXY(), new BwithXYZ() };
    for(B b: arr) {
      b.doIt();
      System.out.print(" ");
    }
    System.out.println();
  }
}