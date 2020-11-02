package com.rhyme.java程序员面试笔试宝典.part8;

import java.util.Arrays;
import java.util.Random;

public class 递归排序 {
	public static void main(String[] args) {
		int j = 100000;
		int[] a = new int[j];
		for (int i = 0; i < j; i++) {
			a[i] = new Random().nextInt(j - 1);
		}

		// System.out.println(Arrays.toString(a));
		int b[] = Arrays.copyOf(a, j);
		long time1 = System.currentTimeMillis();
		mergeSort(a);
		System.out.println(System.currentTimeMillis() - time1);
		time1 = System.currentTimeMillis();
		mergeSortB(b);
		System.out.println(System.currentTimeMillis() - time1);
		// int b[] = { 2, 4, 4, 6 };
		// int c[] = { 1, 4, 4, 5 };
		// int k[] = merge(b, c);
		// System.out.println(Arrays.toString(k));
	}

	public static void mergeSort(int[] a) {
		if (a.length > 1) {
			int mid = a.length / 2;
			int left[] = Arrays.copyOfRange(a, 0, mid);
			int right[] = Arrays.copyOfRange(a, mid, a.length);
			mergeSort(left);
			mergeSort(right);
			int[] temp = merge(left, right);
			System.arraycopy(temp, 0, a, 0, temp.length);
		}
	}

	public static void mergeSortB(int[] a) {
		if (a.length > 1) {
			int mid = a.length / 2;
			int left[] = Arrays.copyOfRange(a, 0, mid);
			int right[] = Arrays.copyOfRange(a, mid, a.length);
			mergeSort(left);
			mergeSort(right);
			int[] temp = mergeB(left, right);
			System.arraycopy(temp, 0, a, 0, temp.length);
		}
	}

	public static int[] merge(int[] left, int[] right) {
		// 高效
		int temp[] = new int[left.length + right.length];
		int current1 = 0;
		int current2 = 0;
		int current3 = 0;
		while (current1 < left.length && current2 < right.length) {
			if (left[current1] < right[current2]) {
				temp[current3++] = left[current1++];
			} else {
				temp[current3++] = right[current2++];
			}
		}
		while (current1 < left.length) {
			temp[current3++] = left[current1++];
		}
		while (current2 < right.length) {
			temp[current3++] = right[current2++];
		}
		return temp;
	}

	protected static int[] mergeB(int[] left, int[] right) {
		// 低效
		int[] result = new int[left.length + right.length];
		int i = 0;
		while (left.length > 0 && right.length > 0) {
			if (left[0] <= right[0]) {
				result[i++] = left[0];
				left = Arrays.copyOfRange(left, 1, left.length);
			} else {
				result[i++] = right[0];
				right = Arrays.copyOfRange(right, 1, right.length);
			}
		}
		while (left.length > 0) {
			result[i++] = left[0];
			left = Arrays.copyOfRange(left, 1, left.length);
		}
		while (right.length > 0) {
			result[i++] = right[0];
			right = Arrays.copyOfRange(right, 1, right.length);
		}
		return result;
	}
}
