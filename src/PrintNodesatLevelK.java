
public class PrintNodesatLevelK {

	private static NodePrint root;

	public static void main(String[] args) {
		PrintNodesatLevelK tree = new PrintNodesatLevelK();
		tree.root = new NodePrint(5);
		tree.root.left = new NodePrint(2);
		tree.root.right = new NodePrint(3);
		tree.root.left.left = new NodePrint(4);
		int k = 2;
		printNode(k, root);
	}

	private static void printNode(int k, NodePrint node) {
		if (node == null)
			return;
		if (k == 0)
			System.out.println(node.key);
		printNode(k - 1, node.left);
		printNode(k - 1, node.right);
	}

}

class NodePrint {
	int key;
	NodePrint left, right;

	NodePrint(int key) {
		this.key = key;
	}

	public NodePrint getLeft() {
		return left;
	}

	public void setLeft(NodePrint left) {
		this.left = left;
	}

	public NodePrint getRight() {
		return right;
	}

	public void setRight(NodePrint right) {
		this.right = right;
	}
}