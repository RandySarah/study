package javaTest.ThreadTest.SynchronizedDemo;

/**
 * 锁的SynchronizedDemo对象
 */
public class SynchronizedDemo1 {

    public synchronized void method(){
    }

    public static void main(String[] args){
        SynchronizedDemo1 demo1 = new SynchronizedDemo1();
        demo1.method();//进入方法会锁demo指向对象中的锁，出方法会释放demo指向对象的锁
    }
}
