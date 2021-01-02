package dd;

import java.util.*;

/**
 * Created by zjw on 2018/09/18 19:54
 * Description:
 */
public class P1 {

    static class Item {
        String para;
        int index;
        int dis;

        public Item(String para, int index, int dis) {
            this.para = para;
            this.index = index;
            this.dis = dis;
        }
    }

    static Set<Character> setA = new HashSet<>(), setB = new HashSet<>();

    static {
        String ga = "qwertasdfgzxcv", gb = "yuiophjklbnm";
        for(char c : ga.toCharArray()) {
            setA.add(c);
        }
        for(char c : gb.toCharArray()) {
            setB.add(c);
        }
    }

    public static boolean isSameGroup(char a, char b) {
        return setA.contains(a) && setA.contains(b) || setB.contains(a) && setB.contains(b);
    }

    public static int editDis(char[] sa, char[] sb) {
        int la = sa.length, lb = sb.length;
        int[][] dp = new int[la + 1][lb + 1];
        for(int i = 0; i <= la; i++) {
            dp[i][0] = i * 3;
        }
        for(int j = 0; j <= lb; j++) {
            dp[0][j] = j * 3;
        }

        for(int i = 1; i <= la; i++) {
            for(int j = 1; j <= lb; j++) {
                if(sa[i -1] == sb[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + (isSameGroup(sa[i - 1], sb[j - 1]) ? 1: 2),
                            Math.min(dp[i][j - 1] + 3, dp[i - 1][j] + 3));
                }
            }
        }
        return dp[la][lb];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().trim().split(" ");
        List<Item> list = new ArrayList<>();
        for(int i = 1; i < inputs.length; i++) {
            list.add(new Item(inputs[i], i, editDis(inputs[0].toLowerCase().toCharArray(), inputs[i].toLowerCase().toCharArray())));
        }

        list.sort((a, b) -> (a.dis == b.dis ? a.index - b.index : a.dis - b.dis));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <=2 && i < list.size(); i++) {
            if(i != 0) {
                sb.append(" ");
            }
            sb.append(list.get(i).para);
        }
        System.out.println(sb.toString());
    }

}
