package solution100_199;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2018/04/20 14:52
 * Description:
 */
public class P140_WordBreak2 {
    // dp[i] 表示 [i..n]能否word break
    private boolean[] dp;
    int n;

    public List<String> wordBreak(String s, List<String> wordDict) {
        dp = new boolean[s.length() + 1];
        List<String> list = new ArrayList<>();

        n = s.length();
        // calculate dp
        dp[n] = true;
        for(int i = n - 1; i >= 0; i--) {
            for(int j = n; j > i; j--) {
                String head = s.substring(i, j);
                if(dp[j] && wordDict.contains(head)) {
                    dp[i] = true;
                }
            }
        }
        dfs(list, s, wordDict,"", 0);
        return list;
    }

    private void dfs(List<String> res, String s, List<String> wordDict, String path, int start) {
        if(!dp[start])  {
            return;
        }

        if(start >= n) {
            res.add(path);
        }

        for(String word : wordDict) {
            int nextIndex = start + word.length();
            // 当前s的前缀需要时word，并且除去word之后的剩余部分需要能够word break
            if(s.startsWith(word) && dp[nextIndex]) {
                dfs(res, s.substring(word.length()), wordDict, path.length() == 0 ? word : path + " " + word, nextIndex);
            }
        }
    }
}
