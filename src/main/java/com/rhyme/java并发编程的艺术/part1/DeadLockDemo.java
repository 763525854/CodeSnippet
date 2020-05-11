/**
 *  Created by weiping.gong on 2018年6月28日
 */
package com.rhyme.java并发编程的艺术.part1;

/**
 * @Author: weiping.gong
 * @Description: 死锁案例
 * @Date: created in 2018年6月28日
 */
public class DeadLockDemo {
	private static String A = "A";
	private static String B = "B";

	public static void main(String[] args) {
		new DeadLockDemo().deadLock();
	}

	private void deadLock() {
		Thread t1 = new Thread(new Runnable() {

			@SuppressWarnings("static-access")
			@Override
			public void run() {
				synchronized (A) {
					try {
						System.out.println("into A thread");
						 Thread.currentThread().sleep(2000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					synchronized (B) {
						System.out.println("1");
					}
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (B) {
					System.out.println("into B thread");
					synchronized (A) {
						System.out.println("2");
					}
				}
			}
		});

		t1.start();
		t2.start();
	}
}
