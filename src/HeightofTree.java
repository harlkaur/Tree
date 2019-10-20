
public class HeightofTree {

	static NodeTree root;
	public static void main(String[] args) {
		HeightofTree tree = new HeightofTree();
		tree.root = new NodeTree(1);
		tree.root.left = new NodeTree(2);
		tree.root.right = new NodeTree(3);
		tree.root.left.left = new NodeTree(4);
		tree.root.left.right = new NodeTree(5);
		
		System.out.println(tree.heightTree(root));
	}

	public int heightTree(NodeTree node) {
		if (node == null)
			return 0;
		int leftht = heightTree(node.left);
		int rightht = heightTree(node.right);
		return Math.max(leftht, rightht)+1;
	}
}

class NodeTree {
	int key;
	NodeTree left, right;

	NodeTree(int key) {
		this.key = key;
	}

	public NodeTree getLeft() {
		return left;
	}

	public void setLeft(NodeTree left) {
		this.left = left;
	}

	public NodeTree getRight() {
		return right;
	}

	public void setRight(NodeTree right) {
		this.right = right;
	}
}