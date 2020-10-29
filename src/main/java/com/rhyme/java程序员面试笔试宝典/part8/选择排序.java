package com.rhyme.java程序员面试笔试宝典.part8;

public class 选择排序 {
	
	public static void main(String[] args) {
		int a[]= {5,4,9,8,7,6,0,1,3,2};
		selectSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	public static void selectSort(int a[]) {
		int i;
		int j;
		int temp=0;
		int flag=0;
		int n=a.length;
		for (i = 0; i < n; i++) {
			temp=a[i];
			flag=i;
			for (j = i+1; j < n; j++) {
				if (a[j]<temp) {
					temp=a[j];
					flag=j;
				}
			}
			if (flag!=i) {
				a[flag]=a[i];
				a[i]=temp;
			}
		}
	}
}
