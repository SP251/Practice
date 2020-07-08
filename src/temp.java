import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class temp {

	public static void main(String[] args) {
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
				q.add(new QueueObj(temp.node.right, temp.hd-1));
			}
		}
		for(Map.Entry<Integer, Node> temp : treeMap.entrySet()) {
			System.out.println((temp.getValue()).key);
		}
	}

}
