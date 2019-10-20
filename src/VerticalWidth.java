import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalWidth {

	static Node root;

	public static void main(String[] args) {
		VerticalWidth tree = new VerticalWidth();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.left.right.right = new Node(5);
		tree.root.left.right.right.right = new Node(6);
		System.out.println(tree.getWidth(root));
	}

	private static int getWidth(Node root) {
		Queue<QueueVW> queue = new LinkedList<QueueVW>();
		TreeMap<Integer, Node> map = new TreeMap<Integer, Node>();
		if (root == null)
			return 0;
		else
			queue.add(new QueueVW(root, 0));

		while (!queue.isEmpty()) {
			QueueVW temp = queue.poll();
			if (!map.containsKey(temp.hd)) {
				map.put(temp.hd, temp.node);
			}

			if (temp.node.left != null) {
				queue.add(new QueueVW(temp.node.left, temp.hd - 1));
			}

			if (temp.node.right != null) {
				queue.add(new QueueVW(temp.node.right, temp.hd + 1));
			}
		}
		return map.size();
	}

}

class QueueVW {
	Node node;
	int hd;

	QueueVW(Node node, int hd) {
		this.node = node;
		this.hd = hd;
	}

}