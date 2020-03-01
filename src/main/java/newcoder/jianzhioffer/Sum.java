package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/08 23:18
 * Description: 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Sum {

    public int Sum_Solution(int n) {
        int res = n;
        boolean b = res > 0 && ( res += Sum_Solution(n - 1)) > 0;
        return res;
    }

}
