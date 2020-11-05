package com.rhyme.java程序员面试笔试宝典.part8;

import java.util.Arrays;
import java.util.Random;

/**
 * 
 * @deprecated 对于给定的一组记录，经过第一轮比较后得到最小的记录，然后将该记录与第一个记录的位置进行交换。
 *             接着对不包括第一个的记录进行第二轮比较，得到最小的记录与第二个记录进行交换。重复该过程
 *             效率较低。10W数据，耗时2秒左右。50W数据耗时1分钟左右。100W数据，三分钟。
 * 
 * @author rhyme
 */
public class 选择排序B {
	public static void selectSort(int a[]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				// 非常糟糕的选择排序实现方式
				int temp = a[i];
				if (a[i] > a[j]) {
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int j = 10;
		int[] a = new int[j];
		for (int i = 0; i < j; i++) {
			a[i] = new Random().nextInt(j);
		}
		System.out.println(Arrays.toString(a));
		selectSort(a);
		System.out.println(Arrays.toString(a));
	}
}
