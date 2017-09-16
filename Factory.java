/*
*         client                   Product  (interface or abstract class)
*            |                    /    |    \
*         Factory   ------->    Computer Phone  Pad
*                  (get/create)
*/

public abstract class Product{
    private int price;
    public Product(int price){
       this.price = price;
    }
    public abstract void displayInfo();
}

public class Computer extends Product{
    public Computer(int price){
      super(price);
    }
    public void displayInfo(){
      System.out.println("This is a Computer");
    }
}

public class Phone extends Product{
    public Phone(int price){
      super(price);
    }
    public void displayInfo(){
      System.out.println("This is a Phone");
    }
}

public class Pad extends Product{
    public Pad(int price){
      super(price);
    }
    public void displayInfo(){
      System.out.println("This is a Pad");
    }
}

public class Factory{
    public static Product getProduct(String name){
        switch(name){
          case "Computer": return new Computer(1200); break;
          case "Phone":    return new Phone(800);     break;
          case "Pad":      return new Pad(400);       break;
        }
    }
}

public class Client{
    public static void main(String[] args){
       Product product = Factory.getProduct("Phone");
       product.displayInfo();
    }
}
