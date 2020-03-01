package designpattern.singleton;

/**
 * Created by zjw on 2018/03/06 14:19
 * Description: 单例模式，饿汉式，线程安全
 */
public class SingletonC {

    private static SingletonC singleton = new SingletonC();

    private SingletonC() {}

    public static SingletonC getUniqueInstance() {
        return singleton;
    }

}
