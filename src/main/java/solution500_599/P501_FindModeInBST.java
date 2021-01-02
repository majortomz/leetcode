package solution500_599;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zjw on 2017/3/30.
 */
public class P501_FindModeInBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Solution1： 使用map
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        traverse(root, map);
        int max = 0, i = 0;
        int[] result = new int[map.keySet().size()];
//        ArrayList<Integer> list = new ArrayList<>();
        for (Integer val : map.values())
            max = val > max ? val : max;
        for (Integer key : map.keySet()) {
            if (map.get(key) == max) {
                result[i] = key;
                i++;
            }
        }
        return Arrays.copyOfRange(result, 0, i);
    }

    public void traverse(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        traverse(root.left, map);
        traverse(root.right, map);
    }

    // Solution2 : recursive version，使用list
    private int prev;
    private int max;
    private int count;
    public int[] findMode2(TreeNode root) {
        prev = 0;
        max = 0;
        count = 0;
        List<Integer> list = new ArrayList<>();
        traverse2(root, list);
        int res[] = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            res[i] = list.get(i);
        return res;
    }

    public void traverse2(TreeNode root, List<Integer> list) {
        if(root == null)    return;
        traverse2(root.left, list);
        // 更新prev和count
        if(root.val != prev)
        {
            prev = root.val;
            count = 1;
        }
        else
            count++;
        //更新max和max对应的列表
        if(count > max) {
            max = count;
            list.clear();
            list.add(prev);
        }
        else if(count == max)
            list.add(prev);
        traverse2(root.right, list);
    }
}
