package solution300_399;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zjw on 2018/01/05 16:11
 * Description:
 */
public class P394_DecodeString {

    public String decodeString(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        Stack<String> chars = new Stack<>();
        List<Integer> number = new LinkedList<>();
        char[] words = s.toCharArray();
        for(int i = 0; i < words.length; ) {
            if('0' <= words[i] && words[i] <= '9') {
                // handle digit
                int num = 0;
                while(i < words.length && '0' <= words[i] && words[i] <= '9') {
                    num = num * 10 + words[i] - '0';
                    i++;
                }
                number.add(num);
            } else if('a' <= words[i] && words[i] <= 'z' || 'A' <= words[i] && words[i] <= 'Z') {
                // handle character
                StringBuilder sb = new StringBuilder();
                while(i < words.length && ('a' <= words[i] && words[i] <= 'z' || 'A' <= words[i] && words[i] <= 'Z')) {
                    sb.append(words[i]);
                    i++;
                }
                chars.push(sb.toString());
            } else if(words[i] == ']') {
                // handle ']'
                int count= number.remove(number.size() - 1);
                StringBuilder top = new StringBuilder(), builder = new StringBuilder();
                while(!chars.empty()) {
                    if(chars.peek().equals("[")) {
                        chars.pop();
                        break;
                    } else {
                        top.insert(0, chars.pop());
                    }
                }
                while(count > 0) {
                    builder.append(top);
                    count--;
                }
                chars.push(builder.toString());
                i++;
            } else {
                chars.push("[");
                i++;
            }
        }
        StringBuilder result = new StringBuilder();
        for(String item : chars) {
            result.append(item);
        }
        return result.toString();
    }

}

class Solution2 {

    int i = 0;
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        while(i < s.length()) {
            if(Character.isDigit(s.charAt(i))) {
                int num = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i++;  // '['
                String tmp = decodeString(s);
                while(num > 0) {
                    result.append(tmp);
                    num--;
                }
            } else if(Character.isLetter(s.charAt(i))) {
                result.append(s.charAt(i++));
            } else if(s.charAt(i++) == ']') {
                return result.toString();
            }
        }
        return result.toString();
    }
}
