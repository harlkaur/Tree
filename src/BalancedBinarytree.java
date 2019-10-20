
public class BalancedBinarytree {

	static NodeBalanced root;

	public static void main(String[] args) {
		BalancedBinarytree tree = new BalancedBinarytree();
		tree.root = new NodeBalanced(5);
		tree.root.left = new NodeBalanced(2);
		tree.root.right = new NodeBalanced(3);
		tree.root.left.left = new NodeBalanced(5);
		int height = tree.heightTree(root);
		System.out.println(height);
		System.out.println(tree.isBalanced(root, height));
	}

	public int heightTree(NodeBalanced node) {
		if (node == null)
			return 0;
		int leftht = heightTree(node.left);
		int rightht = heightTree(node.right);
		return Math.max(leftht, rightht) + 1;
	}

	public boolean isBalanced(NodeBalanced root, int height) {
		if (root == null) {
			height = 0;
			return true;
		}
		int leftHt = 0;
		int rightHt = 0;
		boolean leftbalanced = isBalanced(root.left, leftHt);
		boolean rightbalanced = isBalanced(root.right, rightHt);
		if (Math.abs(leftHt - rightHt) > 1) {
			return false;
		}
		height = Math.max(leftHt, rightHt) + 1;
		if (leftbalanced && rightbalanced)
			return true;
		return false;
	}
}

class NodeBalanced {
	int key;
	NodeBalanced left, right;

	NodeBalanced(int key) {
		this.key = key;
	}

	public NodeBalanced getLeft() {
		return left;
	}

	public void setLeft(NodeBalanced left) {
		this.left = left;
	}

	public NodeBalanced getRight() {
		return right;
	}

	public void setRight(NodeBalanced right) {
		this.right = right;
	}
}