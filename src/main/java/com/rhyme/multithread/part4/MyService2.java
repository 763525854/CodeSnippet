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
public class MyService2 {
	private Lock lock = new ReentrantLock();

	public void methodA() {
		try {
			lock.lock();
			System.out.println("methodA a begin threadname=" + Thread.currentThread().getName() + " time= "
					+ System.currentTimeMillis());

			Thread.sleep(5000);

			System.out.println("methodA a end threadname=" + Thread.currentThread().getName() + " time= "
					+ System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void methodB() {
		try {
			lock.lock();
			System.out.println("methodB b begin threadname=" + Thread.currentThread().getName() + " time= "
					+ System.currentTimeMillis());

			Thread.sleep(5000);

			System.out.println("methodB b end threadname=" + Thread.currentThread().getName() + " time= "
					+ System.currentTimeMillis());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		MyService2 service = new MyService2();
		TSA a = new TSA(service);
		a.setName("A");
		a.start();
		TSB aa = new TSB(service);
		aa.setName("AA");
		aa.start();
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		TSC b = new TSC(service);
		b.setName("B");
		b.start();
		TSD bb = new TSD(service);
		bb.setName("BB");
		bb.start();
	}
}

class TSA extends Thread {
	private MyService2 service;

	public TSA(MyService2 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		super.run();
		service.methodA();
	}
}

class TSB extends Thread {
	private MyService2 service;

	public TSB(MyService2 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		super.run();
		service.methodA();
	}
}

class TSC extends Thread {
	private MyService2 service;

	public TSC(MyService2 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		super.run();
		service.methodB();
	}
}

class TSD extends Thread {
	private MyService2 service;

	public TSD(MyService2 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		super.run();
		service.methodB();
	}
}
