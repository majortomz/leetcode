package basic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zjw on 2018/03/31 9:52
 * Description:
 */
public class MyInvocationHandler implements InvocationHandler {

    // 目标对象
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 在目标方法执行前执行
        System.out.println("---------before add---------");

        // 执行目标方法对象
        Object result = method.invoke(target, args);

        // 在目标方法执行后执行
        System.out.println("---------after add---------");

        return result;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                this.target.getClass().getInterfaces(), this);
    }

}
