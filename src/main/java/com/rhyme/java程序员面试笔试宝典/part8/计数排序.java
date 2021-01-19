package com.rhyme.java程序员面试笔试宝典.part8;

public class 计数排序 {
	public static void main(String[] args) {
		// 排序的数组
		int a[] = { 100, 93, 97, 92, 96, 99, 92, 89, 93, 97, 90, 94, 92, 95 };
		int b[] = countSort(a);
		for (int i : b) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	/**
	 * 优化版
	 * 
	 * @param A
	 * @return
	 */
	public static int[] countSort(int[] A) {
		// 找出数组A中的最大值、最小值
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int num : A) {
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		// 初始化计数数组count
		// 长度为最大值减最小值加1
		int[] count = new int[max - min + 1];
		// 对计数数组各元素赋值
		for (int num : A) {
			// A中的元素要减去最小值，再作为新索引
			count[num - min]++;
		}
		// 创建结果数组
		int[] result = new int[A.length];
		// 创建结果数组的起始索引
		int index = 0;
		// 遍历计数数组，将计数数组的索引填充到结果数组中
		for (int i = 0; i < count.length; i++) {
			while (count[i] > 0) {
				// 再将减去的最小值补上
				result[index++] = i + min;
				count[i]--;
			}
		}
		// 返回结果数组
		return result;
	}

	/**
	 * 基础版，存在空间浪费
	 * 
	 * @param A
	 * @return
	 */
	public int[] countSortA(int[] A) {
		// 找出数组A中的最大值
		int max = Integer.MIN_VALUE;
		for (int num : A) {
			max = Math.max(max, num);
		}
		// 初始化计数数组count
		int[] count = new int[max + 1];
		// 对计数数组各元素赋值
		for (int num : A) {
			count[num]++;
		}
		// 创建结果数组
		int[] result = new int[A.length];
		// 创建结果数组的起始索引
		int index = 0;
		// 遍历计数数组，将计数数组的索引填充到结果数组中
		for (int i = 0; i < count.length; i++) {
			while (count[i] > 0) {
				result[index++] = i;
				count[i]--;
			}
		}
		// 返回结果数组
		return result;
	}
}
