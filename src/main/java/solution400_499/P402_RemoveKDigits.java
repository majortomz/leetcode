package solution400_499;

/**
 * Created by zjw on 2018/01/27 14:07
 * Description:
 */
public class P402_RemoveKDigits {

    public String removeKdigits(String num, int k) {
        char[] digits = num.toCharArray();
        StringBuilder sb = new StringBuilder();
        int len = num.length() - k;
        for(int i = 0; i < digits.length; i++) {
            if(k == 0) {
                sb.append(num.substring(i, num.length()));
                break;
            }
            // 迭代去除掉sb末尾的大数字（需要保证数字够用，即sb.length() + digits.length - i > len）
            while(sb.length() > 0 && sb.length() + digits.length - i > len && sb.charAt(sb.length() - 1) > digits[i]) {
                k--;
                sb.deleteCharAt(sb.length() - 1);
            }
            // 保证sb的长度不超过num remove后的长度
            if(sb.length() < len) {
                sb.append(digits[i]);
            } else {
                k--;
            }
        }
        while(sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        // in case of all digits are removed
        return sb.length() == 0 ? "0" : sb.toString();
    }

}
