package com.rhyme.java程序员面试笔试宝典.part8;

import java.util.Arrays;
import java.util.Random;

public class 堆排序 {
	public static void main(String[] args) throws Exception {
		int j = 1000000;
		int[] a = new int[j];
		for (int i = 0; i < j; i++) {
			a[i] = new Random().nextInt(j - 1);
		}
		if (j < 100) {
			System.out.println(Arrays.toString(a));
		}
		long time = System.currentTimeMillis();
		sort(a);
		System.out.println(System.currentTimeMillis() - time);
		if (j < 100) {
			System.out.println(Arrays.toString(a));
		}
	}

	public static int heapParentIndex(int i) {
		if (i == 0) {
			return -1;
		}
		return (i - 1) / 2;
	}

	public static int heapLeftIndex(int i) {
		return i * 2 + 1;
	}

	public static int heapRightIndex(int[] a, int i) {
		return (i + 1) * 2;
	}

	public static int[] sort(int[] arr) throws Exception {
		int len = arr.length;
		buildMaxHeap(arr, len);
		for (int i = len - 1; i > 0; i--) {
			swap(arr, 0, i);
			len--;
			heapify(arr, 0, len);
		}
		return arr;
	}

	private static void buildMaxHeap(int[] arr, int len) {
		for (int i = len / 2 - 1; i >= 0; i--) {
			heapify(arr, i, len);
		}
	}

	private static void heapify(int[] arr, int i, int len) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int largest = i;

		if (left < len && arr[left] > arr[largest]) {
			largest = left;
		}

		if (right < len && arr[right] > arr[largest]) {
			largest = right;
		}

		if (largest != i) {
			swap(arr, i, largest);
			heapify(arr, largest, len);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
