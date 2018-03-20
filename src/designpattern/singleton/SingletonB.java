package designpattern.singleton;

/**
 * Created by zjw on 2018/03/06 14:15
 * Description: 懒汉式，线程安全
 */
public class SingletonB {

    private static SingletonB singleton;

    private SingletonB() {}

    public static synchronized SingletonB getUniqueInstance() {
        if(singleton == null) {
            singleton = new SingletonB();
        }
        return singleton;
    }

}
