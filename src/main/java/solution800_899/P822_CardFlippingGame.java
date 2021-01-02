package solution800_899;

/**
 * Created by zjw on 2018/04/22 10:47
 * Description:
 */
public class P822_CardFlippingGame {

    public static int flipgame(int[] fronts, int[] backs) {
        int n = fronts.length;
        boolean[] sameCard = new boolean[2005];

        for(int i = 0; i < n; i++) {
            if(fronts[i] == backs[i]) {
                sameCard[fronts[i]] = true;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(!sameCard[fronts[i]]) {
                min = Math.min(min, fronts[i]);
            }
            if(!sameCard[backs[i]]) {
                min = Math.min(min, backs[i]);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        System.out.println(flipgame(new int[]{1,2,4,4,7}, new int[]{1,3,4,1,3}));
    }

}
