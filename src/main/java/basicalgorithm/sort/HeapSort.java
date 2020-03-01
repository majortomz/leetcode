package basicalgorithm.sort;

import java.util.Arrays;

/**
 * Created by zjw on 2018/03/06 19:37
 * Description: 堆排序
 */
public class HeapSort {

    int size = 0;

    public void sort(int[] a) {
        size = a.length;
        buildHeap(a);
        for(int i = a.length - 1; i > 0; i--) {
            swap(a, 0, i);
            size--;
            heapify(a, 0);
        }
    }

    private void buildHeap(int[] a) {
        int i = a.length / 2;
        while(i >= 0) {
            heapify(a, i);
            i--;
        }
    }

    private void heapify(int[] a, int i) {
        if(i >= size) return;
        int left = 2 * i + 1, right = 2 * i + 2;
        int largest = i;
        if(left < size && a[i] < a[left]) {
            largest = left;
        }
        if(right < size && a[largest] < a[right]) {
            largest = right;
        }
        if(largest != i) {
            swap(a, i, largest);
            heapify(a, largest);
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] test = {5, 4, 3, 10, 2, 64, 532, 5, 17, 99};
        HeapSort sort = new HeapSort();
        sort.sort(test);
        System.out.println(Arrays.toString(test));
    }

}
