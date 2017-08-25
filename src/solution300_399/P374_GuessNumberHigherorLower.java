package solution300_399;

/**
 * Created by zjw on 2017/8/23.
 */
public class P374_GuessNumberHigherorLower {

    public int guess(int num) {
        return 0;
    }

    public int guessNumber(int n) {
        int target = 0, lt = 1, rt = n;
        while(lt <= rt) {
            target = lt + (rt - lt) / 2;
            // target = (lt + rt) / 2 may overflow
            int flag = guess(target);
            if(flag == 0)
                break;
            if(flag == -1) {
                rt = target - 1;
            }
            else {
                lt = target + 1;
            }
        }
        return target;
    }

}
