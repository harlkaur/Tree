
public class PostOrder {

	static NodePreOrder root;
	public static void main(String[] args) {
		PostOrder tree = new PostOrder();
		tree.root = new NodePreOrder(5);
		tree.root.left = new NodePreOrder(2);
		tree.root.right = new NodePreOrder(3);
		tree.root.left.left = new NodePreOrder(5);
		postOrder(root);
	}

	private static void postOrder(NodePreOrder root) {
		if(root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.key + " ");
	}

}
