/**
 *  Created by weiping.gong on 2018年6月4日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月4日
 */
public class SynMyObject {

}

class SynService {
	public void testMethod1(SynMyObject object) throws InterruptedException {
		synchronized (object) {
			long time1 = System.currentTimeMillis();
			System.out.println(
					"testMethod1_____getLock time=" + time1 + " run threadName=" + Thread.currentThread().getName());
			Thread.sleep(2000);
			long time2 = System.currentTimeMillis();
			System.out.println("testMethod1_____relaeaseLock time=" + time2 + " run threadName="
					+ Thread.currentThread().getName());
			System.out.println("it cost " + (time2 - time1) / 1000 + " s");
		}
	}
}

class SynThread1 extends Thread {
	private SynMyObject object;
	private SynService service;

	public SynThread1(SynMyObject object, SynService service) {
		this.object = object;
		this.service = service;
	}

	@Override
	public void run() {
		super.run();
		try {
			service.testMethod1(object);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class SynThread2 extends Thread {
	private SynMyObject object;
	private SynService service;

	public SynThread2(SynMyObject object, SynService service) {
		this.object = object;
		this.service = service;
	}

	@Override
	public void run() {
		super.run();
		try {
			service.testMethod1(object);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
