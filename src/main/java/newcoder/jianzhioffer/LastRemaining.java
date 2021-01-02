package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/08 23:11
 * Description:
 */
public class LastRemaining {

    public int LastRemaining_Solution(int n, int m) {
        if(n <= 0  || m <= 0)    return -1;
        boolean[] arr = new boolean[n];
        int k = m, i = 0, count = n;
        while(count > 1) {
            if(k == 1 && !arr[i]) {
                count--;
                k = m;
                arr[i] = true;
            } else if(!arr[i]) {
                k--;
            }
            i = (i + 1) % n;
        }
        for(i = 0; i < arr.length; i++) {
            if(!arr[i]) return i;
        }
        return -1;
    }

}
