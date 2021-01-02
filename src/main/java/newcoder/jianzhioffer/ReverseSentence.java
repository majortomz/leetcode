package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/08 13:19
 * Description: “student. a am I” =》 “I am a student.”
 */
public class ReverseSentence {

    public String ReverseSentence(String str) {
        if (str == null || str.trim().length() == 0) return str;
        String[] arr = str.split(" ");
        StringBuilder builder = new StringBuilder();
        boolean first = true;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!arr[i].equals("")) {
                if (!first) builder.append(" ");
                else first = false;
                builder.append(arr[i]);
            }
        }
        return builder.toString();
    }
}
