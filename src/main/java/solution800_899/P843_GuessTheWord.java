package solution800_899;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zjw on 2018/05/27 10:27
 * Description:
 */

interface Master {
    public int guess(String word);
}

public class P843_GuessTheWord {

    private int getDistance(String s1, String s2) {
        int match = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) == s2.charAt(i)) {
                match++;
            }
        }
        return match;
    }


    public void findSecretWord(String[] wordlist, Master master) {
        List<Integer> choices = new ArrayList<>();
        for(int i = 0; i < wordlist.length; i++) {
            choices.add(i);
        }

        while(true) {
            Collections.shuffle(choices);
            int guess = choices.remove(choices.size() - 1);
            int match = master.guess(wordlist[guess]);
            if(match == 6) {
                return;
            }
            List<Integer> nexts = new ArrayList<>();
            for(int choice: choices) {
                if(getDistance(wordlist[guess], wordlist[choice]) == match) {
                    nexts.add(choice);
                }
            }
            choices = nexts;
        }
    }
}
