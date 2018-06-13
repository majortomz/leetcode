package solution800_899;

/**
 * Created by zjw on 2018/06/03 15:03
 * Description:
 */
public class P845_LongestMountain {

    public int longestMountain(int[] A) {
        int longest = 0, up = 0, down = 0;
        for(int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                if(down != 0) {
                    down = 0;
                    up = 1;
                } else {
                    up++;
                }
            } else if(A[i] > A[i + 1]) {
                if(up != 0) {
                    down++;
                    if(up + down + 1>= 3) {
                        longest = Math.max(up + down + 1, longest);
                    }
                }
            } else {
                up = down = 0;
            }
        }
        return longest;
    }

}
