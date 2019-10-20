
public class PreOrderTraversal {

	static NodePreOrder root;
	public static void main(String[] args) {
		PreOrderTraversal tree = new PreOrderTraversal();
		tree.root = new NodePreOrder(5);
		tree.root.left = new NodePreOrder(2);
		tree.root.right = new NodePreOrder(3);
		tree.root.left.left = new NodePreOrder(5);
		preOrder(root);
	}
	
	private static void preOrder(NodePreOrder root) {
		if(root == null)
			return;
		
		System.out.print(root.key + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

}

class NodePreOrder {
	int key;
	NodePreOrder left, right;

	NodePreOrder(int key) {
		this.key = key;
	}

	public NodePreOrder getLeft() {
		return left;
	}

	public void setLeft(NodePreOrder left) {
		this.left = left;
	}

	public NodePreOrder getRight() {
		return right;
	}

	public void setRight(NodePreOrder right) {
		this.right = right;
	}
}