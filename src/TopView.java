// view of binary tree 
	import java.util.Queue; 
	import java.util.TreeMap; 
	import java.util.LinkedList; 
	import java.util.Map; 
	import java.util.Map.Entry; 

	class NodeTopView { 
	    int data; 
	    NodeTopView left, right; 
	  
	    public NodeTopView(int data) { 
	        this.data = data; 
	        left = right = null; 
	    } 
	} 
	
	// class of binary tree 
	class TopView { 
		NodeTopView root; 

		public TopView() { 
			root = null; 
		} 
		
		// function should print the topView of 
		// the binary tree 
		private void TopView(NodeTopView root) { 
			class QueueObj { 
				NodeTopView NodeTopView; 
				int hd; 

				QueueObj(NodeTopView NodeTopView, int hd) { 
					this.NodeTopView = NodeTopView; 
					this.hd = hd; 
				} 
			} 
			Queue<QueueObj> q = new LinkedList<QueueObj>(); 
			Map<Integer, NodeTopView> topViewMap = new TreeMap<Integer, NodeTopView>(); 

			if (root == null) { 
				return; 
			} else { 
				q.add(new QueueObj(root, 0)); 
			} 

			System.out.println("The top view of the tree is : "); 
			
			// count function returns 1 if the container 
			// contains an element whose key is equivalent 
			// to hd, or returns zero otherwise. 
			while (!q.isEmpty()) { 
				QueueObj tmpNodeTopView = q.poll(); 
				if (!topViewMap.containsKey(tmpNodeTopView.hd)) { 
					topViewMap.put(tmpNodeTopView.hd, tmpNodeTopView.NodeTopView); 
				} 

				if (tmpNodeTopView.NodeTopView.left != null) { 
					q.add(new QueueObj(tmpNodeTopView.NodeTopView.left, tmpNodeTopView.hd - 1)); 
				} 
				if (tmpNodeTopView.NodeTopView.right != null) { 
					q.add(new QueueObj(tmpNodeTopView.NodeTopView.right, tmpNodeTopView.hd + 1)); 
				} 

			} 
			for (Entry<Integer, NodeTopView> entry : topViewMap.entrySet()) { 
				System.out.print(entry.getValue().data + " "); 
			} 
		} 
		
		// Driver Program to test above functions 
		public static void main(String[] args) 
		{ 
			/* Create following Binary Tree 
				1 
			/ \ 
			2 3 
			\ 
				4 
				\ 
				5 
				\ 
					6*/
			TopView tree = new TopView(); 
			tree.root = new NodeTopView(1); 
			tree.root.left = new NodeTopView(2); 
			tree.root.right = new NodeTopView(3); 
			tree.root.left.right = new NodeTopView(4); 
			tree.root.left.right.right = new NodeTopView(5); 
			tree.root.left.right.right.right = new NodeTopView(6); 
			System.out.println("Following are NodeTopViews in top view of Binary Tree"); 
			tree.TopView(tree.root); 
		} 
		
	} 
