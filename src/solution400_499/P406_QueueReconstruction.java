package solution400_499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zjw on 2018/01/27 15:14
 * Description:
 */
public class P406_QueueReconstruction {

    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0) {
            return people;
        }
        Arrays.sort(people, (a, b) -> (b[0] == a[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < people.length; i++) {
            int count = people[i][1];
            list.add(count, people[i]);
        }
        return list.toArray(people);
    }

}
