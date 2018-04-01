/*    Adapter design pattern example
*
*        Target(interface required by client) ---> Adapter (Wrapper class) -----> Adaptee (Existing class)
*
*/

class Adaptee {
    public void SpecificRequest(){
    }
}

public interface Target {
    //这是源类Adaptee没有的方法
    public void Request(); 
}

class Adapter implements Target{  
    // 直接关联被适配类  
    private Adaptee adaptee;  

    // 可以通过构造函数传入具体需要适配的被适配类对象  
    public Adapter (Adaptee adaptee) {  
        this.adaptee = adaptee;  
    }  

    @Override
    public void Request() {  
        // 这里是使用委托的方式完成特殊功能  
        this.adaptee.SpecificRequest();  
    }  
} 

/*********************************  Client (Main method) *************************************/
public class Client {
    public static void main(String[] args){
        //需要先创建一个被适配类的对象作为参数  
        Target target = new Adapter(new Adaptee())；
        target.Request();
    }
}

/*********************************  Pros and Cons *************************************/
Pros:
  (1)将目标类和适配者类解耦，通过引入一个适配器类来重用现有的适配者类，而无须修改原有代码。
  (2)增加了类的透明性和复用性，将具体的实现封装在适配者类中，对于客户端类来说是透明的，而且提高了适配者的复用性。
Cons:
  (1)要想置换适配者类的方法不容易。
