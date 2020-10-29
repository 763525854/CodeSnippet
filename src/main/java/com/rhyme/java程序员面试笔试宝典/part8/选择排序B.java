package com.rhyme.java程序员面试笔试宝典.part8;

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
		int a[]= {5,4,9,8,7,6,0,1,3,2};
		selectSort(a);
	}
}
