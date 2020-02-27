package proxy.DynamicProxy;

/**
 *  2、定义了一个类来实现了这个接口，这个类是我们的真实对象，RealSubject类
 */
public class RealSubject implements Subject{
    @Override
    public void hello(String str) {
        System.out.println("hello " + str);
    }

    @Override
    public String bye() {
        System.out.println("bye");
        return "bye";
    }
}
