package solution300_399;

/**
 * Created by zjw on 2017/8/21.
 */
public class P343_IntegerBreak {

    public int integerBreak(int n) {
        int[] helper = new int[60];
        helper[1] = 1;
        helper[2] = 1;
        for(int i = 3; i <= n; i++) {
            for(int k = 1; k < i; k++) {
                helper[i] = Math.max(helper[i], Math.max(helper[i-k], i-k)* k);
            }
        }
        return helper[n];
    }

    // Solution 2: from leetcode discussoin
    // as more 3 as possible
    public int integerBreak2(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int product = 1;
        while(n>4){
            product *= 3;
            n -= 3;
        }
        product *= n;

        return product;
    }

}
