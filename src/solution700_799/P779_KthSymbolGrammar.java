package solution700_799;

/**
 * Created by zjw on 2018/02/04 10:32
 * Description:
 */
public class P779_KthSymbolGrammar {

    public int kthGrammar(int N, int K) {

        if(N == 1) {
            return 0;
        }
        int[] helper = new int[N + 1];
        helper[N] = K;
        for(int i = N - 1; i >= 2; i--) {
            helper[i] = (helper[i + 1] + 1) / 2;
        }
        int prev = 0;
        for(int i = 2; i <= N; i++) {
            if(helper[i] % 2 == 0) {
                prev = 1 - prev;
            }
        }
        return prev;
    }

    public static void main(String[] args) {
        P779_KthSymbolGrammar pk = new P779_KthSymbolGrammar();
        System.out.println(pk.kthGrammar(4, 5));
    }
}
