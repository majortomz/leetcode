package solution800_899;

import java.util.Arrays;

/**
 * Created by zjw on 2018/08/14 16:21
 * Description:
 */
public class P885_BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        if(people == null || people.length == 0) {
            return 0;
        }
        Arrays.sort(people);

        int lo = 0, hi = people.length - 1;
        int boats = 0;
        while(lo <= hi) {
            boats++;
            if(people[lo] + people[hi] <= limit) {
                lo++;
            }
            hi--;
        }
        return boats;
    }

}
