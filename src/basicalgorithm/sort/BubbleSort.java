package basicalgorithm.sort;

/**
 * Created by zjw on 2018/03/06 15:36
 * Description: 冒泡排序
 */
public class BubbleSort {

    public static void sort(int[] a) {
        int N = a.length;
        for(int i = N - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(a[j] >= a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }

}
