import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

class Node {
	int key;
	Node left, right;

	public Node(int item) {
		key = item;
		left = right = null;
	}

}

public class TreePractice {

	Node root;
	int preIndex = 0;

	TreePractice(int key) {
		root = new Node(key);
	}

	public TreePractice() {
		root = null;
	}

	public int maxDepth(Node node) {
		if (node == null) {
			return 0;
		} else {
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);

			if (lDepth > rDepth) {
				return lDepth + 1;
			} else {
				return rDepth + 1;
			}
		}
	}

	public void printPreOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.key + " ");
		printPreOrder(node.left);
		printPreOrder(node.right);
	}

	public void printInOrder(Node node) {
		if (node == null) {
			return;
		}
		printInOrder(node.left);
		System.out.print(node.key + " ");
		printInOrder(node.right);
	}

	public void printPostOrder(Node node) {
		if (node == null) {
			return;
		}
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.key + " ");
	}

	public void printLevelOrder(Node node) {
		int h = maxDepth(node);
		for (int i = 1; i <= h; i++) {
			printGivenLevel(node, i);
		}
	}

	public void printGivenLevel(Node node, int level) {
		if (node == null) {
			return;
		}
		if (level == 1) {
			System.out.print(node.key + " ");
		} else {
			printGivenLevel(node.left, level - 1);
			printGivenLevel(node.right, level - 1);
		}
	}

	public int diameter(Node node) {
		if (node == null) {
			return 0;
		}

		int lHeight = maxDepth(node.left);
		int rHeight = maxDepth(node.right);

		int lDiameter = diameter(node.left);
		int rDiameter = diameter(node.right);

		return Math.max((lHeight + rHeight + 1), Math.max(lDiameter, rDiameter));
	}

	public int diameter() {
		return diameter(root);
	}

	public void inOrder() {
		if (root == null) {
			return;
		}
		Stack<Node> s = new Stack<>();
		Node curr = root;

		while (curr != null || s.size() > 0) {
			while (curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop();
			System.out.println(curr.key);
			curr = curr.right;
		}
	}

	public Node buildTree(int[] in, int[] pre, int inStart, int inEnd) {
		if (inStart > inEnd) {
			return null;
		}
		Node tNode = new Node(pre[preIndex++]);
		if (inStart == inEnd) {
			return tNode;
		}
		int intIndex = search(in, inStart, inEnd, tNode.key);
		tNode.left = buildTree(in, pre, inStart, intIndex - 1);
		tNode.right = buildTree(in, pre, intIndex + 1, inEnd);

		return tNode;

	}

	public void printKDistant(Node node, int k) {
		if (node == null) {
			return;
		}
		if (k == 1) {
			System.out.println(node.key);
		} else {
			printKDistant(node.left, k - 1);
			printKDistant(node.right, k - 1);
		}
	}

	public Boolean printAncestors(Node node, int target) {
		if (node == null) {
			return false;
		}
		if (node.key == target) {
			return true;
		}
		if (printAncestors(node.left, target) || printAncestors(node.right, target)) {
			System.out.println(node.key + " ");
			return true;
		}
		return false;
	}

	public int search(int[] in, int inStart, int inEnd, int value) {
		int i;
		for (i = 0; i <= inEnd; i++) {
			if (in[i] == value) {
				return i;
			}
		}
		return i;
	}

	public int getMaxWidth(Node node) {
		if (node == null) {
			return 0;
		}
		int h = maxDepth(node);
		int width;
		int maxWidth = 0;
		for (int i = 1; i <= h; i++) {
			width = getWidth(node, i);
			if (width > maxWidth) {
				maxWidth = width;
			}
		}
		return maxWidth;
	}

	public int getWidth(Node node, int level) {
		if (node == null) {
			return 0;
		}
		if (level == 1) {
			return 1;
		} else if (level > 1) {
			return getWidth(node.left, level - 1) + getWidth(node.right, level - 1);
		}
		return 0;
	}

	public int maxLevelSum(Node root) {
		if (root == null) {
			return -1;
		}

		Queue<Node> q = new LinkedList<Node>();
		Queue<Node> sumQueue = new LinkedList<Node>();
		sumQueue.add(root);
		q.add(root);
		int level = 0;
		int max = Integer.MIN_VALUE;
		int sumNodesLevel = 0;
		while (true) {
			int NodeCount = q.size();
			int sumAtLevel = sumAtGivenLevel(sumQueue);
			if (NodeCount == 0) {
				break;
			}
			if (NodeCount > max) {
				max = NodeCount;
				sumNodesLevel = sumAtLevel;
			}
			while (NodeCount > 0) {
				Node Node = null;
				if (!q.isEmpty()) {
					Node = q.remove();
				}
				if (Node != null && Node.left != null) {
					sumQueue.add(Node.left);
					q.add(Node.left);
				}

				if (Node != null && Node.right != null) {
					sumQueue.add(Node.right);
					q.add(Node.right);
				}

				NodeCount--;
			}
			level++;
		}
		return sumNodesLevel;
	}

	public static int sumAtGivenLevel(Queue<Node> q) {
		int sum = 0;
		while (!q.isEmpty()) {
			Node n = q.remove();
			sum += n.key;
		}
		return sum;
	}
	
	public void TopView(Node head) {
		class QueueObj {
			Node node;
			int hd;

			QueueObj(Node node, int hd) {
				this.node = node;
				this.hd = hd;
			}
		}

		Queue<QueueObj> q = new LinkedList<QueueObj>();
		Map<Integer, Node> treeMap = new TreeMap<>();
		
		if (head == null) {
			return;
		} else {
			q.add(new QueueObj(head, 0));
		}
		
		while(!q.isEmpty()) {
			QueueObj temp = q.poll();
			if (!treeMap.containsKey(temp.hd)) {
				treeMap.put(temp.hd, temp.node);
			}
			if(temp.node.left != null) {
				q.add(new QueueObj(temp.node.left, temp.hd-1));
			}
			if(temp.node.right != null) {
				q.add(new QueueObj(temp.node.right, temp.hd+1));
			}
		}
		for(Map.Entry<Integer, Node> temp : treeMap.entrySet()) {
			System.out.println((temp.getValue()).key);
		}
	}
	
	int maxLevel = 0;
	public void leftViewUtil(Node node, int level) {
		if(node == null) {
			return;
		}
		if(maxLevel < level) {
			System.out.print(node.key + " ");
			maxLevel = level;
		}
		leftViewUtil(node.left, level+1);
		leftViewUtil(node.right, level+1);
	}
	
	public void rightViewUtil(Node node, int level) {
		if(node == null) {
			return;
		}
		if(maxLevel < level) {
			System.out.print(node.key + " ");
			maxLevel = level;
		}
		rightViewUtil(node.right, level+1);
		rightViewUtil(node.left, level+1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreePractice tree = new TreePractice();
		tree.root = new Node(0);
		tree.root.left = new Node(1);
		tree.root.right = new Node(2);
		 tree.root.left.left = new Node(4);
		 tree.root.left.right = new Node(5);
		// System.out.println(tree.maxDepth(tree.root));
//		 tree.printPreOrder(tree.root);
//		 tree.printInOrder(tree.root);
//		 tree.printPostOrder(tree.root);
//		 tree.printLevelOrder(tree.root);
		// System.out.println("Tree diameter::: " + tree.diameter());
		//System.out.println(tree.maxLevelSum(tree.root));
		 //tree.TopView(tree.root);
		// System.out.println(tree.maxDepth(tree.root));
//		 int level = tree.maxDepth(tree.root);
//		 tree.leftViewUtil(tree.root, level);
//		 tree.rightViewUtil(tree.root, level);
		 tree.printAncestors(tree.root, 4);
	}

}
