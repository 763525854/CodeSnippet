/**
 *  Created by weiping.gong on 2018年6月6日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月6日
 */
public class MyThread extends Thread {
	 public static int count;

	synchronized private static void addCount() {
		for (int i = 0; i < 100; i++) {
			count++;
		}
		System.out.println("count=" + count);
	}

	@Override
	public void run() {
		super.run();
		addCount();
	}

	public static void main(String[] args) {
		MyThread[] myThreads = new MyThread[100];
		for (int i = 0; i < 100; i++) {
			myThreads[i] = new MyThread();
			myThreads[i].start();
		}
	}
}
