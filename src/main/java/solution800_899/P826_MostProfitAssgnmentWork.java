package solution800_899;

/**
 * Created by zjw on 2018/04/30 9:42
 * Description:
 */
public class P826_MostProfitAssgnmentWork {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxProfit = 0;
        int[] mem = new int[100001];
        for(int i = 0; i < difficulty.length; i++) {
            mem[difficulty[i]] = Math.max(mem[difficulty[i]], profit[i]);
        }

        for(int i = 1; i < mem.length; i++) {
            mem[i] = Math.max(mem[i - 1], mem[i]);
        }

        for(int work : worker) {
            maxProfit += mem[work];
        }
        return maxProfit;
    }

}
