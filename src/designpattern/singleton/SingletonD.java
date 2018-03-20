package designpattern.singleton;

/**
 * Created by zjw on 2018/03/06 14:21
 * Description: 单例模式，双重校验锁，线程安全
 */
public class SingletonD {

    private static volatile SingletonD singleton;

    private SingletonD() {}

    public static SingletonD getUniqueInstance() {
        if(singleton == null) {
            synchronized(SingletonD.class) {
                if(singleton == null) {
                    singleton = new SingletonD();
                }
            }
        }
        return singleton;
    }
}
