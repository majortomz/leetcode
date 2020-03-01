package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by zjw on 2018/05/11 20:02
 * Description:
 */
public class Robot {

//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int sx = sc.nextInt(), sy = sc.nextInt(), sdir = getDirection(sc.next());
//        int ex = sc.nextInt(), ey = sc.nextInt(), edir = getDirection(sc.next());
//        int m = sc.nextInt(), n = sc.nextInt();
//        int[][] map = new int[m][n];
//        int[][] nextDirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
//        for(int i = 0; i < m; i++) {
//            for(int j = 0; j < m; j++) {
//                map[i][j] = sc.nextInt();
//            }
//        }
//
//        boolean[][][] visited = new boolean[m][n][4];
//        int count = 0;
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{sx, sy, sdir});
//        visited[sx][sy][sdir] = true;
//        while(!queue.isEmpty()) {
//            int size = queue.size();
//            boolean found = false;
//            for(int i = 0; i < size; i++) {
//                int[] cur = queue.poll();
//                //
//                if(cur[0] == ex && cur[1] == ey) {
//                    if(edir == cur[2]) {
//                        System.out.println(edir);
//                        return;
//                    } else {
//                        found = true;
//                    }
//                }
//
//                for(int j = 0; j <= 3; j++) {
//                    if(j == cur[2]) {
//                        int ni = cur[0]
//                    } else {
//                        if(!visited[cur[0]][cur[1]][j]) {
//                            queue.add(new int[]{cur[0], cur[1], j});
//                        }
//                    }
//                }
//
//            }
//            count++;
//            if(found) {
//                System.out.println(count);
//            }
//        }
//        System.out.println(65555);
//    }
//
//    public static int getDirection(String dir) {
//        switch(dir) {
//            case "EAST": return 0;
//            case "WEST": return 1;
//            case "NORTH": return 2;
//            case "SOUTH": return 3;
//        }
//    }
}
