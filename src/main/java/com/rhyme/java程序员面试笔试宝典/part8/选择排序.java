package com.rhyme.java程序员面试笔试宝典.part8;

import java.util.Arrays;
import java.util.Random;

/**
 * 对于给定的一组记录，经过第一轮比较后得到最小的记录，然后将该记录与第一个记录的位置进行交换。
 * 接着对不包括第一个的记录进行第二轮比较，得到最小的记录与第二个记录进行交换。重复该过程.
 * 效率较低。10W数据，耗时2秒左右。50W数据耗时1分钟左右。100W数据，三分钟。
 * 
 * @author rhyme
 */
public class 选择排序 {

	public static void main(String[] args) {
		int j = 100000;
		int[] a = new int[j];
		for (int i = 0; i < j; i++) {
			a[i] = new Random().nextInt(j);
		}
		long time = System.currentTimeMillis();
		selectSort(a);
		System.out.println((System.currentTimeMillis() - time) + "s");
	}

	public static void selectSort(int a[]) {
		int i;
		int j;
		int temp = 0;
		int flag = 0;
		int n = a.length;
		for (i = 0; i < n; i++) {
			temp = a[i];
			flag = i;
			for (j = i + 1; j < n; j++) {
				if (a[j] < temp) {
					temp = a[j];
					flag = j;
				}
			}
			//当某个位置的元素执行for循环判断时，发现自己是最小值时，此时不需要执行无必要的交换操作。
			if (flag != i) {
				a[flag] = a[i];
				a[i] = temp;
			}
		}
	}
}
