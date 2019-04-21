import java.util.HashMap; 
import java.util.Map;

abstract class Color implements Cloneable {
  protected String colorName;

  abstract void addColor();

  public Object clone(){
    Object clone = null;
    try {
      clone = super.clone();
    } catch(CloneNotSupportedException e){
      e.printStackTrace();
    }
    return clone;
  }
}

class BlueColor extends Color {

  public BlueColor(){
    this.colorName = "Blue";
  }

  public void addColor(){
    System.out.println("Blue color added");
  }
}

class BlackColor extends Color {
  
  public BlackColor(){
    this.colorName = "Black";
  }

  public void addColor(){
    System.out.println("Black color added");
  }
}

class ColorStore {

  private static Map<String, Color> colorMap = new HashMap<String, Color>();

  static {
    colorMap.put("blue", new BlueColor());
    colorMap.put("black", new BlackColor());
  }

  public static Color getColor(String colorName) {
    return (Color) colorMap.get(colorName).clone();
  }
}

public class ColorClient{
  public static void main(String[] args) {
    System.out.println(ColorStore.getColor("blue"));
    ColorStore.getColor("blue").addColor();

    System.out.println(ColorStore.getColor("black"));
    ColorStore.getColor("black").addColor();

    System.out.println(ColorStore.getColor("blue")); //Verify the new cloned object is returned
    ColorStore.getColor("blue").addColor();

    System.out.println(ColorStore.getColor("black")); //Verify the new cloned object is returned
    ColorStore.getColor("black").addColor();
  }
}