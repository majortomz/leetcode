package basicalgorithm.sort;

/**
 * Created by zjw on 2018/03/06 20:23
 * Description: 基于切分的快速选择算法
 */
public class KthByQsort {

    public static int select(int[] a, int k) {
        k--;
        if(k < 0 || k >= a.length)   return 0;
        int lo = 0, hi = a.length - 1;
        while(lo <= hi) {
            int p = partition(a, lo, hi);
            if(p == k)  return a[p];
            else if(p > k) hi = p - 1;
            else lo = p + 1;
        }
        return a[k];
    }

    private static int partition(int[] a, int lo, int hi) {
        int x = a[hi], i = lo - 1;
        for(int j = i + 1; j < hi; j++) {
            if(a[j] < x) {
                i++;
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
            }
        }
        a[hi] = a[i + 1];
        a[i + 1] = x;
        return i + 1;
    }

    public static void main(String[] args) {
        for(int k = 1; k <= 10; k++) {
            int[] test = {5, 4, 3, 10, 2, 64, 532, 5, 17, 99};
            System.out.println(KthByQsort.select(test, k));
        }
    }

}
