package solution800_899;

/**
 * Created by zjw on 2018/05/21 10:17
 * Description:
 */
public class P836_RectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2]) && Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]);
    }

}
