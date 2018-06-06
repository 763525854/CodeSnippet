/**
 *  Created by weiping.gong on 2018年6月5日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月5日
 */
public class SynMyService {
	private String lock = "123";

	public void testMethod() {
		try {
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName() + " begin " + System.currentTimeMillis()+lock);
				lock = "456";
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName() + " end " + System.currentTimeMillis());
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
}

class SynMyServiceThreada extends Thread {
	private SynMyService service;

	public SynMyServiceThreada(SynMyService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.testMethod();
	}

}

class SynMyServiceThreadb extends Thread {
	private SynMyService service;

	public SynMyServiceThreadb(SynMyService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.testMethod();
	}

}
