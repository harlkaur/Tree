
public class MirrorTree {

	static Node root;

	public static void main(String[] args) {
		MirrorTree tree = new MirrorTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.mirrorTree(root);
		Inorder(root);
	}

	private static void Inorder(Node root) {
		if (root == null)
			return;
		Inorder(root.left);
		System.out.print(root.key + " ");
		Inorder(root.right);
	}

	private void mirrorTree(Node root) {
		if (root == null)
			return ;
		mirrorTree(root.left);
		mirrorTree(root.right);
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

}
