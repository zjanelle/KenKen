package kenken;
/*
 * This class creates a n-ary tree that stores nodes
 * 
 */
public class SearchTree {
	private Node root;
	private int n;

	public SearchTree(int n) {
		this.n = n;
		root = new Node(n);
		root.setParent(null);
	}
	// adds a new node to a parent... maybe used for some kind of forward tracking method
	public void addNewNode(Node parent, int childValue) {
		Node child = new Node(n);
		child.setValue(childValue);
		child.setParent(parent);
		parent.addChild(child);		
	}

	// returns number of total nodes traversed by tree
	public int getNumOfNodes(Node root) {
		int count = 0;
		if (root.getChildren().size() != 0) {
			for (Node child: root.getChildren()) {
				count += getNumOfNodes(child);
			}
		}
		return count;
	}
	//get height of search tree and when that is equal to n*n, we've found all the values
	public int getDepth() {
		Node traverse = this.root;
		int depth = 0;
		while (traverse != null) {
			traverse = traverse.getLastChild();
			depth++;
		}
		return depth;
	}

	public int getDepthOfNode(Node find) {
		if (find == null) {
			return 0;
		}
		Node traverse = this.root;
		int depth = 0;
		while (traverse != find) {
			traverse = traverse.getLastChild();
			depth++;
		}
		return depth;
	}
	
	public Node getNodeAtDepth(int depth) {
		Node traverse = this.root;
		for (int i = 0; i < depth; i++) {
			if (traverse.getLastChild() == null) {
				return null;
			}
			traverse = traverse.getLastChild();
		}
		return traverse;
	}

	public Node getRoot() {
		return this.root;
	}

}
