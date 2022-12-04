package basicalgorithm.tree;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zjw
 * description:
 * date: 2022/12/04 17:47
 */
@Setter
@Getter
public class TreeNode {

    public enum Color {
        RED,
        BLACK
    }

    TreeNode parent;
    TreeNode left;
    TreeNode right;
    Color color;
    int key;

    public TreeNode(TreeNode parent, TreeNode left, TreeNode right, Color color, int key) {
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.color = color;
        this.key = key;
    }
}
