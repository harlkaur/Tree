
public class CSP {

	static NodeTree root;

	public static void main(String[] args) {
		CSP obj = new CSP();
		obj.root = new NodeTree(5);
		obj.root.left = new NodeTree(2);
		obj.root.right = new NodeTree(2);
//		obj.root.left.left = new NodeTree(4);
		System.out.println(getCSP(root));
	}

	private static boolean getCSP(NodeTree root) {
		if (root == null)
			return true;
		if ((root.left == null) && (root.right == null)) {
			return true;
		}

		int sum = 0;
		sum += root.left.key;
		sum += root.right.key;
		if (sum == root.key)
			return true;

		return false;

	}

}
