
public class DiameterOfTree {

	static Node root;
	public static void main(String[] args) {
		DiameterOfTree tree = new DiameterOfTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		int res = tree.diameter(root);
		System.out.println(res);
	}
	
	private int diameter(Node root) {
		if(root == null)
			return 0;
		int lHt = heightTree(root.left);
		int rHt = heightTree(root.right);
		
		int lDia = diameter(root.left);
		int rDia = diameter(root.right);
		
		return Math.max(lHt+rHt+1,Math.max(lDia, rDia));
	}

	private int heightTree(Node node) {
		if (node == null)
			return 0;
		int leftht = heightTree(node.left);
		int rightht = heightTree(node.right);
		return Math.max(leftht, rightht)+1;
	}

}
