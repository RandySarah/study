package javaTest.ThreadTest.SynchronizedDemo;

/**
 *  锁的SynchronizedDemo类的对象
 */
public class SynchronizedDemo2 {
    public synchronized static void method(){
    }

    public static void main(String[] args) {
        method(); //进入方法会锁SynchronizedDemo2.class 指向对象中的锁；
        //出方法会释放SynchronizedDemo2.class 指向对象中的锁
    }
}
