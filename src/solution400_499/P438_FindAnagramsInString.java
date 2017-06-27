package solution400_499;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2017/6/26 14:32.
 */
public class P438_FindAnagramsInString {

    public List<Integer> findAnagrams(String s, String p) {
        int map[] = new int[128], count[] = new int[128], matches = 0;
        int alpha = 26;
        List<Integer> res = new ArrayList<>();

        if(p.length() > s.length()) return res;

        for(int i = 0; i < p.length(); i++) {
            map[p.charAt(i)] += 1;
            count[s.charAt(i)] += 1;
        }

        for(int i = 97; i <= 122; i++) {
            if(map[i] == count[i])
                matches++;
        }

        for(int i = p.length() - 1; i < s.length(); i++) {
            if(i >= p.length()) {
                if(count[s.charAt(i)] == map[s.charAt(i)])
                    matches--;
                else if(count[s.charAt(i)] == map[s.charAt(i)] - 1)
                    matches++;
                count[s.charAt(i)] += 1;
            }

            int first = i - p.length() + 1;
            if(matches == alpha)    res.add(first);
            // update count[]
            if(count[s.charAt(first)] == map[s.charAt(first)]) {
                matches--;
            }
            else if(count[s.charAt(first)] == map[s.charAt(first)] + 1){
                matches++;
            }
            count[s.charAt(first)] -= 1;
        }
        return res;
    }

    // From leetcode discussion, O(n), elegant and concise
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length() == 0 || p.length() > s.length())  return res;

        int[] hash = new int[128];
        for(Character c : p.toCharArray())
            hash[c]++;

        int left = 0, right = 0, count = p.length();
        while(right < s.length()) {
            if(hash[s.charAt(right++)]-- >= 1) {
                count--;
            }

            if(count == 0)  res.add(left);

            if(right - left == p.length() && hash[s.charAt(left++)]++ >= 0) {
                count++;
            }
        }
        return res;
    }

}
