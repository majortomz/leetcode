package solution;

/**
 * Created by zjw on 2017/5/11.
 */
public class P96_UniqueBST {

    public int numTrees(int n) {
        if(n <= 0)  return 0;
        int[][] mat = new int[n+1][n+1];
        return helper(1, n, mat);
    }
    //    G(n): the number of unique BST for a sequence of length n.
    //    F(i, n), 1 <= i <= n: the number of unique BST, where the number i is the root of BST, and the sequence ranges from 1 to n.
    //    G(n) = F(1, n) + F(2, n) + ... + F(n, n).
    //    F(i, n) = G(i-1) * G(n- (i+1) + 1)
    public int numTrees2(int n) {
        if(n <= 0)  return 0;
        int[] mat = new int[n+1];
        mat[0] = 1;
        mat[1] = 1;
        for(int i=2; i<=n; i++) {
            for(int j=1; j<=i; j++)
            {
                mat[i] += (mat[j-1] * mat[i-j]);
            }
        }
        return mat[n];
    }

    public int helper(int start, int end, int[][] mat) {
        if(start > end) {
            return 1;
        }
        int result = 0;
        for(int i=start; i<=end; i++) {
            int left, right;
            if(i-1 >= 1 && mat[start][i-1] != 0)
                left = mat[start][i-1];
            else
                left = helper(start, i-1, mat);
            if(i + 1 <= end && mat[i+1][end] != 0)
                right = mat[i+1][end];
            else
                right = helper(i+1, end, mat);
            result += (left * right);
        }
        mat[start][end] = result;
        return result;
    }

    public int main(String[] args) {
        P96_UniqueBST uni = new P96_UniqueBST();
        System.out.println(uni.numTrees(19));
        return 0;
    }
}
