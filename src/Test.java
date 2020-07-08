import java.util.ArrayList;
import java.util.Collections;

public class Test {

	public static void main(String[] args) {
		//int[][] arr = new int[][] { { 0, 1, 1 }, { 0, 1, 0 }, { 0, 1, 0 } };
		// interchange(arr, 1, 3);
		// int i = columnWithMaxZero(arr, 3);
		// System.out.println(i);
		// String s = "My Name is Surekha";
		// char[] character = new char[] {};
		// character = s.toCharArray();
		// System.out.println(character[2]);
//		String s = "OhMy9God27";
//
//		String regex = "\\d+";
//		for (int i = 0; i < s.length(); i++) {
//			if (Character.isDigit(s.charAt(i))) {
//				System.out.println("True");
//			}
//		}
//		int[] arr = new int[]{1, 2, 3, 4};
//		reverse(arr, 0, 3, 2);
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(3);
		Collections.sort(a);
		int smallestElement = a.get(2);
//	    return smallestElement;
//		int count = 0;
//		if(a.contains('a')) {
//			for (Character character : a) {
//				if(character == 'a') {
//					count+=1;
//				}
//			}
//			System.out.println("Count::: " + count);
//		}
		
	}

	static void interchange(int a[][], int r, int c) {

		// Your code here
		for (int i = 0; i < r; i++) {
			int temp = a[i][0];
			a[i][0] = a[i][c - 1];
			a[i][c - 1] = temp;
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	static int columnWithMaxZero(int a[][], int n) {

		int maxZeroes = 0;
		int columnNum = 0;

		for (int i = 0; i < n; i++) {
			int tempZeroes = 0;
			for (int j = 0; j < n; j++) {
				if (a[j][i] == 0) {
					tempZeroes += 1;
					if (tempZeroes >= maxZeroes) {
						maxZeroes = tempZeroes;
						columnNum = i;
					}
				}
			}
		}
		return columnNum;

	}

	static int coutChars(String s1, String s2) {
		char[] str1 = new char[] {};
		char[] str2 = new char[] {};
		int unavailable = 0;
		// Your code here
		str1 = s1.toCharArray();
		str2 = s2.toCharArray();
		for (int i = 0; i < str1.length; i++) {
			for (int j = 0; j < str2.length; j++) {
				if (str1[i] == str2[j]) {
					break;
				}
				if (j == str2.length - 1 && str1[i] != str2[j]) {
					unavailable += 1;
				}
			}
		}
		return unavailable;
	}

	public static int[] reverse(int arr[], int start, int end, int rotations) {
		int size = end+1;
		for (int i = 0; i < rotations; i++) {
			start = 0;
			end = arr.length -1;
			while (start < end) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
			}
			printArray(arr, size);
		}
		return arr;
	}

	static void printArray(int arr[], int size) {
		for (int i = 0; i < size; i++)
			System.out.print(arr[i] + " ");

		System.out.println();
	}
}
