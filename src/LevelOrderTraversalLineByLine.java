import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalLineByLine {

	static NodeTree root;

	public static void main(String[] args) {
		LevelOrderTraversalLineByLine obj = new LevelOrderTraversalLineByLine();
		obj.root = new NodeTree(1);
		obj.root.left = new NodeTree(2);
		obj.root.right = new NodeTree(3);
		obj.root.left.left = new NodeTree(4);
//		obj.root.left.right = new NodeTree(5);
		obj.levelOrder(root);
	}

	private void levelOrder(NodeTree root) {
		if (root == null)
			return;
		Queue<NodeTree> queue = new LinkedList<NodeTree>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				NodeTree temp = queue.poll();
				System.out.print(temp.key + " ");

				if (temp.left != null) {
					queue.add(temp.left);
				}

				if (temp.right != null) {
					queue.add(temp.right);
				}
				size--;
			}
			System.out.print("$ ");
		}

	}

}
