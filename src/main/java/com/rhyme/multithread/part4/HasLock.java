/**
 *  Created by weiping.gong on 2018年6月12日
 */
package com.rhyme.multithread.part4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月12日
 */
public class HasLock {
	public ReentrantLock lock = new ReentrantLock();
	public Condition newCondition = lock.newCondition();

	public void waitMethod() {
		try {
			lock.lock();
			Thread.sleep(Integer.MAX_VALUE);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final HasLock service=new HasLock();
		Runnable runnable=new Runnable() {
			
			@Override
			public void run() {
				service.waitMethod();
			}
		};
		Thread threadA=new Thread(runnable);
		threadA.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread threadB=new Thread(runnable);
		threadB.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(service.lock.hasQueuedThread(threadA));
		System.out.println(service.lock.hasQueuedThread(threadB));
		System.out.println(service.lock.hasQueuedThreads());
	}
}
