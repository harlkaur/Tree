
public class ChildrenSumPropertyProblem {

	static NodeTree root;

	public static void main(String[] args) {
		ChildrenSumPropertyProblem tree = new ChildrenSumPropertyProblem();
		tree.root = new NodeTree(5);
		tree.root.left = new NodeTree(2);
		tree.root.right = new NodeTree(3);
		System.out.println(childSum(root));
	}

	private static int childSum(NodeTree root) {
		if (root == null)
			return 0;
		if ((root.left.key == 0) && (root.right.key == 0))
			return 0;
		int sum = 0;
		if (root.left != null)
			sum = sum + root.left.key;
		if (root.right != null)
			sum = sum + root.right.key;
		if ((sum == root.key))
			return 1;
		return 0;
	}

}
