package solution100_199;

import java.util.List;

/**
 * Created by zjw on 2017/5/25.
 */
public class P124_Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)    return 0;
        int arr[] = new int[triangle.size()];
        int res;
        for(int i=0; i < triangle.size(); i++)
        {
            List<Integer> hie = triangle.get(i);
            int pre = arr[0], last = hie.size() - 1;
            arr[0] = hie.get(0) + arr[0];
            for(int j = 1; j < last; j++)
            {
                int tmp = arr[j];
                arr[j] = Math.min(pre, arr[j]) + hie.get(j);
                pre = tmp;
            }
            arr[last] = pre + hie.get(last);
        }
        res = arr[0];
        for(int i = 1; i<arr.length; i++)
            res = Math.min(res, arr[i]);
        return res;
    }
}
