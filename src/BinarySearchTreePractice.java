import java.util.ArrayList;
import java.util.List;

class Sum{
	int sum = 0;
}

public class BinarySearchTreePractice {
	Node root;

	BinarySearchTreePractice(int key) {
		root = new Node(key);
	}

	public BinarySearchTreePractice() {
		root = null;
	}

	public Node search(Node node, int key) {
		if (node == null || node.key == key) {
			return node;
		}
		if (root.key > key) {
			return search(node.left, key);
		}
		return search(node.right, key);
	}

	void insert(int key) {
		root = insertRec(root, key);
	}

	public Node insertRec(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}
		if (root.key > key) {
			root.left = insertRec(root.left, key);
		} else if (root.key < key) {
			root.right = insertRec(root.right, key);
		}
		return root;
	}

	void inOrderRoot() {
		inOrder(root);
	}

	void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.println(root.key + " ");
			inOrder(root.right);
		}
	}

	void deleteKey(int key) {
		deleteKey(root, key);
	}

	Node deleteKey(Node node, int key) {
		if (node == null) {
			return node;
		}
		if (node.key > key) {
			node.left = deleteKey(node.left, key);
		} else if (node.key < key) {
			node.right = deleteKey(node.right, key);
		} else {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			}
			node.key = minValue(node.right);
			node.right = deleteKey(node.right, key);
		}
		return node;
	}

	public int minValue(Node node) {
		int minValue = 0;
		while (root.left != null) {
			minValue = root.left.key;
			node = root.left;

		}
		return minValue;
	}

	public List<Node> faultyNode(Node node, List<Node> faultyNodes) {

		if (node != null) {
			if (node.left == null || node.right == null) {
				return faultyNodes;
			} else {
				if (node.key < node.left.key) {
					faultyNodes.add(node.left);
				} else if (node.key > node.right.key) {
					faultyNodes.add(node.right);
				}
			}
			faultyNode(node.left, faultyNodes);
			faultyNode(node.right, faultyNodes);

		}
		return faultyNodes;
	}
	
	public ArrayList<Integer> convertToArrayList(Node node, ArrayList<Integer> list) {
		if (node == null) {
			return list;
		}
		convertToArrayList(node.left, list);
		list.add(node.key);
		convertToArrayList(node.right, list);
		return list;
	}
	
	boolean isPairPresent(Node node, int target) {
		ArrayList<Integer> a1 = new ArrayList<>();
		ArrayList<Integer> a2 = convertToArrayList(node, a1);
		
		int start = 0;
		int end = a2.size() -1;
		
		while (start < end) {
			if (a2.get(start) + a2.get(end) == target) {
				System.out.println("Found the pair::: " + start + " " + end);
				return true;
			} else if(a2.get(start) + a2.get(end) > target) {
				end--;
			} else if(a2.get(start) + a2.get(end) < target) {
				start++;
			}
		}
		return false;
	}
	
	public ArrayList<Integer> storeInorderList(Node node, ArrayList<Integer> list) {
		if (node == null) {
			return list;
		}
		storeInorderList(node.left, list);
		list.add(node.key);
		storeInorderList(node.right, list);
		return list;
	}
	
	public ArrayList<Integer> sortedArrayList(Node node) {
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = storeInorderList(node, list1);
		return list2;
	}
	
	public ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2, int m, int n) {
		ArrayList<Integer> list3 = new ArrayList<>();
		int i = 0,j = 0;
		while (i < m && j < n) {
			if (list1.get(i) < list2.get(j)) {
				list3.add(list1.get(i));
				i++;
			} else {
				list3.add(list2.get(j));
				j++;
			}
		}
		while(i < m) {
			list3.add(list1.get(i));
			i++;
		}
		while(j < n) {
			list3.add(list2.get(j));
			j++;
		}
		return list3;
	}
	
	public Node ALtoBST(ArrayList<Integer> mergedList, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start+end)/2;
		Node node = new Node(mergedList.get(mid));
		node.left = ALtoBST(mergedList, 0, mid-1);
		node.right = ALtoBST(mergedList, mid+1, end);
		return node;
	}
	
	Node mergeTrees(Node node1, Node node2) {
		ArrayList<Integer> list1 = sortedArrayList(node1);
		ArrayList<Integer> list2 = sortedArrayList(node2);
		ArrayList<Integer> list3 = merge(list1, list2, list1.size(), list2.size());
		Node finalTree = ALtoBST(list3, 0, list3.size()-1);
		return finalTree;
	}
	
	void addGreater(Node node, Sum sum_ptr) {
		if (node == null) {
			return;
		}
		addGreater(node.right, sum_ptr);
		sum_ptr.sum = sum_ptr.sum + node.key;
		node.key = sum_ptr.sum;
		addGreater(node.left, sum_ptr);
	}
	
	
	void addLower(Node node, Sum sum_ptr) {
		if (node == null) {
			return;
		}
		addLower(node.left, sum_ptr);
		sum_ptr.sum = sum_ptr.sum + node.key;
		node.key = sum_ptr.sum;
		addLower(node.right, sum_ptr);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTreePractice tree = new BinarySearchTreePractice();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		// tree.deleteKey(20);

		// tree.inOrderRoot();

		Node sample = new Node(10);
		sample.left = new Node(5);
		sample.right = new Node(8);
		sample.left.left = new Node(2);
		sample.left.right = new Node(20);
		List<Node> faultNodes = new ArrayList<>();
		faultNodes = tree.faultyNode(sample, new ArrayList<Node>());

	}

}
