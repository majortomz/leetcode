package leetcode_ms;

/**
 * Created by zjw on 2018/08/04 20:17
 * Description:
 */
public class P208 {

    class Trie {
        class TreeNode {
            TreeNode[] childs = new TreeNode[26];
            boolean end = false;
        }

        TreeNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TreeNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TreeNode cur = root;
            for(char c : word.toCharArray()) {
                if(cur.childs[c - 'a'] == null) {
                    cur.childs[c - 'a'] = new TreeNode();
                }
                cur = cur.childs[c - 'a'];
            }

            cur.end = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TreeNode cur = root;
            for(char c : word.toCharArray()) {
                if(cur.childs[c - 'a'] == null) {
                    return false;
                }
                cur = cur.childs[c - 'a'];
            }
            return cur.end;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TreeNode cur = root;
            for(char c: prefix.toCharArray()) {
                if(cur.childs[c - 'a'] == null) {
                    return false;
                }
                cur = cur.childs[c - 'a'];
            }
            return true;
        }
    }



}
