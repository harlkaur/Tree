
public class FoldableBinarytree {

	static Node root;
	public static void main(String[] args) {
		FoldableBinarytree tree = new FoldableBinarytree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.foldable(root);
		
	}
	
	private static boolean foldable(Node root) {
		if(root == null)
			return true;
	   boolean result = foldableUtil(root.left,root.right);
	   return result;
	}
	
	private static boolean foldableUtil(Node left, Node right) {
		if(left == null && right == null)
			return true;
		if(left == null || right == null)
			return false;
		return foldableUtil(left.left,right.right) &&
				foldableUtil(left.right,right.left);
	}

}
