/**
 *  Created by weiping.gong on 2018年6月14日
 */
package com.rhyme.multithread.part4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月14日
 */
public class AwaitUninterruptibly {
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void testMethod() {
		try {
			lock.lock();
			System.out.println("wait begin");
			// condition.await();
			condition.awaitUninterruptibly();
			System.out.println("wait end");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("catch");
		} finally {
			lock.unlock();
		}
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		AwaitUninterruptibly service = new AwaitUninterruptibly();
		MyThreadA myThreadA = new MyThreadA(service);
		myThreadA.start();
		myThreadA.sleep(3000);
		myThreadA.interrupt();
	}
}

class MyThreadA extends Thread {
	private AwaitUninterruptibly service;

	public MyThreadA(AwaitUninterruptibly service) {
		this.service = service;
	}

	@Override
	public void run() {
		super.run();
		service.testMethod();
	}
}
