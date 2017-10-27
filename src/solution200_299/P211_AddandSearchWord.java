package solution200_299;

/**
 * Created by zjw on 2017/10/27.
 */
public class P211_AddandSearchWord {

}

class WordDictionary {

    private WordNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new WordNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        WordNode curNode = root;
        int len = word.length();
        curNode.setMaxLength(Math.max(curNode.getMaxLength(), len));
        for(char c : word.toCharArray()) {
            int index = c - 'a';
            if(curNode.childs[index] == null) {
                curNode.childs[index] = new WordNode(c);
            }
            curNode = curNode.childs[index];
            curNode.setMaxLength(Math.max(curNode.getMaxLength(), len--));
        }
        curNode.setWordTag(true);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchHelper(root, word.toCharArray(), 0);
    }

    private boolean searchHelper(WordNode root, char[] words, int start) {
        if(start >= words.length) {
            return root.isWord();
        }

        int len = words.length - start;

        WordNode[] childs;
        if(words[start] == '.') {
            childs = root.childs;
        } else {
            childs = new WordNode[]{root.childs[words[start] - 'a']};
        }

        for(WordNode node : childs) {
            if(node == null || node.getMaxLength() < len)
                continue;
            if(searchHelper(node, words, start + 1))
                return true;
        }
        return false;
    }

}

class WordNode {

    public WordNode[] childs;

    private char value;

    private boolean flag;

    private int maxLength;

    public WordNode() {
        this.childs = new WordNode[26];
    }

    public WordNode(char value) {
        this.value = value;
        this.childs = new WordNode[26];
    }

    public char getValue() {
        return this.value;
    }

    public boolean isWord() {
        return flag;
    }

    public void setWordTag(boolean isWord) {
        this.flag = isWord;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }
}
