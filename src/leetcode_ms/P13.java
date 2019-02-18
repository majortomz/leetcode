package leetcode_ms;

/**
 * Created by zjw on 2018/08/04 9:32
 * Description:
 */
public class P13 {

    public int romanToInt(String s) {

        int i = 0, n = s.length();
        int res = 0;
        while(i < n) {
            char c = s.charAt(i);
            if(c == 'I') {
                if(i + 1 < n && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                    res -= 1;
                } else {
                    res += 1;
                }
            } else if(c == 'V') {
                res += 5;
            } else if(c == 'X') {
                if(i + 1 < n && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                    res -= 10;
                } else {
                    res += 10;
                }
            } else if(c == 'L') {
                res += 50;
            } else if(c == 'C') {
                if(i + 1 < n && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                    res -= 100;
                } else {
                    res += 100;
                }
            } else if(c == 'D') {
                res += 500;
            } else if(c == 'M') {
                res += 1000;
            }
            i++;
        }
        return res;
    }

}
