package solution300_399;

import java.util.*;

/**
 * Created by zjw on 2017/11/26 16:02.
 */
public class P310_MinimumHeightTree {

    // TLE: 传递闭包
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n <= 0 || edges == null)
            return new ArrayList<>();
        int[][] dis = new int[n][n];
        int[] depth = new int[n];
        for(int i = 0; i < edges.length; i++) {
            dis[edges[i][0]][edges[i][1]] = 1;
            dis[edges[i][1]][edges[i][0]] = 1;
        }

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = i+1; j < n; j++) {
                    if(i == j || dis[i][k] == 0 || dis[k][j] == 0)
                        continue;
                    int disNew = dis[i][k] + dis[k][j];
                    dis[j][i] = dis[i][j] = dis[i][j] == 0 ? disNew : Math.min(dis[i][j], disNew);
                }
            }
            // printMatrix(dis);
        }

        int minDepth = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            depth[i] = 0;
            for(int j = 0; j < n; j++) {
                if(dis[i][j] != 0 && depth[i] < dis[i][j]) {
                    depth[i] = dis[i][j];
                }
            }
            minDepth = Math.min(minDepth, depth[i]);
        }
//        System.out.println(minDepth);

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(depth[i] == minDepth) {
                res.add(i);
            }
        }
        return res;
    }

    // TLE 广搜
    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        if(n <= 0 || edges == null) {
            return new ArrayList<>();
        }

        // init map
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for(int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        // calculate
        int minDepth = Integer.MAX_VALUE;
        int[] depth = new int[n];
        for(int i = 0; i < n; i++) {
            depth[i] = 0;

            int[] queue = new int[n];
            boolean[] visited = new boolean[n];
            queue[0] = i;
            int index = 0, size = 1, dis = 0;
            while(size < n) {
                dis++;
                int oldSize = size;
                while(index < oldSize) {
                    visited[queue[index]] = true;
                    for(Integer neighbor : map.get(queue[index])) {
                        if(!visited[neighbor]) {
                            queue[size++] = neighbor;
                        }
                    }
                    index++;
                }
            }
            depth[i] = dis;
            minDepth = Math.min(dis, minDepth);
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < depth.length; i++) {
            if(depth[i] == minDepth)
                result.add(i);
        }
        return result;
    }

    // from leetcode discussion, 目的：找到处于最中间的结点, 策略：不断删除叶子节点，直到只剩下一到两个节点，
    public List<Integer> findMinHeightTree3(int n, int[][] edges) {
        if(n < 0 || edges == null) {
            return new ArrayList<>();
        } else if(n == 1) {
            return new ArrayList<>(Arrays.asList(0));
        }

        // init graph
        List<Set<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(graph.get(i).size() == 1)    leaves.add(i);
        }

        while(n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int i : leaves) {
                int index = graph.get(i).iterator().next();
                graph.get(index).remove(i);
                if(graph.get(index).size() == 1) {
                    newLeaves.add(index);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    public void printMatrix(int[][] dis) {
        int m = dis.length, n = dis[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(dis[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
