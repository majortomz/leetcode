package solution400_499;

/**
 * Created by zjw on 2018/02/07 9:36
 * Description:
 */
public class P458_PoorPigs {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int r = minutesToTest / minutesToDie;

        return (int)Math.ceil(Math.log10(buckets) / Math.log10(minutesToTest / minutesToDie));
    }

}
