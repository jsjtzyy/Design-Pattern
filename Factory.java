/*
*     Factory Example
*
*      Abstract Factory                             Abstract Product  (interface or abstract class)
*        /     |      \                             /     |     \
*   Computer  Phone   Pad Factory   ---------->   Pad     |      \
*   Factory   Factory --------------------------------> Phone     \
*      |------------------------------------------------------> Computer
*/
/************************************* Abstract Factory and Concrete Factory **********************************************/
public abstract class Factory {
  public static Product getProduct(String name);
}

public class ComputerFactory extends Factory{
  public static Product getProduct(){
    return new Computer(1000);
  }
}

public class PhoneFactory extends Factory{
  public static Product getProduct(){
    return new Phone(800);
  }
}

public class PadFactory extends Factory{
  public static Product getProduct(){
    return new Pad(300);
  }
}
/************************************* Abstract Product and Concrete Product **********************************************/
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
/************************************* Client (Main method) **********************************************/
public class Client{
    public static void main(String[] args){
       Factory computerFactory = new ComputerFactory();
       Product computer = computerFactory.getProduct();
       computer.displayInfo();
    }
}
