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
public class IsFair {
	private ReentrantLock lock;

	public IsFair(boolean isFair) {
		super();
		lock = new ReentrantLock(isFair);
	}

	public void serviceMethod() {
		try {
			lock.lock();
			System.out.println("公平锁情况：" + lock.isFair());
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		final IsFair service1 = new IsFair(true);
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				service1.serviceMethod();

			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		final IsFair service2 = new IsFair(false);
		runnable = new Runnable() {

			@Override
			public void run() {
				service2.serviceMethod();

			}
		};

		thread = new Thread(runnable);
		thread.start();
	}
}
