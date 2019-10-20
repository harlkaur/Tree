
public class DetermineIfTreesareidentical {

	public static void main(String[] args) {

		
	}

	private static boolean ifIdentical(NodeTopView root1, NodeTopView root2){
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		
		boolean left = ifIdentical(root1.left,root2.left);
		if(root1.key != root2.key)
			return false;
		boolean right = ifIdentical(root1.right, root2.right);
		
		return left && right;
	}
}
