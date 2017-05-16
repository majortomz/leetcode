package solution100_199;

/**
 * Created by zjw on 2017/5/12.
 */

/*
    1) 1 2 3 4 5
    2) 5 4 3 2 1
    3)
*/

//只用考虑最低点，每次寻找小于等于当前最低点的下一个最低点，同时在这过程中更新max
public class P121_BestTimeBuyandSell {

    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i=1; i<prices.length; i++)
        {
            if(prices[i] < prices[i-1])
                continue;
            int minI = i-1, maxI = i, tmp;
            for(int j = i + 1; j<prices.length; j++)
            {
                if(prices[j] <= prices[minI])    break;
                if(prices[j] >= prices[maxI])    maxI = j;
            }
            tmp = prices[maxI] - prices[i-1];
            max = tmp>max? tmp: max;
            if(minI != i-1)     i = minI;
            else    i = maxI;
        }
        return max;
    }

    // From leetcode discussion, more concise and easy to understand
    public int maxProfit2(int[] prices) {
        if(prices.length == 0)  return 0;
        int max = 0, sofarMin = prices[0];
        for(int i=1; i<prices.length; i++)
        {
            if(prices[i] > sofarMin)
                max = Math.max(max, prices[i] - sofarMin);
            else
                sofarMin = prices[i];
        }
        return max;
    }

}
