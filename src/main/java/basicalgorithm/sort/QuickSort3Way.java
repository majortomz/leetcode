package basicalgorithm.sort;

import java.util.Arrays;

/**
 * Created by zjw on 2018/03/06 19:16
 * Description: 快排，三向切分
 */
public class QuickSort3Way {

    public static void sort(int[] a) {
        qsort(a, 0, a.length - 1);
    }

    private static void qsort(int[] a, int lo, int hi) {
        if(lo >= hi)    return;
        int lt = lo, i = lo + 1, gt = hi;
        int x = a[lo];
        while(i <= gt) {
            if(a[i] < x) swap(a, lt++, i++);
            else if(a[i] > x) swap(a, i, gt--);
            else i++;
        }
        qsort(a, lo, lt - 1);
        qsort(a, gt + 1, hi);
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] test = {5, 4, 3, 10, 2, 64, 532, 5, 17, 99};
        QuickSort3Way.sort(test);
        System.out.println(Arrays.toString(test));
    }

}
