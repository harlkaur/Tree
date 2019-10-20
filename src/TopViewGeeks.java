import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewGeeks {

	static NodeTopView root;

	public static void main(String[] args) {
		TopViewGeeks tree = new TopViewGeeks();
		tree.root = new NodeTopView(1);
		tree.root.left = new NodeTopView(2);
		tree.root.right = new NodeTopView(3);
		tree.root.left.right = new NodeTopView(4);
		tree.root.left.right.right = new NodeTopView(5);
		tree.root.left.right.right.right = new NodeTopView(6);
		tree.printTopView(root);
	}

	private void printTopView(NodeTopView root) {
		Queue<QueueTopView> queue = new LinkedList<QueueTopView>();
		TreeMap<Integer, NodeTopView> map = new TreeMap<Integer, NodeTopView>();
		if (root == null)
			return;
		else
			queue.add(new QueueTopView(root, 0));

		while (!queue.isEmpty()) {
			QueueTopView temp = queue.poll();
			if (!map.containsKey(temp.hd)) {
				map.put(temp.hd, temp.NodeTopView);
			}

			if (temp.NodeTopView.left != null) {
				queue.add(new QueueTopView(temp.NodeTopView.left, temp.hd - 1));
			}

			if (temp.NodeTopView.right != null) {
				queue.add(new QueueTopView(temp.NodeTopView.right, temp.hd + 1));
			}
		}
		
		// iterating map and printing the views
		for(Map.Entry<Integer, NodeTopView> entry:map.entrySet()) {
			System.out.print(entry.getValue().data + " ");
		}
	}

}

class QueueTopView {
	NodeTopView NodeTopView;
	int hd;

	QueueTopView(NodeTopView NodeTopView, int hd) {
		this.NodeTopView = NodeTopView;
		this.hd = hd;
	}

}