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
public class GetWaitQueueLength {
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void waitMethod() {
		try {
			lock.lock();
			condition.await();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void notityMethod() {
		try {
			lock.lock();
			System.out.println("有" + lock.getWaitQueueLength(condition) + "个线程正在等待condition");
			condition.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final GetWaitQueueLength service = new GetWaitQueueLength();
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				service.waitMethod();
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
		service.notityMethod();
	}
}
