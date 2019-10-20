
public class BinaryTreetoDLL {

	static Node root;
	static Node head;
	static Node prev = null;
	public static void main(String[] args) {
		BinaryTreetoDLL tree = new BinaryTreetoDLL();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.convert(root,head);
	}
	private void convert(Node root,Node head) {
		if(root == null)
			return;
		convert(root.left,head);
		if(prev == null) {
			head = root;
		}else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		convert(root.right,head);
	}

}
