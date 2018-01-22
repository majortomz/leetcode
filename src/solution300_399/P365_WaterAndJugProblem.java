package solution300_399;

/**
 * Created by zjw on 2018/01/18 16:00
 * Description:
 */
public class P365_WaterAndJugProblem {

    public boolean canMeasureWater(int x, int y, int z) {
        // given x, y and z , we can model this question as : ax + by = z, and a, b must be integer
        // we just need to know whether this equation has integer solution.
        if (z == 0) {
            return true;
        } else if (z - x >= y) {
            return z - x == y;
        }
        // 只需要判断x和y的最大公因子能否被z整除
        int mcf = Math.min(x, y), max = Math.max(x, y);
        while (mcf >= 1 && (x % mcf != 0 || y % mcf != 0)) {
            mcf--;
        }
        return mcf != 0 ? z % mcf == 0 : max == z;
    }

}
