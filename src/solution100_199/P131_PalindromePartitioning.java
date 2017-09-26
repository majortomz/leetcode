package solution100_199;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2017/9/26.
 */
public class P131_PalindromePartitioning {

    public List<List<String>> partition(String s) {
        char[] arr = s.toCharArray();

        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();

        // first, calculate all possible palindrome of s
        // use array instead of List may reduce space needed
        // we can also use dynamic programming to calculate all possible palindrome
        // dp[i][j] == true if (arr[i] == arr[j] && (j - i <= 2 || dp[i+1][j-1] == true) )
        List<List<Integer>> palindromeList = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            palindromeList.add(new ArrayList<>());
            palindromeList.get(i).add(i);

            int lt = i - 1, rt = i + 1;
            while(lt >= 0 && rt < arr.length && arr[lt] == arr[rt]) {
                palindromeList.get(lt).add(rt);
                lt--;
                rt++;
            }
            lt = i;
            rt = i + 1;
            while(lt >= 0 && rt < arr.length && arr[lt] == arr[rt]) {
                palindromeList.get(lt).add(rt);
                lt--;
                rt++;
            }
        }

        helper(res, s, path, palindromeList, 0);
        return res;
    }

    public void helper(List<List<String>> res, String str, List<String> path, List<List<Integer>> palindromeList, int start) {
        if(start >= str.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        List<Integer> subPalindrome = palindromeList.get(start);
        for(Integer lt : subPalindrome) {
            String curStr = str.substring(start, lt + 1);
            path.add(curStr);
            helper(res, str, path, palindromeList, lt + 1);
            path.remove(path.size() - 1);
        }
    }

}
