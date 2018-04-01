/*
*       Simple Factory Example
*
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

public class SimpleFactory{
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
       Product product = SimpleFactory.getProduct("Phone");
       product.displayInfo();
    }
}

/************************************* Pros and Cons **********************************************/
Pros:
(1) 工厂类含有必要的判断逻辑，可以决定创建哪一个产品类的instance，客户端可以免除直接创建产品instance的责任，而仅仅“消费”产品；
    简单工厂模式实现了对责任的分割，它提供了专门的工厂类用于创建instance。
(2) 客户端无须知道产品类的具体类名，只需要知道产品类所对应的参数即可，对于一些复杂的类名，通过简单工厂模式可以减少使用者的记忆量。
(3) 通过引入配置文件，可以在不修改任何客户端代码的情况下更换和增加新的具体产品类，在一定程度上提高了系统的灵活性。

Cons:
(1) 由于工厂类集中了所有产品创建逻辑，一旦不能正常工作，整个系统都要受到影响。
(2) 使用简单工厂模式将会增加系统中类的个数，在一定程序上增加了系统的复杂度和理解难度。
(3) 系统扩展困难，一旦添加新产品就不得不修改工厂逻辑，在产品类型较多时，有可能造成工厂逻辑过于复杂，不利于系统的扩展和维护。
(4) 简单工厂模式由于使用了静态工厂方法，造成工厂角色无法形成基于继承的等级结构。
