package basicalgorithm.sort;

/**
 * Created by zjw on 2018/03/06 15:32
 * Description: 插入排序
 */
public class InsertionSort {

    public static void sort(int[] a) {
        int N = a.length;
        for(int i = 1; i < N; i++) {
            for(int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                swap(a, j, j - 1);
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
