package off66;


/**
 * Q2:设计一个类，我们只能时生成该类的一个实例(单例模式)
 */
public class A2_Singleton {

    /**
     * 一、饿汉式，线程安全
     * 1、只能生成一个实例：构造函数设为私有函数禁止他人创建实例
     * 2、创建一个静态的实例，在需要的时候返回该实例
     */
    public static class Singleton1{

        private final static Singleton1 INSTANCE = new Singleton1();

        private Singleton1(){

        }

        private static Singleton1 getInstance(){
            return INSTANCE;
        }
    }

    /**
     * 二、懒汉式，线程不安全
     * 1、定义静态的实例，在需要的时候创建该实例
     * 2、多线程同时判断instanse==null,两个线程都会创建该实例，不满足单例
     */
    public static class Singleton2{

        private static Singleton2 instance = null;

        private Singleton2(){

        }

        public static Singleton2 getInstance(){

            //避免重复创建
            if(instance == null){
                instance = new Singleton2();
            }
            return instance;
        }

    }

    /**
     * 三、懒汉式，线程安全，效率不高
     * 1、增加同步锁，第一个线程加上锁后第二个线程只能等待，
     * 第一个线程释放锁后，第二个线程加锁运行这时第一个线程已经创建好实例
     * 第二个线程不会重复创建实例，保证在多线程环境中也只能得到一个实例
     * 2、使用同步锁加锁会十分耗时，尽量避免该操作
     */
    public static class Singleton3{

        private static Singleton3 instance = null;

        private Singleton3(){

        }

        //使用同步锁，保证同一时间只有一个线程执行这段代码
        private static synchronized Singleton3 getInstance(){
            if(instance == null){
                instance = new Singleton3();
            }
            return instance;
        }

    }

    /**
     * 四、懒汉式，线程安全，双重校验锁，效率高
     * 1、无需在获取实例的方法上加锁，在内部判断如果实例为空则加锁，时间效率高
     * 2、但是两个if判断代码实现比较复杂，容易出错
     */
    public static class Singleton4{

        private static Singleton4 instance = null;

        private Singleton4(){

        }

        private static Singleton4 getInstance(){
            if(instance == null){
                synchronized (Singleton4.class){
                    if(instance == null){
                        instance = new Singleton4();
                    }
                }
            }
            return instance;
        }
    }

    /**
     * 五、使用静态内部类，线程安全
     * 1、静态内部类创建了该类的实例，外部使用直接返回
     */
    public static class Singltton5{

        private final static class SingletonHolder{
            private static final Singltton5 INSTANCE = new Singltton5();
        }

        private Singltton5(){
        }

        private static Singltton5 getInstance(){
            return SingletonHolder.INSTANCE;
        }
    }


}
