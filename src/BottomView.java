import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {

	static Node root;

	public static void main(String[] args) {
		BottomView tree = new BottomView();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.left.right.right = new Node(5);
		tree.root.left.right.right.right = new Node(6);
		tree.bottomView(root);
	}

	private void bottomView(Node root) {
		Queue<QueueBottomView> queue = new LinkedList<QueueBottomView>();
		TreeMap<Integer, Node> map = new TreeMap<Integer, Node>();

		if (root == null)
			return;
		else
			queue.add(new QueueBottomView(root, 0));

		while (!queue.isEmpty()) {
			QueueBottomView temp = queue.poll();
			map.put(temp.hd, temp.rightView);
			
			if(temp.rightView.left != null) {
				queue.add(new QueueBottomView(temp.rightView.left, temp.hd-1));
			}
			
			if(temp.rightView.right != null ) {
				queue.add(new QueueBottomView(temp.rightView.right, temp.hd+1));
			}
		}
		// iterating map
		for(Map.Entry<Integer, Node> entry : map.entrySet()) {
			System.out.print(entry.getValue().key + " ");
		}
	}

}

class QueueBottomView {
	Node rightView;
	int hd;

	QueueBottomView(Node rightView, int hd) {
		this.rightView = rightView;
		this.hd = hd;
	}
}