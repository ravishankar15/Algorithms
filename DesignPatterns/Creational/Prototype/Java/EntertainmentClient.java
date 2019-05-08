/*
I am creating an entertainment application that will require instance of movie, album and show classes very frequently. 
I do not want to create their instances every time as it is costly. so i will create their prototype instances, and everytime when i will need
the new instance i will just clone the prototype instance.
*/
import java.util.HashMap; 
import java.util.Map;

abstract class Entertainment implements Cloneable {
  protected String name;

  public Entertainment clone(){
    Entertainment clone = null;
    try {
      clone = (Entertainment)super.clone();
    } catch(CloneNotSupportedException e){
      e.printStackTrace();
    }
    return clone;
  }

  abstract void fetch();
}


class Movie extends Entertainment {

  public Movie(String name){
    this.name = name;
  }

  public void fetch(){
    System.out.println(name + " movie is added");
  }
}

class Album extends Entertainment {

  public Album(String name) {
    this.name = name;
  }

  public void fetch(){
    System.out.println(name + " album is added");
  }
}

class Show extends Entertainment {

  public Show(String name) {
    this.name = name;
  }

  public void fetch() {
    System.out.println(name + " show is added");
  }
}


class EntertainmentFactory {

  private static Map<String, Entertainment> registry = new HashMap<String, Entertainment>();
  
  static {
    registry.put("Movie", new Movie("End Game"));
    registry.put("Album", new Album("Petta"));
    registry.put("Show", new Show("Black sheep"));
  }

  public static Entertainment getInstance(String key){
    return registry.get(key).clone();
  }
}

public class EntertainmentClient {
  public static void main(String[] args) {
    System.out.println(EntertainmentFactory.getInstance("Movie"));
    EntertainmentFactory.getInstance("Movie").fetch();

    System.out.println(EntertainmentFactory.getInstance("Album"));
    EntertainmentFactory.getInstance("Album").fetch();

    System.out.println(EntertainmentFactory.getInstance("Show"));
    EntertainmentFactory.getInstance("Show").fetch();

    System.out.println(EntertainmentFactory.getInstance("Movie"));
    EntertainmentFactory.getInstance("Movie").fetch();
  }
}