package proxy.StaticProxy;

/**
 * 2、RealSubject 定义 Proxy 所代表的真实实体。
 */
class RealSubject extends Subject{
    @Override
    public void Request() {
        System.out.println("真实的请求");
    }
}
