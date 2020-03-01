package solution800_899;

/**
 * Created by zjw on 2018/04/22 9:47
 * Description:
 */
public class P820_ShortEncodingOfWords {

    class TreeNode {
        TreeNode[] childs = new TreeNode[26];
    }

    class Trie {
        TreeNode root = new TreeNode();

        int num = 0;

        public void insert(String s) {
            TreeNode cur = root;
            char[] words = s.toCharArray();
            for(int i = words.length - 1; i >= 0; i--) {
                char c = words[i];
                if(cur.childs[c - 'a'] == null) {
                    cur.childs[c - 'a'] = new TreeNode();
                }
                cur = cur.childs[c - 'a'];
            }
        }

        public int count() {
            num = 0;
            dfs(root, 0);
            return num;
        }

        private void dfs(TreeNode root, int depth) {
            int count = 0;
            for(TreeNode child : root.childs) {
                if(child != null) {
                    dfs(child, depth + 1);
                    count++;
                }
            }
            if(count == 0)
                num += (depth + 1);
        }
    }


    public int minimumLengthEncoding(String[] words) {
        if(words == null || words.length == 0) {
            return 0;
        }
        Trie dict = new Trie();
        for(String word : words) {
            dict.insert(word);
        }
        return dict.count();
    }

    public static void main(String[] args) {
        P820_ShortEncodingOfWords ps = new P820_ShortEncodingOfWords();
        System.out.println(ps.minimumLengthEncoding(new String[]{"time", "kme", "me", "bell"}));
    }
}
