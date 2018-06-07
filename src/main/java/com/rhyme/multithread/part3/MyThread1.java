/**
 *  Created by weiping.gong on 2018年6月7日
 */
package com.rhyme.multithread.part3;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月7日
 */
public class MyThread1 extends Thread {
	private Object lock;

	public MyThread1(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		super.run();
		try {
			synchronized (lock) {
				System.out.println("开始 wait time=" + System.currentTimeMillis());
				lock.wait();
				System.out.println("结束 wait time=" + System.currentTimeMillis());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Object mylock = new Object();
		MyThread1 t1 = new MyThread1(mylock);
		t1.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MyThread2 t2 = new MyThread2(mylock);
		t2.start();
	}
}

class MyThread2 extends Thread {
	private Object lock;

	public MyThread2(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		super.run();
		synchronized (lock) {
			System.out.println("开始notify time=" + System.currentTimeMillis());
			lock.notify();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("结束notify time=" + System.currentTimeMillis());
		}
	}
}
