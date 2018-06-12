/**
 *  Created by weiping.gong on 2018年6月12日
 */
package com.rhyme.multithread.part4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月12日
 */
public class MyService {
	private Lock lock = new ReentrantLock();

	public void testMethod() {
		lock.lock();
		for (int i = 0; i < 5; i++) {
			System.out.println("threadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
		}
		lock.unlock();
	}

	public static void main(String[] args) {
		MyService service = new MyService();
		MyThread a1 = new MyThread(service);
		MyThread a2 = new MyThread(service);
		MyThread a3 = new MyThread(service);
		MyThread a4 = new MyThread(service);
		MyThread a5 = new MyThread(service);
		a1.start();
		a2.start();
		a3.start();
		a4.start();
		a5.start();
	}
}

class MyThread extends Thread {
	private MyService service;

	public MyThread(MyService service) {
		this.service = service;
	}

	@Override
	public void run() {
		super.run();
		service.testMethod();
	}
}