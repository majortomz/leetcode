package zhaohang;

import java.util.*;

public class Problem2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        set.add(0);

        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean found  = false;
            for(int i = 1; i <= size; i++) {
                int cur = queue.poll();
                System.out.println(cur);
                if(cur == n) {
                    found = true;
                    break;
                }
                if(!set.contains(cur + 1)) {
                    set.add(cur + 1);
                    queue.add(cur + 1);
                }
                if(!set.contains(cur - 1)) {
                    set.add(cur - 1);
                    queue.add(cur - 1);
                }
                if(!set.contains(cur * 2)) {
                    set.add(cur * 2);
                    queue.add(cur * 2);
                }
            }
            if(found)   break;
            step++;
        }
        System.out.println(step);
    }
}
