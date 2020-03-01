package solution300_399;

import java.util.*;

/**
 * Created by zjw on 2017/7/15.
 */
public class P347_TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0)    return res;

        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int pre: nums) {
            hash.put(pre, hash.getOrDefault(pre, 0));
        }

        int[] arr = new int[hash.size()];
        int i = 0;
        for(Integer freq: hash.values()) {
            arr[i] = freq;
            i++;
        }
        Arrays.sort(arr);

        int index = arr.length - k;
        for(Integer key : hash.keySet()) {
            if(hash.get(key) >= arr[index])
                res.add(key);
        }
        return res;
    }

    public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0)    return res;

        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int pre: nums) {
            hash.put(pre, hash.getOrDefault(pre, 0) + 1);
        }

//        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(nums.length, new Comparator<Map.Entry>() {
//            @Override
//            public int compare(Map.Entry o1, Map.Entry o2) {
//                return (Integer)o2.getValue() - (Integer)o1.getValue();
//            }
//        });
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(nums.length,
                (x, y) -> y.getValue() - x.getValue());

        for(Map.Entry entry:  hash.entrySet()) {
            queue.add(entry);
        }

        for(int i = 1; i <= nums.length; i++) {
            System.out.println(queue.peek().getKey() + " " + queue.peek().getValue());
            res.add(queue.poll().getKey());
        }
        return res;
    }


}
