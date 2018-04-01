/*
*     Abstract Factory Example
*
*              Abstract Phone                    Abstract Factory                           Abstract Computer
*              /         \                         /         \                               /            \
*      |---> Galaxy S8   iPhone  <------------    Apple     Sumsung Factory ------------> NoteBook     MacBook <--|
*      |                                        Factory  -----|---------------------------------------------------| 
*      -------------------------------------------------------|                    
*/
/************************************* Abstract Factory and Concrete Factory **********************************************/
pubic abstract class Factory {
  public static Product getComputer();
  public static Product getPhone();
}

public class AppleFactory extends Factory {
  public static Product getComputer(){
    return new Macbook(1200);
  }
  public static Product getPhone(){
    return new IPhone(1000);
  }
}

public class SumsungFactory extends Factory {
  public static Product getComputer(){
    return new NoteBook(980);
  }
  public static Product getPhone(){
    return new GalaxyS8(900);
  }
}
/************************************* Abstract Product and Concrete Product **********************************************/
public abstract class Computer {
    private int price;
    public Computer(int price){
       this.price = price;
    }
    public abstract void displayInfo();
}

public class Macbook extends Computer {
   public Macbook(int price){
    super(price);
   }
   public void displayInfo() {
    System.out.println("This is a MacBook");
   }
}

public class NoteBook extends Computer {
   public NoteBook(int price){
    super(price);
   }
   public void displayInfo() {
    System.out.println("This is a NoteBook");
   }
}

public abstract class Phone {
    private int price;
    public Phone(int price){
       this.price = price;
    }
    public abstract void displayInfo();
}

public class IPhone extends Phone {
   public IPhone(int price){
    super(price);
   }
   public void displayInfo() {
    System.out.println("This is a iPhone");
   }
}

public class GalaxyS8 extends Phone {
   public GalaxyS8(int price){
    super(price);
   }
   public void displayInfo() {
    System.out.println("This is a GalaxyS8");
   }
}
/************************************* Client (Main method) **********************************************/
public class Client{
    public static void main(String[] args){
       Factory appleFactory = new AppleFactory();
       Factory sumsungFactory = new SumsungFactory();
       Product macbook = appleFactory.getComputer();
       macbook.displayInfo();
       Product galaxyS8 = sumsungFactory.getPhone();
       galaxyS8.displayInfo();
    }
}
