package solution800_899;

/**
 * Created by zjw on 2018/08/13 10:58
 * Description: 887. Projection Area of 3D Shapes
 */
public class P887_ProjectionOf3D {

    public int projectionArea(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int n = grid.length;
        int xy = 0;
        int[] xz = new int[n], zy = new int[n]; // top, front, left
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0) {
                    xy++;
                }
                xz[i] = Math.max(xz[i], grid[i][j]);
                zy[j] = Math.max(zy[j], grid[i][j]);
            }
        }

        int area = xy;
        for(int i = 0; i < n; i++) {
            area += xz[i];
            area += zy[i];
        }

        return area;
    }

}
