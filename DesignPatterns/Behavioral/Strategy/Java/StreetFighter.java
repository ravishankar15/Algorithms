interface JumpBehaviour{
  public void jump();
}

class ShortJump implements JumpBehaviour {
  public void jump(){
    System.out.println("Short Jump");
  }
}

class LongJump implements JumpBehaviour {
  public void jump(){
    System.out.println("Long Jump");
  }
}


interface RollBehaviour{
  public void roll();
}

class SingleRoll implements RollBehaviour {
  public void roll(){
    System.out.println("Single Roll");
  }
}

class DoubleRoll implements RollBehaviour {
  public void roll() {
    System.out.println("Double Roll");
  }
}


abstract class Fighter{
  private JumpBehaviour jumpBehaviour;
  private RollBehaviour rollBehaviour;

  public abstract void display();

  public Fighter(JumpBehaviour jumpBehaviour, RollBehaviour rollBehaviour){
    this.jumpBehaviour = jumpBehaviour;
    this.rollBehaviour = rollBehaviour;
  }

  public void punch(){
    System.out.println("Default Punch");
  }

  public void kick(){
    System.out.println("Default Kick");
  }

  public void jump(){
    this.jumpBehaviour.jump();
  }

  public void roll(){
    this.rollBehaviour.roll();
  }

  public void setJumpBehaviour(JumpBehaviour jumpBehaviour){
    this.jumpBehaviour = jumpBehaviour;
  }

  public void setRollBehaviour(RollBehaviour rollBehaviour){
    this.rollBehaviour = rollBehaviour;
  }

}


class Ryu extends Fighter {
  public Ryu(JumpBehaviour jumpBehaviour, RollBehaviour rollBehaviour) {
    super(jumpBehaviour, rollBehaviour);
  }

  public void display(){
    System.out.println("Ryu");
  }
}

class Ken extends Fighter {
  public Ken(JumpBehaviour jumpBehaviour, RollBehaviour rollBehaviour){
    super(jumpBehaviour, rollBehaviour);
  }

  public void display() {
    System.out.println("Ken");
  }
}


public class StreetFighter {
  public static void main(String[] args) {
    JumpBehaviour shortJump = new ShortJump();
    JumpBehaviour longJump = new LongJump();

    RollBehaviour singleRoll = new SingleRoll();
    RollBehaviour doubleRoll = new DoubleRoll();

    Fighter ken = new Ken(shortJump, doubleRoll);
    ken.display();
    ken.punch();
    ken.kick();
    ken.jump();
    ken.roll();

    Fighter ryu = new Ryu(longJump, singleRoll);
    ryu.display();
    ryu.punch();
    ryu.kick();
    ryu.jump();
    ryu.roll();
  }
}