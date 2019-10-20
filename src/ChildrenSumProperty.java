
public class ChildrenSumProperty {

	private static NodeSum root;

	public static void main(String[] args) {
		ChildrenSumProperty tree = new ChildrenSumProperty();
		tree.root = new NodeSum(5);
		tree.root.left = new NodeSum(2);
		tree.root.right = new NodeSum(3);

		System.out.println(tree.childrenSumProperty(root));

	}

	private boolean childrenSumProperty(NodeSum root) {
		if (root == null)
			return true;
		if (root.left == null && root.right == null)
			return true;
		int sum = 0;
		if (root.left != null)
			sum = sum + root.left.key;
		if (root.right != null)
			sum = sum + root.right.key;
		if (sum == root.key && childrenSumProperty(root.left) && childrenSumProperty(root.right))
			return true;
		return false;
	}

}

class NodeSum {
	int key;
	NodeSum left, right;

	NodeSum(int key) {
		this.key = key;
	}

	public NodeSum getLeft() {
		return left;
	}

	public void setLeft(NodeSum left) {
		this.left = left;
	}

	public NodeSum getRight() {
		return right;
	}

	public void setRight(NodeSum right) {
		this.right = right;
	}
}