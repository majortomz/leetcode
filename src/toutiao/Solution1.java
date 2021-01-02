package toutiao;

import java.util.*;

public class Solution1 {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        if(k == 0) {
            for(int num : nums) {
                if(map.getOrDefault(num, 0) == 1) {
                    count++;
                }
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        } else {
            for(int num: nums) {
                if(map.containsKey(num)) continue;
                if(map.containsKey(num - k)) {
                    count++;
                }
                if(map.containsKey(k + num)) {
                    count++;
                }
                map.put(num, 1);
            }
        }
        System.out.println(count);
    }
}
