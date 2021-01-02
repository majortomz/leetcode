package solution800_899;

/**
 * Created by zjw on 2018/04/08 9:30
 * Description:
 */
public class P812_LargestTriangleArea {

    public double largestTriangleArea(int[][] points) {
        double max = 0;
        for(int i = points.length - 3; i >= 0; i--) {
            int[] pa = points[i];

            for(int j = points.length - 2; j > i; j--) {
                int[] pb = points[j];
                for(int k = points.length - 1; k > j; k--) {
                    int[] pc = points[k];
                    double area = 0.5 * Math.abs(pa[0] * (pb[1] - pc[1]) + pb[0] * (pc[1] - pa[1]) + pc[0] * (pa[1] - pb[1]));
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

}
