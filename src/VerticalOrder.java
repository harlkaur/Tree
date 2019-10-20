import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrder {

	static Node root;
	public static void main(String[] args) {
		VerticalOrder tree = new VerticalOrder();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.left.right.right = new Node(5);
		tree.root.left.right.right.right = new Node(6);
		tree.verticalOrder(root);
	}
	
	private void verticalOrder(Node root) {
		Queue<VerticalOrderQueue> queue = new LinkedList<VerticalOrderQueue>();
		TreeMap<Integer,ArrayList<Node>> map = new TreeMap<Integer,ArrayList<Node>>();
		
		if(root == null)
			return;
		else
			queue.add(new VerticalOrderQueue(root,0));
		
		while(!queue.isEmpty()) {
			VerticalOrderQueue temp = queue.poll();
			
			// inserting elements into Map
			addIntoMap(map,temp.hd,temp.node);
			
			// left node of tree
			if(temp.node.left != null) {
				queue.add(new VerticalOrderQueue(temp.node.left, temp.hd-1));
			}
			
			if(temp.node.right != null) {
				queue.add(new VerticalOrderQueue(temp.node.right, temp.hd+1));
			}
		}
		
		// iterating the map
		for(Map.Entry<Integer,ArrayList<Node>> entry : map.entrySet()) {
			for(int i=0;i<entry.getValue().size();i++) {
				System.out.print(entry.getValue().get(i).key + " ");
			}
		}
	}

	private void addIntoMap(TreeMap<Integer,ArrayList<Node>> map, int hd, Node node) {
		if(map.get(hd) == null) {
			ArrayList<Node> value = new ArrayList<Node>();
			value.add(node);
			map.put(hd, value);
		}else {
			ArrayList<Node> value = map.get(hd);
			value.add(node);
			map.put(hd, value);
		}
		
	}

}

class VerticalOrderQueue {
	Node node;
	int hd;

	VerticalOrderQueue(Node node, int hd) {
		this.node = node;
		this.hd = hd;
	}
}