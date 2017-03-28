package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zjw on 2017/3/27.
 */
public class P68_TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int num = 0, base = 0, other, len;
        int i, j, k;
        StringBuilder blanks;
        for(i=0; i<words.length; i++) {
            num = 0;
            len = maxWidth;
            blanks = new StringBuilder();
            StringBuilder sb = new StringBuilder(maxWidth);
            // 找到当前行可以插入的单词的下标[i, k]， 退出时j = k+1
            for (j = i; j < words.length && len >= words[j].length(); j++) {
                num++;
                len = len - words[j].length() - 1;
            }
            // 处理三种不同情况下，分隔单词的空格数目
            if(j == words.length)
            {
                // 当前行是最后一行
                blanks.append(" ");
                other = 0;
            }
            else if(num > 1){
                // 当前行的单词个数大于1
                num--;
                len = len + num + 1;
                base = len / num;
                for(k = 1; k<=base; k++)
                    blanks.append(" ");
                other= len % num;
            }
            else {
                // 当前行的单词个数为1， 则无须有空格
                other = 0;
            }
            System.out.println(base + " " + other);
            for (k = i; k<j; k++)
            {
                sb.append(words[k]);
                if(k < j-1)
                    sb.append(blanks);
                if(other > 0)
                {
                    other--;
                    sb.append(" ");
                }
                System.out.println(sb.toString());
            }
            while(sb.length() < maxWidth)
                sb.append(" ");
            result.add(sb.toString());
            i=j-1;
        }
        return result;
    }

    public static void main(String[] args) {
        P68_TextJustification pt = new P68_TextJustification();
        String[] st = {"This", "is", "an", "example", "of", "text", "justification."};
//        String [] st = {""};
        System.out.println(pt.fullJustify(st, 16));
    }
}
