package solution800_899;

/**
 * Created by zjw on 2018/08/15 20:52
 * Description:
 */
public class P885_SpiralMatrix3 {

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int count = 1;

        res[0] = new int[]{r0, c0};

        int end = Math.max(Math.max(R - r0 - 1, r0 ), Math.max(C - c0 - 1, c0));
//        for(int len = 1; len <= end; len++) {
//            int top = Math.max(0, res - )
//        }

        return null;
    }

}
