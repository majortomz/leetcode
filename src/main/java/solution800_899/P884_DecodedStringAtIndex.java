package solution800_899;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2018/08/14 16:32
 * Description:
 */
public class P884_DecodedStringAtIndex {

    class Item {
        int x, y;
        long prevCount;
        long count;

        public Item(int x, int y, long prevCount, long count) {
            this.x = x;
            this.y = y;
            this.prevCount = prevCount;
            this.count = count;
        }
    }


    public String decodeAtIndex(String S, int K) {
        boolean prevChar = true;
        List<Item> list = new ArrayList<>();
        Item cur = new Item(0, 0, 0, 1);
        list.add(cur);

        for(int i = 1; i < S.length() && cur.count < K; i++) {
            char c = S.charAt(i);
            if('a' <= c && c <= 'z') {
                if(prevChar) {
                    cur.y++;
                    cur.count++;
                } else {
                    long prevCount = cur.count;
                    cur = new Item(i, i, prevCount, prevCount + 1);
                    list.add(cur);
                }
                prevChar = true;
            } else {
                prevChar = false;
                cur.count *= (c - '0');
            }
        }

        K -= 1;
        String res = "";
        for(int i = list.size() - 1; i >= 0; i--) {
            cur = list.get(i);
            K %= (cur.prevCount + cur.y - cur.x + 1);
            if(K >= cur.prevCount) {
                K -= cur.prevCount;
                res = S.substring(cur.x, cur.y + 1).substring(K, K + 1);
                break;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        P884_DecodedStringAtIndex pd = new P884_DecodedStringAtIndex();
        System.out.println(pd.decodeAtIndex("ixm5xmgo78", 711));
    }
}
