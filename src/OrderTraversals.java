
public class OrderTraversals {

	Node root;

	OrderTraversals() {
		root = null;
	}

	void printPostorder(Node node) {
		if (node == null)
			return;
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.println(node.key + " ");
	}

	void printInorder(Node node) {
		if (node == null)
			return;
		printInorder(node.left);
		System.out.println(node.key + " ");
		printInorder(node.right);
	}

	void printPreOrder(Node node) {
		if (node == null)
			return;
		System.out.println(node.key + " ");
		printPreOrder(node.left);
		printPreOrder(node.right);
	}

	void printPreOrder() {
		printPreOrder(root);
	}

	void printInorder() {
		printInorder(root);
	}

	void printPostorder() {
		printPostorder(root);
	}

	public static void main(String[] args) {
		OrderTraversals tree = new OrderTraversals();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		System.out.println(" pre order traversals : ");
		tree.printPreOrder();

		System.out.println(" Inorder traversal of binary tree is ");
		tree.printInorder();

		System.out.println(" Postorder traversal of binary tree is ");
		tree.printPostorder();
	}

}

class Node {
	int key;
	Node left, right;

	Node(int item) {
		key = item;
	}
}