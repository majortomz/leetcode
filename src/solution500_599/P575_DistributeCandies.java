package solution500_599;

/**
 * Created by zjw on 2017/6/16 14:34.
 */
public class P575_DistributeCandies {

    public int distributeCandies(int[] candies) {
        if(candies == null || candies.length == 0)  return 0;
        int[] kinds = new int[200001];
        int count = 0;
        for(int i = 0; i < candies.length; i++) {
            int index = candies[i] + 100000;
            if(kinds[index] == 0) {
                kinds[index] = 1;
                count++;
            }
        }
        return count > candies.length / 2 ? candies.length / 2 : count;
    }
}
