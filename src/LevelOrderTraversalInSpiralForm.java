import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversalInSpiralForm {

	static NodeTree root;

	public static void main(String[] args) {
		LevelOrderTraversalInSpiralForm obj = new LevelOrderTraversalInSpiralForm();
		obj.root = new NodeTree(1);
		obj.root.left = new NodeTree(2);
		obj.root.right = new NodeTree(3);
		obj.root.left.left = new NodeTree(4);
		obj.root.left.right = new NodeTree(5);
		obj.root.right.left = new NodeTree(6);
		obj.root.right.right = new NodeTree(7);
		obj.spiralForm(root);

	}

	private static void spiralForm(NodeTree root) {
		if (root == null)
			return;
		Stack<NodeTree> currentStack = new Stack<NodeTree>();
		Stack<NodeTree> stack = new Stack<NodeTree>();
		currentStack.add(root);
		boolean flag = false;
		while (!currentStack.isEmpty()) {
			if (flag) {
				NodeTree temp = currentStack.pop();
				System.out.print(temp.key + " ");

				if (temp.left != null) {
					stack.add(temp.left);
				}
				if (temp.right != null) {
					stack.add(temp.right);
				}
			} else {
				NodeTree temp = currentStack.pop();
				System.out.print(temp.key + " ");

				if (temp.right != null) {
					stack.add(temp.right);
				}
				if (temp.left != null) {
					stack.add(temp.left);
				}
			}

			if (currentStack.isEmpty()) {
				Stack temp = currentStack;
				currentStack = stack;
				stack = temp;

				flag = !flag;

			}

		}
	}

}
