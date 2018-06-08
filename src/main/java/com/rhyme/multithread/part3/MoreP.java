/**
 *  Created by weiping.gong on 2018年6月8日
 */
package com.rhyme.multithread.part3;

import com.rhyme.multithread.part2.RunThread;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月8日
 */
public class MoreP {
	private String lock;

	public MoreP(String lock) {
		super();
		this.lock = lock;
	}

	public void setValue() {
		try {
			synchronized (lock) {
				while (!ValueObject2.value.equals("")) {
					System.out.println("生产者" + Thread.currentThread().getName() + "WAITING了");
					lock.wait();
				}
				System.out.println("生产者，" + Thread.currentThread().getName() + "Runnable 了");
				String value = System.currentTimeMillis() + "__" + System.nanoTime();
				ValueObject2.value = value;
				lock.notify();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String lock = new String("");
		MoreP p = new MoreP(lock);
		MoreC r = new MoreC(lock);
		ThreadMPA[] pThreadMPAs = new ThreadMPA[2];
		ThreadMPC[] pThreadMPCs = new ThreadMPC[2];
		for (int i = 0; i < 2; i++) {
			pThreadMPAs[i] = new ThreadMPA(p);
			pThreadMPAs[i].setName("生产者" + (i + 1));
			pThreadMPCs[i] = new ThreadMPC(r);
			pThreadMPCs[i].setName("消费者" + (i + 1));
			pThreadMPAs[i].start();
			pThreadMPCs[i].start();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread[] threadArray = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
		Thread.currentThread().getThreadGroup().enumerate(threadArray);
		for (int i = 0; i < threadArray.length; i++) {
			System.out.println(threadArray[i].getName() + "" + threadArray[i].getState());
		}
	}
}

class MoreC {
	private String lock;

	public MoreC(String lock) {
		this.lock = lock;
	}

	public void getValue() {
		try {
			synchronized (lock) {
				while (ValueObject2.value.equals("")) {
					System.out.println("消费者" + Thread.currentThread().getName() + " watingasa");
					lock.wait();
				}
				System.out.println("消费者" + Thread.currentThread().getName());
				ValueObject2.value = "";
				lock.notify();
			}
		} catch (Exception e) {
		}
	}
}

class ThreadMPA extends Thread {
	private MoreP p;

	public ThreadMPA(MoreP p) {
		this.p = p;
	}

	@Override
	public void run() {
		super.run();
		while (true) {
			p.setValue();
		}
	}

}

class ThreadMPC extends Thread {
	private MoreC r;

	/**
	 * 
	 */
	public ThreadMPC(MoreC r) {
		this.r = r;
	}

	@Override
	public void run() {
		super.run();
		while (true) {
			r.getValue();
		}
	}
}
