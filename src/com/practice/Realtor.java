package com.practice;

import java.util.ArrayList;
import java.util.Collections;

public class Realtor {
	static int kthSmallestElement(ArrayList<Integer> arrayList, int size, int smallest) {
		Collections.sort(arrayList);
		int smallestElement = arrayList.get(smallest - 1);
		return smallestElement;
	}
}


