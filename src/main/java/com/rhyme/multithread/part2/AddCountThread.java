/**
 *  Created by weiping.gong on 2018年6月6日
 */
package com.rhyme.multithread.part2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月6日
 */
public class AddCountThread extends Thread {
	private AtomicInteger count = new AtomicInteger(0);

	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 100; i++) {
			System.out.println("Thread name "+Thread.currentThread().getName()+" print "+count.incrementAndGet());
		}
	}

	public static void main(String[] args) {
		AddCountThread countService = new AddCountThread();
		Thread[] myThreads = new Thread[100];
		for (int i = 0; i < 100; i++) {
			myThreads[i] = new Thread(countService);
			myThreads[i].setName(Integer.toString(i));
			myThreads[i].start();
		}
	}
}
