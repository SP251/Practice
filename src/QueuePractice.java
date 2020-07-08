
class QNode {
	int key;
	QNode next;
	
	public QNode(int key) {
		this.key = key;
		this.next = null;
	}
}

public class QueuePractice {
	QNode front, rear;
	
	public QueuePractice() {
		this.front = this.rear = null;
	}
	
	void enQueue(int key) {
		
		QNode temp = new QNode(key);
		
		if (this.rear == null) {
			this.rear = this.front = temp;
		}
		
		this.rear.next = temp;
		this.rear = temp;
	}
	
	
	QNode deQueue() {
		if (this.front == null) {
			return null;
		}
		QNode temp = this.front;
		this.front = this.front.next;
		if (this.front == null) {
			this.rear = null;
		}
		return temp;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
