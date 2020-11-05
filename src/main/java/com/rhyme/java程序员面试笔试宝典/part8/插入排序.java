package com.rhyme.java程序员面试笔试宝典.part8;

import java.util.Arrays;
import java.util.Random;

/**
 * 对于给定的一组记录，初始时假设第一个记录自成一个有序序列，其余记录为无序序列。
 * 接着从第二个记录开始，按照记录的大小依次将当前处理的记录插入到其之前的有序序列中。
 * 直至最后一个记录插入到有序序列中为止
 * (效率略低于选择排序)
 * @author rhyme
 *
 */
public class 插入排序 {
	/**
	 * 等同于insertSortC方法
	 * @param a
	 */
	public static void insertSort(int a[]) {
		// 更高的效率
		long time = System.currentTimeMillis();
		for (int i = 1; i < a.length; i++) {
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

	/**
	 * 等同于insertSort方法
	 */
	public static void insertSortC(int a[]) {
		// 更高的效率
		long time = System.currentTimeMillis();
		for (int i = 1; i < a.length; i++) {
			int temp = a[i];
			for (int j = i; j > 0; j--) {
				if (temp < a[j - 1]) {
					a[j] = a[j - 1];
					a[j - 1] = temp;
				} else {
					break;
				}
			}
		}
		System.out.println((System.currentTimeMillis() - time) + "s");
	}

	public static void main(String[] args) {
		int j = 10000;
		int[] b = new int[j];
		int[] c = new int[j];
		for (int i = 0; i < j; i++) {
			b[i] = new Random().nextInt(j);
		}
		c = Arrays.copyOf(b, j);
		System.out.println(Arrays.toString(b));
		insertSort(b);
		System.out.println(Arrays.toString(b));
		// insertSortA(c);
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
