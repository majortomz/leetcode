package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/02 13:49
 * Description: 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Power {

    public double Power(double base, int exponent) {
        if (base == 0) return 0;
        else if (exponent == 0) return 1;

        double sub = Power(base, Math.abs(exponent) / 2);
        double res = exponent % 2 == 0 ? sub * sub : base * sub * sub;
        return exponent < 0 ? 1 / res : res;
    }


}
