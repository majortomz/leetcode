package solution800_899;

/**
 * Created by zjw on 2018/06/10 9:31
 * Description:
 */
public class P848_ShiftingLetters {

    public String shiftingLetters(String S, int[] shifts) {
        StringBuilder sb = new StringBuilder();
        char[] words = S.toCharArray();

        int count = 0;
        for(int i = words.length - 1; i >= 0; i--) {
            if(i >= shifts.length) {
                sb.append(words[i]);
            } else {
                count += shifts[i];
                count %= 26;
                sb.append((char)('a' + (words[i] - 'a' + count) % 26));
            }
        }

        return sb.reverse().toString();
    }

}
