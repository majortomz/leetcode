package solution800_899;

/**
 * Created by zjw on 2018/04/01 9:53
 * Description:
 */
public class P809_ExpressiveWords {

    public int expressiveWords(String S, String[] words) {

        int count = 0;

        char[] input = S.toCharArray();
        for (String word : words) {
            char[] inputB = word.toCharArray();
            int m = 0, n = 0;
            boolean found = true;
            while (m < input.length && n < inputB.length) {
                char ca = input[m], cb = inputB[n];
                int countA = 1, countB = 1;
                if (ca != cb) {
                    found = false;
                    break;
                }
                while (m + 1 < input.length && input[m] == input[m + 1]) {
                    m++;
                    countA++;
                }
                while (n + 1 < inputB.length && inputB[n] == inputB[n + 1]) {
                    n++;
                    countB++;
                }
                if (countB > countA || (countA > countB && countA < 3)) {
                    found = false;
                    break;
                }
                m++;
                n++;
            }

            if (found && m >= input.length && n >= inputB.length) count++;
        }
        return count;
    }

}
