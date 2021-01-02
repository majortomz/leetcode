package solution100_199;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
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

    private class Solution2 {

        boolean[][] dp;

        public List<List<String>> partition(String s) {
            char[] words = s.toCharArray();
            int n = s.length();
            dp = new boolean[n][n];

            for(int j = 0; j < n; j++) {
                for(int i = 0; i <= j; i++) {
                    if(words[i] == words[j] && (j - i <= 2 || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                    }
                }
            }

            List<List<String>> res = new ArrayList<>();
            helper(s, 0, new ArrayList<>(), res);
            return res;
        }

        private void helper(String s, int start, List<String> path, List<List<String>> res) {
            if(start >= s.length()) {
                res.add(new ArrayList<>(path));
            }

            for(int i = start; i < s.length(); i++) {
                if(dp[start][i]) {
                    String head = s.substring(start, i + 1);
                    path.add(head);
                    helper(s, i + 1, path, res);
                    path.remove(path.size() - 1);
                }
            }

        }
    }

}
