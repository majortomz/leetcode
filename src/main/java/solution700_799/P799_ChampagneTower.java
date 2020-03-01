package solution700_799;

/**
 * Created by zjw on 2018/05/28 14:09
 * Description:
 */
public class P799_ChampagneTower {

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] mem = new double[100][100];
        mem[0][0] = poured;
        for(int i = 1; i <= query_row; i++) {
            for(int j = 0; j <= i; j++) {
                if(j < i) {
                    mem[i][j] = Math.max((mem[i - 1][j] - 1) / 2, 0);
                }
                if(j > 0) {
                    mem[i][j] += Math.max((mem[i - 1][j - 1] - 1) / 2, 0);
                }
            }
        }
        return Math.min(mem[query_row][query_glass], 1);
    }

}
