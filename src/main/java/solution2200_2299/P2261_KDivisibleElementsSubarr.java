package solution2200_2299;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zjw on 2022/05/04 18:26
 * Description:
 */
public class P2261_KDivisibleElementsSubarr {

    // rabin-karp rolling hash
    public int countDistinct(int[] nums, int k, int p) {
        Set<Long> fp = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            long hash = 0;
            for (int j = i; j < nums.length; j++) {
                count += (nums[j] % p == 0 ? 1 : 0);
                if (count <= k) {
                    hash = (hash * 199 + nums[j]);
                    fp.add(hash);
                }
            }
        }
        return fp.size();
    }

    // trie
    public int countDistinct2(int[] nums, int k, int p) {
        int MAX = 201;
        int res = 0;
        List<int[]> list = new ArrayList<>();
        list.add(new int[MAX]);
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int node = 0;
            for (int j = i; j < nums.length; j++) {
                count += (nums[j] % p == 0 ? 1 : 0);
                if (count <= k) {
                    if (list.get(node)[nums[j]] == 0) {
                        res++;
                        list.get(node)[nums[j]] = list.size();
                        list.add(new int[MAX]);
                    }
                    node = list.get(node)[nums[j]];
                } else {
                    break;
                }
            }
        }
        return res;
    }


}
