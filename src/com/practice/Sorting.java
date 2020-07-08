package com.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;


public class Sorting {
	
	private Node head;
	public Node2 root;
	Maximum max = new Maximum(); 
    static Node2 target_leaf = null; 
	
	public static class Node{
		private int value;
		private Node next;
		
		Node(int value) {
			this.value = value;
		}
	}
	
	public static class Node2{
		 int key;
		 Node2 left, right;
		
		Node2(int key) {
			this.key = key;
			left = right = null;
		}
	}
	
	class Maximum { 
	    int max_no = Integer.MIN_VALUE; 
	} 

	
	static int[] array = { 20, 2, 15, 12, 18, 32, 6, 17 };
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// bubbleSort(array);
		// insertionSort(array);
		// printArray(selectionSort(array));

//		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
//		pQueue.add(15);
//		pQueue.add(2);
//		pQueue.add(12);
//		pQueue.add(32);
//		pQueue.add(6);
//		pQueue.add(17);
//
//		Iterator itr = pQueue.iterator();
//		while (itr.hasNext())
//			System.out.println(itr.next());
//		mergeSort(array, 0, array.length-1);
//		quickSort(0, array.length-1);
//		printArray(array);
		
		
		Sorting tree = new Sorting();
		tree.root = new Node2(10);
		tree.root.left = new Node2(-2); 
        tree.root.right = new Node2(7); 
        tree.root.left.left = new Node2(8); 
        tree.root.left.right = new Node2(-4); 
       int sum = tree.maxSumPath();
       System.out.println(sum);

	}
	
	public int maxSumPath() {
		if (root == null) {
			return 0;
		}
		getTargetLeaf(root, max, 0);
		printPath(root, target_leaf);
		return max.max_no;
	}
	
	static void getTargetLeaf(Node2 node, Maximum max_ref, int curr_sum) {
		if (node == null) {
			return;
		}
		curr_sum = curr_sum + node.key;
		if (node.left == null && node.right == null) {
			if (curr_sum > max_ref.max_no) {
				max_ref.max_no = curr_sum;
				target_leaf = node;
			}
		}
		getTargetLeaf(node.left, max_ref, curr_sum);
		getTargetLeaf(node.right, max_ref, curr_sum);
	}
	
	static boolean printPath(Node2 node, Node2 target_leaf) {
		if (node == null) {
			return false;
		}
		if (node == target_leaf || printPath(node.left, target_leaf) || printPath(node.right, target_leaf)) {
			System.out.println(node.key + " ");
			return true;
		}
		return false;
	}

	public static int[] bubbleSort(int[] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[i] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
			System.out.println("Interation:: " + (i + 1));
			printArray(array);
		}
		return array;
	}

	public static int[] insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int valueToSort = array[i];
			int j;
			for (j = i; j > 0 && array[j - 1] > valueToSort; j--) {
				array[j] = array[j - 1];
			}
			array[j] = valueToSort;
			System.out.println("Interation:: " + (i));
			printArray(array);
		}
		return array;
	}

	public static int[] selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int index = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[index]) {
					index = j;
				}
			}
			int smallNumber = array[index];
			array[index] = array[i];
			array[i] = smallNumber;
		}
		return array;
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void printArray(int[] array, int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.println(array[i] + " ");
		}
		System.out.println();
	}

	public static void mergeSort(int[] array, int start, int end) {
		int mid = (start + end) / 2;

		if (start < end) {
			mergeSort(array, start, mid);
			mergeSort(array, mid + 1, end);
			merge(start, mid, end);
		}
	}
	
	public static void merge(int start, int mid, int end) {
		int[] tempArray = new int[array.length];
		int tempArrayIndex = start;
		
		int startIndex = start;
		int midIndex = mid+1;
		
		while(startIndex <= mid && midIndex <= end) {
			if(array[startIndex] < array[midIndex]) {
				tempArray[tempArrayIndex++] = array[startIndex++];
			} else {
				tempArray[tempArrayIndex++] = array[midIndex++];
			}
		}
		
		while(startIndex <= mid) {
			tempArray[tempArrayIndex++] = array[startIndex++];
		}
		while(midIndex <= end) {
			tempArray[tempArrayIndex++] = array[midIndex++];
		}
		
		for(int i = start; i<=end; i++) {
			array[i] = tempArray[i];
		}
		
		printArray(tempArray, start, end);
	}
	
	public static void quickSort(int left, int right) {
		int i = left;
		int j = right;
		
		int pivot = array[(left + right) /2];
		while(i <= j) {
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			if ( i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}
		if(left < j) {
			quickSort(left, j);
		}
		if (i < right) {
			quickSort(i, right);
		}
	}
	
	public static void exchange(int i, int j) {
		int temp = array[i];
		array[i]  =array[j];
		array[j] = temp;
	}
	
	public Node findMiddleNode(Node head) {
		Node slowpointer, fastPointer;
		slowpointer = fastPointer = head;
		
		while(fastPointer != null) {
			fastPointer = fastPointer.next;
			if (fastPointer != null && fastPointer.next != null) {
				slowpointer = slowpointer.next;
				fastPointer = fastPointer.next;
			}
		}
		return slowpointer;
	}
	
	public static void heapify(int[] arr, int i, int size) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int max;
		if (left <= size && arr[left] > arr[i]) {
			max = left;
		} else {
			max = i;
		}
 
		if (right <= size && arr[right] > arr[max]) {
			max = right;
		}
		// If max is not current node, exchange it with max of left and right child
		if (max != i) {
			exchange(i, max);
			heapify(arr, max, size);
		}
	}

}
