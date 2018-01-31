package solution400_499;

/**
 * Created by zjw on 2018/01/31 9:54
 * Description:
 */
public class P433_MinimumGeneticMutation {

    public int minMutation(String start, String end, String[] bank) {
        int sd = getStringEncoding(start), ed = getStringEncoding(end);
        int[] bankD = new int[bank.length];
        for(int i = 0; i < bank.length; i++) {
            bankD[i] = getStringEncoding(bank[i]);
        }

        return helper(ed, bankD, sd, 0, new boolean[bank.length]);
    }

    private int helper(int ed, int[] bankD, int curD, int count, boolean[] isVisited) {
        if(curD == ed) {
            return count;
        }
        int res = Integer.MAX_VALUE;
        boolean found = false;
        for(int i = 0; i < bankD.length; i++) {
            if(isVisited[i] || !isOneCharDiff(curD, bankD[i]))    continue;
            isVisited[i] = true;
            int tmp = helper(ed, bankD, bankD[i], count + 1, isVisited);
            if(tmp != -1) {
                found = true;
                res = Math.min(res, tmp);
            }
            isVisited[i] = false;
        }
        return found ? res : -1;
    }

    private boolean isOneCharDiff(int a, int b) {
        int count = 0;
        for(int i = 1; i <= 8; i++) {
            if((a & 3) != (b & 3)) {
                count++;
            }
            a >>>= 2;
            b >>>= 2;
        }
        return count == 1;
    }

    private int getStringEncoding(String str) {
        int res = 0;
        for(char c : str.toCharArray()) {
            res = res << 2;
            switch(c) {
                case 'A': res |= 0; break;
                case 'C': res |= 1; break;
                case 'G': res |= 2; break;
                case 'T': res |= 3; break;
            }
        }
        return res;
    }

}
