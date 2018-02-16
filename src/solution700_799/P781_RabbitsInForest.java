package solution700_799;

import java.util.Arrays;

public class P781_RabbitsInForest {

    public int numRabbits(int[] answers) {
        if(answers == null || answers.length == 0)
            return 0;
        Arrays.sort(answers);
        int num = 0, cur = answers[0], count = answers[1];
        for(int i = 1; i < answers.length; i++) {
            if(answers[i] != cur || count == 0) {
                num += (cur + 1);
                cur = count = answers[i];
            } else {
                count--;
            }
        }
        num += (cur + 1);
        return num;
    }

}
