package solution100_199;

import java.util.*;

/**
 * Created by zjw on 2017/9/23.
 */
public class P127_WordLadder {

    // special case: "hot", "dog", ["hot", "dog"] return 0
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;

        List<String> queue = new ArrayList<>();
        queue.add(beginWord);

        int level = 1, levelSize = 1, nextLevelSize = 0;

        while(!queue.isEmpty()) {
            String cur = queue.remove(0);
            levelSize--;

            // System.out.println(cur + " " +level);

            Iterator<String> iter = wordList.iterator();
            while(iter.hasNext()) {
                String next = iter.next();
                int diffNum = 0;
                for(int k = 0; k < beginWord.length() && diffNum <= 1; k++) {
                    if(cur.charAt(k) != next.charAt(k))
                        diffNum++;
                }
                if(diffNum == 1) {
                    if(endWord.equals(next))    return level + 1;
                    queue.add(next);
                    iter.remove();
                    nextLevelSize++;
                }
            }

            if(levelSize == 0) {
                level++;
                levelSize = nextLevelSize;
                nextLevelSize = 0;
            }
        }
        return 0;
    }

    // TLE
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        int[][] map = new int[wordList.size() + 2][wordList.size() + 2];
        int NOT_CONNECTED = -1;

        wordList.add(0, beginWord);
        wordList.add(endWord);

        Set<Integer> nodeSet = new HashSet<>();
        int start = 0, len = wordList.size();

        // cal distance
        for(int i = 0; i < wordList.size(); i++) {
            for(int j = i + 1; j < wordList.size(); j++) {
                int diffNum = 0;
                for(int k = 0; k < beginWord.length() && diffNum <= 1; k++) {
                    if(wordList.get(i).charAt(k) != wordList.get(j).charAt(k))
                        diffNum++;
                }
                if(diffNum <= 1)
                    map[i][j] = map[j][i] = diffNum;
                else
                    map[i][j] = map[j][i] = NOT_CONNECTED;
            }
        }

        nodeSet.add(start);
        int count = 1, cur = start;
        while(count < len && !nodeSet.contains(len-1)) {
            // System.out.println(cur);
            int minDis = Integer.MAX_VALUE, index = 0;

            for(int i = 0; i < len; i++) {
                // update shorted distance
                if(nodeSet.contains(i))    continue;
                if(map[cur][i] != NOT_CONNECTED && (map[start][i] == NOT_CONNECTED || map[start][i] > map[start][cur] + map[cur][i])) {
                    map[start][i] = map[start][cur] + map[cur][i];
                }
                // select next node
                if(map[start][i] != NOT_CONNECTED && map[start][i] <= minDis) {
                    minDis = map[start][i];
                    index = i;
                }
            }

            cur = index;
            if(nodeSet.contains(cur))
                break;
            nodeSet.add(cur);

            count++;
        }

        return map[start][len-1] == NOT_CONNECTED ? 0 : map[start][len-1] + 1;
    }

}
