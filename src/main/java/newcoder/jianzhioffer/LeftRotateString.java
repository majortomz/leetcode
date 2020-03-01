package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/08 13:12
 * Description: 左旋转字符串
 */
public class LeftRotateString {

    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0 || n <= 0)    return str;
        n %= str.length();
        if(n >= 1)
            return str.substring(n, str.length()) + str.substring(0, n);
        return str;
    }
}
