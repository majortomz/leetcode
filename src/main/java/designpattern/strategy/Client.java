package designpattern.strategy;

/**
 * Created by zjw on 2018/03/21 11:07
 * Description:
 */
public class Client {

    public static void main(String[] args) {
        // 声明具体的策略
        Strategy strategy = new ConcreteStrategyA();
        // 声明上下文对象
        Context context = new Context(strategy);
        // 执行封装后的方法
        context.doSomething();
    }
}
