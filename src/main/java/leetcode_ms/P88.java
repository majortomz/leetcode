package leetcode_ms;

import java.util.Arrays;

/**
 * Created by zjw on 2018/07/18 10:42
 * Description:
 */
public class P88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] cp = Arrays.copyOf(nums1, nums1.length);

        int i = 0, j = 0, k = 0;
        while(i < m || j < n) {
            if(i >= m) {
                nums1[k] = nums2[j++];
            } else if(j >= n) {
                nums1[k] = cp[i++];
            } else if(cp[i] <= nums2[j]) {
                nums1[k] = cp[i++];
            } else {
                nums1[k] = nums2[j++];
            }
            k++;
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        m -= 1;
        n -= 1;
        while(k >= 0) {
            if(m < 0) {
                nums1[k] = nums2[n--];
            } else if(n < 0) {
                break;
            } else if(nums1[m] >= nums2[n]) {
                nums1[k] = nums1[m--];
            } else {
                nums1[k] = nums2[n--];
            }
            k--;
        }
    }

}
