package designpattern.singleton;

/**
 * Created by zjw on 2018/03/07 10:52
 * Description: 登记式/静态内部类
 */
public class SingletonF {

    private static class Holder {
        private static SingletonF singleton = new SingletonF();
    }

    public SingletonF getInstance() {
        return Holder.singleton;
    }
}
