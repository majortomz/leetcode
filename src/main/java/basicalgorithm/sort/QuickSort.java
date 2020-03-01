package basicalgorithm.sort;

import java.util.Arrays;

/**
 * Created by zjw on 2018/03/06 16:43
 * Description: 快速排序
 */
public class QuickSort {

    public static void sort(int[] a) {
        qsort(a, 0, a.length - 1);
    }

    private static void qsort(int[] a, int lt, int rt) {
        if(lt >= rt)    return;
        int k = partition(a, lt, rt);
        qsort(a, lt, k - 1);
        qsort(a, k + 1, rt);
    }

    private static int partition(int[] a, int lt, int rt) {
        int x = a[rt], i = lt - 1;
        for(int j = lt; j <= rt - 1; j++) {
            if(a[j] <= x) {
                i += 1;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, rt);
        return i + 1;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] test = {5, 4, 3, 10, 2, 64, 532, 5, 17, 99};
        QuickSort.sort(test);
        System.out.println(Arrays.toString(test));
    }
}
