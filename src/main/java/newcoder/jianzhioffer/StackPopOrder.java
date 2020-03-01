package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/02 20:07
 * Description: 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等
 */
public class StackPopOrder {

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int len = pushA.length, i = 0, j = 0, k = -1;
        int[] stack = new int[pushA.length];
        while(j < len) {
            if(k >= 0 && stack[k] == popA[j]) {
                k--;
                j++;
            } else if (i < len) {
                stack[++k] = pushA[i++];
            } else {
                break;
            }
        }
        return k == -1;
    }

    public static void main(String[] args) {
        StackPopOrder popOrder = new StackPopOrder();
        popOrder.IsPopOrder(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1});
    }

}
