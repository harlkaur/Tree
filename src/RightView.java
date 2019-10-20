import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class RightView {

	static Node root;

	public static void main(String[] args) {
		RightView tree = new RightView();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.left.right.right = new Node(5);
		tree.root.left.right.right.right = new Node(6);
		tree.rightView(root);
	}

	private void rightView(Node root) {
		Queue<QueueRightView> queue = new LinkedList<QueueRightView>();
		TreeMap<Integer, Node> map = new TreeMap<Integer, Node>();
		if (root == null)
			return;
		else
			queue.add(new QueueRightView(root, 0));

		while (!queue.isEmpty()) {
			QueueRightView temp = queue.poll();
			map.put(temp.hd, temp.rightView);

			if (temp.rightView.left != null) {
				queue.add(new QueueRightView(temp.rightView.left, temp.hd + 1));
			}

			if (temp.rightView.right != null) {
				queue.add(new QueueRightView(temp.rightView.right, temp.hd + 1));
			}
		}

		// iterating the map
		for (Map.Entry<Integer, Node> entry : map.entrySet()) {
			System.out.print(entry.getValue().key + " ");
		}
	}

}

class QueueRightView {
	Node rightView;
	int hd;

	QueueRightView(Node rightView, int hd) {
		this.rightView = rightView;
		this.hd = hd;
	}
}