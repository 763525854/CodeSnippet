package com.rhyme.java程序员面试笔试宝典.part8;

import java.util.Arrays;
import java.util.Random;

public class 冒泡排序 {
	public static void main(String[] args) {
		int j = 100000;
		int[] a = new int[j];
		for (int i = 0; i < j; i++) {
			a[i] = new Random().nextInt(j - 1);
		}
		int[] b = new int[j];
		b = Arrays.copyOf(a, j);
		bubbleSort(a);
		bubbleSortB(b);
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

	public static void bubbleSortB(int a[]) {
		// 冒泡排序增强型，当中途某次循环时，发现没有任何改动，说明此时已经排序好了。不必进行后续的比较
		long time = System.currentTimeMillis();
		boolean needNextPass = true;
		for (int i = 1; i < a.length && needNextPass; i++) {
			needNextPass = false;
			for (int j = 0; j < a.length - i; j++) {
				int temp = a[j];
				if (a[j] > a[j + 1]) {
					a[j] = a[j + 1];
					a[j + 1] = temp;
					needNextPass = true;
				}
			}
		}
		System.out.println((System.currentTimeMillis() - time) + "s");
	}
}
