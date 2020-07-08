import java.util.Arrays;
import java.util.Collections;

public class Practice_0513 {
	static Node root;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {2, 3, 5, -4, 5, 3, 4};
		//int arr[] = new int[] {3, 3, 2, 3};
		int n = arr.length;
//		pushZerosToEnd(arr, arr.length);
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
//		
//		Integer intArr[] = new Integer[] {6, 3, 2, 7, 4, 8, 1, 0, 5};
//		int k = 4;
//		topKElements(intArr, k);
		
//		Practice_0513 tree = new Practice_0513();
//		tree.root = new Node(0);
//		tree.root.left = new Node(1);
//		tree.root.right = new Node(2);
//		tree.root.left.left = new Node(4);
//		tree.root.left.right = new Node(5);
//		
//		int d1 = 4,d2 = 5;
//		if (checkIfNodesAreSiblings(root, d1, d2)) {
//			System.out.println("Yes");
//		} else {
//			System.out.println("No");
//		}
//		System.out.println(getSingle(arr, n));
//		System.out.println(findSingle(arr, n));
		System.out.println(maxSubArraySum(arr));
	}
	
	public static void pushZerosToEnd(int[] arr, int length) {
		int count = 0;
		for (int i = 0; i< length; i++) {
			if (arr[i] != 0) {
				arr[count++] = arr[i];
			}
		}
		while(count < length) {
			arr[count++] = 0;
		}
	}
	
	public static void topKElements(Integer[] arr, int k) {
		Arrays.sort(arr, Collections.reverseOrder());
		for (int i = 0; i< k; i ++) {
			System.out.println(arr[i]);
		}
	}
	
	public static Boolean checkIfNodesAreSiblings(Node root, int d1, int d2) {
		if (root == null) {
			return false;
		}
		if (root.left != null && root.right != null) {
			if ((root.left.key == d1 && root.right.key == d2)) {
				return true;
			} else if (root.left.key == d2 && root.right.key == d1) {
				return true;
			}
		}
		if (root.left != null) {
			checkIfNodesAreSiblings(root.left, d1, d2);
		}
		if (root.right != null) {
			checkIfNodesAreSiblings(root.right, d1, d2);
		}
		return false;
	}
	
	public static int getSingle(int[] arr, int n) {
		int ones = 0, twos = 0;
		int common_bit_mask;
		for (int i = 0; i < n; i++) {
			twos = twos | (ones & arr[i]);
			ones = ones ^ arr[i];
			common_bit_mask = ~(ones & twos);
			ones &= common_bit_mask;
			twos &= common_bit_mask;
		}
		return ones;
	}
	
	public static int findSingle(int[] arr, int n) {
		int res = arr[0];
		for(int i = 1; i< n; i++) {
			res = res ^ arr[i];
		}
		return res;
	}
	
	public static  int maxSubArraySum(int[] a) {
		int size = a.length;
		int max_so_far = 0, max_ending_here = 0;
		for (int i = 0; i< size; i++) {
			max_ending_here = max_ending_here + a[i];
			if (max_ending_here < 0) {
				max_ending_here = 0;
			}
			if (max_ending_here > max_so_far) {
				max_so_far = max_ending_here;
			}
		}
		return max_so_far;
	}

}
