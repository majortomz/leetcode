package solution;

/**
 * Created by zjw on 2018/03/25 14:38
 * Description:
 */
public class P42_TrappingRainWater {

    public int trap(int[] height) {
        if(height == null || height.length <= 2)    return 0;
        int len = height.length;

        int[] leftToRight = new int[len], rightToLeft = new int[len];
        for(int i = 1; i < len; i++) {
            leftToRight[i] = Math.max(height[i - 1], leftToRight[i - 1]);
        }
        for(int i = len - 2; i >= 0; i--) {
            rightToLeft[i] = Math.max(height[i + 1], rightToLeft[i + 1]);
        }

        int water = 0;
        for(int i = len - 2; i > 0; i--) {
            int deep = Math.min(leftToRight[i], rightToLeft[i]);
            if(deep > height[i]) {
                water += deep - height[i];
            }
        }
        return water;
    }
}
