/**
 *  Created by weiping.gong on 2018年6月13日
 */
package com.rhyme.multithread.part4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月13日
 */
public class HasQueuedThread {
	public ReentrantLock lock = new ReentrantLock();
	public Condition condition = lock.newCondition();

	public void waitMethod() {
		try {
			lock.lock();
			Thread.sleep(Integer.MAX_VALUE);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final HasQueuedThread service = new HasQueuedThread();
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				service.waitMethod();
			}
		};
		Thread threadA = new Thread(runnable);
		threadA.start();
		Thread.sleep(500);
		Thread threadB = new Thread(runnable);
		threadB.start();
		Thread.sleep(500);
		System.out.println(service.lock.hasQueuedThread(threadA));
		System.out.println(service.lock.hasQueuedThread(threadB));
		System.out.println(service.lock.hasQueuedThreads());
	}
}
