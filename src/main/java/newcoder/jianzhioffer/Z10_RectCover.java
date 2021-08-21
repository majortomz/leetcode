package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/02 11:14
 * Description: 矩阵覆盖
 */
public class Z10_RectCover {

    public int RectCover(int target) {
        if(target <= 2) return target;
        int a = 1, b = 1, c = 0;
        for(int i = 2; i <= target; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

}
