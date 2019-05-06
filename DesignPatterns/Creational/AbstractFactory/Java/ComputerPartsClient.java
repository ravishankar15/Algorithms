interface CPU {
  public void displayCPU();
}

class EmberCPU implements CPU {

  public void displayCPU(){
    System.out.println("Ember CPU is been built");
  }
}

class EnginolaCPU implements CPU {

  public void displayCPU() {
    System.out.println("Enginola CPU is been build");
  }
}

interface MMU {
  public void displayMMU();
}

class EmberMMU implements MMU {

  public void displayMMU(){
    System.out.println("Ember MMU is been built");
  }
}

class EnginolaMMU implements MMU {

  public void displayMMU() {
    System.out.println("Enginola MMU is been built");
  }
}

enum Architecture {
  ENGINOLA, EMBER
}

abstract class ToolKitFactory {
  private static final EmberToolKit EMBER_TOOLKIT = new EmberToolKit();
  private static final EnginolaToolKit ENGINOLA_TOOLKIT = new EnginolaToolKit();

  static ToolKitFactory getFactory(Architecture architecture) {
    ToolKitFactory factory = null;
    switch(architecture) {
      case EMBER:
        factory = EMBER_TOOLKIT;
        break;
      case ENGINOLA:
        factory = ENGINOLA_TOOLKIT;
        break;
    }
    return factory;
  }

  public abstract CPU createCPU();
  public abstract MMU createMMU();
}

class EmberToolKit extends ToolKitFactory {

  public CPU createCPU(){
    return new EmberCPU();
  }

  public MMU createMMU() {
    return new EmberMMU();
  }
}

class EnginolaToolKit extends ToolKitFactory {

  public CPU createCPU() {
    return new EnginolaCPU();
  }

  public MMU createMMU() {
    return new EnginolaMMU();
  }
}

public class ComputerPartsClient {
  public static void main(String[] args) {
    ToolKitFactory factory = ToolKitFactory.getFactory(Architecture.EMBER);
    CPU cpu = factory.createCPU();
    cpu.displayCPU();
  }
}