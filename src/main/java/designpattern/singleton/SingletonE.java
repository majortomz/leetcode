package designpattern.singleton;

/**
 * Created by zjw on 2018/03/07 10:51
 * Description: 基于enum实现
 */
public enum SingletonE {

    INSTANCE {
        public void process() {

        }
    };

    public abstract void process();

}
