package javaTest.ThreadTest;

/**
 * 创建线程的方法2：实现Runnable接口，并且调用Thread的构造方法将Runnable
 * 对象作为target参数传入来创建线程对象，好处是规避类的单继承限制，需要通过Thread,currentThread()
 * 来获取当前线程的引用
 */
public class RunnableTest implements Runnable{
    @Override
    public void run() {
        System.out.println(" 121212  ");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new RunnableTest());
        t.start();
    }
}
