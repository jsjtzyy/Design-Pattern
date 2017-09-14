public class Singleton{
    private int value; 
    private Singleton(){         // constructor is private because it instantiates only once inside class
        value = 0;
    }
    private static final Singleton instance = new Singleton(); // only one static instance is instantiated like global instance
  
    // methods
    public static Singleton getInstance(){
        return instance;
    }
  
    public synchronized void addValue(int amount){           // synchronized is used for multithreads working on value
        value += amount;
    }
  
    public synchronized int getValue(){
        return value;
    }
  
    public synchronized boolean getAmount(int amount){
        if(value >= amount){
            value -= amount;
            return true;
        }
        return false;
    }
}
