import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesatSameLevel {

	static connectNodes root;

	public static void main(String[] args) {
		ConnectNodesatSameLevel tree = new ConnectNodesatSameLevel();
		tree.root = new connectNodes(1);
		tree.root.left = new connectNodes(2);
		tree.root.right = new connectNodes(3);
		tree.root.left.left = new connectNodes(4);
		tree.root.left.right = new connectNodes(5);
		tree.root.right.left = new connectNodes(6);
		tree.root.right.right = new connectNodes(7);
		tree.connectNodesMethod(root);
	}

	private static void connectNodesMethod(connectNodes root) {
		if (root == null)
			return;
		Queue<connectNodes> queue = new LinkedList<connectNodes>();
		queue.add(root);
		connectNodes prev = null;
		while (!queue.isEmpty()) {
			int size = queue.size();
			prev = null;
			while (size > 0) {
				connectNodes temp = queue.poll();
				if (temp.left != null) {
					queue.add(temp.left);
				}

				if (temp.right != null) {
					queue.add(temp.right);
				}

				if (prev == null)
					prev = temp;
				else {
					prev.nextRight = temp;
					prev = temp;
				}
				if (size == 1)
					temp.nextRight = null;
				size--;
			}

		}
	}

}

class connectNodes {
	int data;
	connectNodes left, right, nextRight;

	connectNodes(int x) {
		this.data = x;
		left = right = nextRight = null;
	}

}