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
public class IsHeldByCurrentThread {
	private ReentrantLock lock;

	public IsHeldByCurrentThread(boolean isFair) {
		super();
		lock = new ReentrantLock(isFair);
	}

	public void serviceMethod() {
		try {
			System.out.println(lock.isHeldByCurrentThread());
			lock.lock();
			System.out.println(lock.isHeldByCurrentThread());
		} catch (Exception e) {
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final IsHeldByCurrentThread service=new IsHeldByCurrentThread(true);
		Runnable runnable=new Runnable() {
			
			@Override
			public void run() {
				service.serviceMethod();
			}
		};
		Thread thread=new Thread(runnable);
		thread.start();
	}
}
