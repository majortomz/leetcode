package mytry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zjw on 2018/03/11 12:26
 * Description:
 */
public class Permutation {

    public static List<List<Integer>> cal(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        if(arr == null || arr.length == 0)  return res;
        res.add(new ArrayList<>());
        for(int i = 1; i <= arr.length; i++) {
            List<List<Integer>> tmpRes = new ArrayList<>();
            for(List<Integer> list : res) {
                for(int m = 0; m < arr.length; m++) {
                    boolean found = false;
                    for(int n = 0; n < list.size(); n++) {
                        count++;
                        if(arr[m] == list.get(n)) {
                            found = true;
                            break;
                        }
                    }
                    if(!found) {
                        List<Integer> tmpList = new ArrayList<>(list);
                        tmpList.add(arr[m]);
                        tmpRes.add(tmpList);
                    }
                }
            }
            res = tmpRes;
        }
        long fact = 1;
        for(int i = 1; i <= arr.length; i++)
            fact *= i;
        System.out.println(count + " " + 1.0 * count / fact );
        return res;
    }

    public static List<List<Integer>> dfs(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        if(arr == null || arr.length == 0)  return res;
        helper(res, arr, arr.length);
        return res;
    }

    public static void helper(List<List<Integer>> res, int[] arr, int n) {
        if(n == 0) {
            List<Integer> list = new ArrayList<>();
            for(int i = arr.length - 1; i >= 0; i--) {
                list.add(arr[i]);
            }
            res.add(list);
        }

        for(int i = 0; i < n; i++) {
            int tmp = arr[i];
            arr[i] = arr[n - 1];
            arr[n - 1] = tmp;
            helper(res, arr, n - 1);
            arr[n - 1] = arr[i];
            arr[i] = tmp;
        }
    }

    public static void main(String[] args) {

        for(int i = 1; i <= 10; i++) {
            // init data
            int[] arr = new int[i];
            for(int k = 0; k < i; k++) {
                arr[k] = k + 1;
            }
            long startTime = System.nanoTime();
            Permutation.cal(arr);
//            System.out.println(Permutation.dfs(arr));
            long endTime = System.nanoTime();
            System.out.println(i + " " + (endTime - startTime) / 1000) ;
        }

    }

}
