public class Practice {
	Node head;

	class Node {
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public void printList() {
		Node temp = head;
		while(temp!=null) {
			System.out.println(temp.data + " ");
			temp = temp.next;
		}
	}
	
	public void push(int new_data) {
		Node new_Node = new Node(new_data);
		new_Node.next = head;
		head = new_Node;
	}
	
	public void insertAt(Node prev_Node, int new_data) {
		Node new_Node = new Node(new_data);
		new_Node.next = prev_Node.next;
		prev_Node.next = new_Node;
	}
	
	public void append(int new_data) {
		Node new_Node = new Node(new_data);
		if (head == null) {
			head = new_Node;
			return;
		}
		new_Node.next = null;
		Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		last.next = new_Node;
		return;
	}
	
	public void deleteNode(int key) {
		Node temp = head;
		Node prev = null;
		
		if(temp==null) {
			System.out.println("List is empty");
			return;
		}
		if(temp != null && temp.data == key) {
			head = temp.next;
			return;
		}
		
		while(temp != null && temp.data != key) {
			prev = temp;
			temp = head.next;	
		}
		prev.next = temp.next;
	}
	
	public int getCount() {
		Node temp = head;
		int count = 0;
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	public void swapNodes(int x, int y) {
		
		if (x == y) {
			return;
		}
		Node prevX = null, currX = head;
		while (currX != null && currX.data != x) {
			prevX = currX;
			currX = currX.next;
		}
		
		Node prevY = null, currY = head;
		while (currY != null && currY.data != y) {
			prevY = currY;
			currY = currY.next;
		}
		
		if (currX == null || currY == null) {
			return;
		}
		
		if (prevX != null) {
			prevX.next = currY;
		} else {
			head = currY;
		}
		
		if (prevY != null) {
			prevY.next = currX;
		} else {
			head = currX;
		}
		
		Node temp = currY.next;
		currY.next = currX.next;
		currX.next = temp;
	}
	
	public Node sortedMerge(Node headA, Node headB) {
		Node dummyNode = new Node(0);
		Node tail = dummyNode;
		
		while(true) {
			if (headA == null) {
				tail.next = headB;
				break;
			}
			if (headB == null) {
				tail.next = headA;
				break;
			}
			
			if (headA.data < headB.data) {
				tail.next = headA;
				headA = headA.next;
			} else {
				tail.next = headB;
				headB = headB.next;
			}
			tail = tail.next;
		}
		return dummyNode.next;
	}
	
	public static void main(String[] args) {
		Practice lList = new Practice();
		lList.append(6);
		lList.push(7);
		lList.push(1);
		lList.append(4);
		lList.insertAt(lList.head.next, 8);
		System.out.println("\nCreated LinkedList: ");
		lList.printList();
//		lList.deleteNode(1);
//		System.out.println("\nLinkedList after deletion: ");
//		lList.printList();
//		lList.swapNodes(8, 4);
//		System.out.println("\n Linked List after swapping");
//		lList.printList();
		
		
	}

}
