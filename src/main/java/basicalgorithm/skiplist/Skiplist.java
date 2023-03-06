package basicalgorithm.skiplist;

/**
 * @author zjw
 * description:
 * date: 2023/03/05 16:08
 */
public class Skiplist {

    public static final int MAX_LEVEL = 10;
    public static final double RANDOM_RATIO = 0.5;

    private int levelNum;
    private Node head;
    private double random = RANDOM_RATIO;
    private int maxLevel = MAX_LEVEL;

    private static class Node {
        int val;
        Node[] next;

        public Node(int val, int maxLevel) {
            this.val = val;
            this.next = new Node[maxLevel];
        }

    }

    public Skiplist() {
        maxLevel = MAX_LEVEL;
        random = RANDOM_RATIO;
        head = new Node(Integer.MIN_VALUE, maxLevel);
        levelNum = 0;
    }

    public boolean search(int target) {
        Node cur = head;
        for (int i = levelNum - 1; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].val < target) {
                cur = cur.next[i];
            }
        }
        cur = cur.next[0];
        return cur != null && cur.val == target;
    }

    public void add(int num) {
        Node cur = head;
        for (int i = levelNum - 1; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].val < num) {
                cur = cur.next[i];
            }
        }

        Node node = new Node(num, maxLevel);
        int level = randomeLevel();
        if (level > levelNum) {
            for (int i = levelNum; i < level; i++) {
                head.next[i] = node;
            }
        }
        for (int i = 0; i < levelNum; i++) {
            node.next[i] = cur.next[i];
            cur.next[i] = node;
        }
        levelNum = Math.max(level, levelNum);
    }

    public boolean erase(int num) {
        Node cur = head;
        for (int i = levelNum - 1; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].val < num) {
                cur = cur.next[i];
            }
        }

        Node target = cur.next[0];
        if (target == null || target.val != num) {
            return false;
        }
        for (int i = 0; i < levelNum; i++) {
            cur.next[i] = target.next[i];
        }
        return true;
    }

    private int randomeLevel() {
        float r = (float) Math.random();
        int level = 1;
        while (r < RANDOM_RATIO  && level < maxLevel) {
            level++;
            r = (float) Math.random();
        }
        return level;
    }

    protected void displayList() {
        System.out.println("\n*****Skip List*****");
        for (int i = 0; i < levelNum; i++) {
            Node node = head.next[i];
            System.out.print("Level " + i + ": ");
            while (node != null) {
                System.out.print(node.val + " ");
                node = node.next[i];
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
        int[] arr = {1, 2, 3, 4};
        for (int num : arr) {
            System.out.println(skiplist.search(num));
            skiplist.add(num);
            System.out.println(skiplist.search(num));
            skiplist.displayList();
        }

//        for (int num : arr) {
//            System.out.println(skiplist.search(num));
//        }
//
//        for (int num : arr) {
//            System.out.println(skiplist.search(num));
//            skiplist.erase(num);
//            System.out.println(skiplist.search(num));
//            skiplist.displayList();
//        }

    }
}
