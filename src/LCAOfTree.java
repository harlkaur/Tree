
public class LCAOfTree {

	static Node root;
	public static void main(String[] args) {
		LCAOfTree tree = new LCAOfTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		Node result = tree.lca(root, 4, 7);
		System.out.println(result.key);
	}

	private Node lca(Node root, int n1, int n2) {
		if (root == null)
			return null;
		if (n1 == root.key || n2 == root.key) {
			return root;
		}
		Node leftLCA = lca(root.left, n1, n2);
		Node rightLCA = lca(root.right, n1, n2);

		if (leftLCA != null && rightLCA != null) {
			return root;
		}

		return (leftLCA != null) ? leftLCA : rightLCA;
	}

}
