package toutiao.second;

import java.util.Scanner;

public class P4 {

    static char[] query, doc;
    static int maxScore = Integer.MIN_VALUE;

    public static void main(String[] args) {
//        Scanner sc = new Scanner("mbh\namhbyghdc\n");
        Scanner sc = new Scanner(System.in);

        query = sc.next().toCharArray();
        doc = sc.next().toCharArray();

        maxScore = Integer.MIN_VALUE;
        dfs(0, 0, 0, -1);

        System.out.println(maxScore == Integer.MIN_VALUE ? 0 : maxScore);
    }

    public static void dfs(int indexQ, int indexD, int score, int lastIndex) {
        if(indexQ >= query.length || indexD >= doc.length) {
            return;
        }

        while(indexD < doc.length) {
            if(query[indexQ] == doc[indexD]) {
                if(indexQ == query.length - 1) {
                    maxScore = Math.max(maxScore, 100 - (lastIndex == -1 ? 0 : score + indexD - lastIndex - 1));
                } else {
//                    System.out.println(indexD - lastIndex - 1);
                    dfs(indexQ + 1, indexD + 1, lastIndex == -1 ? 0 : score + indexD - lastIndex - 1, indexD);
                }
            }
            indexD++;
        }

    }

}
