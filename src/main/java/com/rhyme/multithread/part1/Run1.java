/**
 *  Created by weiping.gong on 2018年5月28日
 */
package com.rhyme.multithread.part1;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年5月28日
 */
public class Run1 {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		// myThread.stop();
		// myThread.suspend();
		// myThread.resume();
		myThread.interrupt();
		// myThread.start();
		myThread.run();
	}
}

class MyThreadGG extends Thread {
	public MyThreadGG() {
		System.out.println("构造方法的答应" + Thread.currentThread().getName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		System.out.println("run" + Thread.currentThread().getName());
	}
}
