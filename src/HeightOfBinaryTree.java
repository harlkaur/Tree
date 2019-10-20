
public class HeightOfBinaryTree {

	static NodeTree root;

	public static void main(String[] args) {
		HeightOfBinaryTree tree = new HeightOfBinaryTree();
		tree.root = new NodeTree(1);
		tree.root.left = new NodeTree(2);
		tree.root.right = new NodeTree(3);
		// tree.root.left.left = new NodeTree(4);
		// tree.root.left.right = new NodeTree(5);

		System.out.println(tree.height(root));
	}

	private static int height(NodeTree root) {
		if (root == null)
			return 0;

		int leftHt = 0;
		int rightHt = 0;
		leftHt += height(root.left);
		rightHt += height(root.right);

		return Math.max(leftHt, rightHt) + 1;
	}

}
