package solution700_799;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by zjw on 2017/12/6.
 */
public class P737_SentenceSimilarity2 {

    private int[] sim = new int[1001];

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if(words1 == null || words2 == null || words1.length != words2.length) {
            return false;
        }

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < sim.length; i++) {
            sim[i] = i;
        }

        for(String[] pair : pairs) {
            if(!map.containsKey(pair[0]))   map.put(pair[0], map.size());
            if(!map.containsKey(pair[1]))   map.put(pair[1], map.size());

            int indexA = map.get(pair[0]), indexB = map.get(pair[1]);
            // path compression
            int rootA = findRoot(indexA), rootB = findRoot(indexB);
            if(rootA != rootB) {
                sim[rootB] = rootA;
            }
        }

        for(int i = 0; i < words1.length; i++) {
            if(words1[i].equals(words2[i]))
                continue;
            if(!map.containsKey(words1[i]) || !map.containsKey(words2[i]))
                return false;
            int indexA = map.get(words1[i]), indexB = map.get(words2[i]);
            int rootA = findRoot(indexA), rootB = findRoot(indexB);
            if(rootA != rootB)
                return false;
        }
        return true;
    }

    private int findRoot(int x) {
        int p = x, root;
        // find root
        while(sim[p] != p) {
            p = sim[p];
        }
        root = p;
        // path compression
        while(x != root) {
            p = sim[x]; sim[x] = root; x = p;
        }
        return root;
    }

}
