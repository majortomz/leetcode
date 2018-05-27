package solution800_899;

/**
 * Created by zjw on 2018/05/06 9:41
 * Description:
 */
public class P831_MaskingPersonalInformation {

    public String maskPII(String S) {
        if(S.contains("@")) {
            return maskEmail(S.toLowerCase());
        } else {
            return maskPhone(S);
        }
    }

    public String maskEmail(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        sb.append(s.charAt(0));
        int i = 1;
        while(i < s.length() && s.charAt(i) != '@') {
            i++;
        }
        if(i >= 2) {
            sb.append("*****").append(s.charAt(i - 1));
        }
        sb.append(s.substring(i, s.length()));
        return sb.toString();
    }

    public String maskPhone(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if('0' <= c && c <= '9') {
                sb.append(c);
            }
        }
        StringBuilder res = new StringBuilder();
        String[] masks = {"", "*", "**", "***"};
        int i = sb.length() - 10;
        if(sb.length() > 10) {
            res.append("+").append(masks[i]).append("-");
        }
        res.append(masks[3]).append("-").append(masks[3]).append("-").append(sb.substring(i + 6, sb.length()));
        return res.toString();
    }

}
