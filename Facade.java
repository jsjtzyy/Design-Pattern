/*
*
*                                                   |-------> System A
*                                                   |      
*     Client  ---------> Facade (Uniform Interface) |-------> System B
*                                                   |
*                                                   |-------> System C
*/
/************************** Sub-Systems **********************************/
public interface Shape {
   void draw();
}

public class Rectangle implements Shape {
   public void draw() {
      System.out.println("Rectangle::draw()");
   }
}

public class Square implements Shape {
   public void draw() {
      System.out.println("Square::draw()");
   }
}

public class Circle implements Shape {
   public void draw() {
      System.out.println("Circle::draw()");
   }
}
/************************** Facade class **********************************/
public class ShapeMaker {
   private Shape circle;
   private Shape rectangle;
   private Shape square;

   public ShapeMaker() {
      circle = new Circle();
      rectangle = new Rectangle();
      square = new Square();
   }

   public void drawCircle(){
      circle.draw();
   }
   public void drawRectangle(){
      rectangle.draw();
   }
   public void drawSquare(){
      square.draw();
   }
}
/************************** Client (Main method) **********************************/
public class Client {
   public static void main(String[] args) {
      ShapeMaker shapeMaker = new ShapeMaker();

      shapeMaker.drawCircle();
      shapeMaker.drawRectangle();
      shapeMaker.drawSquare();		
   }
}
