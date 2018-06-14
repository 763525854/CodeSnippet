/**
 *  Created by weiping.gong on 2018年6月14日
 */
package com.rhyme.multithread.part4;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月14日
 */
public class TryLock {
	public ReentrantLock lock = new ReentrantLock();

	public void waitMethod() {
		if (lock.tryLock()) {
			System.out.println(Thread.currentThread().getName() + " get the lock");
		} else {
			System.out.println(Thread.currentThread().getName() + " unget the lock");
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		final TryLock service=new TryLock();
		Runnable runnable=new Runnable() {
			
			@Override
			public void run() {
				service.waitMethod();
			}
		};
		Thread threadA=new Thread(runnable);
		threadA.setName("A");
		threadA.start();
		Thread.sleep(50);
		Thread threadB=new Thread(runnable);
		threadB.setName("B");
		threadB.start();
	}
}
