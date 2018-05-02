package newcoder.huawei;

/**
 * Created by zjw on 2018/04/24 10:18
 * Description:
 */
public class IntToChinese {

    // 一千零二万五千八百
    public static String iToChinese(String num) {
        if(num.length() == 0 || num.length() > 12)   return "";

        char[] digits = {'零', '一', '二', '三', '四', '五', '六', '七', '八', '九'};
        String[] postfix = {"", "十", "百", "千"};
        String[] words = {"", "万", "亿"};

        int len = num.length(), i = 0;
        StringBuilder sb = new StringBuilder();
        // 将四位作为分隔
        while(i < num.length()) {
            int count = len % 4 == 0 ? 4 : len % 4;  // 当前位对应的数字
            for(int k = 0; k < count; k++) {
                int c = num.charAt(i + k) - '0';
                // 是 0 的话就不用读
                if(c == 0)  continue;
                // 判断是否需要读0, 如果当前位不是0,且前面出现了0就需要读 零
                if(k > 0 && num.charAt(i + k - 1) == '0')
                    sb.append(digits[0]);
                // 读取digit, 处理十位， 十位为1的话，不需要读一
                if(count != 2 || c != 1)
                    sb.append(digits[c]);
                // 加上后缀，如 千、百、十，各位不用读
                sb.append(postfix[count - k - 1]);
            }
            sb.append(words[(len - 1) / 4]);
            i += count;
            len -= count;
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        iToChinese("10259211200");
        iToChinese("12");
        iToChinese("4");
    }
}
