/**
 *  Created by weiping.gong on 2018年6月1日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月1日
 */
public class MyObject {
	synchronized public void methodA() {
		try {
			System.out.println("begin methodA threadName=" + Thread.currentThread().getName());
			Thread.sleep(5000);
			System.out.println("end");
		} catch (java.lang.Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

class ThreadC extends Thread {
	private MyObject object;

	public ThreadC(MyObject object) {
		super();
		this.object = object;
	}
	
	@Override
	public void run() {
		super.run();
		object.methodA();
	}
}

class ThreadD extends Thread {
	private MyObject object;

	public ThreadD(MyObject object) {
		super();
		this.object = object;
	}
	
	@Override
	public void run() {
		super.run();
		object.methodA();
	}
}
