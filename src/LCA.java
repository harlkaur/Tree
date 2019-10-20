
public class LCA {

	static Node root;
	public static void main(String[] args) {
		LCA tree = new LCA();
		tree.root = new Node(8);
		tree.root.left = new Node(2);
		tree.root.right = new Node(90);
		System.out.println(tree.lca(root, 2, 90).key);
	}

	static Node lca(Node root, int n1, int n2) {
		if(root == null)
			return null;
		if (root.right != null && (root.key < (Math.min(n1, n2)))) {
			return lca(root.right, n1, n2);
		} else if (root.left != null && (root.key > Math.max(n1, n2))) {
			return lca(root.left, n1, n2);
		} else
			return root;
	}
}
