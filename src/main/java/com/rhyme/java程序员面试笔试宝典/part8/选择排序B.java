package com.rhyme.java程序员面试笔试宝典.part8;

import java.util.Random;

public class 选择排序B {
	public static void selectSort(int a[]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				int temp=a[i];
				if (a[i]>a[j]) {
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	public static void main(String[] args) {	
		int j = 10;
		int[] a = new int[j];
		for (int i = 0; i < j; i++) {
			a[i] = new Random().nextInt(j);
		}
		selectSort(a);
	}
}
