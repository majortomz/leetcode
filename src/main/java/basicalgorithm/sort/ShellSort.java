package basicalgorithm.sort;

/**
 * Created by zjw on 2018/03/06 16:02
 * Description: 希尔排序
 */
public class ShellSort {

    public static void sort(int[] a) {
        int N = a.length, h = 1;
        while(h < N / 3) {
            h = 3 * h + 1;
        }
        while(h >= 1) {
            for(int i = h; i < N; i++) {
                for(int j = i; j >= h && a[j] < a[j - h]; j -= h) {
                    int tmp= a[j  - h];
                    a[j - h] = a[j];
                    a[j] = tmp;
                }
            }
            h /= 3;
        }
    }

}
