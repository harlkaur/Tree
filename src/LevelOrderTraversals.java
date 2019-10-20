import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversals {
	static NodeT root;

	void levelOrder() {
		Queue<NodeT> q = new LinkedList<NodeT>();
		q.add(root);
		while (!q.isEmpty()) {
			NodeT tempNode = q.poll();
			System.out.print(tempNode.data + " ");

			if (tempNode.left != null) {
				q.add(tempNode.left);
			}

			if (tempNode.right != null) {
				q.add(tempNode.right);
			}
		}
	}

	int height(NodeT node) {
		if (node == null) {
			return 0;
		}
		int leftHt = height(node.left);
		int rightHt = height(node.right);
		return Math.max(leftHt, rightHt) + 1;
	}

	public static void main(String[] args) {
		LevelOrderTraversals tree = new LevelOrderTraversals();
		tree.root = new NodeT(1);
		tree.root.left = new NodeT(2);
		tree.root.right = new NodeT(3);
		tree.root.left.left = new NodeT(4);
		tree.root.left.right = new NodeT(5);
		System.out.println(" level order traversals ");
		tree.levelOrder();
		
		System.out.println(" Height of tree ");
		System.out.println(tree.height(root));
	}

}

class NodeT {
	int data;
	NodeT left, right;

	NodeT(int item) {
		data = item;
		left = null;
		right = null;
	}
}