package proxy.StaticProxy;

/**
 * 1、Subject 定义了 RealSubject 和 Proxy 的公共接口，这样就在任何使用 RealSubject 的地方都可以使用 Proxy 。
 */
abstract class Subject {
    public abstract void Request();
}
