/**
 *  Created by weiping.gong on 2018年6月1日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月1日
 */
public class MyObject2 {
	synchronized public void methodA() {
		try {
			System.out.println("beign methodA threadName=" + Thread.currentThread().getName());
			Thread.sleep(5000);
			System.out.println("end endTime=" + System.currentTimeMillis());
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}

	synchronized public void methodB() {
		try {
			System.out.println("begin methodB threadName=" + Thread.currentThread().getName() + " begin time="
					+ System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("end");
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}

class ThreadE extends Thread {
	private MyObject2 object;

	public ThreadE(MyObject2 object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		super.run();
		object.methodA();
	}
}

class ThreadF extends Thread {
	private MyObject2 object;

	public ThreadF(MyObject2 object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		super.run();
		object.methodB();
	}
}
