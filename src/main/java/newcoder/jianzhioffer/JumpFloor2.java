package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/02 10:38
 * Description: 变态跳台阶
 */
public class JumpFloor2 {

    class Solution2 {
        public int JumpFloorII(int target) {
            if(target <= 2) return target;
            else    return 2 * JumpFloorII(target - 1);
        }
    }

    public int JumpFloorII(int target) {
        return helper(target);
    }

    private int helper(int target) {
        if(target < 0)    return 0;
        else if(target <= 2)    return target;

        int total = 1;
        for(int i = 1; i < target; i++) {
            total += helper(target - i);
        }
        System.out.println(total);
        return total;
    }


    public static void main(String[] args) {
        JumpFloor2 jump = new JumpFloor2();
        jump.JumpFloorII(4);
    }
}
