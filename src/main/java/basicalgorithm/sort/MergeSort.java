package basicalgorithm.sort;

import java.util.Arrays;

/**
 * Created by zjw on 2018/03/06 16:16
 * Description: 归并排序
 */
public class MergeSort {

    public static void sort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int lt, int rt) {
        if(lt >= rt) return;
        int mid = lt + (rt - lt) / 2;
        mergeSort(a, lt, mid);
        mergeSort(a, mid + 1, rt);
        merge(a, lt, mid, rt);
    }

    private static void merge(int[] a, int lt, int mid, int rt) {
        int[] left = Arrays.copyOfRange(a, lt, mid + 1);
        int[] right = Arrays.copyOfRange(a, mid + 1, rt + 1);
        int i = 0, j = 0;
        while(i < left.length || j < right.length) {
            if(i >= left.length) {
                a[lt++] = right[j++];
            } else if(j >= right.length) {
                a[lt++] = left[i++];
            } else {
                if(left[i] <= right[j]) a[lt++] = left[i++];
                else a[lt++] = right[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {5, 4, 3, 10, 2, 64, 532, 5, 17, 99};
        MergeSort.sort(test);
        System.out.println(Arrays.toString(test));
    }
}
