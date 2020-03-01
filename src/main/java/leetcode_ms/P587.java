package leetcode_ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zjw on 2018/08/08 19:13
 * Description:
 */
public class P587 {

    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    class Vector implements Comparable<Vector>{
        int x, y;
        int dist;
        int index;

        public Vector(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
            this.dist = x * x + y * y;
        }

        @Override
        public int compareTo(Vector vb) {
            // return negative , represent va < vb;
            // 0, va == vb
            // >0, va > vb

            int tmp = crossProduct(this, vb);
            if(tmp == 0) {
                return this.dist - vb.dist;
            }
            return tmp > 0 ? -1 : 1;
        }
    }

    private int crossProduct(Vector a, Vector b) {
        return a.x * b.y - a.y * b.x;
    }

    private int crossProduct(int x1, int y1, int x2, int y2) {
        return x1 * y2 - x2 * y1;
    }

    private Point getBottomLeft(Point[] points) {
        Point p = points[0];
        for(int i = 1; i < points.length; i++) {
            if(points[i].y < p.y || (points[i].y == p.y && points[i].x == p.x)) {
                p = points[i];
            }
        }
        return p;
    }

    private List<Vector> sortByCounterClockwise(Point[] points, Point p0) {
        // sort by counterclockwise
        List<Vector> vectors = new ArrayList<>();
        for(int i = 0; i < points.length; i++) {
            if(points[i].x == p0.x && points[i].y == p0.y) {
                continue;
            }
            vectors.add(new Vector(points[i].x - p0.x, points[i].y - p0.y, i));
        }
        vectors.sort((a, b) -> (a.compareTo(b)));
        // find collinear points in the end positions
        int i = vectors.size() - 2;
        while(i >= 0 && crossProduct(vectors.get(i), vectors.get(i + 1)) == 0) {
            i--;
        }
        // reverse sort order of collinear points in the end positions
        for(int l = i + 1, h = vectors.size() - 1; l < h; l++, h--) {
            Vector tmp = vectors.get(l);
            vectors.set(l, vectors.get(h));
            vectors.set(h, tmp);
        }
        return vectors;
    }

    public List<Point> outerTrees(Point[] points) {


        if(points == null || points.length <= 3) {
            return Arrays.asList(points);
        }

        List<Point> res = new ArrayList<>();
        Point p0 = getBottomLeft(points), p1, p2;  // initially, select bottom-left point as p0;

        List<Vector> vectors = sortByCounterClockwise(points, p0);
        for(Vector vector: vectors) {
            Point p = points[vector.index];
            System.out.printf("%d %d; ", p.x, p.y);
        }
        System.out.println("\n");

        p1 = points[vectors.get(0).index];
        res.add(p0);
        res.add(p1);

        for(int i = 1; i < vectors.size(); i++) {
            Vector cur = vectors.get(i);
            p0 = res.get(res.size() - 2);
            p1 = res.get(res.size() - 1);
            p2 = points[cur.index];

            while(crossProduct(p1.x - p0.x, p1.y - p0.y, p2.x - p0.x, p2.y - p0.y) < 0) {
                res.remove(res.size() - 1);
                if(res.size() < 2) {
                    break;
                }
                p0 = res.get(res.size() - 2);
                p1 = res.get(res.size() - 1);
            }
            res.add(p2);
        }

        return res;
    }
}
