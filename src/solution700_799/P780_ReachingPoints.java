package solution700_799;

public class P780_ReachingPoints {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        return helper(sx, sy, tx, ty) == 1;
    }

    private int helper(int sx, int sy, int tx, int ty) {
        if(sx == sy && tx == ty)
            return 1;
        else if(Math.abs(sx + sy) > Math.abs(tx) || Math.abs(sx + sy) > Math.abs(ty)) {
            return 0;
        }
        int count = 0;
        count += helper(sx + sy, sy, tx, ty);
        count += helper(sx, sx + sy, tx, ty);
        return count;
    }

}
