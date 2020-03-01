package solution800_899;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

/**
 * Created by zjw on 2018/06/17 9:54
 * Description:
 */
public class P855_ExamRoom {


    class ExamRoom {
        class Space {
            int start, end;
            int length;

            public Space() {
            }

            public Space(int start, int end) {
                this.start = start;
                this.end = end;
                this.calculateLen();
            }

            public void calculateLen() {
                if(this.start == 0 || this.end == N - 1) {
                    this.length = this.end - this.start;
                } else {
                    this.length = (this.end - this.start) / 2;
                }
            }

            @Override
            public boolean equals(Object obj) {
                if(obj == null || !(obj instanceof Space)) {
                    return false;
                }
                Space s = (Space)obj;
                return s.start == this.start && s.end == this.end;
            }

            @Override
            public int hashCode() {
                int code = 17;
                code = code * 31 + start;
                code = code * 31 + end;
                code = code * 32 + length;
                return code;
            }

            @Override
            public String toString() {
                return "Space{" +
                        "start=" + start +
                        ", end=" + end +
                        '}';
            }
        }

        TreeSet<Space> set = new TreeSet<>((a, b) -> (a.start - b.start));
        Queue<Space> queue = new PriorityQueue<>((a, b) -> (a.length == b.length ? a.start - b.start : b.length - a.length));
        int N;

        public ExamRoom(int N) {
            Space space = new Space(0, N - 1);
            queue.offer(space);
            set.add(space);
            this.N = N;
        }

        public int seat() {
            Space cur = queue.poll();
            set.remove(cur);
            if(cur.start == cur.end) {
                return cur.start;
            }
            if(cur.start == 0) {
                Space space = new Space(cur.start + 1, cur.end);
                queue.offer(space);
                set.add(space);
                return cur.start;
            } else if(cur.end == N - 1) {
                Space space = new Space(cur.start, cur.end - 1);
                queue.offer(space);
                set.add(space);
                return cur.end;
            } else {
                int mid = cur.start + (cur.end - cur.start) / 2;
                if(cur.start != mid) {
                    Space space = new Space(cur.start, mid - 1);
                    queue.offer(space);
                    set.add(space);
                }
                if(cur.end != mid) {
                    Space space = new Space(mid + 1, cur.end);
                    queue.offer(space);
                    set.add(space);
                }
                return mid;
            }
        }

        public void leave(int p) {
            Space space = new Space(p, p);
            Space left = set.lower(space);
            Space right = set.higher(space);
            if(left != null && left.end == p - 1) {
                space.start = left.start;
                queue.remove(left);
                set.remove(left);
            }
            if(right != null && right.start == p + 1) {
                space.end = right.end;
                queue.remove(right);
                set.remove(right);
            }
            space.calculateLen();
            queue.add(space);
            set.add(space);
        }
    }

}
