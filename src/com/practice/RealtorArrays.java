package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

class Node {
	int key;
	Node left, right;

	public Node(int item) {
		key = item;
		left = right = null;
	}
}

public class RealtorArrays {

	public static void main(String[] args) {

		// Scanner sc = new Scanner(System.in);
		// int T = Integer.parseInt(sc.nextLine());
		// while (T > 0) {
		// String noOfElements = sc.nextLine();
		// String elements = sc.nextLine();
		// ArrayList<Integer> arr = new ArrayList<Integer>();
		// String str[] = elements.split(" ");
		// for (String s : str) {
		// arr.add(Integer.parseInt(s));
		// }
		// System.out.println(kthSmallestElement(arr, arr.size(),
		// Integer.parseInt(sc.nextLine())));
		// T--;
		// }

		// Integer[] flatArray = flattenStream(arr).toArray(Integer[] ::new);
		// System.out.println(Arrays.toString(flatArray));

		// System.out.println(findEven(3, 11));
		// String name = "Surekha";
		// String reverse = "";
		// for(int i = name.length()-1; i>=0; i--) {
		// reverse += name.charAt(i);
		// }
		// System.out.println(reverse);
		//
		// int[] intArray = new int[]{};

//		int s[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
//		int d[] = { 15, 25, 35, 45, 55, 65, 75, 85, 95, 105 };
//
//		int source_arr[], sourcePos, dest_arr[], destPos, len;
//		source_arr = s;
//		sourcePos = 3;
//		dest_arr = d;
//		destPos = 5;
//		len = 5;
//
//		System.arraycopy(source_arr, sourcePos, dest_arr, destPos, len);
//
//		// Print elements of destination after
//		System.out.print("final dest_array : ");
//		for (int i = 0; i < d.length; i++)
//			System.out.print(d[i] + " ");
		
		System.out.println(evaluate("10 + 2 * 6")); 

	}

	static int kthSmallestElement(ArrayList<Integer> arrayList, int size, int smallest) {
		Collections.sort(arrayList);
		int smallestElement = arrayList.get(smallest - 1);
		return smallestElement;
	}

	static int[][] transformation(int[][] sourceArr, int m, int n) {
		int[][] destnArr = new int[][] {};
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				destnArr[c][m - r - 1] = sourceArr[r][c];
			}
		}
		return destnArr;
	}

	int maxLength = 0;

	public void leftView(Node node, int length) {
		if (node == null) {
			return;
		}
		if (maxLength < length) {
			System.out.println(node.key);
			maxLength = length;
		}
		leftView(node.left, length + 1);
		leftView(node.right, length + 1);
	}

	List<Integer> path1 = new ArrayList<>();
	List<Integer> path2 = new ArrayList<>();

	public int findLCA(Node node, int n1, int n2) {
		if ((!findPath(node, n1, path1)) || !findPath(node, n2, path2)) {
			return -1;
		}
		int i;
		for (i = 0; i < path1.size() && i < path2.size(); i++) {
			if (!path1.get(i).equals(path2.get(i))) {
				break;
			}
		}
		return path1.get(i - 1);
	}

	public boolean findPath(Node node, int n, List<Integer> path) {
		if (node == null) {
			return false;
		}
		path.add(node.key);
		if (node.key == n) {
			return true;
		}
		if (node.left != null || findPath(node.left, n, path)) {
			return true;
		}
		if (node.right != null || findPath(node.right, n, path)) {
			return true;
		}
		path.remove(path.size() - 1);
		return false;
	}

	public static <T> Stream<T> flattenStream(T[][] arrays) {

		// Create an empty list to collect the stream
		List<T> list = new ArrayList<>();

		// Using forEach loop
		// convert the array into stream
		// and add the stream into list
		for (T[] array : arrays) {
			Arrays.stream(array).forEach(list::add);
		}

		// Convert the list into Stream and return it
		return list.stream();
	}

	static int findEven(int start, int end) {
		int count = 0;
		for (int i = start; i <= end; i++) {
			if ((i % 2) == 0) {
				count++;
			}
		}
		return count;
	}

	public static int evaluate(String expression) {
		char[] tokens = expression.toCharArray();

		// Stack for numbers: 'values'
		Stack<Integer> values = new Stack<Integer>();

		// Stack for Operators: 'ops'
		Stack<Character> ops = new Stack<Character>();

		for (int i = 0; i < tokens.length; i++) {
			// Current token is a whitespace, skip it
			if (tokens[i] == ' ')
				continue;

			// Current token is a number, push it to stack for numbers
			if (tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuffer sbuf = new StringBuffer();
				// There may be more than one digits in number
				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
					sbuf.append(tokens[i++]);
				values.push(Integer.parseInt(sbuf.toString()));
			}

			// Current token is an opening brace, push it to 'ops'
			else if (tokens[i] == '(')
				ops.push(tokens[i]);

			// Closing brace encountered, solve entire brace
			else if (tokens[i] == ')') {
				while (ops.peek() != '(')
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));
				ops.pop();
			}

			// Current token is an operator.
			else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
				// While top of 'ops' has same or greater precedence to current
				// token, which is an operator. Apply operator on top of 'ops'
				// to top two elements in values stack
				while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));

				// Push current token to 'ops'.
				ops.push(tokens[i]);
			}
		}

		// Entire expression has been parsed at this point, apply remaining
		// ops to remaining values
		while (!ops.empty())
			values.push(applyOp(ops.pop(), values.pop(), values.pop()));

		// Top of 'values' contains result, return it
		return values.pop();
	}

	// Returns true if 'op2' has higher or same precedence as 'op1',
	// otherwise returns false.
	public static boolean hasPrecedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}

	// A utility method to apply an operator 'op' on operands 'a'
	// and 'b'. Return the result.
	public static int applyOp(char op, int b, int a) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0)
				throw new UnsupportedOperationException("Cannot divide by zero");
			return a / b;
		}
		return 0;
	}

}
