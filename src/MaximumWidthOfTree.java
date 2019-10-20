import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfTree {

	static NodeTopView root;

	public static void main(String[] args) {
		MaximumWidthOfTree tree = new MaximumWidthOfTree();
		tree.root = new NodeTopView(1);
		tree.root.left = new NodeTopView(2);
		tree.root.left.left = new NodeTopView(3);
		tree.root.right = new NodeTopView(4);
		tree.root.left.right = new NodeTopView(5);
		tree.root.right.left = new NodeTopView(6);

//		tree.root.right.left = new Node(6);
//		tree.root.right.right = new Node(7);
		System.out.println(tree.maxWidth(root));
	}

	private static int maxWidth(NodeTopView root) {
		if (root == null)
			return 0;
		int leftCt = 0;
		int rightCt = 0;
		Queue<NodeTopView> queue = new LinkedList<NodeTopView>();
		queue.add(root);
		int maxNodes = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				NodeTopView temp = queue.poll();
				if (temp.left != null) {
					queue.add(temp.left);
					leftCt++;
				}

				if (temp.right != null) {
					queue.add(temp.right);
					rightCt++;
				}
				size--;
			}
			if (maxNodes < (leftCt + rightCt)) {
				maxNodes = leftCt + rightCt;
			}
			leftCt = 0;
			rightCt = 0;

		}
		return maxNodes;
	}

}
