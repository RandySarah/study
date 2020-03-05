package javaTest.ThreadTest;

import java.util.Random;

public class ThreadTest {

    /**
     * 创建线程的方法1：继成Thread类
     * this就是当前线程，不需要通过Thread.currentThread()来获取当前线程的引用
     */
    public static class MyThreadTest extends Thread{
        @Override
        public void run() {
            Random random = new Random();
            while (true){
                //打印线程名称
                System.out.println(Thread.currentThread().getName());
                try{
                    //随机停止运行0-9秒
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyThreadTest t1 = new MyThreadTest();
        MyThreadTest t2 = new MyThreadTest();
        MyThreadTest t3 = new MyThreadTest();

        t1.start();
        t2.start();
        t3.start();

        Random random = new Random();
        while (true){
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(random.nextInt(10));
        }

    }
}
