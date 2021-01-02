package solution;

/**
 * Created by zjw on 2017/5/23.
 */
public class P88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n, la = 0, lb = 0;
        for(int i=0; i < len; i++)
        {
            // nums2 到头了
            if(lb >= n)
                break;
            // nums1到头了
            else if(la >= m) {
                nums1[i] = nums2[lb];
                lb++;
                continue;
            }
            // nums1当前元素小于等于nums2当前元素
            else if(nums1[i] <= nums2[lb]) {
                la++;
                continue;
            }
            // nums1当前元素大于nums2当前元素
            else {
                int index = lb;
                while(index < n && nums1[i] > nums2[index])
                    index++;
                int count = index - lb;
                // 将nums1 [i, m+lb-1] 的元素向后挪动count
                for(int j = m + lb - 1; j >= i; j--)
                    nums1[j + count] = nums1[j];
                // nums1 [i, i+count) 中间插入nums2[lb, lb+count)
                for(int k = 0; k < count; k++)
                    nums1[i + k] = nums2[lb + k];
                lb = index;
                i = i + count - 1;
            }
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1, ia = m - 1, ib = n - 1;
        while(ia >= 0 && ib >= 0)
        {
            if(nums1[ia] > nums2[ib]) {
                nums1[index--] = nums1[ia--];
            }
            else {
                nums1[index--] = nums2[ib--];
            }
        }
        while(ib >= 0)
        {
            nums1[index--] = nums2[ib--];
        }
    }

}
