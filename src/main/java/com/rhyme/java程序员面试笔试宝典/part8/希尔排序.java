package com.rhyme.java程序员面试笔试宝典.part8;

import java.util.Arrays;
import java.util.Random;

/**
 * 插入排序增强版，效率不如快速排序.
 * 
 * @author Administrator
 *
 */
public class 希尔排序 {
	public static void main(String[] args) {
		int j = 10000000;
		int[] a = new int[j];
		for (int i = 0; i < j; i++) {
			a[i] = new Random().nextInt(j - 1);
		}
		if (j <= 100) {
			System.out.println(Arrays.toString(a));
		}
		long time = System.currentTimeMillis();
		int b[] = Arrays.copyOf(a, j);
		shellSort(a);
		shellSortB(b);
		System.out.println(System.currentTimeMillis() - time);
		if (j <= 100) {
			System.out.println(Arrays.toString(a));
		}
	}

	/**
	 * 希尔排序
	 * 
	 * @param arr
	 */
	public static void shellSort(int[] arr) {
		long time = System.currentTimeMillis();
		int length = arr.length;
		int temp;
		for (int step = (int) (length / 2); step >= 1; step /= 2) {
			for (int i = step; i < length; i++) {
				temp = arr[i];
				int j = i - step;
				while (j >= 0 && arr[j] > temp) {
					arr[j + step] = arr[j];
					j -= step;
				}
				arr[j + step] = temp;
			}
		}
		System.out.println((System.currentTimeMillis() - time) + "shellSort花费时间");
	}

	/**
	 * 增强型希尔排序写法 用2.2的效率高于用2的效率
	 * 
	 * @param
	 */
	public static void shellSortB(int a[]) {
		long time = System.currentTimeMillis();
		for (int step = (int) (a.length / 2.2); step >= 1; step /= 2.2) {
			for (int i = step; i < a.length; i++) {
				int temp = a[i];
				int j = i - step;
				// 因为这里需要循环判断步长，所以用while
				while (j >= 0 && a[j] > temp) {
					a[j + step] = a[j];
					a[j] = temp;
					j -= step;
				}
			}
		}
		System.out.println((System.currentTimeMillis() - time) + "shellSortB花费时间");
	}

}
