package solution800_899;

/**
 * Created by zjw on 2018/05/21 10:36
 * Description:
 */
public class P838_PushDominoes {

    public String pushDominoes(String dominoes) {
        if(dominoes == null || dominoes.length() == 0) {
            return dominoes;
        }
        int n = dominoes.length();
        char[] res = dominoes.toCharArray();
        int[] disToLeft = new int[n];
        disToLeft[n - 1] = res[n - 1] == 'L' ? 0 : Integer.MAX_VALUE;
        for(int i = n -2; i >= 0; i--) {
            if(res[i] == 'L') {
                disToLeft[i] = 0;
            } else if(res[i] == 'R') {
                disToLeft[i] = Integer.MAX_VALUE;
            } else {
                disToLeft[i] = disToLeft[i + 1] == Integer.MAX_VALUE ? Integer.MAX_VALUE : disToLeft[i + 1] + 1;
            }
        }

        int disToRight = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(res[i] == 'L') {
                disToRight = Integer.MAX_VALUE;
            } else if(res[i] == 'R') {
                disToRight = 0;
            } else {
                disToRight = disToRight == Integer.MAX_VALUE ? disToRight : disToRight + 1;
                if(disToRight < disToLeft[i]) {
                    res[i] = 'R';
                } else if(disToRight > disToLeft[i]) {
                    res[i] = 'L';
                }
            }
        }
        return new String(res);
    }

}
