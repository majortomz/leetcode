package basic.proxy;

/**
 * Created by zjw on 2018/03/31 10:00
 * Description: jdk动态代理测试
 */
public class JdkProxyTest {

    public static void main(String[] args) {
        // 实例化目标对象
        UserService service = new UserServiceImpl();

        // 实例化Invocation
        MyInvocationHandler invocation = new MyInvocationHandler(service);

        // 根据目标生成代理对象
        UserService proxy = (UserService)invocation.getProxy();

        // 调用代理方法
        proxy.add();
    }
}
