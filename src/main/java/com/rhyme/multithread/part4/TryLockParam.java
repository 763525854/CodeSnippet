/**
 *  Created by weiping.gong on 2018年6月14日
 */
package com.rhyme.multithread.part4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月14日
 */
public class TryLockParam {
	public ReentrantLock lock = new ReentrantLock();

	public void waitMethod() {
		try {
			if (lock.tryLock(3, TimeUnit.SECONDS)) {
				System.out.println("       " + Thread.currentThread().getName() + " get the locm time:"
						+ System.currentTimeMillis());
				Thread.sleep(10000);
			} else {
				System.out.println("       " + Thread.currentThread().getName() + " unget the lock");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (lock.isHeldByCurrentThread()) {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) {
		final TryLockParam service = new TryLockParam();
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + "调用waitMethod时间:" + System.currentTimeMillis());
				service.waitMethod();
			}
		};
		Thread threada = new Thread(runnable);
		threada.setName("A");
		threada.start();
		Thread threadb = new Thread(runnable);
		threadb.setName("B");
		threadb.start();
	}
}
