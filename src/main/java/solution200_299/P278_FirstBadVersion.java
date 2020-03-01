package solution200_299;

/**
 * Created by zjw on 2017/11/1.
 */
public class P278_FirstBadVersion {

    public int firstBadVersion(int n) {
        int lt = 1, rt = n;
        while(lt < rt) {
            int mid = lt + (rt - lt) / 2;
            if(isBadVersion(mid)) {
                rt = mid;
            } else {
                lt = mid + 1;
            }
        }
        return lt;
    }

    private boolean isBadVersion(int n) {
        return arr[n];
    }

    boolean[] arr =  {false,  false, false, true, true, true};
    public static void main(String[] args) {
        P278_FirstBadVersion test = new P278_FirstBadVersion();
        System.out.println(test.firstBadVersion(3));
    }

}
