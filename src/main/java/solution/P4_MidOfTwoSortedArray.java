package solution;

/**
 * Created by zjw on 2017/6/16 16:30.
 */
public class P4_MidOfTwoSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int k = (nums1.length + nums2.length) / 2;
        if((nums1.length + nums2.length) % 2 == 0)
            return (findK(nums1, nums2, k) + findK(nums1, nums2, k+1))/2.0;
        else
            return findK(nums1, nums2, k);
    }

    public int findK(int[] nums1, int[] nums2, int k) {
        int ms = 0, me = nums1.length, ns = 0, ne = nums2.length;
        while(true) {
            if(ns > ne) {
                return nums1[ms + k - 1];
            }
            if(ms > me){
                return nums2[ns + k - 1];
            }
            int midA = ms + (me - ms) / 2, midB = ns + (ne - ns) / 2;
            int lenA = midA - ms + 1, lenB = midB - ns + 1;
            if(k < lenA + lenB) {
                if(nums1[midA] >= nums2[midB]) {
                    me = midA - 1;
                } else {
                    ne = midB - 1;
                }
            } else {
                if(nums1[midA] >= nums2[midB]) {
                    k -= lenB;
                    ns = midB + 1;
                } else {
                    k -= lenA;
                    ms = midA + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 23, 59, 100}, nums2 = {3, 22, 25, 66};
        P4_MidOfTwoSortedArray pm = new P4_MidOfTwoSortedArray();
        for(int i = 1; i <= nums1.length + nums2.length; i++) {
            System.out.println(pm.findK(nums1, nums2, i));
        }
    }

}
