/**
 *  Created by weiping.gong on 2018年6月14日
 */
package com.rhyme.multithread.part4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import com.ibm.icu.util.Calendar;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月14日
 */
public class AwaitUntil {
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void waitMethod() {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.SECOND, 10);
			lock.lock();
			System.out.println("wait begin timer=" + System.currentTimeMillis());
			condition.awaitUntil(calendar.getTime());
			System.out.println("wait end timer=" + System.currentTimeMillis());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void notifyMethod() {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.SECOND, 10);
			lock.lock();
			System.out.println("notify begin timer=" + System.currentTimeMillis());
			condition.signalAll();
			System.out.println("notify end timer=" + System.currentTimeMillis());
		} catch (Exception e) {
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		AwaitUntil service = new AwaitUntil();
		ThreadAUA thread = new ThreadAUA(service);
		thread.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ThreadAUB threadAUB = new ThreadAUB(service);
		threadAUB.start();
	}
}

class ThreadAUA extends Thread {
	private AwaitUntil service;

	public ThreadAUA(AwaitUntil service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		super.run();
		service.waitMethod();
	}
}

class ThreadAUB extends Thread {
	private AwaitUntil service;

	public ThreadAUB(AwaitUntil service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		super.run();
		service.notifyMethod();
	}
}