package solution300_399;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2018/01/24 11:04
 * Description:
 */
public class P386_LexicographicalNumbers {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        if(n <= 0) {
            return list;
        }
        for(int i = 1; i <=9; i++) {
            helper(list, i, n);
        }
        return list;
    }

    public void helper(List<Integer> list, int num, int bound) {
        if(num <= 0 || num > bound) {
            return;
        }
        list.add(num);
        for(int i = 0; i < 10; i++) {
            int tmp = num * 10 + i;
            helper(list, tmp, bound);
        }
    }

    class Solution2 {

        public List<Integer> lexicalOrder(int n) {
            List<Integer> list = new ArrayList<>(n);
            int cur = 1;
            for(int i = 1; i <= n; i++) {
                list.add(cur);
                if(cur * 10 <= n) {
                    cur *= 10;
                } else if(cur % 10 != 9 && cur + 1 <= n) {
                    cur++;
                } else {
                    while((cur / 10) % 10 == 9) {
                        cur /= 10;
                    }
                    cur = cur / 10 + 1;
                }
            }
            return list;
        }

    }

}
