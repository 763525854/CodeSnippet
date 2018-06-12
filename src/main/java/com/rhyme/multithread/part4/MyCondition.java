/**
 *  Created by weiping.gong on 2018年6月12日
 */
package com.rhyme.multithread.part4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月12日
 */
public class MyCondition {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void await() {
		try {
			lock.lock();
			System.out.println("aaaaaaaaaaaaaaaaaaaaa");
			// condition.await();
			condition.await(2, TimeUnit.SECONDS);
			// condition.signal();
			System.out.println("bbbbbbbbbbbbbbbbbbbbb");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		MyCondition service = new MyCondition();
		ThreadCondition a = new ThreadCondition(service);
		a.start();
	}
}

class ThreadCondition extends Thread {
	private MyCondition service;

	public ThreadCondition(MyCondition service) {
		this.service = service;
	}

	@Override
	public void run() {
		super.run();
		service.await();
	}
}
