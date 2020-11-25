package com.rhyme.java程序员面试笔试宝典.part8;

import java.util.Arrays;
import java.util.Random;

public class 快速排序 {
	// 经过测试，快速排序的算法优于归并排序，即优于递归排序。千万级数组排序，平均效能是两倍
	public static void main(String[] args) {
		int j = 100000000;
		int[] a = new int[j];
		for (int i = 0; i < j; i++) {
			a[i] = new Random().nextInt(j - 1);
		}
		int[] c = new int[j];
		c = Arrays.copyOf(a, j);
		if (j < 100) {
			System.out.println(Arrays.toString(c));
		}
		long time = System.currentTimeMillis();
		quickSort(c, 0, c.length - 1);
		System.out.println(System.currentTimeMillis() - time);
		if (j < 100) {
			System.out.println(Arrays.toString(c));
		}
	}

	public static void quickSort(int[] a, int left, int rihgt) {
		int temp = a[left];
		int i = left;
		int j = rihgt;
		while (i != j) {
			while (a[j] >= temp && j > i) {
				j--;
			}
			while (a[i] <= temp && j > i) {
				i++;
			}
			if (i < j) {
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		a[left] = a[i];
		a[i] = temp;
		if (left < i - 1) {
			// 继续处理左边的数据，直到左边数据只剩1个，或者不剩数据
			quickSort(a, left, i - 1);
		}
		if (rihgt > j + 1) {
			// 继续处理右边的数据，直到右边的数据只剩1个，或者不剩数据
			quickSort(a, i + 1, rihgt);
		}
	}

}
