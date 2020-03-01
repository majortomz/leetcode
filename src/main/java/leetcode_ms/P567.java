package leetcode_ms;

/**
 * Created by zjw on 2018/08/06 20:29
 * Description:
 */
public class P567 {

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }

        char[] wa = s1.toCharArray(), wb = s2.toCharArray();
        int lenA = wa.length, lenB = wb.length;
        int[] ca = count(wa, 0, lenA - 1), cb = count(wb, 0, lenA - 1);

        if(isEqual(ca, cb)) {
            return true;
        }

        for(int i = lenA; i < lenB; i++) {
            cb[wb[i - lenA] - 'a']--;
            cb[wb[i] - 'a']++;

            if(isEqual(ca, cb)) {
                return true;
            }
        }

        return false;
    }

    private boolean isEqual(int[] ca, int[] cb) {
        int diff = 0;
        for(int j = 0; j < 26; j++) {
            if(ca[j] != cb[j]) {
                diff++;
            }
        }
        return diff == 0;
    }

    private int[] count(char[] arr, int i, int j) {
        int[] res = new int[26];
        while(i <= j && i < arr.length) {
            res[arr[i] - 'a']++;
            i++;
        }
        return res;
    }

}
