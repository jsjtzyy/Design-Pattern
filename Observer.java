/*    Observer design pattern example
*     Also know as "Publish/Subscribe", "Event/Listener" pattern
*
*                                    attach observer
*            Subject(Interface)  <-----------------  Observer(Interface)
*                  |                                        |
*                  |                  notify                |
*              Concrete Subject  ------------------> Concrete Observer
*
*/

/************************** Observer Implementation **********************************/

class ConcreteObserver implements java.util.Observer {   
    public void update(java.util.Observable obj, Object arg) {   
        System.out.println("Update() called, count is " + ((Integer) arg).intValue());   
    }   
}


class ConcreteSubject extends java.util.Observable {   
    void counter(int period) {   
        while(period >= 0) {   
            setChanged();   
            notifyObservers(new Integer(period));   
            try {   
                Thread.sleep(100);   
            } catch( InterruptedException e) {   
                System.out.println("Sleep interrupeted" );   
            }   
            --period;
        }   
    }   
}

public class ObserverDemo {   
    public static void main(String[] args) {   
        ConcreteSubject subject = new ConcreteSubject();   //Subject(观察对象)   
        ConcreteObserver observer = new ConcreteObserver();//观察者   
        subject.addObserver(observer);   
        subject.counter(10);   
    }   
}
