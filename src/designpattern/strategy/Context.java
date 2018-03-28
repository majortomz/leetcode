package designpattern.strategy;

/**
 * Created by zjw on 2018/03/21 11:05
 * Description: 屏蔽客户端对策略的直接访问
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doSomething() {
        strategy.doSomething();
    }
}
