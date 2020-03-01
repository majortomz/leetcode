package solution;

/**
 * Created by zjw on 2017/9/21.
 */
public class P60_PermutationSequence {

    public String getPermutation(int n, int k) {
        if(n <= 0)  return "";
        int segNum = 1;
        for(int i = 1; i <= n; i++)
            segNum *= i;

        StringBuilder sb = new StringBuilder(n);
        boolean[] visited = new boolean[n+1];

        for(int i = n; i >= 1; i--) {
            // calculate segNum = A(n-1, 1)
            segNum /= i;
            int index = (k - 1) / segNum;
            // calculate next k
            k -= index * segNum;
            for(int m = 1; m < visited.length; m++) {
                if(visited[m])  continue;
                if(index == 0) {
                    visited[m] = true;
                    sb.append(m);
                    break;
                }
                index--;
            }
        }
        return sb.toString();
    }

}
