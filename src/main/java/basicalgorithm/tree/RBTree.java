package basicalgorithm.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zjw on 2021/04/11 20:01
 * Description: 红黑树实现
 * 红黑树性质：
 * - 每个节点是红色或者黑色
 * - 根节点是黑色的
 * - 每个叶子节点(NIL) 是黑色的
 * - 如果一个节点是红色的，则他的两个子节点都是黑色的
 * - 对每个节点，从改节点到其所有后代叶节点的简单路基ing上，据包含相同数目的黑色节点。
 *
 * 不考虑插入重复key的情况
 */
public class RBTree {

    private TreeNode root;
    private final TreeNode NIL = new TreeNode(null, null, null, TreeNode.Color.BLACK, -1);

    private Set<Integer> nodeSet = new HashSet<>();

    public RBTree() {
        root = NIL;
    }

    public void insert(int key) {
        insertNode(new TreeNode(NIL, NIL, NIL, null, key));
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
        node.color = TreeNode.Color.RED;
        insertFixUp(node);
    }

    private void insertFixUp(TreeNode node) {
        while (node.parent.color == TreeNode.Color.RED) {
            // node.parent.parent 一定不为NIL
            // node.parent.parent.color 一定为黑色
            if (node.parent == node.parent.parent.left) {
                // y is node's uncle (parent's sibling)
                TreeNode y = node.parent.parent.right;
                if (y.color == TreeNode.Color.RED) {              // case 1
                    node.parent.color = TreeNode.Color.BLACK;
                    y.color = TreeNode.Color.BLACK;
                    node.parent.parent.color = TreeNode.Color.RED;
                    node = node.parent.parent;
                    continue;
                } else if (node == node.parent.right) {  // case 2
                    node = node.parent;
                    leftRotate(node);
                }
                node.parent.color = TreeNode.Color.BLACK;         // case 3
                node.parent.parent.color = TreeNode.Color.RED;
                rightRotate(node.parent.parent);
            } else {
                TreeNode y = node.parent.parent.left;
                if (y.color == TreeNode.Color.RED) {
                    node.parent.color = TreeNode.Color.BLACK;
                    y.color = TreeNode.Color.BLACK;
                    node.parent.parent.color = TreeNode.Color.RED;
                    node = node.parent.parent;
                    continue;
                } else if (node == node.parent.left) {
                    node = node.parent;
                    rightRotate(node);
                }
                node.parent.color = TreeNode.Color.BLACK;
                node.parent.parent.color = TreeNode.Color.RED;
                leftRotate(node.parent.parent);
            }
        }
        root.color = TreeNode.Color.BLACK;
    }

    public TreeNode delete(int key) {
        TreeNode node = searchNode(key);
        if (node != null) {
            deleteNode(node);
        }
        return node;
    }

    private void deleteNode(TreeNode node) {
        TreeNode y = node;
        TreeNode nodeNeedFix = null;
        TreeNode.Color originColor = y.color;
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
            y.left.parent = y;
            y.color = node.color;
        }
        if (originColor == TreeNode.Color.BLACK) {
            deleteFixUp(nodeNeedFix);
        }
    }

    private void deleteFixUp(TreeNode node) {
        // node is double black
        while (node != root && node.color == TreeNode.Color.BLACK) {
            if (node == node.parent.left) {
                TreeNode brother = node.parent.right;
                if (brother.color == TreeNode.Color.RED) {        // case 1
                    brother.color = TreeNode.Color.BLACK;
                    node.parent.color = TreeNode.Color.RED;
                    leftRotate(node.parent);
                    brother = node.parent.right;
                }
                // here brother is black
                if (brother.left.color == TreeNode.Color.BLACK && brother.right.color == TreeNode.Color.BLACK) {
                    // case 2: brother's both left/right is black
                    // let node and it's brother remove one black, then node(double black) is still black, brother is red
                    // let node's parent is double black and becomes next target.
                    // note: case 1 -> case2, node's parent is red-black, while loop will break
                    brother.color = TreeNode.Color.RED;
                    node = node.parent;
                    continue;
                } else if (brother.right.color == TreeNode.Color.BLACK) {
                    // case 3: brother is black, brother's left is red, right is black
                    brother.left.color = TreeNode.Color.BLACK;
                    brother.color = TreeNode.Color.RED;
                    rightRotate(brother);
                    brother = node.parent.right;
                }
                // case4: brother is black and brother's right is red
                brother.color = node.parent.color;
                node.parent.color = TreeNode.Color.BLACK;
                brother.right.color = TreeNode.Color.BLACK;
                leftRotate(node.parent);
                node = root;
            } else {
                TreeNode brother = node.parent.left;
                if (brother.color == TreeNode.Color.RED) {
                    brother.color = TreeNode.Color.BLACK;
                    node.parent.color = TreeNode.Color.RED;
                    leftRotate(node.parent);
                    brother = node.parent.left;
                }
                if (brother.left.color == TreeNode.Color.BLACK && brother.right.color == TreeNode.Color.BLACK) {
                    brother.color = TreeNode.Color.RED;
                    node = node.parent;
                    continue;
                } else if (brother.left.color == TreeNode.Color.BLACK) {
                    brother.right.color = TreeNode.Color.BLACK;
                    brother.color = TreeNode.Color.RED;
                    leftRotate(brother);
                    brother = node.parent.left;
                }
                brother.color = node.parent.color;
                node.parent.color = TreeNode.Color.BLACK;
                brother.left.color = TreeNode.Color.BLACK;
                rightRotate(node.parent);
                node = root;
            }
        }
        node.color = TreeNode.Color.BLACK;
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

        while (treeNode.left != NIL) {
            treeNode = treeNode.left;
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

    protected void traverse(TreeNode treeNode) {
        if (treeNode == NIL) {
            return;
        }
        traverse(treeNode.left);
        System.out.print(" " + treeNode.key);
        traverse(treeNode.right);
        if (treeNode == root) {
            System.out.println("");
        }
    }


    public static void main(String[] args) {
        RBTree rbTree = new RBTree();
        rbTree.insert(5);
        rbTree.insert(3);
        rbTree.insert(1);
        rbTree.insert(4);
        rbTree.insert(2);
        rbTree.insert(9);
        rbTree.traverse(rbTree.root);

        rbTree.delete(3);
        rbTree.traverse(rbTree.root);

        rbTree.delete(9);
        rbTree.traverse(rbTree.root);

        rbTree.insert(3);
        rbTree.insert(18);
        rbTree.insert(9);
        rbTree.traverse(rbTree.root);
    }
}
