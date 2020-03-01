package solution100_199;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zjw on 2018/09/06 15:52
 * Description:
 */
public class P146_LRUCache {

    class LRUCache {

        class Node {
            Node prev, next;
            int key;
            int val;

            public Node() {
            }

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }

        }

        Map<Integer, Node> map;
        Node head = null, tail = null;
        int capacity = 0;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if(!map.containsKey(key)) {
                return -1;
            }
            Node cur = map.get(key);

            removeNode(cur);
            addHead(cur);

//            print();
            return cur.val;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)) {
                Node cur = map.get(key);
                cur.val = value;

                removeNode(cur);
                addHead(cur);
            } else {
                Node node = new Node(key, value);
                if(map.size() >= capacity) {
                    map.remove(tail.key);
                    removeNode(tail);
                    addHead(node);
                } else {
                    addHead(node);
                }
                map.put(key, node);
            }
        }

        public void removeNode(Node cur) {
            if(cur.prev != null) {
                cur.prev.next = cur.next;
            } else {
                head = cur.next;
            }

            if(cur.next != null) {
                cur.next.prev = cur.prev;
            } else {
                tail = cur.prev;
            }
        }

        public void addHead(Node cur) {
            cur.next = head;
            cur.prev = null;

            if(head != null) {
                head.prev = cur;
            }
            head = cur;

            if(tail == null) {
                tail = head;
            }
        }

        public void print() {
            StringBuilder sb = new StringBuilder();
            Node cur = head;
            int i = 0;
            while(i < map.size()) {
                sb.append(cur.key).append(" ");
                i++;
                cur = cur.next;
            }
            System.out.println(sb.toString());
        }
    }

}
