import java.util.LinkedList;
import java.util.Queue;

public class InsertionInBinaryTree {

	static NodeInsertion root;

	public static void main(String[] args) {
		InsertionInBinaryTree tree = new InsertionInBinaryTree();
		tree.root = new NodeInsertion(5);
		tree.root.left = new NodeInsertion(2);
		tree.root.right = new NodeInsertion(3);
		tree.root.left.left = new NodeInsertion(5);
		System.out.println(" Inorder traversal before insertion ");
		InOrderTraversal(root);
		
		System.out.println();
		System.out.println(" Inserting key ");
		insertAtTree(root,12);
		
		System.out.println();
		System.out.println(" Inorder traversal after insertion ");
		InOrderTraversal(root);

	}

	static void InOrderTraversal(NodeInsertion root) {
		if (root == null) {
			return;
		}
		InOrderTraversal(root.left);
		System.out.print(root.key + " ");
		InOrderTraversal(root.right);
	}

	private static void insertAtTree(NodeInsertion root, int key) {
		Queue<NodeInsertion> queue = new LinkedList<NodeInsertion>();
		queue.add(root);
		while (!queue.isEmpty()) {
			root=queue.peek();
			queue.remove();
			
			if(root.left == null) {
			 root.left = new NodeInsertion(key);
			 break;
			}else
				queue.add(root.left);
			
			if(root.right == null) {
				root.right = new NodeInsertion(key);
				break;
			}else
				queue.add(root.left);
		}
	}

}

class NodeInsertion {
	int key;
	NodeInsertion left, right;

	NodeInsertion(int key) {
		this.key = key;
	}

	public NodeInsertion getLeft() {
		return left;
	}

	public void setLeft(NodeInsertion left) {
		this.left = left;
	}

	public NodeInsertion getRight() {
		return right;
	}

	public void setRight(NodeInsertion right) {
		this.right = right;
	}
}