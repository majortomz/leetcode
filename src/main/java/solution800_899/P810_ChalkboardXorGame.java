package solution800_899;

/**
 * Created by zjw on 2018/04/03 16:48
 * Description:
 */
public class P810_ChalkboardXorGame {

    // from leetcode discussion
    public boolean xorGame(int[] nums) {
        int xor = 0;
        for(int num : nums) {
            xor ^= num;
        }
        return xor == 0 || nums.length % 2 == 0;
    }

}
