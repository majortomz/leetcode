package solution500_599;

/**
 * Created by zjw on 2017/5/16.
 */
public class P566_ReshapeMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums == null)    return nums;
        int nr = nums.length, nc = nums.length == 0? 0: nums[0].length;
        if(nr * nc != r * c || (nr == r && nc == c))    return nums;
        int result[][] = new int[r][c];
        for(int i=0; i<nr; i++)
        {
            for(int j = 0; j<nc; j++)
            {
                int tmp =  i*nc + j + 1;
//                int ir = (tmp - 1) / c, ic = tmp - ir * c  - 1;
                int ir = (tmp - 1) / c, ic = (tmp - 1) % c;
                result[ir][ic] = nums[i][j];
            }
        }
        return result;
    }
}
