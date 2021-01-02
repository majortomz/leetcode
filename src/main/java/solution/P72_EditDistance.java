package solution;

import java.util.Arrays;

/**
 * Created by zhou on 2017/3/28.
 */
public class P72_EditDistance {

    // Method of LCS, wrong answer
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0 || word2.length() == 0)
            return Math.max(word1.length(), word2.length());
        int l1 = word1.length(), l2 = word2.length(), i, j;
        int table[][] = new int[l1+1][l2+1], c[][] = new int[l1+1][l2+1];
        int step = 0, last1 = 0, last2 = 0;
        for(i=0; i<l1; i++)
        {
            for(j=0; j<l2; j++)
            {
                if(word1.charAt(i) == word2.charAt(j)){
                    c[i+1][j+1] = c[i][j] + 1;
                    table[i][j] = 0;
                }
                else if(c[i][j+1] >= c[i+1][j]) {
                    c[i+1][j+1] = c[i][j+1];
                    table[i][j] = 1;
                }
                else{
                    c[i+1][j+1] = c[i+1][j];
                    table[i][j] = 2;
                }
            }
        }
        System.out.println(c[l1][l2]);
        for(i=l1-1, j=l2-1; i>=0 && j>=0;) {
            if(table[i][j] == 0)
            {
                i--; j--;
                step += Math.max(last1, last2);
                last1 = 0;
                last2 = 0;
            }
            else if(table[i][j] == 1)
            {
                i--;
                last1++;
            }
            else {
                j--;
                last2++;
            }
        }
        System.out.println(last1 + " " + j);
        if(i < 0 )
            step += Math.max(last1, j+1);
        else if(j < 0)
            step += Math.max(last2, i+1);
        return step;
    }

    //
    public int minDistance2(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length(), i, j;
        int table[][] = new int[l1+1][l2+1], c[][] = new int[l1+1][l2+1];
        for(i=0; i<=l1; i++)
            table[i][0] = i;
        for(j=0; j<=l2; j++)
            table[0][j] = j;
        for(i=0; i<l1; i++)
        {
            for(j=0; j<l2; j++)
            {
                if(word1.charAt(i) == word2.charAt(j))
                    table[i+1][j+1] = table[i][j];
                else {
                    int min = Math.min(table[i][j+1], table[i+1][j]);
                    min = Math.min(min, table[i][j]);
                    table[i+1][j+1] = min + 1;
                }
            }
        }
        return table[l1][l2];
    }

    public static void main(String[] args) {
        P72_EditDistance pe = new P72_EditDistance();
        String word1 = "mart", word2 = "karma";
        System.out.println(pe.minDistance(word1, word2));
    }
}
