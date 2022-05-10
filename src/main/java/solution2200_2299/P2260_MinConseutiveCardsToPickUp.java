package solution2200_2299;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zjw on 2022/05/04 18:07
 * Description:
 */
public class P2260_MinConseutiveCardsToPickUp {

    public int minimumCardPickup(int[] cards) {
        if (cards == null || cards.length <= 1) {
            return -1;
        }
        int[][] map = new int[cards.length][2];
        for (int i = 0; i < cards.length; i++) {
            map[i][0] = cards[i];
            map[i][1] = i;
        }
        Arrays.sort(map, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if (o1[0] != o2[0]) {
                            return o1[0] - o2[0];
                        }
                        return o1[1] - o2[1];
                    }
                }
        );
        int min = cards.length + 1;
        for (int i = 1; i < map.length; i++) {
            if (map[i][0] == map[i - 1][0]) {
                min = Math.min(min, map[i][1] - map[i - 1][1] + 1);
                if (min == 2) {
                    break;
                }
            }
        }
        return min == cards.length + 1 ? -1 : min;
    }

    public int minimumCardPickup2(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = cards.length + 1;
        for (int i = 0; i < cards.length; i++) {
            Integer index = map.get(cards[i]);
            if (index != null) {
                min = Math.min(min, i - index + 1);
            }
            map.put(cards[i], i);
        }
        return min == cards.length + 1 ? -1 : min;
    }
}
