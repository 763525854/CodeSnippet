/**
 *  Created by weiping.gong on 2018年5月31日
 */
package com.rhyme.multithread.part1;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年5月31日
 */
public class MyThread1 extends Thread {
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		System.out.println("mythread1 run priority=" + this.getPriority());
		MyThread2 thread2 = new MyThread2();
		thread2.start();
	}
}

class MyThread2 extends Thread {
	@Override
	public void run() {
		System.out.println("mythread2 run priority=" + this.getPriority());
	}
}
