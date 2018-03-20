package designpattern.singleton;

/**
 * Created by zjw on 2018/03/06 14:13
 * Description: 单例模式，最简单的懒汉式，且线程不安全
 */
public class SingletonA {

    private static SingletonA singleton;

    private SingletonA() {}

    public static SingletonA getUniqueInstance() {
        if(singleton == null) {
            singleton = new SingletonA();
        }
        return singleton;
    }

}
