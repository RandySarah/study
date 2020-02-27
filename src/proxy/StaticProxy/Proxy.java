package proxy.StaticProxy;

/**
 * 3、Proxy 保存一个引用使得代理可以访问实体，并提供一个与 Subject 的接口相同的接口，这样代理就可以用来替代实体。
 */
class Proxy extends Subject {

    private RealSubject realSubject;

    @Override
    public void Request() {
        if(null == realSubject){
            realSubject = new RealSubject();
        }
        realSubject.Request();
    }

    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.Request();
    }
}
