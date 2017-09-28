package solution100_199;

/**
 * Created by zjw on 2017/9/28.
 */
public class P171_ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int res = 0, multi = 1;
        for(int i = s.length() - 1; i >= 0; i--) {

            res += multi * (s.charAt(i) - 'A' + 1);
            multi *= 26;
        }
        return res;
    }

}
