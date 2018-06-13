/**
 *  Created by weiping.gong on 2018年6月13日
 */
package com.rhyme.multithread.part4;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月13日
 */
public class GetQueueLength {
	public ReentrantLock lock = new ReentrantLock();

	public void serviceMethod1() {
		try {
			lock.lock();
			System.out.println("ThreadName=" + Thread.currentThread().getName() + "进入方法");
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final GetQueueLength service = new GetQueueLength();
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				service.serviceMethod1();

			}
		};
		Thread[] threadArray = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threadArray[i] = new Thread(runnable);
		}
		for (int i = 0; i < 10; i++) {
			threadArray[i].start();
		}
		Thread.sleep(2000);
		System.out.println("有线程数" + service.lock.getQueueLength() + "在等待获取锁");

	}
}
