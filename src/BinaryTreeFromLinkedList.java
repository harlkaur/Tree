import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeFromLinkedList {

	 static BinaryTreeNode root;
	 ListNode head;

	public static void main(String[] args) {
		BinaryTreeFromLinkedList tree = new BinaryTreeFromLinkedList();
		tree.push(36); 
        tree.push(30); 
        tree.push(25); 
        tree.push(15); 
        tree.push(12); 
        tree.push(10);
        BinaryTreeNode node = tree.convert(root);
        tree.inOrder(node);
        
	}

	public void push(int new_data) {
		ListNode new_node = new ListNode(new_data);
		new_node.next = head;
		head = new_node;
	}

	BinaryTreeNode convert(BinaryTreeNode root) {
		if (head == null)  
        { 
            root = null;  
            return null; 
        }

		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		root = new BinaryTreeNode(head.data);
		queue.add(root);

		// advance pointer to next node
		head = head.next;

		while (head != null) {
			BinaryTreeNode parent = queue.poll();

			BinaryTreeNode leftChild = null, rightChild = null;
			leftChild = new BinaryTreeNode(head.data);
			queue.add(leftChild);
			head = head.next;
			if (head != null) {
				rightChild = new BinaryTreeNode(head.data);
				queue.add(rightChild);
				head = head.next;

			}
			parent.left = leftChild;
			parent.right = rightChild;

		}
		return root;

	}

	private void inOrder(BinaryTreeNode node1) {
		if (node1 == null)
			return;
		inOrder(node1.left);
		System.out.print(node1.data + " ");
		inOrder(node1.right);
	}
}

class ListNode {
	int data;
	ListNode next;

	ListNode(int d) {
		data = d;
		next = null;
	}
}

class BinaryTreeNode {
	int data;
	BinaryTreeNode left, right = null;

	BinaryTreeNode(int data) {
		this.data = data;
		left = right = null;
	}
}
