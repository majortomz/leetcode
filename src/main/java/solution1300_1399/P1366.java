package solution1300_1399;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 *
 * @author lanling.zjw date: 2020/03/07 23:51
 */
public class P1366 {

    class Element implements Comparable<Element> {

        char team;

        int[] scores;

        String finalScore;


        public Element(char team, int size) {

            this.team = team;
            this.scores = new int[size];
        }

        public void record(int rank) {
            this.scores[rank]++;
        }

        public void calculateFinal() {

            StringBuilder sb = new StringBuilder(team * 26);
            for (int i = 0; i < scores.length; i++) {
                sb.append(String.format("%05d", scores[i] * (scores.length - i)));
            }
            this.finalScore = sb.toString();
        }

        @Override
        public int compareTo(Element o) {
            int res = o.finalScore.compareTo(this.finalScore);
            return res == 0 ? this.team - o.team : res;
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

        // init team score board
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

        teams.forEach(Element::calculateFinal);

        Collections.sort(teams);

        StringBuilder res = new StringBuilder();
        teams.forEach(s -> res.append(s.team));
        return res.toString();
    }

}
