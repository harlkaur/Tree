
public class CountNumberOfSubTrees {

	static Node root;
	static int count = 0;

	public static void main(String[] args) {
		CountNumberOfSubTrees tree = new CountNumberOfSubTrees();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		System.out.println(tree.countSubtreesWithSumX(root, 6));
	}

	static int countSubtreesWithSumX(Node root, int x) {
		countSubTree(root, x);
		return count;

	}

	private static void countSubTree(Node root, int x) {
		if (root == null)
			return;
		countSubTree(root.left, x);
		countSubTree(root.right, x);
		int sum = 0;
		if (root.left != null)
			sum = sum + root.left.key;
		if (root.right != null)
			sum = sum + root.right.key;

		sum = sum + root.key;
		// System.out.println(root.data + sum);
		if (x == (sum))
			++count;
		root.key = sum;
	}
}
