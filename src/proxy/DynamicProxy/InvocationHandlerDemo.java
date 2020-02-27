package proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 3、定义一个动态代理类，需要实现InvocationHandler里的invoke接口
 */
public class InvocationHandlerDemo implements InvocationHandler {

    //需要代理的真实对象
    private Object subject;

    //构造方法，给我们要代理的对象赋初值
    public InvocationHandlerDemo(Object subject){
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("在代理真是对象前我们可以做一些自己的操作");

        System.out.println("调用的方法为：" + method.toString());

        //当代理对象调用真实对象的方法时，其会自动跳转到代理对象关联的handler对象的invoke方法来进行调用
        Object object = method.invoke(subject, args);

        System.out.println("在代理真实对象后我们也可以添加一些自己的操作");

        return object;
    }
}
