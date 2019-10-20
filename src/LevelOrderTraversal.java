import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	static NodeTreee root;

	public static void main(String[] args) {
		LevelOrderTraversal obj = new LevelOrderTraversal();
		obj.root = new NodeTreee(1);
		obj.root.left = new NodeTreee(2);
		obj.root.right = new NodeTreee(3);
		obj.levelOrder(root);
	}

	public void levelOrder(NodeTreee root) {
		if (root == null)
			return;
		Queue<NodeTreee> queue = new LinkedList<NodeTreee>();
		queue.add(root);
		while (!queue.isEmpty()) {
			NodeTreee temp = queue.poll();
			System.out.print(temp.key + " ");

			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}
}

class NodeTreee{
	NodeTreee left,right;
	int key;
	NodeTreee(int key){
		this.key=key;
	}
}