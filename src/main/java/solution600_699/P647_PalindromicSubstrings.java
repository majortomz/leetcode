package solution600_699;

/**
 * Created by zjw on 2017/8/21.
 */
public class P647_PalindromicSubstrings {

    public int countSubstrings(String s) {
        char[] str = s.toCharArray();
        int num = 0;
        for(int i = 0; i < str.length; i++) {
            num += 1;
            int m = i - 1, n = i + 1;
            while(m >= 0 && n < str.length && str[m] == str[n])
            {
                m--;
                n++;
                num++;
            }
            m = i;
            n = i + 1;
            while(m >= 0 && n < str.length && str[m] == str[n])
            {
                m--;
                n++;
                num++;
            }
        }
        return num;
    }

}
