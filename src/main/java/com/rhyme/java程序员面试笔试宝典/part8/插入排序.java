package com.rhyme.java程序员面试笔试宝典.part8;

import java.util.Arrays;
import java.util.Random;

public class 插入排序 {
	public static void insertSort(int a[]) {
		// 更高的效率
		long time = System.currentTimeMillis();
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				int temp = a[j - 1];
				if (a[j] < a[j - 1]) {
					a[j - 1] = a[j];
					a[j] = temp;
				} else {
					break;
				}
			}
		}
		System.out.println((System.currentTimeMillis() - time) + "s");
	}

	public static void main(String[] args) {
		int j = 100000;
		int[] b = new int[j];
		int[] c = new int[j];
		for (int i = 0; i < j; i++) {
			b[i] = new Random().nextInt(j);
		}
		c = Arrays.copyOf(b, j);
		insertSort(b);
		insertSortA(c);
	}

	public static void insertSortA(int a[]) {
		long time = System.currentTimeMillis();
		int j;
		for (int i = 1; i < a.length; i++) {
			Integer temp = a[i];
			for (j = i; j > 0 && temp.compareTo(a[j - 1]) < 0; j--)
				a[j] = a[j - 1];
			a[j] = temp;
		}
		System.out.println((System.currentTimeMillis() - time) + "s");
	}

}
