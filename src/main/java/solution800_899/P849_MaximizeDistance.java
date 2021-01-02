package solution800_899;

/**
 * Created by zjw on 2018/06/10 9:46
 * Description:
 */
public class P849_MaximizeDistance {

    public int maxDistToClosest(int[] seats) {
        int leftIndex = -1;
        int dis = 0;

        for(int i = 0; i < seats.length; i++) {
            if(seats[i] == 1) {
                if(leftIndex != -1) {
                    dis = Math.max((i - leftIndex) / 2, dis);
                } else {
                    dis = i;
                }
                leftIndex = i;
            }
        }
        if(seats[seats.length - 1] == 0) {
            dis = Math.max(dis, seats.length - 1 - leftIndex);
        }
        return dis;
    }

}
