interface HousePlan {
  public void setBasement(String basement);
  public void setStructure(String structure);
  public void setRoof(String roof);
  public void setInterior(String interior);
}

class House implements HousePlan {

  private String basement;
  private String structure;
  private String roof;
  private String interior;

  public String getBasement(){
    return this.basement;
  }

  public void setBasement(String basement) {
    this.basement = basement; 
  }

  public String getStructure(){
    return this.structure;
  }

  public void setStructure(String structure) {
    this.structure = structure;
  }

  public String getRoof(){
    return this.roof;
  }

  public void setRoof(String roof) {
    this.roof = roof;
  }

  public String getInterior(){
    return this.interior;
  }

  public void setInterior(String interior) {
    this.interior = interior;
  }

  public String toString() {
    return "House Spec \nBasement: " + this.basement + "\nStructure: " + this.structure + "\nRoof: " + this.roof + "\nInterior: " + this.interior +  "\n";
  }
}

interface HouseBuilder {
  public void buildBasement();
  public void buildStructure();
  public void buildRoof();
  public void buildInterior();
  public House getHouse();
}

class IglooHouseBuilder implements HouseBuilder {
  private House house;

  public IglooHouseBuilder() {
    this.house = new House();
  }

  public void buildBasement() {
    house.setBasement("Ice Bars");
  }

  public void buildStructure() {
    house.setStructure("Ice Blocks");
  }

  public void buildInterior() {
    house.setInterior("Ice carvings");
  }

  public void buildRoof() {
    house.setRoof("Ice Dome");
  }

  public House getHouse(){
    return this.house;
  }
}

class TipiHouseBuilder implements HouseBuilder {
  private House house;

  public TipiHouseBuilder() {
    this.house = new House();
  }

  public void buildBasement() {
    house.setBasement("Wooden Poles");
  }

  public void buildStructure() {
    house.setStructure("Wood and Ice");
  }

  public void buildInterior() {
    house.setInterior("Fire Wood");
  }

  public void buildRoof() {
    house.setRoof("Wood, caribou and seal skins");
  }

  public House getHouse(){
    return this.house;
  }
}


class CivilEngineer {
  private HouseBuilder houseBuilder;

  public CivilEngineer(HouseBuilder houseBuilder){
    this.houseBuilder = houseBuilder;
  }

  public House getHouse() {
    return this.houseBuilder.getHouse();
  }

  public void constructHouse(){
    this.houseBuilder.buildBasement();
    this.houseBuilder.buildStructure();
    this.houseBuilder.buildRoof();
    this.houseBuilder.buildInterior();
  }
}


public class HouseClient{
  public static void main(String[] args) {
    HouseBuilder igh = new IglooHouseBuilder();
    CivilEngineer e1 = new CivilEngineer(igh);
    e1.constructHouse();
    System.out.println(e1.getHouse()); 
  }
}