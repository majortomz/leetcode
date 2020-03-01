package solution800_899;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zjw on 2018/05/21 22:20
 * Description:
 */
public class P839_SimilarStringGroups {

    // 并查集的变种？
    public int numSimilarGroups(String[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] map = new int[n];
        for(int i = 0; i < n; i++) {
            map[i] = i;
        }
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int rootI = findRoot(map, i), rootJ = findRoot(map, j);
                if(rootI != rootJ) {
                    if(isSimilar(A[i], A[j])) {
                        map[rootJ] = rootI;
                    }
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(findRoot(map, i));
            System.out.print(map[i] + " ");
        }
        System.out.println();
        return set.size();
    }

    private int findRoot(int[] map, int i) {
        int root = i;
        while(map[root] != root) {
            root = map[root];
        }
        while(map[i] != root) {
            int next = map[i];
            map[i] = root;
            i = next;
        }
        return root;
    }

    private boolean isSimilar(String sa, String sb) {
        int mark = -1;
        int n = sa.length();
        char ca = ' ', cb = ' ';
        for(int i = 0; i < n; i++) {
            if(sa.charAt(i) == sb.charAt(i)) {
                continue;
            }
            if(mark == -1) {
                mark = 0;
                ca = sb.charAt(i);
                cb = sa.charAt(i);
            } else if(mark == 0) {
                if(sa.charAt(i) != ca || sb.charAt(i) != cb) {
                    return false;
                }
                mark = 1;
            } else {
                return false;
            }
        }
        return mark != 0;
    }

}
