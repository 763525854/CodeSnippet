package com.rhyme.java程序员面试笔试宝典.part8;

import java.util.Random;

public class 冒泡排序 {
	public static void main(String[] args) {
		int j = 100000;
		int[] a = new int[j];
		for (int i = 0; i < j; i++) {
			a[i] = new Random().nextInt(j-1);
		}
		bubbleSort(a);
	}

	public static void bubbleSort(int a[]) {
		long time = System.currentTimeMillis();
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < a.length - i; j++) {
				int temp = a[j];
				if (a[j] > a[j + 1]) {
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		System.out.println((System.currentTimeMillis() - time) + "s");
	}
}
