package solution500_599;

/**
 * Created by zjw on 2018/01/06 18:33
 * Description:
 */
public class P547_FriendCircles {

    int[] root;

    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }

        root = new int[M.length];
        // init
        for(int i = 0; i < root.length; i++) {
            root[i] = i;
        }
        // cal
        for(int i = 0; i < M.length; i++) {
            for(int j = i + 1; j < M.length; j++) {
                if(M[i][j] == 1) {
                    int ri = findRoot(i), rj = findRoot(j);
                    if(ri != rj) {
                        root[rj] = ri;
                    }
                }
            }
        }
        int count = 0;
        for(int i = 0; i < root.length; i++) {
            count += (root[i] == i ? 1 : 0);
        }
        return count;
    }

    private int findRoot(int x) {
        int cur = x;
        while(root[cur] != cur) {
           cur = root[cur];
        }
        int curRoot = cur;
        // path compression
        while(root[x] != curRoot) {
            int pre = root[x];
            root[x] = curRoot;
            x = pre;
        }
        return curRoot;
    }

}

class Solution2 {

    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }

        boolean[] visited = new boolean[M.length];
        int count = 0;
        for(int i = 0; i < M.length; i++) {
            if(visited[i])  continue;
            count++;
            dfs(M, visited, i);
        }
        return count;
    }

    private void dfs(int[][] M, boolean[] visited, int i) {
        if(visited[i])  return;
        visited[i] = true;
        for(int j = 0; j < M.length; j++) {
            if(M[i][j] == 0)  continue;
            dfs(M, visited, j);
        }
    }
}
