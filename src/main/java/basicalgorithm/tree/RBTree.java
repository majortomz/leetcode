package basicalgorithm.tree;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by zjw on 2021/04/11 20:01
 * Description: 红黑树实现
 * 红黑树性质：
 */
public class RBTree {

    private TreeNode root;
    private final TreeNode NIL = new TreeNode(null, null, null, Color.BLACK, 0);


    public void insert(int key) {

    }

    private void insertNode(TreeNode node) {
        TreeNode y = NIL;
        TreeNode x = root;
        while (x != NIL) {
            y = x;
            if (node.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        node.parent = y;
        if (y == NIL) {
            root = node;
        } else if (node.key < y.key) {
            y.left = node;
        } else {
            y.right = node;
        }
        node.left = NIL;
        node.right = NIL;
        node.color = Color.RED;

    }

    private void insertFixUp(TreeNode node) {
        while (node.parent.color == Color.RED) {
            // node.parent.parent 一定不为NIL
            // node.parent.parent.color 一定为黑色
            if (node.parent == node.parent.parent.left) {
                TreeNode y = node.parent.parent.right;
                if (y.color == Color.RED) {              // case 1
                    node.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    node = node.parent.parent;
                    continue;
                } else if (node == node.parent.right) {  // case 2
                    node = node.parent;
                    leftRotate(node);
                }
                node.parent.color = Color.BLACK;         // case 3
                node.parent.parent.color = Color.RED;
                rightRotate(node.parent.parent);
            } else {
                TreeNode y = node.parent.parent.left;
                if (y.color == Color.RED) {
                    node.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    node.parent.parent.color = Color.BLACK;
                    node = node.parent.parent;
                    continue;
                } else if (node == node.parent.left) {
                    node = node.parent;
                    rightRotate(node);
                }
                node.parent.color = Color.BLACK;
                node.parent.parent.color = Color.RED;
                leftRotate(node.parent.parent);
            }
        }
        root.color = Color.BLACK;
    }

    private TreeNode delete(int key) {
        TreeNode node = searchNode(key);
        if (node != null) {
            deleteFixUp(node);
        }
        return node;
    }

    private void deleteNode(TreeNode node) {
        TreeNode y = node;
        TreeNode nodeNeedFix = null;
        Color originColor = y.color;
        if (node.left == NIL) {
            nodeNeedFix = node.right;
            transPlant(node, node.right);
        } else if (node.right == NIL) {
            nodeNeedFix = node.left;
            transPlant(node, node.left);
        } else {
            y = minimum(node.right);   // y.left一定为NIL
            originColor = y.color;
            nodeNeedFix = y.right;
            if (y.parent == node) {
                nodeNeedFix.parent = y;
            } else {
                transPlant(y, y.right);
                y.right = node.right;
                y.right.parent = y;
            }
            transPlant(node, y);
            y.left = node.left;
            y.left.parent = y.parent;
            y.color = node.color;
        }
        if (originColor == Color.BLACK) {
            deleteFixUp(nodeNeedFix);
        }
    }

    private void deleteFixUp(TreeNode node) {
        while (node != root && node.color == Color.BLACK) {
            if (node == node.parent.left) {
                TreeNode brother = node.parent.right;
                if (brother.color == Color.RED) {
                    brother.color = Color.BLACK;
                    node.parent.color = Color.RED;
                    leftRotate(node.parent);
                    brother = node.parent.right;
                }
                if (brother.left.color == Color.BLACK && brother.right.color == Color.BLACK) {
                    brother.color = Color.RED;
                    node = node.parent;
                } else if (brother.right.color == Color.BLACK) {
                    brother.left.color = Color.BLACK;
                    brother.color = Color.RED;
                    rightRotate(brother);
                    brother = node.parent.right;
                }
                brother.color = node.parent.color;
                node.parent.color = Color.BLACK;
                brother.right.color = Color.BLACK;
                leftRotate(node.parent);
                node = root;
            } else {
                TreeNode brother = node.parent.left;
                if (brother.color == Color.RED) {
                    brother.color = Color.BLACK;
                    node.parent.color = Color.RED;
                    leftRotate(node.parent);
                    brother = node.parent.left;
                }
                if (brother.left.color == Color.BLACK && brother.right.color == Color.BLACK) {
                    brother.color = Color.RED;
                    node = node.parent;
                } else if (brother.left.color == Color.BLACK) {
                    brother.right.color = Color.BLACK;
                    brother.color = Color.RED;
                    leftRotate(brother);
                    brother = node.parent.left;
                }
                brother.color = node.parent.color;
                node.parent.color = Color.BLACK;
                brother.left.color = Color.BLACK;
                rightRotate(node.parent);
                node = root;
            }
        }
        node.color = Color.BLACK;
    }

    private TreeNode searchNode(int key) {
        TreeNode node = root;
        while (node != NIL) {
            if (key == node.key) {
                return node;
            } else if ( key < node.key) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

    private TreeNode minimum(TreeNode treeNode) {
        if (treeNode == NIL) {
            return NIL;
        }

        if (treeNode.left != NIL) {
            return minimum(treeNode.left);
        } else if (treeNode.right != NIL) {
            return minimum(treeNode.right);
        }
        return treeNode;
    }

    /**
     * 完整的替换一个子树
     * @param oldSubTree
     * @param newSubTree
     */
    private void transPlant(TreeNode oldSubTree, TreeNode newSubTree) {
        if (oldSubTree.parent == NIL) {
            root = newSubTree;
        } else if (oldSubTree == oldSubTree.parent.left) {
            oldSubTree.parent.left = newSubTree;
        } else {
            oldSubTree.parent.right = newSubTree;
        }
        newSubTree.parent = oldSubTree.parent;  // 无条件执行，即使newSubTree 为NIL节点
    }

    /**
     * 左旋, 目标节点的右边节点不能为空节点
     * 涉及6个操作
     * x, y, p, a
     * x.right = y; x.parent = p; y.left = a
     * @param node node is x, rightSon is y
     */
    private void leftRotate(TreeNode node) {
        TreeNode rightSon = node.right;           //  get y
        node.right = rightSon.left;               //  set x's new right  = a
        if (rightSon.left != NIL) {
            rightSon.left.parent = node;          //  set a's new parent = x
        }
        rightSon.parent = node.parent;            //  set y's new parent = p
        if (node.parent == NIL) {
            root = rightSon;                      //  update root
        } else if (node == node.parent.left) {    //  update p's new son = y
            node.parent.left = rightSon;
        } else {
            node.parent.right = rightSon;
        }
        rightSon.left = node;                      // update y's new left
        node.parent= rightSon;                     // update x's new parent
    }

    /**
     * 右旋，目标节点的左边节点不能为空节点
     * 跟左旋一样，涉及6个操作
     * x, y, p, a
     * x.left = y; x.parent = p; y.right = a
     * @param node node is x, leftSon is y
     */
    private void rightRotate(TreeNode node) {
        TreeNode leftSon = node.left;               // get y
        node.left = leftSon.right;                  // set x's new left
        if (leftSon.right != NIL) {
            leftSon.right.parent = node;            // set a's new parent
        }
        leftSon.parent = node.parent;               // set y's new parent = p
        if (node.parent == NIL) {
            root = leftSon;                         // update root
        } else if (node.parent.left == node) {      // set p's new son
            node.parent.left = leftSon;
        } else {
            node.parent.right = leftSon;
        }
        leftSon.right = node;                       // set y's new right
        node.parent = leftSon;                      // set x's new parent
    }

    @Setter
    @Getter
    private static class TreeNode {
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

    private enum Color {
        RED,
        BLACK
    }
}
