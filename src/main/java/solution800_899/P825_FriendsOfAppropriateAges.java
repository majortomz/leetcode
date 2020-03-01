package solution800_899;

import java.util.Arrays;

/**
 * Created by zjw on 2018/04/29 9:49
 * Description:
 */
public class P825_FriendsOfAppropriateAges {

    public static int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        System.out.println(Arrays.toString(ages));

        int count = 0;
        for(int i = 0; i < ages.length; i++) {
            // 跳过相同的数，，同时记录相同的数的个数
            int num = 1;
            while(i + 1 < ages.length && ages[i] == ages[i + 1]) {
                i++;
                num++;
            }
            // 右边界肯定是age[i]， 左边界 0.5 * ages[i] + 7
            int min = ages[i] / 2 + 7;
            if(min >= ages[i]) {
                continue;
            }
            // 二分查找左边界，  binarySearch如果找不到则返回负数（-index - 1）
            int k = Arrays.binarySearch(ages, 0, i, min);
            if(k < 0) {
                k = -(k + 1);
            }
            while(k < ages.length && ages[k] == min) {
                k++;
            }
            count += ((i - k) * num);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numFriendRequests(new int[]{56,117,42,55,100,27,97,113,56,57,117,13,42,119,67}));  // 48
    }
}
