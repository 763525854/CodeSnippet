/**
 *  Created by weiping.gong on 2018年6月7日
 */
package com.rhyme.multithread.part3;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月7日
 */
public class NotifyOne {
	public void testMethod(Object lock) {
		synchronized (lock) {
			System.out.println("begin wait() threadname=" + Thread.currentThread().getName());
			for (int i = 0; i < 100; i++) {
				System.out.println("this is thread" + Thread.currentThread().getName());
			}
			try {
				lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("end wait() threadname=" + Thread.currentThread().getName());
			lock.notify();
		}
	}

	public static void main(String[] args) {
		Object lock = new Object();
		NotifyOneTA a = new NotifyOneTA(lock);
		NotifyOneTB b = new NotifyOneTB(lock);
		NotifyOneTC c = new NotifyOneTC(lock);
		a.start();
		b.start();
		c.start();
		NotifyOneThread notifyOneThread = new NotifyOneThread(lock);
		notifyOneThread.start();
	}
}

class NotifyOneTA extends Thread {
	private Object lock;

	public NotifyOneTA(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		super.run();
		NotifyOne service = new NotifyOne();
		service.testMethod(lock);
	}
}

class NotifyOneTB extends Thread {
	private Object lock;

	public NotifyOneTB(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		super.run();
		NotifyOne service = new NotifyOne();
		service.testMethod(lock);
	}
}

class NotifyOneTC extends Thread {
	private Object lock;

	public NotifyOneTC(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		super.run();
		NotifyOne service = new NotifyOne();
		service.testMethod(lock);
	}
}

class NotifyOneThread extends Thread {
	private Object lock;

	public NotifyOneThread(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		super.run();
		synchronized (lock) {
			lock.notifyAll();
			// lock.notify();
			// lock.notify();
			// lock.notify();
		}
	}
}
