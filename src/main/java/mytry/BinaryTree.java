package mytry;
import java.util.LinkedList;

//二叉树中的节点
class TNode {
	public int key;
	public String value;
	public TNode left, right, pre;

	public TNode(int key) {
		this.key = key;
	}
}

public class BinaryTree {
	// attribute
	private TNode root;

	public BinaryTree(TNode root) {
		root.pre = root.left = root.right = null;
		this.root = root;
	}

	// hierarchical traverse
	public void hTraverse() {
		LinkedList<TNode> lt = new LinkedList<TNode>();
		LinkedList<TNode> result = new LinkedList<TNode>();
		lt.add(root);
		while (!lt.isEmpty()) {
			TNode cNode = lt.removeFirst();
			result.addLast(cNode);
			if (cNode.left != null)
				lt.addLast(cNode.left);
			if (cNode.right != null)
				lt.addLast(cNode.right);
		}
		for (TNode tNode : result) {
			System.out.print(tNode.key + " ");
		}
		System.out.println();
	}

	// insert a node into the tree
	public void insert(TNode node) {
		TNode y = null, x = this.root;
		while (x != null) {
			y = x;
			if (node.key < x.key)
				x = x.left;
			else
				x = x.right;
		}
		node.pre = y;
		if (y == null)
			this.root = node;
		else if (node.key < y.key)
			y.left = node;
		else
			y.right = node;
	}

	// search the tree node whose key equals the key we specify
	public TNode search(int key) {
		TNode cNode = this.root; // current node
		while (cNode != null && cNode.key != key) {
			if (key < cNode.key)
				cNode = cNode.left;
			else
				cNode = cNode.right;
		}
		return cNode;
	}

	// get the tree node which has the minimum key value
	public TNode findMinimum(TNode cNode) {
		if (cNode == null)
			return null;
		while (cNode.left != null) {
			cNode = cNode.left;
		}
		return cNode;
	}

	// get the successor of a specific tree node
	public TNode successor(TNode node) {
		if (node.right != null)
			return this.findMinimum(node);
		TNode preN = node.pre;
		while (preN != null && node == preN.right) {
			node = preN;
			preN = preN.pre;
		}
		return preN;
	}

	// let the tree whose root is ynode replace the tree whose root is xnode
	private void transplant(TNode xnode, TNode ynode) {
		if (xnode.pre == null)
			this.root = ynode;
		else if (xnode == xnode.pre.left)
			xnode.pre.left = ynode;
		else
			xnode.pre.right = ynode;
		if (ynode != null)
			ynode.pre = xnode.pre;
	}

	//
	public TNode delete(TNode node) {
		if (node.left == null)
			this.transplant(node, node.right);
		else if (node.right == null)
			this.transplant(node, node.left);
		else {
			// 找到后继结点
			TNode sNode = this.findMinimum(node.right);
			if (sNode.pre != node) {
				this.transplant(sNode, sNode.right);
				sNode.right = node.right;
				sNode.right.pre = sNode;
			}
			this.transplant(node, sNode);
			sNode.left = node.left;
			sNode.left.pre = node.left;
		}
		node.left = node.right = node.pre = null;
		return node;
	}

	public static void main(String[] args) {
		TNode rootN = new TNode(15);
		BinaryTree bTree = new BinaryTree(rootN);
		LinkedList<TNode> lt = new LinkedList<TNode>();
		lt.add(rootN);
		int arr[] = { 6, 18, 3, 7, 17, 20, 2, 13, 9, 4 };
		for (int i = 0; i < arr.length; i++) {
			TNode node = new TNode(arr[i]);
			bTree.insert(node);
			lt.addLast(node);
		}
		bTree.delete(lt.get(5));
		bTree.hTraverse();
	}
}
