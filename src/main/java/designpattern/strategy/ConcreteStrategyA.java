package designpattern.strategy;

/**
 * Created by zjw on 2018/03/21 11:02
 * Description: 具体策略类A
 */
public class ConcreteStrategyA implements Strategy{

    @Override
    public void doSomething() {
        System.out.println("运行策略A的策略");
    }
}
