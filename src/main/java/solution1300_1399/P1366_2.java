package solution1300_1399;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 *
 * @author lanling.zjw date: 2020/03/08 00:39
 */
public class P1366_2 {



    class Element implements Comparable<Element> {

        char team;

        int[] scores;


        public Element(char team, int size) {

            this.team = team;
            this.scores = new int[size];
        }

        public void record(int rank) {
            this.scores[rank]++;
        }

        @Override
        public int compareTo(Element o) {
            for (int i = 0; i < this.scores.length; i++) {
                if (this.scores[i] > o.scores[i]) {
                    return -1;
                } else if (this.scores[i] < o.scores[i]) {
                    return 1;
                }
            }

            return this.team - o.team;
        }
    }

    // Rank Teams by Votes
    public String rankTeams(String[] votes) {

        if (votes == null || votes.length == 0 || votes[0] == null || votes[0].length() == 0) {
            return "";
        }

        if (votes.length == 1) {
            return votes[0];
        }

        int teamNum = votes[0].length();
        int[] posMap = new int[26];

        List<Element> teams = new ArrayList<>();

        // init team sscore board
        for (int i = 0; i < teamNum; i++) {
            teams.add(new Element(votes[0].charAt(i), teamNum));
            posMap[votes[0].charAt(i) - 'A'] = i;
        }

        // record score
        for (String vote: votes) {
            for (int i = 0; i < teamNum; i++) {
                char c = vote.charAt(i);
                teams.get(posMap[c - 'A']).record(i);
            }
        }

        Collections.sort(teams);

        StringBuilder res = new StringBuilder();
        teams.forEach(s -> res.append(s.team));
        return res.toString();
    }


}
