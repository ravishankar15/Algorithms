interface Color {
  public void applyColor();
}

class RedColor implements Color {

  public void applyColor(){
    System.out.println(" Red.");
  }
}

class GreenColor implements Color {

  public void applyColor() {
    System.out.println(" Green.");
  }
}

abstract class Shape {
  protected Color color;

  public Shape(Color color){
    this.color = color;
  }

  abstract public void createShape();
}

class Triangle extends Shape {

  public Triangle(Color color){
    super(color);
  }

  public void createShape() {
    System.out.print("Triangle filled with color");
    color.applyColor();
  }
}

class Pentagon extends Shape {

  public Pentagon(Color color) {
    super(color);
  }

  public void createShape() {
    System.out.print("Pentagon filled with color");
    color.applyColor();
  }
}

public class ShapeClient {
  public static void main(String[] args) {
    Shape shape = new Triangle(new RedColor());
    shape.createShape();
    Shape shape1 = new Pentagon(new GreenColor());
    shape1.createShape();
  }
}