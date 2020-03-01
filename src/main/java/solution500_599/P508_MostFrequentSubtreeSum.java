package solution500_599;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zjw on 2017/5/11.
 */
public class P508_MostFrequentSubtreeSum {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int maxFreq = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        traverse(root, map);
        for(Map.Entry<Integer, Integer> item : map.entrySet()) {
            if(item.getValue() == maxFreq)
                arr.add(item.getKey());
        }
        int[] result = new int[arr.size()];
        for(int i=0; i<result.length; i++)
            result[i] = arr.get(i);
        return result;
    }

    public int traverse(TreeNode root, HashMap<Integer, Integer> map) {
        if(root == null)    return 0;
        int left = traverse(root.left, map), right = traverse(root.right, map);
        int val = root.val + left + right;
        map.put(val, map.getOrDefault(val, 0) + 1);
        maxFreq = map.get(val) > maxFreq? map.get(val) : maxFreq;
        return val;
    }
}
