/*    Observer design pattern example
*     Also know as "Publish/Subscribe" pattern 与 "Event/Listener" pattern 相似. 
*     [Observer pattern]:
*                                    attach observer
*            Subject(Interface)  <-----------------  Observer(Interface)
*                  |                                        |
*                  |                  notify                |
*              Concrete Subject  ------------------> Concrete Observer
*
*     [Event-Listener pattern]:
*                              java.util.EventObject
*                               /         |         \
*                           Event1     Event2      Event3 ---------->
*                            /                                      |
*           EventSource -----                                       | transmit to
*                                                                   |
*                          java.util.EventListener(Interface) <------
*                               /         |         \
*                           Listener1   Listener2   Listener3   
* 事件源(EventSource)经过事件的封装传给监听器(Listener)，当事件源触发事件后，监听器接收到事件对象(EventOject)可以回调事件的方法
*
*    [区别]：
*         (1)Observer的api已经把对观察者的注册，删除等定义好了，而且是线程安全的。而event-listener需要使用者自己实现。 
*         (2)event-listener需要实现三个角色:eventSource, event, listener; observer-observable需要实现两个角色。 
*         (3)两者都需要自己定义并实现触发事件的通知。但Observable需要注意要在通知Observer之前调用jdk提供的setChanged()。 
*         (4)event-listener是传统的c/s界面事件模型，分事件源和事件（状态）角色，事件源要经过事件的包装、成为事件的属性之一再传递给事件监听/处理者，这个事件监听者就相当于观察者。
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
