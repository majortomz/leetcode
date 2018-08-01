package solution800_899;

import java.util.Arrays;

/**
 * Created by zjw on 2018/07/29 9:46
 * Description:
 */
public class P877_StoneGame {


    public static boolean stoneGame(int[] piles) {
        int[][] cache = new int[piles.length][piles.length];
        return helper(piles, cache, 0, piles.length - 1) > 0;
    }

    public static int helper(int[] piles, int[][] cache, int low, int high) {
        if (low > high) {
            return 0;
        }

        if (cache[low][high] != 0) {
            return cache[low][high];
        }

        int a = piles[low] - piles[high] + helper(piles, cache, low + 1, high - 1);
        int b = piles[low] - piles[low + 1] + helper(piles, cache, low + 2, high);
        int c =  piles[high] - piles[low] + helper(piles, cache, low + 1, high - 1);
        int d =  piles[high] - piles[high - 1] + helper(piles, cache, low, high - 2);
        cache[low][high] = Math.max(Math.min(a, b), Math.min(c, d));
        return cache[low][high];
    }

    public static void main(String[] args) {
        int[] arr = {7, 7, 12, 16, 41, 48, 41, 48, 11, 9, 34, 2, 44, 30, 27, 12, 11, 39, 31, 8, 23, 11, 47, 25, 15, 23, 4, 17, 11, 50, 16, 50, 38, 34, 48, 27, 16, 24, 22, 48, 50, 10, 26, 27, 9, 43, 13, 42, 46, 24};
//        int[] arr = {7, 8, 8, 10};
//        int[] arr = {4,3,4,3,2,5};
        System.out.println(stoneGame(arr));
    }
}
