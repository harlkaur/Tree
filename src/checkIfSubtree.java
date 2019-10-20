import java.util.LinkedList;
import java.util.Queue;

public class checkIfSubtree {

	static Node root;
	static Node child;

	public static void main(String[] args) {
		checkIfSubtree tree = new checkIfSubtree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.child = new Node(1);
		tree.child.left = new Node(2);
		tree.child.right = new Node(3);
		boolean result = tree.isSubtree(root, child);
		System.out.println(result);
	}

	public static boolean isSubtree(Node parent, Node child) {
		if (parent == null && child == null)
			return true;
		if (parent == null || child == null)
			return false;

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(parent);
		// check root and see if it is identical
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			if (temp.key == child.key) {
				boolean result = checkIfIdentical(temp, child);
				if (result) {
					return true;
				}
			}
			// traverse the parent node to check for root again
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
		return false;
	}

	private static boolean checkIfIdentical(Node parent, Node child) {
		if (parent == null && child == null)
			return true;
		if (parent == null || child == null)
			return false;
		// do preorder -> ROOT -> LEFT -> RIGHT
		if (parent.key != child.key)
			return false;
		boolean left = checkIfIdentical(parent.left, child.left);
		boolean right = checkIfIdentical(parent.right, child.right);

		return left && right;
	}

}
