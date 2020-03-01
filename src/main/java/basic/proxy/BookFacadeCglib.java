package basic.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zjw on 2018/03/31 10:38
 * Description:
 */
public class BookFacadeCglib implements MethodInterceptor{

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(new BookFacadeCglib());
        return enhancer.create();
    }

    // 回调方法
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("--------before--------");
        methodProxy.invokeSuper(obj, args);
        System.out.println("--------after---------");
        return null;
    }
}
