package javaTest.ThreadTest.SynchronizedDemo;

/**
 * 明确锁的对象
 */
public class SynchronizedDemo3 {
    public void method(){
        //进入代码块会锁this指向的对象的锁，出代码块会释放this指向对象的锁
        synchronized (this){
        }
    }

    public static void main(String[] args){
        SynchronizedDemo3 demo3 = new SynchronizedDemo3();
        demo3.method();
    }

}
