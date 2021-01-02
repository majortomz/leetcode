package pdd;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by zjw on 2018/08/05 19:38
 * Description:
 */
public class P3_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), target = sc.nextInt();
        sc.nextLine();
        int[][] arr = new int[n][];
        for(int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split("\\s+");
            arr[i] = new int[line.length];
            for(int k = 0; k < line.length; k++) {
                arr[i][k] = Integer.valueOf(line[k]);
            }
        }

        System.out.println(recommendFriends(arr, target));
    }

    private static int recommendFriends(int[][] friendData, int user) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < friendData[user].length; i++) {
            map.put(friendData[user][i], 1);
        }
        int max = -1;
        int res = friendData.length + 1;
        for(int i = 0; i < friendData.length; i++) {
            if(i == user || map.containsKey(i)) {
                continue;
            }
            int cnt = 0;
            for(int j = 0; j < friendData[i].length; j++) {
                if(map.containsKey(friendData[i][j])) {
                    cnt++;
                }
            }
            if(cnt == 0) {
                continue;
            }
            if(cnt > max) {
                res = i;
                max = cnt;
            } else if(cnt == max && res > i) {
                res = i;
            }
        }

        return res == friendData.length + 1 ? -1 : res;
    }
}
