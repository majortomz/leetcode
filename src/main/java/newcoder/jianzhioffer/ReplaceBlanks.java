package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/01 15:36
 * Description: 替换空格
 */
public class ReplaceBlanks {

    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        for(int i = 0; i < len; i++) {
            if(str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

}
