package proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 每一个动态代理类都必须实现InvocationHandler这个接口，并且每个代理类的实例都关联到了一个Handler，
 * 当我们通过代理对象调用一个方法的时候，这个方法的调用就会被转发为由InvocationHandle这个接口的invoke方法来进行调用。
 */
public class Client {
    public static void main(String[] args) {
        //要代理的真实对象
        Subject realSubject = new RealSubject();

        //我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler handler = new InvocationHandlerDemo(realSubject);

        /**
         通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
         * 第一个参数 handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
         * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         */
        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(),handler);

        System.out.println(subject.getClass().getName());

        subject.hello("world");

        String result = subject.bye();

        System.out.println("Result is:" + result);
    }
}
