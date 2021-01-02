package solution200_299;

/**
 * Created by zjw on 2017/10/27.
 */
public class P208_Trie {


}

class Trie {

    class Node {
        private Node[] childs = new Node[26];

        // 是否是一个单词的结尾
        private boolean flag = false;

        public Node() {}
    }

    private Node rootNode;

    /** Initialize your data structure here. */
    public Trie() {
        this.rootNode = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node curNode = rootNode;
        for(char c : word.toCharArray()) {
            int index = c - 'a';
            if(curNode.childs[index] == null) {
                curNode.childs[index] = new Node();
            }
            curNode = curNode.childs[index];
        }
        curNode.flag = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node curNode = rootNode;
        for(char c : word.toCharArray()) {
            int index = c - 'a';
            if(curNode.childs[index] == null)
                return false;
            curNode = curNode.childs[index];
        }
        return curNode.flag;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node curNode = rootNode;
        for(char c : prefix.toCharArray()) {
            int index = c - 'a';
            if(curNode.childs[index] == null)
                return false;
            curNode = curNode.childs[index];
        }
        return true;
    }
}

