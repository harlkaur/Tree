import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class LeftView {

	static Node root;

	public static void main(String[] args) {
		LeftView tree = new LeftView();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.left.right.right = new Node(5);
		tree.root.left.right.right.right = new Node(6);
		tree.leftView(root);
	}

	private void leftView(Node root) {
		Queue<QueueLeftView> queue = new LinkedList<QueueLeftView>();
		TreeMap<Integer, Node> map = new TreeMap<Integer, Node>();

		if (root == null)
			return;
		else
			queue.add(new QueueLeftView(root, 0));

		while (!queue.isEmpty()) {
			QueueLeftView temp = queue.poll();
			if (!map.containsKey(temp.hd)) {
				map.put(temp.hd, temp.node);
			}
			if (temp.node.left != null) {
				queue.add(new QueueLeftView(temp.node.left, temp.hd + 1));
			}
			if (temp.node.right != null) {
				queue.add(new QueueLeftView(temp.node.right, temp.hd + 1));
			}
		}
		// iterating the map
		for (Map.Entry<Integer, Node> entry : map.entrySet()) {
			System.out.print(entry.getValue().key + " ");
		}
	}

}

class QueueLeftView {
	Node node;
	int hd;

	QueueLeftView(Node node, int hd) {
		this.node = node;
		this.hd = hd;
	}
}