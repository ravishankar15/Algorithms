/*
Diffrence between factory pattern is that it stores the created object and reuses it. Fac
*/
import java.util.Random; 
import java.util.HashMap;


interface Player {
  public void assignWeapon(String weapon);
  public void mission();
}

class Terrorist implements Player {

  private final String TASK;
  private String weapon;

  public Terrorist(){
    TASK = "Plant a Bomb";
  }

  public void assignWeapon(String weapon) {
    this.weapon = weapon;
  }

  public void mission(){
    System.out.println("Terrorist with weapon " + weapon + " | " + "task is " + TASK);
  }
}


class CounterTerrorist implements Player{

  private final String TASK;
  private String weapon;

  public CounterTerrorist(){
    TASK = "Diffuse the bomb";
  }

  public void assignWeapon(String weapon) {
    this.weapon = weapon;
  }

  public void mission(){
    System.out.println("CounterTerrorist with weapon " + weapon + " | " + "task is " + TASK);
  }
}


class PlayerFactory {
  private static HashMap<String, Player> hm = new HashMap<String, Player>();

  public static Player getPlayer(String type){
    Player p = null;

    if(hm.containsKey(type)){
      p = hm.get(type);
    } else {
      switch(type){
        case "Terrorist": 
          System.out.println("Terrorist Created");
          p = new Terrorist();
          break;
        case "CounterTerrorist":
          System.out.println("CounterTerrorist Created");
          p = new CounterTerrorist();
          break;
        default:
          System.out.println("Invalid Type");
      }
      hm.put(type, p);
    }
    return p;
  }
}


public class CounterStrike {
  private static String[] playerType = {"Terrorist", "CounterTerrorist"};
  private static String[] weapons = {"AK-47", "Maverick", "Gut Knife", "Desert Eagle"};
  public static void main(String[] args) {
    for(int i=0; i<10; i++) {

      Player p = PlayerFactory.getPlayer(getRandomPlayerType());
      p.assignWeapon(getRandomWeapon());
      p.mission();
    }
  }

  private static String getRandomPlayerType(){
    Random r = new Random();
    int randInt = r.nextInt(playerType.length);
    return playerType[randInt];
  }

  private static String getRandomWeapon(){
    Random r = new Random();
    int randInt = r.nextInt(weapons.length);
    return weapons[randInt];
  }


}
