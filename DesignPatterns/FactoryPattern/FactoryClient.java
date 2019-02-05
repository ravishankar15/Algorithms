/*
- Factory method is a creational design pattern, related to object creation
- In factory pattern, we create object without exposing the creation logic to client and the client uses the same common interface
    to create new type of object

*/

interface Shape {
    void draw();
}

class Rectangle implements Shape {
    
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}


class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

class Circle implements Shape {

   @Override
   public void draw() {
      System.out.println("Inside Circle::draw() method.");
   }
}


class ShapeFactory {

    public Shape getShape(String shapeType) {
        if(shapeType == null){
            return null;
        }     
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle(); 
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }  
        return null;
    }
}

public class FactoryClient {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        //get an object of Circle and call its draw method.
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        //call draw method of Circle
        shape1.draw();

        //get an object of Rectangle and call its draw method.
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        //call draw method of Rectangle
        shape2.draw();

        //get an object of Square and call its draw method.
        Shape shape3 = shapeFactory.getShape("SQUARE");

        //call draw method of square
        shape3.draw();
    }
}