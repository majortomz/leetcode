package solution100_199;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zjw on 2017/9/29.
 */
public class P179_LargestNumber {

    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // descend
                // leetcode discussion: compare(s1+s2, s2+s1)
                if(s1.equals(s2))
                    return 0;
                int i = 0, j = 0;
                for(int k = Math.max(s1.length(),s2.length()); k >= 0; k--) {
                    int dif = s2.charAt(j) - s1.charAt(i);
                    if(dif != 0)
                        return dif;
                    i = (i + 1) % s1.length();
                    j = (j + 1) % s2.length();
                }
                return s2.length() - s1.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        if(arr[0].equals("0"))   return "0";
        for(String str : arr)
            sb.append(str);
        return sb.toString();
    }

}
